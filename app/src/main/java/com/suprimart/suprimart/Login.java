package com.suprimart.suprimart;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by João on 08/06/2015.
 */
public class Login {

    public static String url = "http://suprimart.com/eloja/app/login.php", Mensagem = "";
    public int Sucesso;

    public Login(String Usuario, String Senha){
        this.url += "?cli_email=" + Usuario + "&cli_senha=" + Senha;
    }

    public void Validar(){
        JSONParse j = new JSONParse();
        j.execute();
        this.Mensagem = j.Msg;
        this.Sucesso = j.Suc;
    }

    private class JSONParse extends AsyncTask<String, String, JSONObject> {

        public String Msg = "";
        public int Suc = 0;

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
                this.Suc = json.getInt("sucesso");
                this.Msg = json.getString("mensagem");

            } catch (JSONException e) {
                this.Msg = e.getMessage();
            }
        }




    }
}
