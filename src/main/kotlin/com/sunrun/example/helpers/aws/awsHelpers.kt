package com.sunrun.example.helpers.aws

import com.sunrun.example.FunctionDefinition
import com.sunrun.example.StackConfiguration
import software.amazon.awscdk.services.iam.Effect
import software.amazon.awscdk.services.iam.PolicyStatement
import software.amazon.awscdk.services.lambda.*
import software.amazon.awscdk.services.lambda.Function
import java.util.*
import mu.KotlinLogging
import software.amazon.awscdk.core.*
import software.amazon.awscdk.services.apigateway.*

private val logger = KotlinLogging.logger {}

private const val APP_CONFIG_WEST_2_LAYER_VERSION_ARN = "arn:aws:lambda:us-west-2:359756378197:layer:AWS-AppConfig-Extension:62"

fun FunctionProps.Builder.defaultSetup(timeout: Int = 10, memory: Int = 4096, functionName: String) {
    this.runtime(Runtime.PROVIDED)
    this.handler("not.used.by.quarkus.in.native.mode")
    this.code(Code.fromAsset("target/function.zip"))
    this.tracing(Tracing.ACTIVE)
    this.timeout(Duration.seconds(timeout))
    this.memorySize(memory)
    this.functionName(functionName)

    val versionOptions = VersionOptions.builder()
        .description("${UUID.randomUUID()}")
        .removalPolicy(RemovalPolicy.RETAIN)
        .build()
    this.currentVersionOptions(versionOptions)
}

fun Function.addAppConfig(stack: StackConfiguration) {
    val appConfigPolicy = PolicyStatement().apply {
        addActions(
            "appconfig:GetConfiguration",
            "logs:CreateLogGroup"
        )
        addResources(
            "arn:aws:appconfig:*:${stack.awsEnv.account.accountNumber}:application/*",
            "arn:aws:appconfig:*:${stack.awsEnv.account.accountNumber}:application/*/environment/*",
            "arn:aws:appconfig:*:${stack.awsEnv.account.accountNumber}:application/*/configurationprofile/*"
        )

        effect = Effect.ALLOW
    }
    this.addToRolePolicy(appConfigPolicy)

    val appConfigLayer = LayerVersion.fromLayerVersionArn(
        this,
        "AWS-AppConfig-Extension",
        APP_CONFIG_WEST_2_LAYER_VERSION_ARN
    )
    logger.info("Adding app config layer")
    this.addLayers(appConfigLayer)
}

fun Function.outputFunctionArn(stack: StackConfiguration, name: String) {
    cfnOutput("${name}Output", cfnOutputProps {
        exportName("${stack.stackName}-${name}")
        value(this@outputFunctionArn.functionArn)
    })
}

/**
 * @see Function
 */
fun Construct.function(
    id: String,
    props: FunctionProps,
    init: (Function.() -> Unit)? = null
): Function {

    val obj = Function(this, id, props)
    init?.invoke(obj)
    return obj
}


/**
 * @see FunctionProps.Builder
 */
fun functionProps(init: FunctionProps.Builder.() -> Unit): FunctionProps {
    val builder = FunctionProps.Builder()
    builder.init()
    return builder.build()
}


/**
 * @see software.amazon.awscdk.CfnOutput
 */
fun Construct.cfnOutput(
    id: String,
    props: CfnOutputProps,
    init: (CfnOutput.() -> Unit)? = null
) : CfnOutput {
    val obj = CfnOutput(this, id, props)
    init?.invoke(obj)
    return obj
}


/**
 * @see software.amazon.awscdk.CfnOutputProps.Builder
 */
fun cfnOutputProps(init: CfnOutputProps.Builder.() -> Unit): CfnOutputProps {
    val builder = CfnOutputProps.Builder()
    builder.init()
    return builder.build()
}

fun Function.createRestApi(
    definition: FunctionDefinition,
    stack: StackConfiguration
) {
    val api = RestApi.Builder.create(this, "${stack.stackName}-${definition.name}-api")
        .endpointTypes(mutableListOf(EndpointType.REGIONAL)).build()

    val integration = LambdaIntegration(
        this, LambdaIntegrationOptions.builder()
            .proxy(false)
            .integrationResponses(
                listOf(
                    IntegrationResponse.builder()
                        .statusCode("200").build()
                )
            )
            .build()
    )
    val options = MethodOptions.builder()
        .apiKeyRequired(true)
        .methodResponses(listOf(MethodResponse.builder().statusCode("200").build()))
        .build()
    api.root.addMethod("ANY", integration, options)

    val devApiKey = api.addApiKey("${stack.stackName}-Developers")
    api.addUsagePlan(
        "${stack.stackName}-Developers-Usage",
        UsagePlanProps.builder()
            .apiKey(devApiKey)
            .apiStages(listOf(UsagePlanPerApiStage.builder().api(api).stage(api.deploymentStage).build()))
            .build()
    )

    val gsheetApiKey = api.addApiKey("${stack.stackName}-GSheet")
    api.addUsagePlan(
        "${stack.stackName}-GSheet-Usage",
        UsagePlanProps.builder()
            .apiKey(gsheetApiKey)
            .apiStages(listOf(UsagePlanPerApiStage.builder().api(api).stage(api.deploymentStage).build()))
            .build()
    )
}
