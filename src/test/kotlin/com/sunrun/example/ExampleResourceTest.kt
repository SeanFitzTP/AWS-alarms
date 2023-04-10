package com.sunrun.example

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured
import io.restassured.http.ContentType
import io.restassured.path.json.JsonPath
import org.hamcrest.CoreMatchers.equalTo
import org.junit.jupiter.api.Test

@QuarkusTest
class ExampleResourceTest {

    @Test
    fun `test that decision tables compile`() {
    }

    @Test
    fun firstTest() {
        val expectedJson = json()

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails()
        RestAssured.given()
            .whenever()
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .body(inputObjectAsString(string = "For instance, on the planet Earth, man had always assumed that he was more intelligent than dolphins because he had achieved so much — the wheel, New York, wars and so on — whilst all the dolphins had ever done was muck about in the water having a good time. But conversely, the dolphins had always believed that they were far more intelligent than man — for precisely the same reasons.").trimIndent())
            .post("/example-query/first")
            .then()
            .statusCode(200)
            .bodyMatchesJson(expectedJson)
    }
}
