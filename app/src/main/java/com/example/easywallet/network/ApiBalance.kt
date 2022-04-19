package com.example.easywallet.network

import com.squareup.moshi.Json

data class ApiBalance(
    @Json(name = "status")
    var status: String,

    @Json(name = "message")
    var message: String,

    @Json(name = "result")
    var result: String
)