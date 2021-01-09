package com.example.transferencias

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class SpinnerAdapter(
    context: Context,
    resource: Int,
    dataset: ArrayList<Customer>
) : ArrayAdapter<Customer>(context, resource) {

    var dataset = dataset

    override fun getCount(): Int {
        return dataset.size
    }

    override fun getItem(position: Int): Customer? {
        return dataset[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val nameComplete= dataset[position].name+" "+dataset[position].middleName+" "+dataset[position].lastName+" "+dataset[position].seccondLastName
        val label: TextView = super.getView(position, convertView, parent) as TextView
        label.text = nameComplete
        return label
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        val label = super.getDropDownView(position, convertView, parent) as TextView
        val nameComplete= dataset[position].name+" "+dataset[position].middleName+" "+dataset[position].lastName+" "+dataset[position].seccondLastName
        label.text = nameComplete

        return label
    }

    override fun isEnabled(position: Int): Boolean {
        return position != 0
    }
}