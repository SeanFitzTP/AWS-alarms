package com.sunrun.example

import kotlinx.serialization.json.Json

object Serialization {
    val json: Json by lazy {
        Json { ignoreUnknownKeys = true; isLenient = true }
    }
}