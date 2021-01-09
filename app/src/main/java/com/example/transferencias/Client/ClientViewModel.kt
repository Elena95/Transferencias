package com.example.transferencias.Client

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.transferencias.Customer
import com.example.transferencias.Payments
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ClientViewModel: ViewModel() {

    private val client = Client().getClient()

    val customer = MutableLiveData<List<Customer>>()
    val onlyCustomer = MutableLiveData<List<Customer>>()
    val infoPayments = MutableLiveData<List<InfoPayments>>()
    val payments = MutableLiveData<List<Payments>>()
    val message = MutableLiveData<Response>()

    fun getCustomer() {
        CoroutineScope(Dispatchers.IO).launch {
            customer.postValue(client.getCustomer().await())
        }
    }
    fun sendCustomer(customer: Customer) {
        CoroutineScope(Dispatchers.IO).launch {
            message.postValue(client.sendCustomer(customer).await())
        }
    }

    fun editCustomer(customer: Customer) {
        CoroutineScope(Dispatchers.IO).launch {
            message.postValue(client.editCustomer(customer).await())
        }
    }


    fun getPayments(payments: Payments) {
        CoroutineScope(Dispatchers.IO).launch {
            infoPayments.postValue(client.getPayments(payments).await())
        }
    }

    fun sendPayment(payments: Payments) {
        CoroutineScope(Dispatchers.IO).launch {
            message.postValue(client.sendPayment(payments).await())
        }
    }


    fun getOnlyCustomer(customer: Customer) {
        CoroutineScope(Dispatchers.IO).launch {
            onlyCustomer.postValue(client.getOnlyCustomer(customer).await())
        }
    }

}