package br.com.example.aps_livraria;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
public class altera_dados_categoria_livros extends AppCompatActivity {

    EditText codigoCateg;
    EditText PrazoMax;
    EditText descricao;
    EditText multa;
    Button alterar;
    Button deletar;
    Cursor cursor;
    BancoController crud;
    String codigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_altera_dados_categoria_livros);

        codigo = this.getIntent().getStringExtra("codigo");
        crud = new BancoController(getBaseContext());
        codigoCateg = (EditText)findViewById(R.id.codigo);
        descricao = (EditText)findViewById(R.id.descricaoCateg);
        PrazoMax = (EditText)findViewById(R.id.PrazoMax);
        multa = (EditText)findViewById(R.id.multa);
        alterar = (Button)findViewById(R.id.btnAlterar);
        cursor = crud.carregaDadoByIdLeitores(Integer.parseInt(codigo));

        codigoCateg.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.getCodCateg())));
        descricao.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.getDescricaoCategoria())));
        PrazoMax.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.getPrazo())));

        alterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crud.alteraRegistroLeitores(Integer.parseInt(codigo), codigoCateg.getText().toString(),
                        descricao.getText().toString(),PrazoMax.getText().toString());
                Intent intent = new Intent(altera_dados_categoria_livros.this,consulta_categoria_livros.class);
                startActivity(intent);
                finish();
            }
        });

        deletar = (Button)findViewById(R.id.btnConsultar);
        deletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crud.deletaRegistroLeitores(Integer.parseInt(codigo));
                Intent intent = new Intent(altera_dados_categoria_livros.this,consulta_categoria_livros.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
