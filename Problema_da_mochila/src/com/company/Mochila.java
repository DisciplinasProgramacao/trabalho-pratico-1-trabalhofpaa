package com.company;

import java.util.ArrayList;
import java.util.List;

public class Mochila {

    private Item[] items;
    private int capacidade;

    public Mochila(Item[] items, int capacidade) {
        this.items = items;
        this.capacidade = capacidade;
    }

    public void exibir() {
        if (items != null  &&  items.length > 0) {
            System.out.println("Problema da Mochila");
            System.out.println("capacidade : " + capacidade);
            System.out.println("itens :");

            for (Item item : items) {
                System.out.println("- " + item.toString());
            }
        }
        }


    public Solucao resolver() {

        int numItens = items.length;
        int[][] matriz = new int[numItens + 1][capacidade + 1];

        for (int i = 0; i <= capacidade; i++)
            matriz[0][i] = 0;

        for (int i = 1; i <= numItens; i++)
        {
            for (int j = 0; j <= capacidade; j++) {
                if (items[i - 1].peso > j)
                    matriz[i][j] = matriz[i-1][j];
                else
                    matriz[i][j] = Math.max(matriz[i-1][j], matriz[i-1][j - items[i-1].peso]
                            + items[i-1].valor);
            }
        }

        int res = matriz[numItens][capacidade];
        int w = capacidade;
        List<Item> itens = new ArrayList<>();

        for (int i = numItens; i > 0  &&  res > 0; i--) {
            if (res != matriz[i-1][w]) {
                itens.add(items[i-1]);
                res -= items[i-1].valor;
                w -= items[i-1].peso;
            }
        }

        return new Solucao(itens, matriz[numItens][capacidade]);
    }
}
