package br.com.example.aps_livraria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class categoria_leitores extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria_leitores);

        Button botao = (Button) findViewById(R.id.btnAlterar);
        Button botaoConsulta = (Button) findViewById(R.id.btnConsultar);

        botao.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                BancoController crud = new BancoController(getBaseContext());
                EditText categoria = (EditText) findViewById(R.id.CatLeitores);
                EditText prazo = (EditText) findViewById(R.id.tvCodCateg);
                EditText descricao = (EditText) findViewById(R.id.etDescricaoCateg);
                String categoriaString = categoria.getText().toString();
                String prazoString = prazo.getText().toString();
                String descricaoString = descricao.getText().toString();
                String resultado;

                resultado = crud.insereCategoriaLeitores(categoriaString, descricaoString,prazoString);

                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
            }
        });

        botaoConsulta.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(categoria_leitores.this, consulta_categoria_leitores.class);
                startActivity(intent);
            }
        });
    }
}
