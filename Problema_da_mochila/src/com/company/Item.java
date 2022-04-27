package com.company;

public class Item {

    public String nome;
    public int valor;
    public int peso;

    public Item(String name, int value, int weight) {
        this.nome = name;
        this.valor = value;
        this.peso = weight;
    }

    @Override
    public String toString() {
        return nome + " [valor = " + valor + ", peso = " + peso + "]";
    }
}
