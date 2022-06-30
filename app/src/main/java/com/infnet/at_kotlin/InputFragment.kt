package com.infnet.at_kotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.infnet.at_kotlin.interfaces.Comunicator
import com.infnet.at_kotlin.model.Conta
import java.text.SimpleDateFormat
import java.util.*


class InputFragment : Fragment() {

    private lateinit var comunicator: Comunicator

    private lateinit var estabelecimento: EditText
    private lateinit var data: TextView
    private lateinit var produtos: EditText
    private lateinit var qtdPessoas: EditText
    private lateinit var percGorjeta: EditText
    private lateinit var totalConta: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_input, container, false)

        comunicator = activity as Comunicator

        estabelecimento = view.findViewById(R.id.txtEstabelecimento)
        data = view.findViewById(R.id.txtData)
        produtos = view.findViewById(R.id.txtProdutos)
        qtdPessoas = view.findViewById(R.id.txtQtdPessoas)
        percGorjeta = view.findViewById(R.id.txtGorjeta)
        totalConta = view.findViewById(R.id.txtTotal)

        // Setar Data e hora
        val date = Calendar.getInstance().time
        val dateTimeFormat = SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.getDefault())
        data.text = dateTimeFormat.format(date)

        val btnCalcular = view.findViewById<Button>(R.id.btnCalcular)

        btnCalcular.setOnClickListener(){

            val conta = atualizarDadosConta()

            comunicator.passData(conta)
        }

        return view
    }

    fun atualizarDadosConta(): Conta {

        val estabelecimentoConvertido = estabelecimento.text.toString()
        val dataConvertida = data.text.toString()
        val produtosConvertido = produtos.text.toString()

        val totalConvertido = totalConta.text.toString().toDouble()
        val qtdPessoasConvertido = qtdPessoas.text.toString().toInt()
        val percGorjetaConvertido = percGorjeta.text.toString().toDouble()

        val valorGorjeta = calcularGorjeta(totalConvertido, percGorjetaConvertido)
        val valorTotalConta = calcularValorTotalConta(totalConvertido, valorGorjeta)
        val valorPessoa = calcularValorPorPessoa(valorTotalConta, qtdPessoasConvertido)

        val conta = Conta()
        conta.estabelecimento = estabelecimentoConvertido
        conta.data = dataConvertida
        conta.produtos = produtosConvertido
        conta.totalConta = valorTotalConta.toString()
        conta.valorGorjeta = valorGorjeta.toString()
        conta.qtdPessoas = qtdPessoasConvertido.toString()
        conta.totalPessoa = valorPessoa.toString()

        return conta
        }
    }