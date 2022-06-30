package com.infnet.at_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.infnet.at_kotlin.interfaces.Comunicator
import com.infnet.at_kotlin.model.Conta

class MainActivity : AppCompatActivity(), Comunicator {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputFragment = InputFragment()
        supportFragmentManager.beginTransaction().replace(R.id.containerInput, inputFragment).commit()

    }

    override fun passData(conta: Conta) {
        val estabelecimento = conta.estabelecimento
        val data = conta.data
        val produtos = conta.produtos
        val totalConta = conta.totalConta
        val qtdPessoas = conta.qtdPessoas
        val gorjeta = conta.valorGorjeta
        val totalPessoa = conta.totalPessoa

        val bundle = Bundle()
        bundle.putString("estabelecimento", estabelecimento)
        bundle.putString("data", data)
        bundle.putString("produtos", produtos)
        bundle.putString("totalConta", totalConta)
        bundle.putString("qtdPessoas", qtdPessoas)
        bundle.putString("gorjeta", gorjeta)
        bundle.putString("totalPessoa", totalPessoa)

        val transaction = this.supportFragmentManager.beginTransaction()
        val resultFragment = ResultFragment()
        resultFragment.arguments = bundle

        transaction.replace(R.id.containerInput,resultFragment)
        transaction.commit()

    }


}