package com.example.transferencias.Client

import com.squareup.moshi.Json


data class InfoPayments (

    @Json(name = "idCustomer") val idCustomer: Int? = null,
    @Json(name = "name") val name: String? = null,
    @Json(name = "lastName") val lastName: String? = null,
    @Json(name = "secondLastName") val secondLastName: String? = null,
    @Json(name = "totaAmount") val totalAmount: String,
    @Json(name = "totalPayment") val totalPayment: String
)
