package com.sunrun.example

import io.restassured.path.json.JsonPath

fun inputObjectAsString(
    integer: Int = 10,
    string: String = "Slartibartfast",
    enum: ExampleEnum = ExampleEnum.A,
    enumWithValues: ExampleEnumWithValues = ExampleEnumWithValues.HHGTTG
) = """
{
  "inputObject": {
    "integer": $integer,
    "string": "$string",
    "enum": "$enum",
    "enumWithValues": "$enumWithValues"
  }
}
""".trimIndent()

fun json(
    integer: Int = 500,
    string: String = "Slartibartfast",
    nestedObjectString1: String = "Heart of Gold",
    nestedObjectString2: String = "Trillian Astra",
    nestedObjectString3: String = "Deep Thought"
) = JsonPath("""
        {
            "integer": $integer,
            "string": "$string",
            "nestedObject": {
                "string1": "$nestedObjectString1",
                "string2": "$nestedObjectString2",
                "string3": "$nestedObjectString3"
            }
        }
        """.trimIndent()
)
