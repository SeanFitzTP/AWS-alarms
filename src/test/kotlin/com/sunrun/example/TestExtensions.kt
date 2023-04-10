package com.sunrun.example

import io.restassured.path.json.JsonPath
import io.restassured.response.ValidatableResponseOptions
import io.restassured.specification.RequestSpecification
import org.hamcrest.CoreMatchers

fun RequestSpecification.whenever() = this.`when`()

fun ValidatableResponseOptions<*, *>.bodyMatchesJson(json: JsonPath)
    = this.body("", CoreMatchers.equalTo(json.getMap<Any, Any>("")))
