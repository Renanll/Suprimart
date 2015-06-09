package com.suprimart.suprimart;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by João on 08/06/2015.
 */
public class Teste  {

    private static String url = "http://suprimart.com/eloja/app/login.php";
    String name, version;
    //TextView tv1;

    public Teste(){

    }

    public void Executar(){

        new JSONParse().execute();
    }

    private class JSONParse extends AsyncTask<String, String, JSONObject> {
        private ProgressDialog pDialog;
        @Override
        protected void onPreExecute() {

        }

        @Override
        protected JSONObject doInBackground(String... args) {
            JsonParser jParser = new JsonParser();
        // Getting JSON from URL
            JSONObject json = jParser.getJSONFromUrl(url);
            return json;
        }

        @Override
        protected void onPostExecute(JSONObject json) {
            try {
                //pDialog.dismiss();
                name = json.getString("sucesso");
                version = json.getString("mensagem");
                Log.e(null, "NOMEEEE " + version);
                //tv1.setText(name + " - " + version);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
