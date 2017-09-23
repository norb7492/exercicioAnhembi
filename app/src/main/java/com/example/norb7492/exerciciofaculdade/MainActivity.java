package com.example.norb7492.exerciciofaculdade;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    //variavle do botão inserir
    private Button inserirLembrete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Inicializar botão inserir
        inserirLembrete = (Button) findViewById(R.id.btInserir);


        //6 - aqui vamos colocar a lista dentro do listview

        //Inicializando o sqlite adapter e o listview
        SqliteAdapter sqliteAdapter = new SqliteAdapter(this);

        //metodo que carrega os dados, e salva a lista retornada na variavel lista
        List<String> lista = sqliteAdapter.carregaDados();

        //colocando a lista dentro do listview para ser printado na tela
        ListAdapter listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);
        ListView listaLembretes = (ListView) findViewById(R.id.lembreteLista);
        listaLembretes.setAdapter(listAdapter);


        //1- Este é o primeiro passo, o evento que troca a página
        inserirLembrete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //2 - A função intent que é responsável por mudar de activity
                Intent intent = new Intent(MainActivity.this, TelaInserir.class);
                startActivity(intent);
            }
        });

    }
}
