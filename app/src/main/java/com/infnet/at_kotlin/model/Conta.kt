package com.infnet.at_kotlin.model

class Conta (
    var estabelecimento: String,
    var data: String,
    var produtos: String,
    var totalConta: String,
    var qtdPessoas: String,
    var valorGorjeta: String,
    var totalPessoa: String,
) {

    override fun toString(): String {

        return (
                "------------------------------------------------------" + "\n" +
                        "Aqui está sua conta calculada" + "\n" +
                        "------------------------------------------------------" + "\n" +
                        "Nome do estabelecimento: ${this.estabelecimento}" + "\n" +
                        "---------------------------------------------------" + "\n" +
                        "Data do consumo: ${this.data}"  + "\n" +
                        "----------------------------------------------------" + "\n" +
                        "Pedido: ${this.produtos}"  + "\n" +

                        "----------------------------------------------------" + "\n" +
                        "Quantidade de pessoas: ${this.qtdPessoas}"  + "\n" +
                        "----------------------------------------------------" + "\n" +
                        "Valor de gorjeta: ${this.valorGorjeta}"  + "\n" +
                        "-----------------------------------------------------" + "\n" +
                        "Valor Total conta: ${this.totalConta}" + "\n" +
                        "-----------------------------------------------------" + "\n" +
                        "Valor por pessoa: ${this.totalPessoa}"

                )

    }
}





