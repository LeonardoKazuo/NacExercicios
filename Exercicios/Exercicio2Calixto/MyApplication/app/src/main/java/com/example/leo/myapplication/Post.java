package com.example.leo.myapplication;

import android.os.AsyncTask;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class Post extends AsyncTask<String,Void,String> {


    private TextView txtResul;

    public Post(TextView txtResul) {
        this.txtResul = txtResul;
    }

    @Override
    protected String doInBackground(String... strings) {

        return NetworkToolkit.doPost(strings[0],strings[1]);
    }

    @Override
    protected void onPostExecute(String s) {
        try
        {
            JSONObject jsonResponse = new JSONObject(s);

            String id = jsonResponse.getString("id");

            txtResul.setText("Sucesso! ID:" + id);
        }
        catch(JSONException e){
            this.txtResul.setText(e.toString());
        }
    }
}
