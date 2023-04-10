package com.sunrun.example

import com.sunrun.example.helpers.aws.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import software.amazon.awscdk.core.*
import software.amazon.awscdk.services.iam.Role
import software.amazon.awscdk.services.lambda.Function
import software.amazon.awscdk.services.ssm.StringParameter
import software.amazon.awscdk.services.ssm.StringParameterProps


/**
 * Largely here for interop with maven exec plugin. How do we want this to run long term?
 * TODO: .env generation
 */
class ExampleApp {
    companion object {
        //128 char limit: https://docs.aws.amazon.com/AWSCloudFormation/latest/UserGuide/cfn-using-console-create-stack-parameters.html
        const val applicationName = "example-app"

        @JvmStatic
        fun main(args: Array<String>) {
            val app = App()
            ExampleCDK(app, StackConfiguration.fromCliArgs(args, applicationName))

            //looks like it requires a commit/tag to exist first.
            Tags.of(app).add("branchName", OS.branch)
            app.synth()
        }
    }
}

class ExampleCDK(
    scope: Construct,
    private val stack: StackConfiguration
) : software.amazon.awscdk.core.Stack(scope, stack.stackName, null) {
    private val logger: Logger = LoggerFactory.getLogger(this::class.java)
    private val functions = listOf(
        FunctionDefinition("ExampleFn", "ExampleFnHandler")
    )

    init {
        functions.forEach {
            buildFunction(it)
        }
    }

    private fun buildFunction(definition: FunctionDefinition): Function {
        val functionName = "$stackName-${definition.name}"
        val function = function(definition.name, functionProps {
            defaultSetup(memory = 1024, functionName = functionName)
            environment(
                mapOf(
                    "DISABLE_SIGNAL_HANDLERS" to "true",            // required by graal native
                    "QUARKUS_LAMBDA_HANDLER" to definition.handler  // https://quarkus.io/guides/amazon-lambda#choose
                )
            )
        })
        val version = function.currentVersion
        logger.info("Current Version is: ${version.latestVersion.version}")
        function.outputFunctionArn(stack, definition.name)

        val versionParameterProps = StringParameterProps.builder()
            .parameterName("/$stackName-${definition.name}/LATEST_VERSION")
            .stringValue(version.version)
            .build()

        val versionParameter = StringParameter(this, "${definition.name}LatestVersion", versionParameterProps)

        versionParameter.grantRead(Role.fromRoleArn(this, "VersionReadableArn", function.role!!.roleArn))
        function.createRestApi(definition, stack)
        function.addAppConfig(stack)
        return function
    }
}
