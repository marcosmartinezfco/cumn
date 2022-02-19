package com.example.easywallet.network

import com.example.easywallet.domain.Transaction
import com.squareup.moshi.Json

/*
{
  "status":"1",
  "message":"OK",
  "result":"40891626854930000000000"
}
*/
data class ApiTransaction(
    @Json(name = "hash")
    var tx_hash: String,

    @Json(name = "value")
    var value: String
)

fun ApiTransaction.asDomainModel(): Transaction{
    return Transaction(tx_hash, value)
}

data class ApiTransactionsContainer(
    @Json(name = "status")
    var status: String,

    @Json(name = "message")
    var message: String,

    @Json(name = "result")
    var result: List<ApiTransaction>
)

fun ApiTransactionsContainer.asDomainModel(): Array<Transaction>{
    return result.map { it.asDomainModel() }.toTypedArray()
}