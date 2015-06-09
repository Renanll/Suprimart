package com.suprimart.suprimart;


import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;



public class MainActivity extends ActionBarActivity {

    private ListView listView1;
    private ArrayList<String> resultado;
    Button btnViewProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);




        /*

        JSONToString str = new JSONToString();
        Log.e("NOME: ", str.readJSONFeed("http://suprimart.com/eloja/app/produto.php"));

        //TODO WORKING CODE
        String result = "{\"produto\":[{\"0\":\"Farinha De Trigo Vilma\",\"pro_nome\":\"Farinha De Trigo Vilma\",\"1\":\"1 Kg\",\"pro_tamanho\":\"1 Kg\",\"2\":\"1.84\",\"pro_preco\":\"1.84\",\"3\":\"1\",\"pro_fotoprincipal\":\"1\",\"4\":\"67\",\"pro_codigo\":\"67\"},{\"0\":\"\\u00d3leo De Girassol Liza\",\"pro_nome\":\"\\u00d3leo De Girassol Liza\",\"1\":\"900 ml\",\"pro_tamanho\":\"900 ml\",\"2\":\"5.14\",\"pro_preco\":\"5.14\",\"3\":\"1\",\"pro_fotoprincipal\":\"1\",\"4\":\"68\",\"pro_codigo\":\"68\"},{\"0\":\"Macarr\\u00e3o Espaguete Com Ovos\",\"pro_nome\":\"Macarr\\u00e3o Espaguete Com Ovos\",\"1\":\"500 g\",\"pro_tamanho\":\"500 g\",\"2\":\"2.36\",\"pro_preco\":\"2.36\",\"3\":\"1\",\"pro_fotoprincipal\":\"1\",\"4\":\"69\",\"pro_codigo\":\"69\"},{\"0\":\"Molho De Tomate Pomarola\",\"pro_nome\":\"Molho De Tomate Pomarola\",\"1\":\"340g\",\"pro_tamanho\":\"340g\",\"2\":\"2.63\",\"pro_preco\":\"2.63\",\"3\":\"1\",\"pro_fotoprincipal\":\"1\",\"4\":\"70\",\"pro_codigo\":\"70\"},{\"0\":\"Maionese Liza Tradicional\",\"pro_nome\":\"Maionese Liza Tradicional\",\"1\":\"500g\",\"pro_tamanho\":\"500g\",\"2\":\"3.29\",\"pro_preco\":\"3.29\",\"3\":\"1\",\"pro_fotoprincipal\":\"1\",\"4\":\"71\",\"pro_codigo\":\"71\"}]}";
        try {

            JSONObject jsonObject = new JSONObject(result);

            JSONArray dataJsonArr = jsonObject.getJSONArray("produto");

            for (int i = 0; i < dataJsonArr.length(); i++) {

                JSONObject c = dataJsonArr.getJSONObject(i);

                // Storing each json item in variable
                String pro_nome = c.getString("pro_nome");
                String pro_tamanho = c.getString("pro_tamanho");
                Double pro_preco = c.getDouble("pro_preco");
                int pro_fotoprincipal = c.getInt("pro_fotoprincipal");
                int pro_codigo = c.getInt("pro_codigo");

                Log.e("Erro ", pro_nome);
            }



        } catch (JSONException e) {
            Log.e("Erro: ", e.getMessage());
        }


        */
        AsyncTaskParseJson a = new AsyncTaskParseJson();
        a.c = this;
        a.LV = (ListView) findViewById(R.id.list);
        a.pDialog = new ProgressDialog(MainActivity.this);
        a.execute();
        /*
        Login l = new Login("joaovictor_10_4@hotmail.com", "159753");
        Produto p;
        if(l.Sucesso == 1)
            p = new Produto("LOGIN COM SUCESSO", "Tamanho do Produto", 45.4, 1, 1);
        else
            p = new Produto("FALHA AO LOGAR", "Tamanho do Produto", 45.4, 1, 1);

        //TODO novo codigo

        Produto proList[] = new Produto[]
                {
                        p,
                        new Produto("Nome do produto", "Tamanho do Produto", 45.4, 1, 1),
                        new Produto("Nome do produto", "Tamanho do Produto", 45.4, 1, 1),
                        new Produto("Nome do produto", "Tamanho do Produto", 45.4, 1, 1),
                        new Produto("Nome do produto", "Tamanho do Produto", 45.4, 1, 1),
                        new Produto("Nome do produto", "Tamanho do Produto", 45.4, 1, 1)
                };


        ProdutoAdapter adapter = new ProdutoAdapter(this,
                R.layout.produto, proList);


        listView1 = (ListView)findViewById(R.id.list);
        listView1.setAdapter(adapter);

        /*

        //TODO COISA NOVA

        // Buttons
        Button btnViewProducts = (Button) findViewById(R.id.but_produto);
        //btnNewProduct = (Button) findViewById(R.id.btnCreateProduct);

        // view products click event
        btnViewProducts.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Launching All products Activity
                Intent i = new Intent(getApplicationContext(), VerProdutosActivity.class);
                startActivity(i);

            }
        });*/


    }




    //TODO WORKING CODE
    /*
    public void getJson(View view){
        //callServer("get-json", "");
    }


    private void degenerateJSON(String data){



        Produto [] pro = null;

        try{
            JSONObject jo = new JSONObject(data);
            JSONArray ja = jo.getJSONArray("produto");

            // loop through all users
            for (int i = 0; i < ja.length(); i++) {

                JSONObject c = ja.getJSONObject(i);

                // Storing each json item in variable
                String pro_nome = c.getString("pro_nome");
                String pro_tamanho = c.getString("pro_tamanho");
                Double pro_preco = c.getDouble("pro_preco");
                int pro_fotoprincipal = c.getInt("pro_fotoprincipal");
                int pro_codigo = c.getInt("pro_codigo");

                pro[i].Nome = pro_nome;
                pro[i].Preco = pro_preco;
                pro[i].Tamanho = pro_tamanho;
                pro[i].FotoPrincipal = pro_fotoprincipal;
                pro[i].Codigo = pro_codigo;

            }


            Produto proList[] = pro;
            ProdutoAdapter adapter = new ProdutoAdapter(this,
                    R.layout.produto, proList);


            listView1 = (ListView)findViewById(R.id.list);
            listView1.setAdapter(adapter);


        }
        catch(JSONException e){ e.printStackTrace(); }

    }
    @SuppressLint("NewApi")
    private void callServer(final String method, final String data){
        new Thread(){
            public void run(){
                String answer = HttpConnection.getSetDataWeb("http://suprimart.com/eloja/app/produto.php", method, data);

                Log.i("Script", "ANSWER: "+answer);

                if(data.isEmpty()){
                    degenerateJSON(answer);
                }
            }
        }.start();
    }
    */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void MudarTitulo(View v){

        TextView PagTitulo = (TextView)findViewById(R.id.pag_titulo);
        PagTitulo.setText((String) v.getTag());


    }

    public void AddCarrinho(View v){
        TextView PagTitulo = (TextView)findViewById(R.id.pag_titulo);
        PagTitulo.setText((String) v.getTag());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
