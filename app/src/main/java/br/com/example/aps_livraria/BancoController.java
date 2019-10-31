package br.com.example.aps_livraria;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;

public class BancoController {
    private SQLiteDatabase db;
    private CriaBanco banco;

    public BancoController(Context context) {
        banco = new CriaBanco(context);
    }
//    public String insereDado(String titulo, String autor, String editora){
//        ContentValues valores;
//        long resultado;
//
//        db = banco.getWritableDatabase();
//        valores = new ContentValues();
//        valores.put(CriaBanco.getTITULO(), titulo);
//        valores.put(CriaBanco.getAUTOR(), autor);
//        valores.put(CriaBanco.getEDITORA(), editora);
//
//        resultado = db.insert(CriaBanco.getTABELA(),null, valores);
//        db.close();
//
//        if(resultado == -1)
//            return "Erro ao inserir registro";
//        else
//            return "Registro inserido com sucesso!";
//    }

    public String insereCategoriaLeitores(String categoria, String prazo, String descricao) {
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBanco.getCodCateg(), categoria);
        valores.put(CriaBanco.getDescricaoCategoria(), descricao);
        valores.put(CriaBanco.getPrazo(), prazo);
        resultado = db.insert(CriaBanco.getTabelaLeitores(), null, valores);
        db.close();

        if (resultado == -1)
            return "Erro ao inserir registro";
        else
            return "Registro inserido com sucesso!";
    }

    public String insereLivros(String codigo, String isbn, String titulo, String codCateg, String autores, String palavras_chave, String dtPublicacao, String edicao, String editora, String paginas) {
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBanco.getCodigo(), codigo);
        valores.put(CriaBanco.getISBN(), isbn);
        valores.put(CriaBanco.getTITULO(), titulo);
        valores.put(CriaBanco.getCodCategoria(), codCateg);
        valores.put(CriaBanco.getAUTOR(), autores);
        valores.put(CriaBanco.getPalavrasChave(), palavras_chave);
        valores.put(CriaBanco.getDataPublicacao(), dtPublicacao);
        valores.put(CriaBanco.getEdicao(), edicao);
        valores.put(CriaBanco.getEDITORA(), editora);
        valores.put(CriaBanco.getPaginas(), paginas);

        resultado = db.insert(CriaBanco.getTABELA(), null, valores);
        db.close();

        if (resultado == -1)
            return "Erro ao inserir registro";
        else
            return "Registro inserido com sucesso!";
    }

    public String insereCategoriaLivros(String codigo, String descricao, String prazo, String multa) {
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBanco.getCodCat(), codigo);
        valores.put(CriaBanco.getDescricaoCateg(), descricao);
        valores.put(CriaBanco.getPrazoMax(), prazo);
        valores.put(CriaBanco.getMulta(), multa);
        resultado = db.insert(CriaBanco.getTabelaCategorias(), null, valores);
        db.close();

        if (resultado == -1)
            return "Erro ao inserir registro";
        else
            return "Registro inserido com sucesso!";
    }

    public String insereClientes(String nome, String endereco, String celular, String email, String cpf, String nascimento, String categoriaLeitor) {
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBanco.getNome(), nome);
        valores.put(CriaBanco.getEndereco(), endereco);
        valores.put(CriaBanco.getCelular(), celular);
        valores.put(CriaBanco.getEmail(), email);
        valores.put(CriaBanco.getCPF(), cpf);
        valores.put(CriaBanco.getNascimento(), nascimento);
        valores.put(CriaBanco.getCategoriaLeitor(), categoriaLeitor);
        resultado = db.insert(CriaBanco.getTabelaClientes(), null, valores);
        db.close();

        if (resultado == -1)
            return "Erro ao inserir registro";
        else
            return "Registro inserido com sucesso!";
    }


    public Cursor carregaDadosLeitores() {
        Cursor cursor;
        String[] campos = {CriaBanco.getID(), CriaBanco.getCodCateg(), CriaBanco.getDescricaoCategoria(), CriaBanco.getPrazo()};
        db = banco.getReadableDatabase();
        cursor = db.query(CriaBanco.getTabelaLeitores(), campos, null, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor carregaDadosLivros() {
        Cursor cursor;
        String[] campos = {CriaBanco.getID(), CriaBanco.getISBN(), CriaBanco.getTITULO(), CriaBanco.getCodCategoria(),CriaBanco.getAUTOR(), CriaBanco.getPalavrasChave(),CriaBanco.getDataPublicacao(),CriaBanco.getEdicao(),CriaBanco.getEDITORA(), CriaBanco.getPaginas()};
        db = banco.getReadableDatabase();
        cursor = db.query(CriaBanco.getTABELA(), campos, null, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor carregaDadosCategoriaLivros() {
        Cursor cursor;
        String[] campos = {CriaBanco.getID(), CriaBanco.getCodCat(), CriaBanco.getDescricaoCateg(), CriaBanco.getPrazoMax(), CriaBanco.getMulta()};
        db = banco.getReadableDatabase();
        cursor = db.query(CriaBanco.getTabelaCategorias(), campos, null, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor carregaDadosClientes() {
        Cursor cursor;
        String[] campos = {CriaBanco.getID(), CriaBanco.getNome(), CriaBanco.getEndereco(), CriaBanco.getCelular(), CriaBanco.getEmail(), CriaBanco.getCPF(), CriaBanco.getNascimento(), CriaBanco.getCategoriaLeitor()};
        db = banco.getReadableDatabase();
        cursor = db.query(CriaBanco.getTabelaClientes(), campos, null, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }
    //
    public Cursor carregaDadoByIdLeitores(int id){
        Cursor cursor;
        String[] campos = {CriaBanco.getID(), CriaBanco.getCodCateg(),CriaBanco.getDescricaoCategoria(), CriaBanco.getPrazo()};
        String where = CriaBanco.getID() + "=" + id;
        db = banco.getReadableDatabase();
        cursor = db.query(CriaBanco.getTabelaLeitores(),campos,where, null, null, null, null, null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor carregaDadoByIdLivros(int id){
        Cursor cursor;
        String[] campos = {CriaBanco.getID(), CriaBanco.getISBN(), CriaBanco.getTITULO(), CriaBanco.getCodCategoria(),CriaBanco.getAUTOR(), CriaBanco.getPalavrasChave(),CriaBanco.getDataPublicacao(),CriaBanco.getEdicao(),CriaBanco.getEDITORA(), CriaBanco.getPaginas()};
        String where = CriaBanco.getID() + "=" + id;
        db = banco.getReadableDatabase();
        cursor = db.query(CriaBanco.getTABELA(),campos,where, null, null, null, null, null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor carregaDadoByIdCategoriaLivros(int id){
        Cursor cursor;
        String[] campos = {CriaBanco.getID(), CriaBanco.getCodCat(), CriaBanco.getDescricaoCateg(), CriaBanco.getPrazoMax(), CriaBanco.getMulta()};
        String where = CriaBanco.getID() + "=" + id;
        db = banco.getReadableDatabase();
        cursor = db.query(CriaBanco.getTabelaCategorias(),campos,where, null, null, null, null, null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor carregaDadoByIdClientes(int id){
        Cursor cursor;
        String[] campos = {CriaBanco.getID(), CriaBanco.getNome(), CriaBanco.getEndereco(), CriaBanco.getCelular(), CriaBanco.getEmail(), CriaBanco.getCPF(), CriaBanco.getNascimento(), CriaBanco.getCategoriaLeitor()};
        String where = CriaBanco.getID() + "=" + id;
        db = banco.getReadableDatabase();
        cursor = db.query(CriaBanco.getTabelaClientes(),campos,where, null, null, null, null, null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }
    ////
    public void alteraRegistroLeitores(int id, String codigo, String descricao, String prazo)
    {
        ContentValues valores;
        String where;
        db = banco.getWritableDatabase();
        where = CriaBanco.getID() + "=" + id;
        valores = new ContentValues();
        valores.put(CriaBanco.getCodCateg(), codigo);
        valores.put(CriaBanco.getDescricaoCategoria(), descricao);
        valores.put(CriaBanco.getPrazo(), prazo);
        db.update(CriaBanco.getTabelaLeitores(),valores,where,null);
        db.close();
    }

    public void alteraRegistroLivros(int id, String codigo, String isbn, String titulo, String codCateg, String autores, String palavras_chave, String dtPublicacao, String edicao, String editora, String paginas)
    {
        ContentValues valores;
        String where;
        db = banco.getWritableDatabase();
        where = CriaBanco.getID() + "=" + id;
        valores = new ContentValues();
        valores.put(CriaBanco.getCodigo(), codigo);
        valores.put(CriaBanco.getISBN(), isbn);
        valores.put(CriaBanco.getTITULO(), titulo);
        valores.put(CriaBanco.getCodCategoria(), codCateg);
        valores.put(CriaBanco.getAUTOR(), autores);
        valores.put(CriaBanco.getPalavrasChave(), palavras_chave);
        valores.put(CriaBanco.getDataPublicacao(), dtPublicacao);
        valores.put(CriaBanco.getEdicao(), edicao);
        valores.put(CriaBanco.getEDITORA(), editora);
        valores.put(CriaBanco.getPaginas(), paginas);
        db.update(CriaBanco.getTABELA(),valores,where,null);
        db.close();
    }

    public void alteraRegistroCategoriaLivros(int id, String categoria, String descricao, String prazo, String multa)
    {
        ContentValues valores;
        String where;
        db = banco.getWritableDatabase();
        where = CriaBanco.getID() + "=" + id;
        valores = new ContentValues();
        valores.put(CriaBanco.getCodCat(), categoria);
        valores.put(CriaBanco.getDescricaoCateg(), categoria);
        valores.put(CriaBanco.getPrazoMax(), prazo);
        valores.put(CriaBanco.getMulta(), categoria);
        db.update(CriaBanco.getTabelaLeitores(),valores,where,null);
        db.close();
    }

    public void alteraRegistroClientes(int id, String nome, String endereco, String celular, String email, String cpf, String nascimento, String categoriaLeitor)
    {
        ContentValues valores;
        String where;
        db = banco.getWritableDatabase();
        where = CriaBanco.getID() + "=" + id;
        valores = new ContentValues();
        valores.put(CriaBanco.getNome(), nome);
        valores.put(CriaBanco.getEndereco(), endereco);
        valores.put(CriaBanco.getCelular(), celular);
        valores.put(CriaBanco.getEmail(), email);
        valores.put(CriaBanco.getCPF(), cpf);
        valores.put(CriaBanco.getNascimento(), nascimento);
        valores.put(CriaBanco.getCategoriaLeitor(), categoriaLeitor);
        db.update(CriaBanco.getTabelaClientes(),valores,where,null);
        db.close();
    }

    public void deletaRegistroLeitores(int id){
        String where = CriaBanco.getID() + "=" + id;
        db = banco.getReadableDatabase();
        db.delete(CriaBanco.getTabelaLeitores(),where,null);
        db.close();
    }
    public void deletaRegistroLivros(int id){
        String where = CriaBanco.getID() + "=" + id;
        db = banco.getReadableDatabase();
        db.delete(CriaBanco.getTABELA(),where,null);
        db.close();
    }

    public void deletaRegistroCategoriaLivros(int id){
        String where = CriaBanco.getID() + "=" + id;
        db = banco.getReadableDatabase();
        db.delete(CriaBanco.getTabelaCategorias(),where,null);
        db.close();
    }
    public void deletaRegistroClientes(int id){
        String where = CriaBanco.getID() + "=" + id;
        db = banco.getReadableDatabase();
        db.delete(CriaBanco.getTabelaClientes(),where,null);
        db.close();
    }
}