package com.company;

import java.util.Random;

public class Item {

    public String nome;
    public int valor;
    public int peso;

    public Item(String name, int value, int weight) {
        this.nome = name;
        this.valor = value;
        this.peso = weight;
    }

    public Item() {
        this.nome = "";
        this.valor = 0;
        this.peso = 0;
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

    /**
     * @param capacidadeMochila       Tamnho da mochila (capacidade total).
     * @param quantidadeItensAleatorios Quantidade de itens aleatorios a serem gerados
     * @return Um vetor com os itens aleatorios
     */
    public Item[] geradorDeItens(int capacidadeMochila, int quantidadeItensAleatorios) {
        // Random gerador = new Random(19700621);
        Random gerador = new Random();
        Item[] items = new Item[quantidadeItensAleatorios];

        for (int i = 0; i < quantidadeItensAleatorios; i++) {
            items[i] = (new Item("Item: " + i+1, gerador.nextInt(capacidadeMochila*3) + 1,
                    gerador.nextInt(capacidadeMochila*3) +1));
        }

        return items;
    }

    @Override
    public String toString() {
        return nome + " [valor = " + valor + ", peso = " + peso + "]";
    }
}
