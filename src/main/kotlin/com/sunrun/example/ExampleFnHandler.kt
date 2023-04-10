package com.sunrun.example

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestStreamHandler
import kotlinx.coroutines.runBlocking
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.InputStream
import java.io.OutputStream
import javax.inject.Named

@Named("ExampleFnHandler")
class ExampleFnHandler(
    val exampleWrapper: ExampleWrapper,
    val configService: ConfigService
) : RequestStreamHandler {
    private val logger: Logger = LoggerFactory.getLogger(this::class.java)

    override fun handleRequest(input: InputStream, output: OutputStream, p2: Context?) {
        val inputJsonString = input.reader().use { it.readText() } // use will close the stream
        val request = Serialization.json.decodeFromString(InputObject.serializer(), inputJsonString)
        logger.info("$request")
        val response = runBlocking {
            exampleWrapper.handleRequest(request)
        }

        val outputJsonString = Serialization.json.encodeToString(ExampleResponse.serializer(), response)
        logger.info(outputJsonString)

        output.writer().use { it.write(outputJsonString) }
    }
}
