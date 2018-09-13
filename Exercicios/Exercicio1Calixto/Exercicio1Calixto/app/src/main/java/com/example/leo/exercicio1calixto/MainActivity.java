package com.example.leo.exercicio1calixto;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Pesquisar(View v) {

        String url = "https://jsonplaceholder.typicode.com/todos/";

        EditText edtId = findViewById(R.id.edtId);
        url += edtId.getText().toString();

        TextView txtTitle = findViewById(R.id.txtTitle2);
        TextView txtComp = findViewById(R.id.txtComp2);

        new getData(txtTitle, txtComp).execute(url);


        edtId.selectAll();
    }

}


