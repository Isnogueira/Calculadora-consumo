package com.infnet.at_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.infnet.at_kotlin.adapter.AdapterConta
import com.infnet.at_kotlin.model.Conta
import com.infnet.at_kotlin.ui.ContaViewModel
import java.text.SimpleDateFormat
import java.util.*

class SaveActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save)

        supportActionBar!!.hide()

        val recyclerViewSaves = findViewById<RecyclerView>(R.id.recl_saves)
        recyclerViewSaves.layoutManager = LinearLayoutManager(this)

        val listaContas : MutableList<Conta> = mutableListOf()
        val adapterConta = AdapterConta(this, listaContas)
        recyclerViewSaves.adapter = adapterConta


        val estabelecimento = intent.getStringExtra("estabelecimento")
        val data = intent.getStringExtra("data")
        val produtos = intent.getStringExtra("produtos")
        val totalConta = intent.getStringExtra("totalConta")
        val qtdPessoas = intent.getStringExtra("qtdPessoas")
        val valorGorjeta = intent.getStringExtra("valorGorjeta")
        val totalPessoa = intent.getStringExtra("totalPessoa")

        val contaInput = Conta(
            estabelecimento,
            data,
            produtos,
            totalConta,
            qtdPessoas,
            valorGorjeta,
            totalPessoa
        )

        listaContas.add(contaInput)

        //TODO APAGAR MOCADOS
        listaContas.add(contaInput)
        listaContas.add(contaInput)
        listaContas.add(contaInput)
        listaContas.add(contaInput)
        listaContas.add(contaInput)
        listaContas.add(contaInput)
        listaContas.add(contaInput)
        listaContas.add(contaInput)
        listaContas.add(contaInput)
        listaContas.add(contaInput)
        listaContas.add(contaInput)
        listaContas.add(contaInput)
        listaContas.add(contaInput)
        listaContas.add(contaInput)
        listaContas.add(contaInput)
        listaContas.add(contaInput)
        listaContas.add(contaInput)
        listaContas.add(contaInput)
        listaContas.add(contaInput)
        listaContas.add(contaInput)
        listaContas.add(contaInput)
        listaContas.add(contaInput)
        listaContas.add(contaInput)
        listaContas.add(contaInput)
        listaContas.add(contaInput)
        listaContas.add(contaInput)


    }



}