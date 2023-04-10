package com.sunrun.example

import io.github.cdimascio.dotenv.dotenv
import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured
import io.restassured.RestAssured.given
import io.restassured.http.ContentType
import io.restassured.path.json.JsonPath
import io.restassured.specification.RequestSpecification
import org.hamcrest.CoreMatchers
import org.junit.jupiter.api.Test

class Cloud : OutsideInTest() {
    private val dotenv = dotenv()
    private val baseUri =
        dotenv["LAMBDA_NAME_HERE_BASE_URI"]
            ?: throw Exception("LAMBDA_NAME_HERE_BASE_URI not set in .env. See the ./manage.sh script.")
    private val apiKey =
        dotenv["LAMBDA_NAME_HERE_API_KEY"]
            ?: throw Exception("LAMBDA_NAME_HERE_API_KEY not set in .env. See the ./manage.sh script.")

    override val setup: RequestSpecification
        get() = given()
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .baseUri(baseUri)
            .header("x-api-key", apiKey)
}

@QuarkusTest
class LocalOutsideInTest : OutsideInTest() {
    override val setup: RequestSpecification
        get() = given().contentType(ContentType.JSON).accept(ContentType.JSON)
}

abstract class OutsideInTest {

    abstract val setup: RequestSpecification
    // TODO replace the path here with the name of the query from your decision table
    // the first path parameter will convert camelcase to all lowercase separated by dashes
    val endpoint = "/example-query/first"

    @Test
    fun firstTest() {
        val expectedJson = json()

        setup
            .whenever()
            .body(inputObjectAsString(string = "For instance, on the planet Earth, man had always assumed that he was more intelligent than dolphins because he had achieved so much — the wheel, New York, wars and so on — whilst all the dolphins had ever done was muck about in the water having a good time. But conversely, the dolphins had always believed that they were far more intelligent than man — for precisely the same reasons."))
            .post("/example-query/first")
            .then()
            .statusCode(200)
            .bodyMatchesJson(expectedJson)

    }

    companion object {
        init {
            RestAssured.enableLoggingOfRequestAndResponseIfValidationFails()
        }
    }
}
