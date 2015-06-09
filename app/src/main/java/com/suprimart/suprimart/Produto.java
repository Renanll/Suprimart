package com.suprimart.suprimart;

/**
 * Created by João on 08/06/2015.
 */
public class Produto {

    public String Nome, Tamanho;
    public double Preco;
    public int FotoPrincipal, Codigo;

    public Produto(String nome, String tamanho, double preco, int fotoPrincipal, int codigo) {
        Nome = nome;
        Tamanho = tamanho;
        Preco = preco;
        FotoPrincipal = fotoPrincipal;
        Codigo = codigo;
    }

    public Produto(){
        Nome = "";
        Tamanho = "";
        Preco = 0.0;
        FotoPrincipal = 0;
        Codigo = 0;
    }
}
