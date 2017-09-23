package com.example.norb7492.exerciciofaculdade;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Norb7492 on 23/09/2017.
 */

//5-esta classe tem as funções para inserir e buscar
public class SqliteAdapter {

    private SQLiteDatabase db;
    private SqliteHelper banco;

    public SqliteAdapter(Context context){
        banco = new SqliteHelper(context);
    }

    //esta função insere os dados no banco de dados
    public String insereDado(String lembrete){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(SqliteHelper.LEMBRETE, lembrete);

        resultado = db.insert(SqliteHelper.TABELA, null, valores);
        db.close();

        if (resultado ==-1){
           return "Erro ao inserir";
        }else{

            return "Inserido com sucesso";
        }
    }
    //esta função lista todos os dados, e retorna uma lista
    public List<String> carregaDados(){
        Cursor cursor;
        List<String> lista = new ArrayList<>();
        String[] campos =  {banco.ID,banco.LEMBRETE};
        db = banco.getReadableDatabase();
        cursor = db.query(banco.TABELA, campos, null, null, null, null, null, null);

        if(cursor!=null){
            if(cursor.moveToFirst()){
                while (!cursor.isAfterLast()) {
                    lista.add(cursor.getString(1));
                    cursor.moveToNext();
                }
            }
        }
        db.close();
        return lista;
    }
}
