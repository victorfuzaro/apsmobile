package br.com.example.aps_livraria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button botao = (Button) findViewById(R.id.btnAlterar);
        Button botaoConsulta = (Button) findViewById(R.id.btnConsultar);

        botao.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                BancoController crud = new BancoController(getBaseContext());
                EditText codigo = (EditText) findViewById(R.id.codigo);
                EditText isbn = (EditText) findViewById(R.id.isbn);
                EditText titulo = (EditText) findViewById(R.id.titulo);
                EditText codCateg = (EditText) findViewById(R.id.codCategoriaLivro);
                EditText autor = (EditText) findViewById(R.id.autores);
                EditText palavras_chave = (EditText) findViewById(R.id.keywords);
                EditText dtPublicacao = (EditText) findViewById(R.id.dtPublicacao);
                EditText num_edicao = (EditText) findViewById(R.id.num_edicao);
                EditText editora = (EditText) findViewById(R.id.editora);
                EditText num_paginas = (EditText) findViewById(R.id.num_paginas);
                String codigoString = codigo.getText().toString();
                String isbnString = isbn.getText().toString();
                String tituloString = titulo.getText().toString();
                String codCategString = codCateg.getText().toString();
                String autoresString = autor.getText().toString();
                String palavrasChaveString = palavras_chave.getText().toString();
                String dtPublicacaoString = dtPublicacao.getText().toString();
                String edicaoString = num_edicao.getText().toString();
                String editoraString = editora.getText().toString();
                String paginasString = num_paginas.getText().toString();
                String resultado;

                resultado = crud.insereLivros(codigoString, isbnString,tituloString,codCategString,autoresString, palavrasChaveString,dtPublicacaoString, edicaoString, editoraString, paginasString);

                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
            }
        });

        botaoConsulta.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, ConsultaDados.class);
                startActivity(intent);
            }
        });
    }
}

