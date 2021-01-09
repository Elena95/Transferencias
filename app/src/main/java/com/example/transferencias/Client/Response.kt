package com.example.transferencias.Client

import com.squareup.moshi.Json

data class Response(

    @Json(name = "message")
    val mensaje: String
)