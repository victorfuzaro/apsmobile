package br.com.example.aps_livraria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class categoria_livros extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria_livros);

        Button botao = (Button) findViewById(R.id.btnAlterar);
        Button botaoConsulta = (Button) findViewById(R.id.btnConsultar);

        botao.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                BancoController crud = new BancoController(getBaseContext());
                EditText codigo = (EditText) findViewById(R.id.codigo);
                EditText descricao = (EditText) findViewById(R.id.descricaoCateg);
                EditText prazo = (EditText) findViewById(R.id.PrazoMax);
                EditText multa = (EditText) findViewById(R.id.multa);
                String codigoString = codigo.getText().toString();
                String descricaoString = descricao.getText().toString();
                String prazoString = prazo.getText().toString();
                String multaString = multa.getText().toString();
                String resultado;

                resultado = crud.insereCategoriaLivros(codigoString, descricaoString,prazoString, multaString);

                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
            }
        });

        botaoConsulta.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(categoria_livros.this, consulta_categoria_livros.class);
                startActivity(intent);
            }
        });
    }
}