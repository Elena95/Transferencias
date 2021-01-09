package com.example.transferencias

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.transferencias.Client.InfoPayments
import kotlinx.android.synthetic.main.recycler_item_payments.view.*

class PaymentsAdapter(var dataset: ArrayList<InfoPayments>): RecyclerView.Adapter<PaymentsAdapter.ViewHolder>() {
    private var onClickListener: (InfoPayments) -> Unit = {}
    fun setOnItemClickListener( onClickListener: (InfoPayments) -> Unit ) {
        this.onClickListener = onClickListener
    }
    class ViewHolder(val view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_payments, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val nameComplete= dataset[position].name+" "+dataset[position].lastName+" "+dataset[position].secondLastName
        holder.view.customer.text = nameComplete
        holder.view.numPayments.text = dataset[position].totalPayment
        holder.view.sumPayments.text = dataset[position].totalAmount
        holder.view.setOnClickListener {
            onClickListener(dataset[position])
        }
    }
    override fun getItemCount(): Int {
        return dataset.size
    }
}