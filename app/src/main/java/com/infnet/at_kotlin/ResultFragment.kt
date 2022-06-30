package com.infnet.at_kotlin

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.infnet.at_kotlin.model.Conta

class ResultFragment : Fragment() {

    private lateinit var resultEstabelecimento: TextView
    private lateinit var resultData: TextView
    private lateinit var resultProdutos: TextView
    private lateinit var resultTotalConta: TextView
    private lateinit var resultQtdPessoas: TextView
    private lateinit var resultValorGorjeta: TextView
    private lateinit var resultValorPessoa: TextView

    var displayResultEstabelecimento: String? = ""
    var displayResultData: String? = ""
    var displayResultProdutos: String? = ""
    var displayResultTotalConta: String? = ""
    var displayResultQtdPessoas: String? = ""
    var displayResultGorjeta: String? = ""
    var displayResultValorPessoa: String? = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_result, container, false)

        displayResultEstabelecimento = arguments?.getString("estabelecimento")
        displayResultData = arguments?.getString("data")
        displayResultProdutos = arguments?.getString("produtos")
        displayResultTotalConta = arguments?.getString("totalConta")
        displayResultQtdPessoas = arguments?.getString("qtdPessoas")
        displayResultGorjeta = arguments?.getString("gorjeta")
        displayResultValorPessoa = arguments?.getString("totalPessoa")

        resultEstabelecimento = view.findViewById(R.id.lblResultEstabelecimento)
        resultData = view.findViewById(R.id.lblResultData)
        resultProdutos = view.findViewById(R.id.lblResultProdutos)
        resultTotalConta = view.findViewById(R.id.lblResultTotalConta)
        resultQtdPessoas = view.findViewById(R.id.lblResultQtd)
        resultValorGorjeta = view.findViewById(R.id.lblResultGorjeta)
        resultValorPessoa = view.findViewById(R.id.lblValorPessoa)

        resultEstabelecimento.text = displayResultEstabelecimento
        resultData.text = displayResultData
        resultProdutos.text = displayResultProdutos
        resultTotalConta.text = displayResultTotalConta
        resultQtdPessoas.text = displayResultQtdPessoas
        resultValorGorjeta.text = displayResultGorjeta
        resultValorPessoa.text = displayResultValorPessoa

        val btnCompatilhar = view.findViewById<Button>(R.id.btnCompatilhar)

        btnCompatilhar.setOnClickListener(){

            val conta = Conta()
            conta.estabelecimento = resultEstabelecimento.text.toString()
            conta.data = resultData.text.toString()
            conta.produtos = resultProdutos.text.toString()
            conta.totalConta = resultTotalConta.text.toString()
            conta.valorGorjeta = resultQtdPessoas.text.toString()
            conta.qtdPessoas = resultValorGorjeta.text.toString()
            conta.totalPessoa = resultValorPessoa.text.toString()


            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, conta.toString())

            val chooser =
                Intent.createChooser(shareIntent, "Selecione uma opção de compartilhamento")
            this.startActivity(chooser)
        }

        return view
    }



}