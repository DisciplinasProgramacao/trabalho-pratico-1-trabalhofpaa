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

    public int getValor() {
        return this.valor;
    }

    public int getPeso() {
        return this.peso;
    }

    public int getValorPorPeso() {
        return this.valor / this.peso;
    }

    @Override
    public String toString() {
        return nome + " [valor = " + valor + ", peso = " + peso + "]";
    }
}
