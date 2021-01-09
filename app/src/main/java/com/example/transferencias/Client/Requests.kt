package com.example.transferencias.Client

import com.example.transferencias.Customer
import com.example.transferencias.Payments
import kotlinx.coroutines.Deferred
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface Requests {

    @GET("getCustomers.php")
    fun getCustomer(): Deferred<List<Customer>>

    @POST("getOnlyCustomer.php")
    fun getOnlyCustomer(@Body customer: Customer): Deferred<List<Customer>>

    @POST("saveCustomer.php")
    fun sendCustomer(@Body customer: Customer): Deferred<Response>

    @POST("updateCustomer.php")
    fun editCustomer(@Body customer: Customer): Deferred<Response>

    @POST("registerPayment.php")
    fun sendPayment(@Body payments: Payments): Deferred<Response>

    @POST("getPayments.php")
    fun getPayments(@Body payments: Payments): Deferred<List<InfoPayments>>

}