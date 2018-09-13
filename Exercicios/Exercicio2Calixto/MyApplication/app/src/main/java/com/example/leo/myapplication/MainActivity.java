package com.example.leo.myapplication;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Submeter(View v){


        TextView edtId = findViewById(R.id.edtId);
        TextView edtTitle = findViewById(R.id.edtTitle);
        TextView edtBody = findViewById(R.id.edtBody);
        TextView txtResul = findViewById(R.id.txtResul);

        String url = "https://jsonplaceholder.typicode.com/posts";

        String parameter =
                "{" +
                        "   \"userId\":   Id, " +
                        "   \"title\" : \"Title\"  " +
                        "   \"body\"  : \"Body\"   " +
                        "}";

        parameter.replace( "Id" , edtId.getText().toString() );
        parameter.replace( "Title" , edtTitle.getText().toString() );
        parameter.replace( "Body" , edtBody.getText().toString() );

        new Post(txtResul).execute(url,parameter);
    }
}

