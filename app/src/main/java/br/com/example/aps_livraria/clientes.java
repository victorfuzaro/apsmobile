package br.com.example.aps_livraria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class clientes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes);

        Button botao = (Button) findViewById(R.id.btnGravar);
        Button botaoConsulta = (Button) findViewById(R.id.btnConsultar);

        botao.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                BancoController crud = new BancoController(getBaseContext());
                EditText nome = (EditText) findViewById(R.id.nome);
                EditText endereco = (EditText) findViewById(R.id.endereco);
                EditText celular = (EditText) findViewById(R.id.celular);
                EditText email = (EditText) findViewById(R.id.email);
                EditText cpf = (EditText) findViewById(R.id.cpf);
                EditText nascimento = (EditText) findViewById(R.id.dtNascimento);
                EditText categoriaLeitor = (EditText) findViewById(R.id.categoriaLeitor);
                String nomeString = nome.getText().toString();
                String enderecoString = endereco.getText().toString();
                String celularString = celular.getText().toString();
                String emailString = email.getText().toString();
                String cpfString = cpf.getText().toString();
                String nascimentoString = nascimento.getText().toString();
                String categoriaLeitorString = categoriaLeitor.getText().toString();
                String resultado;

                resultado = crud.insereClientes(nomeString, enderecoString,celularString, emailString, cpfString, nascimentoString, categoriaLeitorString);

                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
            }
        });

        botaoConsulta.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(clientes.this, consulta_clientes.class);
                startActivity(intent);
            }
        });
    }
}