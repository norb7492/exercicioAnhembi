package com.example.norb7492.exerciciofaculdade;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Norb7492 on 23/09/2017.
 */

//4- esta classe inicializa o banco de dados sqlite
public class SqliteHelper extends SQLiteOpenHelper {

    //variáveis usadas para o banco
    public static final String NOME_BANCO = "lembrete.db";
    public static final String TABELA = "lembretes";
    public static final String ID = "id";
    public static final String LEMBRETE = "lembrete";
    public static final int VERSAO = 1;

    public SqliteHelper(Context context){
        super(context, NOME_BANCO,null,VERSAO);
    }

    //este metodo cria o banco de dados
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE "+TABELA+"("
                + ID + " integer primary key autoincrement,"
                + LEMBRETE + " text"
                +")";
        Log.d("sqlite", "tabela criada");
        sqLiteDatabase.execSQL(sql);
    }

    //este metodo atualiza o banco, se uma nova versão for usada
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS" + TABELA);
        onCreate(sqLiteDatabase);
    }
}
