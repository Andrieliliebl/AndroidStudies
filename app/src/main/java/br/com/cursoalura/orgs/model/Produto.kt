package br.com.cursoalura.orgs.model

import java.math.BigDecimal

data class Produto(
    val nome: String,
    val descricao: String,
    val preco: BigDecimal,
)