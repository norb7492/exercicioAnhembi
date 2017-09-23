package com.example.norb7492.exerciciofaculdade;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TelaInserir extends AppCompatActivity implements View.OnClickListener {


    //Inicializando as variáveis
    private Button inserir, fechar;
    private EditText lembrete;
    private SqliteAdapter sqliteAdapter;
    private String resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inserir);

        sqliteAdapter = new SqliteAdapter(this);

        lembrete = (EditText) findViewById(R.id.editLembrete);

        inserir = (Button) findViewById(R.id.btnInserir);
        fechar = (Button) findViewById(R.id.btnFechar);
        inserir.setOnClickListener(this);
        fechar.setOnClickListener(this);

    }

    @Override
    //3-Neste passo usei um switch case, pq são 2 opções, uma para inserir e uma para fechar e voltar para a activity inicial
    public void onClick(View view) {
        switch(view.getId()){
            //case que insere os dados no banco sqlite
            case R.id.btnInserir:
                //esta funcção é chamada no sqlite adapter
                resultado = sqliteAdapter.insereDado(lembrete.getText().toString());
                Toast.makeText(this, resultado, Toast.LENGTH_LONG).show();
            break;
            case R.id.btnFechar:
                //case que fecha e volta para a tela inicial
                Intent intent = new Intent(TelaInserir.this, MainActivity.class);
                startActivity(intent);
                finish();
            break;
        }

    }
}
