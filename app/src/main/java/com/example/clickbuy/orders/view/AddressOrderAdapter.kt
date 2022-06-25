package com.example.clickbuy.orders.view

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.clickbuy.R
import com.example.clickbuy.models.Address
import com.example.clickbuy.models.CustomerAddress
import com.example.clickbuy.payment.view.AddressInterface

private const val TAG = "AddressOrderAdapter"

class AddressOrderAdapter(val context: Context, var addressInterface: AddressInterface) :
    RecyclerView.Adapter<AddressOrderAdapter.ViewHolder>() {
    var addresses: List<CustomerAddress> = emptyList()
    private var checkedPosition = 0
    private var choosenAdrres: String = ""
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AddressOrderAdapter.ViewHolder {
        val view: View =
            LayoutInflater.from(context).inflate(R.layout.custom_row_order_address, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: AddressOrderAdapter.ViewHolder,
        position: Int
    ) {
        holder.titleOfAddress.text = addresses[position].address1.toString()
        holder.itemView.setOnClickListener {
            addressInterface.showAddress(addresses[position])
        }
    }

    override fun getItemCount(): Int {
        Log.i(TAG, "getItemCount: " + addresses.size)
        return addresses.size
    }

    fun setListOfAddreses(addresees: List<CustomerAddress>) {
        this.addresses = addresees.toList()
        Log.i(TAG, "setListOfBrands: ")
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var titleOfAddress: TextView = itemView.findViewById(R.id.titleOfAddress_cus)
    }
}
