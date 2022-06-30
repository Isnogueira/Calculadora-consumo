package com.infnet.at_kotlin

fun calcularGorjeta(valorTotal: Double, percGorjeta: Double): Double{
    val valorGorjeta = valorTotal * (percGorjeta / 100)
    return valorGorjeta
}

fun calcularValorTotalConta(valorTotal: Double, valorGorjeta: Double) : Double{
    val valorTotalConta = valorTotal + valorGorjeta
    return valorTotalConta
}

fun calcularValorPorPessoa(valorTotalConta: Double, qtdPessoasConvertido: Int): Double{
    val valorPessoa = valorTotalConta / qtdPessoasConvertido
    return valorPessoa
}
