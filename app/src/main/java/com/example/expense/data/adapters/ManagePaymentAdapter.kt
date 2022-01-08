package com.example.expense.data.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.expense.R
import com.example.expense.data.db.entities.Payment
import com.example.expense.ui.fragments.ManagePaymentFragmentDirections

class ManagePaymentAdapter: RecyclerView.Adapter<ManagePaymentAdapter.MyViewHolder>() {

    private var paymentList = emptyList<Payment>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row_master, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = paymentList[position]
        holder.tvPayment.text = currentItem.payment
        holder.cvManagePayment.setOnClickListener {
            val action = ManagePaymentFragmentDirections.actionManagePaymentFragmentToUpdatePaymentFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return paymentList.size
    }

    fun setData(paytList: List<Payment>) {
        this.paymentList = paytList
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val tvPayment: TextView = itemView.findViewById(R.id.cvMasterTitle)
        val cvManagePayment: ConstraintLayout = itemView.findViewById(R.id.cvMasterLayout)

    }



}
