package com.example.transferencias

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        altaBtn.setOnClickListener {
            val intento1 = Intent(this, AltaActivity::class.java)
            startActivity(intento1)
        }

        consultaBtn.setOnClickListener {
            val intentConsult = Intent(this, ConsultCustomersActivity::class.java)
            startActivity(intentConsult)
        }

        registroBtn.setOnClickListener {
            val intentPagos = Intent(this, PagosActivity::class.java)
            startActivity(intentPagos)
        }

        resumenBtn.setOnClickListener {
           val intentShowPagos = Intent(this, SelectDateActivity::class.java)
            startActivity(intentShowPagos)
            //showDatePickerDialog()
        }

        consultaBtn.setOnLongClickListener {
            val intent = Intent(this, EditCustomerActivity::class.java)
            startActivity(intent)
            true
        }
    }
    private fun showDatePickerDialog() {
    }
}
