package com.sunrun.example

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import software.amazon.awscdk.core.RemovalPolicy

/**
 * In principal, we could have a different version for each alias, but that would complicate things alot.
 * We'll stick to same version for all functions in a release. Over time it could result in lots of versions, but
 * in practice, we only pay for actual invocations.
 *
 */
data class FunctionDefinition(
    val name: String,
    val handler: String
)

object OS {
    // Cloud formations does not support . characters
    val whoAmI: String
        get() = String(java.lang.Runtime.getRuntime().exec("whoami").inputStream.readBytes()).replace(".", "-").trim()
    val branch: String
            by lazy {
                System.getenv("GITHUB_HEAD_REF")
            }
}

data class StackConfiguration(
    val envName: String,
    val stackName: String,
    val awsEnv: SunrunApplicationEnvironment
) {
    private val logger: Logger = LoggerFactory.getLogger(this::class.java)

    init {
        logger.info("Synthesizing $this")
    }

    companion object {
        fun fromCliArgs(args: Array<String>, applicationName: String): StackConfiguration {
            val envName = if (args.isNotEmpty()) {
                args[0]
            } else {
                OS.whoAmI
            }

            val stackName = "$envName-$applicationName"
            val applicationEnvironment = SunrunApplicationEnvironment.valueOfCaseInsensitive(envName)

            return StackConfiguration(envName, stackName, applicationEnvironment)
        }
    }
}

enum class SunrunAwsAccount(val accountNumber: Long) {
    Dev(563116987804), Stage(339585210943), Prd(578915239930)
}

enum class SunrunApplicationEnvironment(val account: SunrunAwsAccount, val isEphemeral: Boolean) {
    Sandbox(SunrunAwsAccount.Dev, true),
    Devmaj(SunrunAwsAccount.Dev, false),
    Relcert(SunrunAwsAccount.Stage, false),
    Majstg(SunrunAwsAccount.Prd, false),
    Prd(SunrunAwsAccount.Prd, false);

    val removalPolicy: RemovalPolicy
        get() = if (isEphemeral) RemovalPolicy.DESTROY else RemovalPolicy.RETAIN

    companion object {
        private val valuesByNameCaseInsensitive = values().associateBy { it.name.toLowerCase().trim() }

        fun valueOfCaseInsensitive(value: String): SunrunApplicationEnvironment {
            return valuesByNameCaseInsensitive.getOrDefault(value.toLowerCase().trim(), Sandbox)
        }
    }
}
