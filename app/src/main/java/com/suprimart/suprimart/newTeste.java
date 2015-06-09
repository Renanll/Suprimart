package com.suprimart.suprimart;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

public class newTeste {

    public void conectar() {

        String result = "{\"sucesso\":1,\"mensagem\":\"\",\"qtd\":5,\"produto\":[{\"0\":\"Farinha De Trigo Vilma\",\"pro_nome\":\"Farinha De Trigo Vilma\",\"1\":\"1 Kg\",\"pro_tamanho\":\"1 Kg\",\"2\":\"1.84\",\"pro_preco\":\"1.84\",\"3\":\"1\",\"pro_fotoprincipal\":\"1\",\"4\":\"67\",\"pro_codigo\":\"67\"},{\"0\":\"\\u00d3leo De Girassol Liza\",\"pro_nome\":\"\\u00d3leo De Girassol Liza\",\"1\":\"900 ml\",\"pro_tamanho\":\"900 ml\",\"2\":\"5.14\",\"pro_preco\":\"5.14\",\"3\":\"1\",\"pro_fotoprincipal\":\"1\",\"4\":\"68\",\"pro_codigo\":\"68\"},{\"0\":\"Macarr\\u00e3o Espaguete Com Ovos\",\"pro_nome\":\"Macarr\\u00e3o Espaguete Com Ovos\",\"1\":\"500 g\",\"pro_tamanho\":\"500 g\",\"2\":\"2.36\",\"pro_preco\":\"2.36\",\"3\":\"1\",\"pro_fotoprincipal\":\"1\",\"4\":\"69\",\"pro_codigo\":\"69\"},{\"0\":\"Molho De Tomate Pomarola\",\"pro_nome\":\"Molho De Tomate Pomarola\",\"1\":\"340g\",\"pro_tamanho\":\"340g\",\"2\":\"2.63\",\"pro_preco\":\"2.63\",\"3\":\"1\",\"pro_fotoprincipal\":\"1\",\"4\":\"70\",\"pro_codigo\":\"70\"},{\"0\":\"Maionese Liza Tradicional\",\"pro_nome\":\"Maionese Liza Tradicional\",\"1\":\"500g\",\"pro_tamanho\":\"500g\",\"2\":\"3.29\",\"pro_preco\":\"3.29\",\"3\":\"1\",\"pro_fotoprincipal\":\"1\",\"4\":\"71\",\"pro_codigo\":\"71\"}]}";
        try {

            JSONObject jsonObject = new JSONObject(result);
            Log.e("NOME: ", jsonObject.getString("pro_nome"));

        } catch (JSONException e) {
            Log.e("Erro: ", e.getMessage());
        }
    }
}
