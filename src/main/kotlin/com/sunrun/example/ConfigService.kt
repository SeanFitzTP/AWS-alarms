package com.sunrun.example

import javax.inject.Singleton
import javax.ws.rs.Consumes
import javax.ws.rs.Produces
import org.jboss.resteasy.client.jaxrs.internal.ResteasyClientBuilderImpl
import org.kie.kogito.rules.units.FieldDataStore
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import javax.ws.rs.core.Response

@Singleton
object ConfigService {

    @Produces("application/json")
    @Consumes("application/json")
    data class Config(var features: List<String> = listOf())

    private val app: String = "products-and-pricing"
    private val env: String = System.getenv("ENVIRONMENT") ?: "main"
    private val configuration: String = "main"
    private val logger: Logger = LoggerFactory.getLogger(this::class.java)
    private var cachedConfig: Config = Config()

    val configStore: FieldDataStore<Config>
        get() = FieldDataStore<Config>().apply {
            set(getConfig(true))
        }

    /**
     * Handle caching the config
     */
    private fun getConfig(refreshCache: Boolean = false): Config {
        return if (refreshCache) {
            val config = when (val appConfigResponse = retrieveConfig(app, env, configuration)) {
                is Result.Success -> mapToConfig(appConfigResponse.value)
                is Result.Error -> Config()
            }
            cachedConfig = config
            config
        } else {
            return cachedConfig
        }
    }

    fun hasFeature(feature: String) = getConfig().features.contains(feature)

    private fun mapToConfig(response: Response): Config {
        if (response.status != 200) {
            val output = response.readEntity(String::class.java)
            logger.error("AppConfig call failed with error $output. Defaulting to default Config()")
            return Config()
        }
        val output = response.readEntity(Config::class.java)
        logger.info("AppConfig is $output")
        return output
    }

    private fun retrieveConfig(app: String, env: String, configuration: String): Result<Response> {
        val client = ResteasyClientBuilderImpl().build()
        return try {
            val appConfigUrl = "http://localhost:2772/applications/$app/environments/$env/configurations/$configuration"
            logger.info("retrieving AppConfig from $appConfigUrl")
            val response = client
                .target(appConfigUrl)
                .request()
                .header("content-type", "application/json")
                .get()
            Result.Success(response)
        } catch (e: Exception) {
            logger.error("Error trying to call AppConfig: $e")
            Result.Error("Error trying to call AppConfig: ", e)
        } finally {
            client.close()
        }
    }
}