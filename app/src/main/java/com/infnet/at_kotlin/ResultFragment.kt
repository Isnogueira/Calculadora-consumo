package com.infnet.at_kotlin

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.infnet.at_kotlin.model.Conta

class ResultFragment : Fragment() {

    private lateinit var resultEstabelecimento: TextView
    private lateinit var resultData: TextView
    private lateinit var resultProdutos: TextView
    private lateinit var resultTotalConta: TextView
    private lateinit var resultQtdPessoas: TextView
    private lateinit var resultValorGorjeta: TextView
    private lateinit var resultValorPessoa: TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        resultEstabelecimento = view.findViewById(R.id.lblResultEstabelecimento)
        resultData = view.findViewById(R.id.lblResultData)
        resultProdutos = view.findViewById(R.id.lblResultProdutos)
        resultTotalConta = view.findViewById(R.id.lblResultTotalConta)
        resultQtdPessoas = view.findViewById(R.id.lblResultQtd)
        resultValorGorjeta = view.findViewById(R.id.lblResultGorjeta)
        resultValorPessoa = view.findViewById(R.id.lblValorPessoa)

        var contaViewModel : ContaViewModel? = null
        activity?.let {
            contaViewModel = ViewModelProvider(it)[ContaViewModel::class.java]
        }
            val conta = contaViewModel!!.conta
            if (conta != null) {
                resultEstabelecimento.text = conta.estabelecimento
                resultData.text = conta.data
                resultProdutos.text = conta.produtos
                resultTotalConta.text = conta.totalConta
                resultQtdPessoas.text = conta.qtdPessoas
                resultValorGorjeta.text = conta.valorGorjeta
                resultValorPessoa.text = conta.totalPessoa
            }


            val btnCompatilhar = view.findViewById<Button>(R.id.btnCompatilhar)
            btnCompatilhar.setOnClickListener() {
                onClickBtnListener(conta)
            }

    }

   private fun onClickBtnListener(conta: Conta?){
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "text/plain"
        shareIntent.putExtra(Intent.EXTRA_TEXT, conta.toString())

        val chooser =
            Intent.createChooser(shareIntent, "Selecione uma opção de compartilhamento")
        this.startActivity(chooser)
   }


}