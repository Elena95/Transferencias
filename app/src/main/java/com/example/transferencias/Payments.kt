package com.example.transferencias

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import org.jetbrains.annotations.NotNull
import java.util.*

data class Payments (
    @Json(name = "id_customer") val idCustomer: Int? = null,
    @Json(name = "register_date") val regiterDate: String? = null,
    @Json(name = "date") val date: String,
    @Json(name = "amount") val amount: String
)

