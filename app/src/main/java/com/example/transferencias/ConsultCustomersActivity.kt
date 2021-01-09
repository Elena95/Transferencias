package com.example.transferencias

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.transferencias.Client.ClientViewModel
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_consult_payments.*

class ConsultCustomersActivity: AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProviders.of(this)[ClientViewModel::class.java]
    }

      var adapter = CustomerAdapter(ArrayList<Customer>())

    override fun onCreate(savedInstanceState: Bundle?) {
            viewModel.getCustomer();
            addObserver()
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_customers)
            mRecyclerView.layoutManager = LinearLayoutManager(this)
            mRecyclerView.adapter = adapter
            adapter.setOnItemClickListener {
                val id = it.idCustomer
                val intentEdit = Intent(this, EditCustomerActivity::class.java)
                intentEdit.putExtra("idCustomer",id)
                startActivity(intentEdit)
            }
        }

    private fun addObserver() {
         viewModel.customer.observe(this, Observer {
             adapter.dataset = it.toCollection(ArrayList())
             adapter.notifyDataSetChanged()
         })
    }

    }