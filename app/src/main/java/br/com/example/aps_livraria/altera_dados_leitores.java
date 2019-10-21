package br.com.example.aps_livraria;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
public class altera_dados_leitores extends AppCompatActivity {

    EditText CodCateg;
    EditText Prazo;
    EditText descricao;
    Button alterar;
    Button deletar;
    Cursor cursor;
    BancoController crud;
    String codigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_altera_dados_leitores);

        codigo = this.getIntent().getStringExtra("codigo");
        crud = new BancoController(getBaseContext());
        CodCateg = (EditText)findViewById(R.id.CatLeitores);
        descricao = (EditText)findViewById(R.id.descricaoCateg);
        Prazo = (EditText)findViewById(R.id.tvCodCateg);
        alterar = (Button)findViewById(R.id.btnAlterar);
        cursor = crud.carregaDadoByIdLeitores(Integer.parseInt(codigo));

        CodCateg.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.getCodCateg())));
        descricao.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.getDescricaoCateg())));
        Prazo.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.getPrazo())));

        alterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crud.alteraRegistroLeitores(Integer.parseInt(codigo), CodCateg.getText().toString(),
                        descricao.getText().toString(),Prazo.getText().toString());
                Intent intent = new Intent(altera_dados_leitores.this,consulta_categoria_leitores.class);
                startActivity(intent);
                finish();
            }
        });

//        deletar = (Button)findViewById(R.id.button3);
//        deletar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                crud.deletaRegistroLeitores(Integer.parseInt(codigo));
//                Intent intent = new Intent(AlteraDadosLeitores.this,consulta_categoria_leitores.class);
//                startActivity(intent);
//                finish();
//            }
//        });

    }
}
