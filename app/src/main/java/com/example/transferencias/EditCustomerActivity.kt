package com.example.transferencias

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.transferencias.Client.ClientViewModel
import kotlinx.android.synthetic.main.activity_edit_customer.*
import androidx.lifecycle.Observer

class EditCustomerActivity : AppCompatActivity() {
    private val viewModel by lazy {
        ViewModelProviders.of(this)[ClientViewModel::class.java]
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        val idCustomer =  intent.getIntExtra("idCustomer",1)
        val customer = Customer(
            "",
            "",
            "",
            "",
            "",
            0,
            idCustomer
        )
        viewModel.getOnlyCustomer(customer);
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_customer)
        addObserver()
        addCustomerButton.setOnClickListener { editCustomer(idCustomer) }
    }

    private fun addObserver() {
        viewModel.onlyCustomer.observe(this, Observer {
            nameEditText.setText(it[0].name)
            middleNameEditText.setText(it[0].middleName)
            lastNameEditText.setText(it[0].lastName)
            secondLastNameEditText.setText(it[0].seccondLastName)
            birthDateEditText.setText(it[0].birthdate)
            genderSpinner.setSelection(it[0].gender -1)
        })

        viewModel.message.observe(this, Observer {
            val toast = Toast.makeText(applicationContext, "Se actualizo el cliente", Toast.LENGTH_LONG)
            toast.show()
        })
    }

    private fun editCustomer(idCustomer:Int) {
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
            gender,
            idCustomer
        )
        if (name != "" && lastName != "" && secondLastName !="" && birthDate !="")
            viewModel.editCustomer(customer)
        else{
            val toast = Toast.makeText(applicationContext, "No dejar campos vacios", Toast.LENGTH_LONG)
            toast.show()
        }
    }
}