package com.infnet.at_kotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.infnet.at_kotlin.model.Conta


class InputFragment : Fragment() {

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
       val root = inflater.inflate(R.layout.fragment_input, container, false)

        val viewModel = ViewModelProvider(this).get(DataViewModel::class.java)

        val data: TextView = root.findViewById(R.id.txtData)
        viewModel.data.observe(viewLifecycleOwner, Observer {
            data.text = it
        })

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        estabelecimento = view.findViewById(R.id.txtEstabelecimento)
        produtos = view.findViewById(R.id.txtProdutos)
        qtdPessoas = view.findViewById(R.id.txtQtdPessoas)
        percGorjeta = view.findViewById(R.id.txtGorjeta)
        totalConta = view.findViewById(R.id.txtTotal)
        data = view.findViewById(R.id.txtData)

        val btnCalcular = view.findViewById<Button>(R.id.btnCalcular)
        btnCalcular.setOnClickListener() {

            val viewModel = ViewModelProvider(this).get(DataViewModel::class.java)

            viewModel.data.observe(viewLifecycleOwner, Observer {
                data.text = it
            })

            var contaViewModel : ContaViewModel? = null
            activity?.let {
                contaViewModel = ViewModelProvider(it)[ContaViewModel::class.java]
            }

            val conta = atualizarDadosConta()
            contaViewModel?.conta = Conta(
                conta.estabelecimento,
                conta.data,
                conta.produtos,
                conta.totalConta,
                conta.qtdPessoas,
                conta.valorGorjeta,
                conta.totalPessoa

            )
            findNavController().navigate(R.id.action_inputFragment_to_resultFragment)
        }

    }


    private fun atualizarDadosConta(): Conta {

        val totalConvertido = totalConta.text.toString().toDouble()
        val qtdPessoasConvertido = qtdPessoas.text.toString().toInt()
        val percGorjetaConvertido = percGorjeta.text.toString().toDouble()

        val valorGorjeta = calcularGorjeta(totalConvertido, percGorjetaConvertido)
        val valorTotalConta = calcularValorTotalConta(totalConvertido, valorGorjeta)
        val valorPessoa = calcularValorPorPessoa(valorTotalConta, qtdPessoasConvertido)

        val conta = Conta(
            estabelecimento.text.toString(),
            data.text.toString(),
            produtos.text.toString(),
            valorTotalConta.toString(),
            qtdPessoasConvertido.toString(),
            valorGorjeta.toString(),
            valorPessoa.toString()
        )

        return conta
    }

}