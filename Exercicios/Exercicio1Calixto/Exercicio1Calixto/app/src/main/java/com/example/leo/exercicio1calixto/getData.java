package com.example.leo.exercicio1calixto;

import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class getData extends AsyncTask<String,Void,String> {

    private TextView txtTitle ;
    private TextView txtComp;

    public getData(TextView txtTitle, TextView txtComp) {
        this.txtTitle = txtTitle;
        this.txtComp = txtComp;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected String doInBackground(String... strings) {

        String url = strings[0];
        String result = NetworkToolkit.doGet(url);

        return result;
    }

    @Override
    protected void onPostExecute(String s) {

        try
        {

            JSONObject jsonObject = new JSONObject(s);



            String title = jsonObject.getString("title");
            boolean completed = jsonObject.getBoolean("completed");

            txtTitle.setText(title);
            txtComp.setText(String.valueOf(completed));

        }
        catch(JSONException e){
            this.txtTitle.setText(e.toString());
        }
    }
}
