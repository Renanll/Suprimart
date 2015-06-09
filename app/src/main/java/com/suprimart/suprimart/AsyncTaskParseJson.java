package com.suprimart.suprimart;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// you can make this class as another java file so it will be separated from your main activity.
public class AsyncTaskParseJson extends AsyncTask<String, String, String> {

    public String pro = "Produtos:";
    private ProgressDialog pDialog;


    //url de onde as informacoes serao tiradas
    String yourJsonStringUrl = "http://suprimart.com/eloja/app/produto.php";

    // contacts JSONArray
    JSONArray dataJsonArr = null;

    @Override
    protected void onPreExecute() {


    }

    @Override
    public String doInBackground(String... arg0) {


        try {

            // instantiate our json parser
            JsonParser jParser = new JsonParser();

            // get json string from url
            JSONObject json = jParser.getJSONFromUrl(yourJsonStringUrl);

            // get the array of users
            dataJsonArr = json.getJSONArray("produto");

            // loop through all users
            for (int i = 0; i < dataJsonArr.length(); i++) {

                JSONObject c = dataJsonArr.getJSONObject(i);

                // Storing each json item in variable
                String pro_nome = c.getString("pro_nome");
                String pro_tamanho = c.getString("pro_tamanho");
                Double pro_preco = c.getDouble("pro_preco");
                int pro_fotoprincipal = c.getInt("pro_fotoprincipal");
                int pro_codigo = c.getInt("pro_codigo");

                this.pro += " " + pro_nome;

            }




        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String strFromDoInBg) {



    }
}