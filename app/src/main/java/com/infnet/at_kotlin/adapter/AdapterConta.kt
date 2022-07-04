package com.infnet.at_kotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.infnet.at_kotlin.R
import com.infnet.at_kotlin.model.Conta

class AdapterConta(private val context: Context, private val contas: MutableList<Conta>): RecyclerView.Adapter<AdapterConta.ContaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContaViewHolder {
        val itemLista = LayoutInflater.from(context).inflate(R.layout.saves_item, parent, false);
        return ContaViewHolder(itemLista)
    }

    override fun onBindViewHolder(holder: ContaViewHolder, position: Int) {
        holder.estabelecimentoSave.text = contas[position].estabelecimento
        holder.dataSave.text = contas[position].data
    }

    override fun getItemCount(): Int = contas.size

    inner class ContaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val estabelecimentoSave: TextView = itemView.findViewById(R.id.txtEstabelecimentoSave)
        val dataSave: TextView = itemView.findViewById(R.id.txtDataSave)
    }

}