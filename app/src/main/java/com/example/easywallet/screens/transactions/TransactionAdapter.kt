package com.example.easywallet.screens.transactions

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewParent
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.easywallet.databinding.ListItemTransactionBinding
import com.example.easywallet.domain.Transaction

class TransactionAdapter (): ListAdapter<Transaction, TransactionsViewHolder> (TransactionDiffCallBack()){
    override fun onBindViewHolder(holder: TransactionsViewHolder, position: Int){
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionsViewHolder {
        return TransactionsViewHolder.from(parent)
    }
}

class TransactionsViewHolder(val binding: ListItemTransactionBinding): RecyclerView.ViewHolder(binding.root){
    companion object {
        fun from(parent: ViewGroup): TransactionsViewHolder{
            val inflater = LayoutInflater.from(parent.context)
            val binding = ListItemTransactionBinding.inflate(inflater, parent, false)
            return TransactionsViewHolder(binding)
        }
    }
    fun bind(item: Transaction){
        binding.transaction = item
    }
}

class TransactionDiffCallBack: DiffUtil.ItemCallback<Transaction>(){
    override fun areContentsTheSame(oldItem: Transaction, newItem: Transaction): Boolean {
       return oldItem.transactionId == newItem.transactionId
    }

    override fun areItemsTheSame(oldItem: Transaction, newItem: Transaction): Boolean {
        return oldItem == newItem
    }
}
