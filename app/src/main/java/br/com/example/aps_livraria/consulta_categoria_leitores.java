package br.com.example.aps_livraria;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class consulta_categoria_leitores extends AppCompatActivity {
    private ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_categoria_leitores);

        BancoController crud = new BancoController(getBaseContext());
        final Cursor cursor = crud.carregaDadosLeitores();

        String[] nomeCampos = new String[] {CriaBanco.getID(), CriaBanco.getCodCateg(), CriaBanco.getDescricaoCateg(), CriaBanco.getPrazo()};
        int[] idViews = new int[] {R.id.codigo,R.id.descricao, R.id.prazo};

        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(getBaseContext(),
                R.layout.activity_consulta_categoria_leitores,cursor,nomeCampos,idViews, 0);

        lista = (ListView)findViewById(R.id.lvCategoriaLivros);
        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String codigo;
                cursor.moveToPosition(position);
                codigo = cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.getID()));
                Intent intent = new Intent(consulta_categoria_leitores.this, altera_dados_leitores.class);
                intent.putExtra("codigo", codigo);
                startActivity(intent);
                finish();
            }
        });
    }
}
