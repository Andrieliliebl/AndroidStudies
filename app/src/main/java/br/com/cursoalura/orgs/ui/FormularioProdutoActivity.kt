package br.com.cursoalura.orgs.ui

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.com.cursoalura.orgs.R
import br.com.cursoalura.orgs.dao.ProdutosDao
import br.com.cursoalura.orgs.model.Produto
import java.math.BigDecimal

class FormularioProdutoActivity : AppCompatActivity(R.layout.activity_formulario_produto) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val botaoSalvar = findViewById<Button>(R.id.botao_salvar)
        botaoSalvar.setOnClickListener {
            val campoNome = findViewById<EditText>(R.id.nome)
            val nome = campoNome.text.toString()
            val campoDescricao = findViewById<EditText>(R.id.descricao)
            val descricao = campoDescricao.text.toString()
            val campoPreco = findViewById<EditText>(R.id.preco)
            val precoEmtexto = campoPreco.text.toString()

            val preco = if(precoEmtexto.isBlank()) {
                BigDecimal.ZERO
            } else {
                BigDecimal(precoEmtexto)
            }

            val produtoNovo = Produto(
                nome = nome,
                descricao = descricao,
                preco = preco
            )

            Log.i("FormularioProdutoActivity", "onCreate($produtoNovo)")

            val dao = ProdutosDao()
            dao.adicionar(produtoNovo)

            Log.i("FormularioProdutoActivity", "onCreate(${dao.buscarTodos()})")
            finish()

        }
    }


}