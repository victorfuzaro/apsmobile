package br.com.example.aps_livraria;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
public class AlteraDados extends AppCompatActivity {

    //    EditText codigo;
    EditText isbn;
    EditText titulo;
    EditText codCateg;
    EditText autor;
    EditText keywords;
    EditText dtPublicacao;
    EditText num_edicao;
    EditText editora;
    EditText num_paginas;
    String codigo;
    Button alterar;
    Button deletar;
    Cursor cursor;
    BancoController crud;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_altera_dados);

        codigo = this.getIntent().getStringExtra("codigo");
        crud = new BancoController(getBaseContext());
//        codigo = (EditText)findViewById((R.id.codigo));
        isbn = (EditText)findViewById(R.id.isbn);
        titulo = (EditText)findViewById(R.id.titulo);
        codCateg = (EditText)findViewById(R.id.codCategoriaLivro);
        autor = (EditText)findViewById(R.id.autores);
        keywords = (EditText)findViewById(R.id.keywords);
        dtPublicacao = (EditText)findViewById(R.id.dtPublicacao);
        num_edicao = (EditText)findViewById(R.id.num_edicao);
        editora = (EditText)findViewById(R.id.editora);
        num_paginas = (EditText)findViewById(R.id.num_paginas);
//        String codigoString = codigo.getText().toString();
        alterar = (Button)findViewById(R.id.button);
        cursor = crud.carregaDadoByIdLivros(Integer.parseInt(codigo));

        isbn.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.getISBN())));
        titulo.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.getTITULO())));
        codCateg.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.getCodCategoria())));
        autor.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.getAUTOR())));
        keywords.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.getPalavrasChave())));
        dtPublicacao.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.getPalavrasChave())));
        num_edicao.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.getEdicao())));
        editora.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.getEDITORA())));
        num_paginas.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.getPaginas())));

        alterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crud.alteraRegistroLivros(Integer.parseInt(codigo),codigo,
                        isbn.getText().toString(),titulo.getText().toString(),
                        codCateg.getText().toString(), autor.getText().toString(), keywords.getText().toString(), dtPublicacao.getText().toString(), num_edicao.getText().toString(), editora.getText().toString(), num_paginas.getText().toString());
                Intent intent = new Intent(AlteraDados.this,ConsultaDados.class);
                startActivity(intent);
                finish();
            }
        });

        deletar = (Button)findViewById(R.id.button4);
        deletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crud.deletaRegistroLivros(Integer.parseInt(codigo));
                Intent intent = new Intent(AlteraDados.this,ConsultaDados.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
