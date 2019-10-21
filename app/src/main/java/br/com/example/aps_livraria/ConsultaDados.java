package br.com.example.aps_livraria;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class ConsultaDados extends AppCompatActivity {
    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_dados);

        BancoController crud = new BancoController(getBaseContext());
        final Cursor cursor = crud.carregaDadosLivros();
        String[] nomeCampos = {CriaBanco.getID(), CriaBanco.getISBN(), CriaBanco.getTITULO(), CriaBanco.getCodCategoria(),CriaBanco.getAUTOR(), CriaBanco.getPalavrasChave(),CriaBanco.getDataPublicacao(),CriaBanco.getEdicao(),CriaBanco.getEDITORA(), CriaBanco.getPaginas()};

        int[] idViews = new int[] {R.id.codigo, R.id.descricao, R.id.prazo, R.id.tvCodCateg, R.id.tvAutor, R.id.tvKeywords,R.id.tvDtPublicacao,R.id.tvEdicao, R.id.tvEditora, R.id.tvPaginas };

        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(getBaseContext(),
                R.layout.activity_consulta_dados,cursor,nomeCampos,idViews, 0);

        lista = (ListView)findViewById(R.id.lvCategoriaLivros);
        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String codigo;
                cursor.moveToPosition(position);
                codigo = cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.getID()));
                Intent intent = new Intent(ConsultaDados.this, AlteraDados.class);
                intent.putExtra("codigo", codigo);
                startActivity(intent);
                finish();
            }
        });

    }
}