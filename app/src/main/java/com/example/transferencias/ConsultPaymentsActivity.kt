package com.example.transferencias

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.transferencias.Client.ClientViewModel
import kotlinx.android.synthetic.main.activity_consult_payments.*
import androidx.lifecycle.Observer
import com.example.transferencias.Client.InfoPayments

class ConsultPaymentsActivity(): AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProviders.of(this)[ClientViewModel::class.java]
    }
    var adapter = PaymentsAdapter(ArrayList<InfoPayments>())

    override fun onCreate(savedInstanceState: Bundle?) {
        val date =  intent.getStringExtra("date")
        val payment = Payments(
            0,
            "",
             date,
            ""
        )
        viewModel.getPayments(payment)
        addObserver()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consult_payments)
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        mRecyclerView.adapter = adapter
        adapter.setOnItemClickListener {
            Toast.makeText(this, "Click en $it", Toast.LENGTH_LONG).show()
        }
    }
    private fun addObserver() {
        viewModel.infoPayments.observe(this, Observer {
            adapter.dataset = it.toCollection(ArrayList())
            adapter.notifyDataSetChanged()
        })
    }

}