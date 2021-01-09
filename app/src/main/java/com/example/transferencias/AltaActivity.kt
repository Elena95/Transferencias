package com.example.transferencias

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.transferencias.Client.ClientViewModel
import kotlinx.android.synthetic.main.activity_alta.*


class AltaActivity : AppCompatActivity() {
    private val viewModel by lazy {
        ViewModelProviders.of(this)[ClientViewModel::class.java]
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alta)
        addCustomerButton.setOnClickListener { addCustomer() }
        addObserver()
    }

    private fun addObserver() {
        viewModel.message.observe(this, Observer {
            val toast = Toast.makeText(applicationContext, "Registro exitoso", Toast.LENGTH_LONG)
            toast.show()

        })
    }
    private fun addCustomer() {
        val name = nameEditText.text.toString()
        val middleName = middleNameEditText.text.toString()
        val lastName = lastNameEditText.text.toString()
        val secondLastName = secondLastNameEditText.text.toString()
        val birthDate = birthDateEditText.text.toString()
        var gender = genderSpinner.selectedItemId.toInt()
        gender=gender+1

        val customer = Customer(
            name,
            middleName,
            lastName,
            secondLastName,
            birthDate,
            gender
        )

        if (name != "" && lastName != "" && secondLastName !="" && birthDate !="")
            viewModel.sendCustomer(customer)
        else{
            val toast = Toast.makeText(applicationContext, "No dejar campos vacios", Toast.LENGTH_LONG)
            toast.show()
        }


    }
}