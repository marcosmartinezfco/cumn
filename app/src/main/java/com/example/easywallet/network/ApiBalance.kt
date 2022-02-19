package com.example.easywallet.network

import com.squareup.moshi.Json

/*
{
  "status":"1",
  "message":"OK",
  "result":"40891626854930000000000"
}
*/
data class ApiBalance(
    @Json(name = "status")
    var status: String,

    @Json(name = "message")
    var message: String,

    @Json(name = "result")
    var result: String
)