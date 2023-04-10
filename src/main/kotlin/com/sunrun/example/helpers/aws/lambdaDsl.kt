package com.sunrun.example

import software.amazon.awscdk.core.*
import software.amazon.awscdk.services.lambda.SingletonFunction
import software.amazon.awscdk.services.lambda.SingletonFunctionProps
import software.amazon.awscdk.services.lambda.*
import software.amazon.awscdk.services.logs.RetentionDays


/**
 * @see software.amazon.awscdk.App
 */
fun app(props: AppProps = AppProps.builder().build(), init: (App.() -> Unit)? = null): App {
    val obj = App(props)
    init?.invoke(obj)
    return obj
}

/**
 * @see software.amazon.awscdk.Stack
 */
fun Construct.stack(
    id: String,
    props: StackProps = StackProps.builder().build(),
    init: (Stack.() -> Unit)? = null
): Stack {
    val obj = Stack(this, id, props)
    init?.invoke(obj)
    return obj
}

/**
 * @see SingletonFunction
 */
fun Construct.singletonFunction(
    id: String,
    props: SingletonFunctionProps,
    init: (SingletonFunction.() -> Unit)? = null
): SingletonFunction {
    val obj = SingletonFunction(this, id, props)
    init?.invoke(obj)
    return obj
}


/**
 * @see LayerVersion
 */
fun Construct.layerVersion(id: String, props: LayerVersionProps, init: (LayerVersion.() -> Unit)? = null)
        : LayerVersion {
    val obj = LayerVersion(this, id, props)
    init?.invoke(obj)
    return obj
}


/**
 * @see CfnVersion
 */
fun Construct.cfnVersion(
    id: String,
    props: CfnVersionProps,
    init: (CfnVersion.() -> Unit)? = null
)
        : CfnVersion {

    val obj = CfnVersion(this, id, props)
    init?.invoke(obj)
    return obj
}


/**
 * @see CfnPermission
 */
fun Construct.cfnPermission(
    id: String,
    props: CfnPermissionProps,
    init: (CfnPermission.() -> Unit)? = null
)
        : CfnPermission {

    val obj = CfnPermission(this, id, props)
    init?.invoke(obj)
    return obj
}


/**
 * @see CfnLayerVersionPermission
 */
fun Construct.cfnLayerVersionPermission(
    id: String,
    props: CfnLayerVersionPermissionProps,
    init: (CfnLayerVersionPermission.() -> Unit)? = null
)
        : CfnLayerVersionPermission {

    val obj = CfnLayerVersionPermission(this, id, props)
    init?.invoke(obj)
    return obj
}


/**
 * @see EventSourceMapping
 */
fun Construct.eventSourceMapping(
    id: String,
    props: EventSourceMappingProps,
    init: (EventSourceMapping.() -> Unit)? = null
)
        : EventSourceMapping {

    val obj = EventSourceMapping(this, id, props)
    init?.invoke(obj)
    return obj
}


/**
 * @see LogRetention
 */
fun Construct.logRetention(
    id: String,
    props: LogRetentionProps,
    init: (LogRetention.() -> Unit)? = null
)
        : LogRetention {

    val obj = LogRetention(this, id, props)
    init?.invoke(obj)
    return obj
}


/**
 * @see CfnEventSourceMapping
 */
fun Construct.cfnEventSourceMapping(
    id: String,
    props: CfnEventSourceMappingProps,
    init: (CfnEventSourceMapping.() -> Unit)? = null
)
        : CfnEventSourceMapping {

    val obj = CfnEventSourceMapping(this, id, props)
    init?.invoke(obj)
    return obj
}


/**
 * @see Version
 */
fun Construct.version(
    id: String,
    props: VersionProps,
    init: (Version.() -> Unit)? = null
)
        : Version {

    val obj = Version(this, id, props)
    init?.invoke(obj)
    return obj
}


/**
 * @see Alias
 */
fun Construct.alias(
    id: String,
    props: AliasProps,
    init: (Alias.() -> Unit)? = null
)
        : Alias {

    val obj = Alias(this, id, props)
    init?.invoke(obj)
    return obj
}

/**
 * @see CfnFunction
 */
fun Construct.cfnFunction(
    id: String,
    props: CfnFunctionProps,
    init: (CfnFunction.() -> Unit)? = null
): CfnFunction {
    val obj = CfnFunction(this, id, props)
    init?.invoke(obj)
    return obj
}


/**
 * @see CfnLayerVersion
 */
fun Construct.cfnLayerVersion(
    id: String,
    props: CfnLayerVersionProps,
    init: (CfnLayerVersion.() -> Unit)? = null
)
        : CfnLayerVersion {

    val obj = CfnLayerVersion(this, id, props)
    init?.invoke(obj)
    return obj
}


/**
 * @see CfnAlias
 */
fun Construct.cfnAlias(
    id: String,
    props: CfnAliasProps,
    init: (CfnAlias.() -> Unit)? = null
)
        : CfnAlias {

    val obj = CfnAlias(this, id, props)
    init?.invoke(obj)
    return obj
}

/**
 * @see AliasProps.Builder
 */
fun aliasProps(init: AliasProps.Builder.() -> Unit): AliasProps {
    val builder = AliasProps.Builder()
    builder.init()
    return builder.build()
}

/**
 * @see AliasProps.Builder.withAliasName
 */
var AliasProps.Builder.aliasName: String
    get() = throw NoSuchFieldException("Get on aliasName is not supported.")
    set(value) {
        this.aliasName(value)
    }

/**
 * @see AliasProps.Builder.withDescription
 */
var AliasProps.Builder.description: String
    get() = throw NoSuchFieldException("Get on description is not supported.")
    set(value) {
        this.description(value)
    }

/**
 * @see AliasProps.Builder.withVersion
 */
var AliasProps.Builder.version: Version
    get() = throw NoSuchFieldException("Get on version is not supported.")
    set(value) {
        this.version(value)
    }


/**
 * @see CfnEventSourceMappingProps.Builder
 */
fun cfnEventSourceMappingProps(init: CfnEventSourceMappingProps.Builder.() -> Unit): CfnEventSourceMappingProps {
    val builder = CfnEventSourceMappingProps.Builder()
    builder.init()
    return builder.build()
}

/**
 * @see CfnEventSourceMappingProps.Builder.withEventSourceArn
 */
var CfnEventSourceMappingProps.Builder.eventSourceArn: String
    get() = throw NoSuchFieldException("Get on eventSourceArn is not supported.")
    set(value) {
        this.eventSourceArn(value)
    }

/**
 * @see CfnEventSourceMappingProps.Builder.withFunctionName
 */
var CfnEventSourceMappingProps.Builder.functionName: String
    get() = throw NoSuchFieldException("Get on functionName is not supported.")
    set(value) {
        this.functionName(value)
    }

/**
 * @see CfnEventSourceMappingProps.Builder.withStartingPosition
 */
var CfnEventSourceMappingProps.Builder.startingPosition: String
    get() = throw NoSuchFieldException("Get on startingPosition is not supported.")
    set(value) {
        this.startingPosition(value)
    }

/**
 * @see CfnEventSourceMappingProps.Builder.withBatchSize
 */
var CfnEventSourceMappingProps.Builder.batchSize: Number
    get() = throw NoSuchFieldException("Get on batchSize is not supported.")
    set(value) {
        this.batchSize(value)
    }

/**
 * @see CfnEventSourceMappingProps.Builder.withEnabled
 */
var CfnEventSourceMappingProps.Builder.enabled: Boolean
    get() = throw NoSuchFieldException("Get on enabled is not supported.")
    set(value) {
        this.enabled(value)
    }



/**
 * @see FunctionProps.Builder.withFunctionName
 */
var FunctionProps.Builder.functionName: String
    get() = throw NoSuchFieldException("Get on functionName is not supported.")
    set(value) {
        this.functionName(value)
    }

/**
 * @see FunctionProps.Builder.withCode
 */
var FunctionProps.Builder.code: Code
    get() = throw NoSuchFieldException("Get on code is not supported.")
    set(value) {
        this.code(value)
    }

/**
 * @see FunctionProps.Builder.withAllowAllOutbound
 */
var FunctionProps.Builder.allowAllOutbound: Boolean
    get() = throw NoSuchFieldException("Get on allowAllOutbound is not supported.")
    set(value) {
        this.allowAllOutbound(value)
    }


/**
 * @see FunctionProps.Builder.withMemorySize
 */
var FunctionProps.Builder.memorySize: Number
    get() = throw NoSuchFieldException("Get on memorySize is not supported.")
    set(value) {
        this.memorySize(value)
    }


/**
 * @see FunctionProps.Builder.withTimeout
 */
var FunctionProps.Builder.timeout: Duration
    get() = throw NoSuchFieldException("Get on timeout is not supported.")
    set(value) {
        this.timeout(value)
    }

/**
 * @see FunctionProps.Builder.withHandler
 */
var FunctionProps.Builder.handler: String
    get() = throw NoSuchFieldException("Get on handler is not supported.")
    set(value) {
        this.handler(value)
    }

/**
 * @see FunctionProps.Builder.withRuntime
 */
var FunctionProps.Builder.runtime: Runtime
    get() = throw NoSuchFieldException("Get on runtime is not supported.")
    set(value) {
        this.runtime(value)
    }

/**
 * @see FunctionProps.Builder.withDeadLetterQueueEnabled
 */
var FunctionProps.Builder.deadLetterQueueEnabled: Boolean
    get() = throw NoSuchFieldException("Get on deadLetterQueueEnabled is not supported.")
    set(value) {
        this.deadLetterQueueEnabled(value)
    }

/**
 * @see FunctionProps.Builder.withReservedConcurrentExecutions
 */
var FunctionProps.Builder.reservedConcurrentExecutions: Number
    get() = throw NoSuchFieldException("Get on reservedConcurrentExecutions is not supported.")
    set(value) {
        this.reservedConcurrentExecutions(value)
    }

/**
 * @see FunctionProps.Builder.withTracing
 */
var FunctionProps.Builder.tracing: Tracing
    get() = throw NoSuchFieldException("Get on tracing is not supported.")
    set(value) {
        this.tracing(value)
    }

/**
 * @see FunctionProps.Builder.withDescription
 */
var FunctionProps.Builder.description: String
    get() = throw NoSuchFieldException("Get on description is not supported.")
    set(value) {
        this.description(value)
    }


/**
 * @see CfnFunction.DeadLetterConfigProperty.Builder
 */
fun deadLetterConfigProperty(init: CfnFunction.DeadLetterConfigProperty.Builder.() -> Unit): CfnFunction.DeadLetterConfigProperty {
    val builder = CfnFunction.DeadLetterConfigProperty.Builder()
    builder.init()
    return builder.build()
}

/**
 * @see CfnFunction.DeadLetterConfigProperty.Builder.targetArn
 */
var CfnFunction.DeadLetterConfigProperty.Builder.targetArn: String
    get() = throw NoSuchFieldException("Get on targetArn is not supported.")
    set(value) {
        this.targetArn(value)
    }


/**
 * @see CfnLayerVersion.ContentProperty.Builder
 */
fun contentProperty(init: CfnLayerVersion.ContentProperty.Builder.() -> Unit): CfnLayerVersion.ContentProperty {
    val builder = CfnLayerVersion.ContentProperty.Builder()
    builder.init()
    return builder.build()
}

/**
 * @see CfnLayerVersion.ContentProperty.Builder.withS3Bucket
 */
var CfnLayerVersion.ContentProperty.Builder.s3Bucket: String
    get() = throw NoSuchFieldException("Get on s3Bucket is not supported.")
    set(value) {
        this.s3Bucket(value)
    }

/**
 * @see CfnLayerVersion.ContentProperty.Builder.withS3ObjectVersion
 */
var CfnLayerVersion.ContentProperty.Builder.s3ObjectVersion: String
    get() = throw NoSuchFieldException("Get on s3ObjectVersion is not supported.")
    set(value) {
        this.s3ObjectVersion(value)
    }

/**
 * @see CfnLayerVersion.ContentProperty.Builder.withS3Key
 */
var CfnLayerVersion.ContentProperty.Builder.s3Key: String
    get() = throw NoSuchFieldException("Get on s3Key is not supported.")
    set(value) {
        this.s3Key(value)
    }


/**
 * @see CfnFunction.VpcConfigProperty.Builder
 */
fun vpcConfigProperty(init: CfnFunction.VpcConfigProperty.Builder.() -> Unit): CfnFunction.VpcConfigProperty {
    val builder = CfnFunction.VpcConfigProperty.Builder()
    builder.init()
    return builder.build()
}


/**
 * @see CfnAlias.AliasRoutingConfigurationProperty.Builder
 */
fun aliasRoutingConfigurationProperty(init: CfnAlias.AliasRoutingConfigurationProperty.Builder.() -> Unit): CfnAlias.AliasRoutingConfigurationProperty {
    val builder = CfnAlias.AliasRoutingConfigurationProperty.Builder()
    builder.init()
    return builder.build()
}

/**
 * @see CfnFunction.EnvironmentProperty.Builder
 */
fun environmentProperty(init: CfnFunction.EnvironmentProperty.Builder.() -> Unit): CfnFunction.EnvironmentProperty {
    val builder = CfnFunction.EnvironmentProperty.Builder()
    builder.init()
    return builder.build()
}


/**
 * @see CfnFunction.TracingConfigProperty.Builder
 */
fun tracingConfigProperty(init: CfnFunction.TracingConfigProperty.Builder.() -> Unit): CfnFunction.TracingConfigProperty {
    val builder = CfnFunction.TracingConfigProperty.Builder()
    builder.init()
    return builder.build()
}

/**
 * @see CfnFunction.TracingConfigProperty.Builder.withMode
 */
var CfnFunction.TracingConfigProperty.Builder.mode: String
    get() = throw NoSuchFieldException("Get on mode is not supported.")
    set(value) {
        this.mode(value)
    }


/**
 * @see LayerVersionProps.Builder
 */
fun layerVersionProps(init: LayerVersionProps.Builder.() -> Unit): LayerVersionProps {
    val builder = LayerVersionProps.Builder()
    builder.init()
    return builder.build()
}

/**
 * @see LayerVersionProps.Builder.withCode
 */
var LayerVersionProps.Builder.code: Code
    get() = throw NoSuchFieldException("Get on code is not supported.")
    set(value) {
        this.code(value)
    }

/**
 * @see LayerVersionProps.Builder.withName
 */
var LayerVersionProps.Builder.name: String
    get() = throw NoSuchFieldException("Get on name is not supported.")
    set(value) {
        this.name = value
    }

/**
 * @see LayerVersionProps.Builder.withDescription
 */
var LayerVersionProps.Builder.description: String
    get() = throw NoSuchFieldException("Get on description is not supported.")
    set(value) {
        this.description(value)
    }

/**
 * @see LayerVersionProps.Builder.withLicense
 */
var LayerVersionProps.Builder.license: String
    get() = throw NoSuchFieldException("Get on license is not supported.")
    set(value) {
        this.license(value)
    }


/**
 * @see VersionProps.Builder
 */
fun versionProps(init: VersionProps.Builder.() -> Unit): VersionProps {
    val builder = VersionProps.Builder()
    builder.init()
    return builder.build()
}

/**
 * @see VersionProps.Builder.withLambda
 */
var VersionProps.Builder.lambda: IFunction
    get() = throw NoSuchFieldException("Get on lambda is not supported.")
    set(value) {
        this.lambda(value)
    }

/**
 * @see VersionProps.Builder.withDescription
 */
var VersionProps.Builder.description: String
    get() = throw NoSuchFieldException("Get on description is not supported.")
    set(value) {
        this.description(value)
    }

/**
 * @see VersionProps.Builder.withCodeSha256
 */
var VersionProps.Builder.codeSha256: String
    get() = throw NoSuchFieldException("Get on codeSha256 is not supported.")
    set(value) {
        this.codeSha256(value)
    }


/**
 * @see CfnPermissionProps.Builder
 */
fun cfnPermissionProps(init: CfnPermissionProps.Builder.() -> Unit): CfnPermissionProps {
    val builder = CfnPermissionProps.Builder()
    builder.init()
    return builder.build()
}

/**
 * @see CfnPermissionProps.Builder.withAction
 */
var CfnPermissionProps.Builder.action: String
    get() = throw NoSuchFieldException("Get on action is not supported.")
    set(value) {
        this.action(value)
    }

/**
 * @see CfnPermissionProps.Builder.withPrincipal
 */
var CfnPermissionProps.Builder.principal: String
    get() = throw NoSuchFieldException("Get on principal is not supported.")
    set(value) {
        this.principal(value)
    }

/**
 * @see CfnPermissionProps.Builder.withFunctionName
 */
var CfnPermissionProps.Builder.functionName: String
    get() = throw NoSuchFieldException("Get on functionName is not supported.")
    set(value) {
        this.functionName(value)
    }

/**
 * @see CfnPermissionProps.Builder.withEventSourceToken
 */
var CfnPermissionProps.Builder.eventSourceToken: String
    get() = throw NoSuchFieldException("Get on eventSourceToken is not supported.")
    set(value) {
        this.eventSourceToken(value)
    }

/**
 * @see CfnPermissionProps.Builder.withSourceAccount
 */
var CfnPermissionProps.Builder.sourceAccount: String
    get() = throw NoSuchFieldException("Get on sourceAccount is not supported.")
    set(value) {
        this.sourceAccount(value)
    }

/**
 * @see CfnPermissionProps.Builder.withSourceArn
 */
var CfnPermissionProps.Builder.sourceArn: String
    get() = throw NoSuchFieldException("Get on sourceArn is not supported.")
    set(value) {
        this.sourceArn(value)
    }


/**
 * @see VersionWeight.Builder
 */
fun versionWeight(init: VersionWeight.Builder.() -> Unit): VersionWeight {
    val builder = VersionWeight.Builder()
    builder.init()
    return builder.build()
}

/**
 * @see VersionWeight.Builder.withVersion
 */
var VersionWeight.Builder.version: Version
    get() = throw NoSuchFieldException("Get on version is not supported.")
    set(value) {
        this.version(value)
    }

/**
 * @see VersionWeight.Builder.withWeight
 */
var VersionWeight.Builder.weight: Number
    get() = throw NoSuchFieldException("Get on weight is not supported.")
    set(value) {
        this.weight(value)
    }


/**
 * @see CfnLayerVersionPermissionProps.Builder
 */
fun cfnLayerVersionPermissionProps(init: CfnLayerVersionPermissionProps.Builder.() -> Unit): CfnLayerVersionPermissionProps {
    val builder = CfnLayerVersionPermissionProps.Builder()
    builder.init()
    return builder.build()
}

/**
 * @see CfnLayerVersionPermissionProps.Builder.withAction
 */
var CfnLayerVersionPermissionProps.Builder.action: String
    get() = throw NoSuchFieldException("Get on action is not supported.")
    set(value) {
        this.action(value)
    }

/**
 * @see CfnLayerVersionPermissionProps.Builder.withPrincipal
 */
var CfnLayerVersionPermissionProps.Builder.principal: String
    get() = throw NoSuchFieldException("Get on principal is not supported.")
    set(value) {
        this.principal(value)
    }


/**
 * @see CfnFunctionProps.Builder
 */
fun cfnFunctionProps(init: CfnFunctionProps.Builder.() -> Unit): CfnFunctionProps {
    val builder = CfnFunctionProps.Builder()
    builder.init()
    return builder.build()
}

/**
 * @see CfnFunctionProps.Builder.withFunctionName
 */
var CfnFunctionProps.Builder.functionName: String
    get() = throw NoSuchFieldException("Get on functionName is not supported.")
    set(value) {
        this.functionName(value)
    }

/**
 * @see CfnFunctionProps.Builder.withVpcConfig
 */
var CfnFunctionProps.Builder.vpcConfig: CfnFunction.VpcConfigProperty
    get() = throw NoSuchFieldException("Get on vpcConfig is not supported.")
    set(value) {
        this.vpcConfig(value)
    }

/**
 * @see CfnFunctionProps.Builder.withKmsKeyArn
 */
var CfnFunctionProps.Builder.kmsKeyArn: String
    get() = throw NoSuchFieldException("Get on kmsKeyArn is not supported.")
    set(value) {
        this.kmsKeyArn(value)
    }


/**
 * @see CfnFunctionProps.Builder.withHandler
 */
var CfnFunctionProps.Builder.handler: String
    get() = throw NoSuchFieldException("Get on handler is not supported.")
    set(value) {
        this.handler(value)
    }

/**
 * @see CfnFunctionProps.Builder.withRuntime
 */
var CfnFunctionProps.Builder.runtime: String
    get() = throw NoSuchFieldException("Get on runtime is not supported.")
    set(value) {
        this.runtime(value)
    }

/**
 * @see CfnFunctionProps.Builder.withReservedConcurrentExecutions
 */
var CfnFunctionProps.Builder.reservedConcurrentExecutions: Number
    get() = throw NoSuchFieldException("Get on reservedConcurrentExecutions is not supported.")
    set(value) {
        this.reservedConcurrentExecutions(value)
    }

/**
 * @see CfnFunctionProps.Builder.withDescription
 */
var CfnFunctionProps.Builder.description: String
    get() = throw NoSuchFieldException("Get on description is not supported.")
    set(value) {
        this.description(value)
    }

/**
 * @see CfnFunctionProps.Builder.withDeadLetterConfig
 */
var CfnFunctionProps.Builder.deadLetterConfig: CfnFunction.DeadLetterConfigProperty
    get() = throw NoSuchFieldException("Get on deadLetterConfig is not supported.")
    set(value) {
        this.deadLetterConfig(value)
    }

/**
 * @see CfnAliasProps.Builder
 */
fun cfnAliasProps(init: CfnAliasProps.Builder.() -> Unit): CfnAliasProps {
    val builder = CfnAliasProps.Builder()
    builder.init()
    return builder.build()
}

/**
 * @see CfnAliasProps.Builder.withFunctionName
 */
var CfnAliasProps.Builder.functionName: String
    get() = throw NoSuchFieldException("Get on functionName is not supported.")
    set(value) {
        this.functionName(value)
    }

/**
 * @see CfnAliasProps.Builder.withFunctionVersion
 */
var CfnAliasProps.Builder.functionVersion: String
    get() = throw NoSuchFieldException("Get on functionVersion is not supported.")
    set(value) {
        this.functionVersion(value)
    }

/**
 * @see CfnAliasProps.Builder.withName
 */
var CfnAliasProps.Builder.name: String
    get() = throw NoSuchFieldException("Get on name is not supported.")
    set(value) {
        this.name(value)
    }

/**
 * @see CfnAliasProps.Builder.withDescription
 */
var CfnAliasProps.Builder.description: String
    get() = throw NoSuchFieldException("Get on description is not supported.")
    set(value) {
        this.description(value)
    }


/**
 * @see LambdaRuntimeProps.Builder
 */
fun lambdaRuntimeProps(init: LambdaRuntimeProps.Builder.() -> Unit): LambdaRuntimeProps {
    val builder = LambdaRuntimeProps.Builder()
    builder.init()
    return builder.build()
}

/**
 * @see LambdaRuntimeProps.Builder.withSupportsInlineCode
 */
var LambdaRuntimeProps.Builder.supportsInlineCode: Boolean
    get() = throw NoSuchFieldException("Get on supportsInlineCode is not supported.")
    set(value) {
        this.supportsInlineCode(value)
    }

/**
 * @see CfnFunction.CodeProperty.Builder
 */
fun codeProperty(init: CfnFunction.CodeProperty.Builder.() -> Unit): CfnFunction.CodeProperty {
    val builder = CfnFunction.CodeProperty.Builder()
    builder.init()
    return builder.build()
}

/**
 * @see CfnFunction.CodeProperty.Builder.withS3Bucket
 */
var CfnFunction.CodeProperty.Builder.s3Bucket: String
    get() = throw NoSuchFieldException("Get on s3Bucket is not supported.")
    set(value) {
        this.s3Bucket(value)
    }

/**
 * @see CfnFunction.CodeProperty.Builder.withS3ObjectVersion
 */
var CfnFunction.CodeProperty.Builder.s3ObjectVersion: String
    get() = throw NoSuchFieldException("Get on s3ObjectVersion is not supported.")
    set(value) {
        this.s3ObjectVersion(value)
    }

/**
 * @see CfnFunction.CodeProperty.Builder.withS3Key
 */
var CfnFunction.CodeProperty.Builder.s3Key: String
    get() = throw NoSuchFieldException("Get on s3Key is not supported.")
    set(value) {
        this.s3Key(value)
    }

/**
 * @see CfnFunction.CodeProperty.Builder.withZipFile
 */
var CfnFunction.CodeProperty.Builder.zipFile: String
    get() = throw NoSuchFieldException("Get on zipFile is not supported.")
    set(value) {
        this.zipFile(value)
    }


/**
 * @see SingletonFunctionProps.Builder
 */
fun singletonFunctionProps(init: SingletonFunctionProps.Builder.() -> Unit): SingletonFunctionProps {
    val builder = SingletonFunctionProps.Builder()
    builder.init()
    return builder.build()
}

/**
 * @see SingletonFunctionProps.Builder.withFunctionName
 */
var SingletonFunctionProps.Builder.functionName: String
    get() = throw NoSuchFieldException("Get on functionName is not supported.")
    set(value) {
        this.functionName(value)
    }

/**
 * @see SingletonFunctionProps.Builder.withCode
 */
var SingletonFunctionProps.Builder.code: Code
    get() = throw NoSuchFieldException("Get on code is not supported.")
    set(value) {
        this.code(value)
    }

/**
 * @see SingletonFunctionProps.Builder.withAllowAllOutbound
 */
var SingletonFunctionProps.Builder.allowAllOutbound: Boolean
    get() = throw NoSuchFieldException("Get on allowAllOutbound is not supported.")
    set(value) {
        this.allowAllOutbound(value)
    }


/**
 * @see SingletonFunctionProps.Builder.withMemorySize
 */
var SingletonFunctionProps.Builder.memorySize: Number
    get() = throw NoSuchFieldException("Get on memorySize is not supported.")
    set(value) {
        this.memorySize(value)
    }

/**
 * @see SingletonFunctionProps.Builder.withHandler
 */
var SingletonFunctionProps.Builder.handler: String
    get() = throw NoSuchFieldException("Get on handler is not supported.")
    set(value) {
        this.handler(value)
    }

/**
 * @see SingletonFunctionProps.Builder.withRuntime
 */
var SingletonFunctionProps.Builder.runtime: Runtime
    get() = throw NoSuchFieldException("Get on runtime is not supported.")
    set(value) {
        this.runtime(value)
    }


/**
 * @see SingletonFunctionProps.Builder.withDeadLetterQueueEnabled
 */
var SingletonFunctionProps.Builder.deadLetterQueueEnabled: Boolean
    get() = throw NoSuchFieldException("Get on deadLetterQueueEnabled is not supported.")
    set(value) {
        this.deadLetterQueueEnabled(value)
    }

/**
 * @see SingletonFunctionProps.Builder.withLogRetentionDays
 */
var SingletonFunctionProps.Builder.logRetentionDays: RetentionDays
    get() = throw NoSuchFieldException("Get on logRetentionDays is not supported.")
    set(value) {
        this.logRetentionDays = value
    }

/**
 * @see SingletonFunctionProps.Builder.withReservedConcurrentExecutions
 */
var SingletonFunctionProps.Builder.reservedConcurrentExecutions: Number
    get() = throw NoSuchFieldException("Get on reservedConcurrentExecutions is not supported.")
    set(value) {
        this.reservedConcurrentExecutions(value)
    }

/**
 * @see SingletonFunctionProps.Builder.withTracing
 */
var SingletonFunctionProps.Builder.tracing: Tracing
    get() = throw NoSuchFieldException("Get on tracing is not supported.")
    set(value) {
        this.tracing(value)
    }

/**
 * @see SingletonFunctionProps.Builder.withDescription
 */
var SingletonFunctionProps.Builder.description: String
    get() = throw NoSuchFieldException("Get on description is not supported.")
    set(value) {
        this.description(value)
    }

/**
 * @see SingletonFunctionProps.Builder.withUuid
 */
var SingletonFunctionProps.Builder.uuid: String
    get() = throw NoSuchFieldException("Get on uuid is not supported.")
    set(value) {
        this.uuid(value)
    }

/**
 * @see SingletonFunctionProps.Builder.withLambdaPurpose
 */
var SingletonFunctionProps.Builder.lambdaPurpose: String
    get() = throw NoSuchFieldException("Get on lambdaPurpose is not supported.")
    set(value) {
        this.lambdaPurpose(value)
    }


/**
 * @see CfnVersionProps.Builder
 */
fun cfnVersionProps(init: CfnVersionProps.Builder.() -> Unit): CfnVersionProps {
    val builder = CfnVersionProps.Builder()
    builder.init()
    return builder.build()
}

/**
 * @see CfnVersionProps.Builder.withFunctionName
 */
var CfnVersionProps.Builder.functionName: String
    get() = throw NoSuchFieldException("Get on functionName is not supported.")
    set(value) {
        this.functionName(value)
    }

/**
 * @see CfnVersionProps.Builder.withDescription
 */
var CfnVersionProps.Builder.description: String
    get() = throw NoSuchFieldException("Get on description is not supported.")
    set(value) {
        this.description(value)
    }

/**
 * @see CfnVersionProps.Builder.withCodeSha256
 */
var CfnVersionProps.Builder.codeSha256: String
    get() = throw NoSuchFieldException("Get on codeSha256 is not supported.")
    set(value) {
        this.codeSha256(value)
    }


/**
 * @see Permission.Builder
 */
fun permission(init: Permission.Builder.() -> Unit): Permission {
    val builder = Permission.Builder()
    builder.init()
    return builder.build()
}

/**
 * @see Permission.Builder.withAction
 */
var Permission.Builder.action: String
    get() = throw NoSuchFieldException("Get on action is not supported.")
    set(value) {
        this.action(value)
    }

/**
 * @see Permission.Builder.withEventSourceToken
 */
var Permission.Builder.eventSourceToken: String
    get() = throw NoSuchFieldException("Get on eventSourceToken is not supported.")
    set(value) {
        this.eventSourceToken(value)
    }

/**
 * @see Permission.Builder.withSourceAccount
 */
var Permission.Builder.sourceAccount: String
    get() = throw NoSuchFieldException("Get on sourceAccount is not supported.")
    set(value) {
        this.sourceAccount(value)
    }

/**
 * @see Permission.Builder.withSourceArn
 */
var Permission.Builder.sourceArn: String
    get() = throw NoSuchFieldException("Get on sourceArn is not supported.")
    set(value) {
        this.sourceArn(value)
    }


/**
 * @see LogRetentionProps.Builder
 */
fun logRetentionProps(init: LogRetentionProps.Builder.() -> Unit): LogRetentionProps {
    val builder = LogRetentionProps.Builder()
    builder.init()
    return builder.build()
}

/**
 * @see LogRetentionProps.Builder.withLogGroupName
 */
var LogRetentionProps.Builder.logGroupName: String
    get() = throw NoSuchFieldException("Get on logGroupName is not supported.")
    set(value) {
        this.logGroupName(value)
    }

/**
 * @see CfnAlias.VersionWeightProperty.Builder
 */
fun versionWeightProperty(init: CfnAlias.VersionWeightProperty.Builder.() -> Unit): CfnAlias.VersionWeightProperty {
    val builder = CfnAlias.VersionWeightProperty.Builder()
    builder.init()
    return builder.build()
}

/**
 * @see CfnAlias.VersionWeightProperty.Builder.withFunctionVersion
 */
var CfnAlias.VersionWeightProperty.Builder.functionVersion: String
    get() = throw NoSuchFieldException("Get on functionVersion is not supported.")
    set(value) {
        this.functionVersion(value)
    }
