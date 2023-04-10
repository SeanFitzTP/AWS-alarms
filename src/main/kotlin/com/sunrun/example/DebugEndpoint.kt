package com.sunrun.example

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.io.OutputStream
import javax.inject.Inject
import javax.ws.rs.Consumes
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/debug")
class DebugEndpoint {

    @Inject
    lateinit var handler: ExampleFnHandler

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun executeQueryDebug(request: InputObject): ExampleResponse {
        val inputStream = Serialization.json.encodeToString(request).byteInputStream()
        val output = ByteArrayOutputStream()
        handler.handleRequest(inputStream, output,null)
        return Serialization.json.decodeFromString(String(output.toByteArray()))
    }
}
