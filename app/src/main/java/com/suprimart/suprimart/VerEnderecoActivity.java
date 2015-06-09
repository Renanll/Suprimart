package com.suprimart.suprimart;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;


public class VerEnderecoActivity extends ActionBarActivity {

    ArrayList<Integer> Carrinho = new ArrayList();
    public int pro_codigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ver_endereco);

        //Pega o carrinho proveniente da Activity anterior
        Intent intent = getIntent();
        Carrinho = intent.getIntegerArrayListExtra("carrinho");
        this.pro_codigo = intent.getIntExtra("elo_codigo", -1);

        Log.e("CODIGO FINAL:", String.valueOf(this.pro_codigo));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ver_endereco, menu);
        return true;
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
