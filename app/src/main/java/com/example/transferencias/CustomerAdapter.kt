package com.example.transferencias

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_item.view.*

class CustomerAdapter(var dataset: ArrayList<Customer>): RecyclerView.Adapter<CustomerAdapter.ViewHolder>() {

    private var onClickListener: (Customer) -> Unit = {}

    fun setOnItemClickListener( onClickListener: (Customer) -> Unit ) {
        this.onClickListener = onClickListener
    }

    class ViewHolder(val view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val nameComplete= dataset[position].name+" "+dataset[position].middleName+" "+dataset[position].lastName+" "+dataset[position].seccondLastName
        holder.view.name.text = nameComplete
        holder.view.birthdate.text = dataset[position].birthdate
        holder.view.buttonEditCustomer.setOnClickListener {
            onClickListener(dataset[position])
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}