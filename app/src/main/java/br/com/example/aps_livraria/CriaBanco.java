package br.com.example.aps_livraria;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CriaBanco extends SQLiteOpenHelper{

    private static final String NOME_BANCO = "livros.db";

    private static final String TABELA_LIVRARIA = "livros";
    private static final String ID = "_id";
    private static final String Codigo = "codigo";
    private static final String TITULO = "titulo";
    private static final String AUTOR = "autor";
    private static final String EDITORA = "editora";
    private static final String PalavrasChave = "palavras";
    private static final String ISBN = "_isbn";
    private static final String CodCategoria = "_codCategoria";
    private static final String DataPublicacao = "data";
    private static final String edicao = "_edicao";
    private static final String paginas = "_paginas";
    private static final int VERSAO = 1;

    private static final String TABELA_CLIENTES = "clientes";
    private static final String Nome = "nome";
    private static final String CPF = "cpf";
    private static final String Endereco = "endereco";
    private static final String Celular = "celular";
    private static final String Nascimento = "nascimento";
    private static final String CategoriaLeitor = "categoria";
    private static final String Email = "email";

    private static final String TABELA_LEITORES = "leitores";
    private static final String CodCateg = "_codcateg";
    private static final String DescricaoCategoria = "descricao";
    private static final String Prazo = "_prazo";

    private static final String TABELA_CATEGORIAS = "categorias";
    private static final String CodCat = "_codcat";
    private static final String DescricaoCateg = "descricao";
    private static final String PrazoMax = "_prazomax";
    private static final String Multa = "_multa";




    public CriaBanco(Context context) {
        super(context, getNomeBanco(), null, getVERSAO());


    }


    public static String getTABELA() {
        return TABELA_LIVRARIA;
    }

    public static String getCodigo() {
        return Codigo;
    }

    public static String getTITULO() {
        return TITULO;
    }

    public static String getAUTOR() {
        return AUTOR;
    }

    public static String getEDITORA() {
        return EDITORA;
    }

    public static int getVERSAO() {
        return VERSAO;
    }

    public static String getNomeBanco() {
        return NOME_BANCO;
    }

    public static String getTabelaClientes() {
        return TABELA_CLIENTES;
    }

    public static String getNome() {
        return Nome;
    }

    public static String getCPF() {
        return CPF;
    }

    public static String getEndereco() {
        return Endereco;
    }

    public static String getCelular() {
        return Celular;
    }

    public static String getNascimento() {
        return Nascimento;
    }

    public static String getCategoriaLeitor() {
        return CategoriaLeitor;
    }


    public static String getEmail() {
        return Email;
    }

    public static String getPalavrasChave() {
        return PalavrasChave;
    }

    public static String getISBN() {
        return ISBN;
    }

    public static String getCodCategoria() {
        return CodCategoria;
    }

    public static String getEdicao() {
        return edicao;
    }

    public static String getPaginas() {
        return paginas;
    }

    public static String getTabelaLeitores() {
        return TABELA_LEITORES;
    }

    public static String getDescricaoCategoria() {
        return DescricaoCategoria;
    }

    public static String getPrazo() {
        return Prazo;
    }

    public static String getTabelaCategorias() {
        return TABELA_CATEGORIAS;
    }

    public static String getCodCateg() {
        return CodCateg;
    }

    public static String getDescricaoCateg() {
        return DescricaoCateg;
    }

    public static String getDataPublicacao() {
        return DataPublicacao;
    }

    public static String getPrazoMax() {
        return PrazoMax;
    }

    public static String getMulta() {
        return Multa;
    }

    public static String getCodCat() {
        return CodCat;
    }

    public static String getID() {
        return ID;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String sql_catlivros = "CREATE TABLE " + TABELA_CATEGORIAS + "("
                + ID + " integer primary key autoincrement,"
                + CodCat + " text,"
                + DescricaoCategoria + " text,"
                + PrazoMax + " text,"
                + Multa  + " text"
                + ")";

        String sql = "CREATE TABLE " + TABELA_LIVRARIA + "("
                + ID + " integer primary key autoincrement,"
                + Codigo + " text,"
                + TITULO + " text,"
                + AUTOR +  " text,"
                + EDITORA + " text,"
                + ISBN + " text,"
                + PalavrasChave + " text,"
                + DataPublicacao + " text,"
                + edicao + " text,"
                + paginas + " text,"
                + CodCategoria + " text"
                + ")";

        String sql_catleitores = "CREATE TABLE " + TABELA_LEITORES + "("
                + ID + " integer primary key autoincrement,"
                + CodCateg + " text,"
                + DescricaoCateg + " text,"
                + Prazo + " text"
                + ")";

        String sql_clientes = "CREATE TABLE " + TABELA_CLIENTES + "("
                + ID + " integer primary key autoincrement,"
                + CPF + " text,"
                + Nome + " text,"
                + Endereco + " text,"
                + Celular  + " text,"
                + Email + " text,"
                + Nascimento + " text,"
                + CategoriaLeitor + " text"
                + ")";

        sqLiteDatabase.execSQL(sql_catlivros);
        sqLiteDatabase.execSQL(sql);
        sqLiteDatabase.execSQL(sql_catleitores);
        sqLiteDatabase.execSQL(sql_clientes);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + getTABELA());
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + getTabelaCategorias());
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + getTabelaClientes());
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + getTabelaLeitores());
        onCreate(sqLiteDatabase);
    }
}
