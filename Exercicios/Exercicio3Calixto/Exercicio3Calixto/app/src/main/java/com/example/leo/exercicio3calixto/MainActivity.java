package com.example.leo.exercicio3calixto;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {


    private final String certo = "";
    private final String errado = "";
    private EditText edtId;
    private EditText edtAnota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Salvar(View view)
    {

        edtId = findViewById(R.id.edtId);
        edtAnota = findViewById(R.id.edtAnota);

        String Id = edtId.getText().toString();
        String Anotacao = edtAnota.getText().toString();

        SharedPreferences sh = getSharedPreferences(certo, Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = sh.edit();

        ed.putString(Id, Anotacao);

        ed.apply();

        edtId.setText("");
        edtAnota.setText("");

    }

    public void Pesquisar(View view)
    {
        edtId = findViewById(R.id.edtId);
        edtAnota = findViewById(R.id.edtAnota);

        String Id =edtId.getText().toString();

        SharedPreferences sh = getSharedPreferences(certo, Context.MODE_PRIVATE);

        String Anota = sh.getString(Id, errado);

        if(Anota == errado)
        {
            Toast.makeText(this, "Não há nada salvo nesse ID" + errado, Toast.LENGTH_SHORT).show();
        }else{
            edtAnota.setText(Anota);
        } } }
