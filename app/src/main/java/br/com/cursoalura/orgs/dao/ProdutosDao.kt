package br.com.cursoalura.orgs.dao

import br.com.cursoalura.orgs.model.Produto

class ProdutosDao {

    fun adicionar(produto: Produto) {
        produtos.add(produto)

    }

    fun buscarTodos(): List<Produto> {
        return produtos.toList()
    }

    companion object {
        private val produtos = mutableListOf<Produto>()
    }
}