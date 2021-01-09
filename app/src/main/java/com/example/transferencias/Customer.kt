package com.example.transferencias

import com.squareup.moshi.Json

data class Customer (
    @Json(name = "name")
    val name: String,
    @Json(name = "middleName")
    val middleName: String? = null,
    @Json(name = "lastName")
    val lastName: String,
    @Json(name = "seccondLastName")
    val seccondLastName: String,
    @Json(name = "birthdate")
    val birthdate:String,
    @Json(name = "gender")
    val gender: Int,
    @Json(name = "idCustomer")
    val idCustomer: Int? = null)




