package br.com.example.aps_livraria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class altera_dados_clientes extends AppCompatActivity {

    EditText nome;
    EditText endereco;
    EditText celular;
    EditText email;
    EditText cpf;
    EditText nascimento;
    EditText categoriaLeitor;
    Button alterar;
    Button deletar;
    Cursor cursor;
    BancoController crud;
    String codigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_altera_dados_clientes);

        codigo = this.getIntent().getStringExtra("codigo");
        crud = new BancoController(getBaseContext());
        nome = (EditText)findViewById(R.id.nome);
        endereco = (EditText)findViewById(R.id.endereco);
        celular = (EditText)findViewById(R.id.celular);
        email = (EditText)findViewById(R.id.email);
        cpf = (EditText)findViewById(R.id.cpf);
        nascimento = (EditText)findViewById(R.id.nascimento);
        categoriaLeitor = (EditText)findViewById(R.id.categoriaLeitor);
        alterar = (Button)findViewById(R.id.button);
        cursor = crud.carregaDadoByIdClientes(Integer.parseInt(codigo));

        nome.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.getNome())));
        endereco.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.getEndereco())));
        celular.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.getCelular())));
        email.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.getEmail())));
        cpf.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.getCPF())));
        nascimento.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.getNascimento())));
        categoriaLeitor.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.getCategoriaLeitor())));


        alterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crud.alteraRegistroClientes(Integer.parseInt(codigo), nome.getText().toString(),
                        endereco.getText().toString(),celular.getText().toString(), email.getText().toString(), cpf.getText().toString(), nascimento.getText().toString(), categoriaLeitor.getText().toString());
                Intent intent = new Intent(altera_dados_clientes.this,consulta_clientes.class);
                startActivity(intent);
                finish();
            }
        });

        deletar = (Button)findViewById(R.id.button4);
        deletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crud.deletaRegistroLeitores(Integer.parseInt(codigo));
                Intent intent = new Intent(altera_dados_clientes.this,consulta_clientes.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
