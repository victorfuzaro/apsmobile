package br.com.example.aps_livraria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class consulta_clientes extends AppCompatActivity {
    private ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_clientes);

        BancoController crud = new BancoController(getBaseContext());
        final Cursor cursor = crud.carregaDadosClientes();

        String[] nomeCampos = new String[] {CriaBanco.getID(), CriaBanco.getNome(), CriaBanco.getEndereco(), CriaBanco.getCelular(), CriaBanco.getEmail(), CriaBanco.getCPF(), CriaBanco.getNascimento(), CriaBanco.getCategoriaLeitor()};
        int[] idViews = new int[] {R.id.nome,R.id.endereco, R.id.celular, R.id.email, R.id.cpf, R.id.nascimento, R.id.categoriaLeitor};

        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(getBaseContext(),
                R.layout.activity_consulta_clientes,cursor,nomeCampos,idViews, 0);

        lista = (ListView)findViewById(R.id.lvClientes);
        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String codigo;
                cursor.moveToPosition(position);
                codigo = cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.getID()));
                Intent intent = new Intent(consulta_clientes.this, altera_dados_leitores.class);
                intent.putExtra("codigo", codigo);
                startActivity(intent);
                finish();
            }
        });
    }


}
