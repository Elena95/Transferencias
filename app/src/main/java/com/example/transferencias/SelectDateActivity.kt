package com.example.transferencias

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.transferencias.Client.ClientViewModel
import kotlinx.android.synthetic.main.activity_date.*

class SelectDateActivity : AppCompatActivity() {
    private val viewModel by lazy {
        ViewModelProviders.of(this)[ClientViewModel::class.java]
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date)
        showButton.setOnClickListener { getPayments()
            }
    }
    private fun getPayments() {
        val date = dateEditText.text.toString()
        if (date != ""){
            val intentPagos = Intent(this, ConsultPaymentsActivity()::class.java)
            intentPagos.putExtra("date",date)
            startActivity(intentPagos)
        }else{
            val toast = Toast.makeText(applicationContext, "No dejar campos vacios", Toast.LENGTH_LONG)
            toast.show()
        }
    }
}