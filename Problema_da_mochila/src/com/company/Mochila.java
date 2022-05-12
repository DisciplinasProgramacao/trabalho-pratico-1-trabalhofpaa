package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
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

    public List<Item> getSortedItemList(String orderBy) {
        // Retorna um array de itens ordenado pelo valor decrescente
        List<Item> sortedList = new LinkedList<Item>(Arrays.asList(items.clone()));
        if(orderBy.equals("valor")) {
            Collections.sort(sortedList, Comparator.comparingInt(Item::getValor));
        } else if(orderBy.equals("peso")) {
            Collections.sort(sortedList, Comparator.comparingInt(Item::getPeso));
        } else if(orderBy.equals("valorPorPeso")) {
            Collections.sort(sortedList, Comparator.comparingInt(Item::getValorPorPeso));
        }
        return sortedList;
    }


    public Solucao resolverBruteForce() {
        // Solução com força bruta

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

    public Solucao resolverGreedy(String criterio) {
        // Solução com algoritmo guloso

        List<Item> itemList = this.getSortedItemList(criterio);
        List<Item> resultList = new ArrayList<Item>();

        int currentPeso = 0;
        int totalValor = 0;
        Item currentItem = itemList.get(0);
        while(currentPeso + currentItem.getPeso() <= this.capacidade) {
            resultList.add(currentItem);
            itemList.remove(0);
            currentPeso += currentItem.getPeso();
            totalValor += currentItem.getValor();
            if(!itemList.isEmpty()) {
                currentItem = itemList.get(0);
            } else {
                break;
            }
        }

        return new Solucao(resultList, totalValor);
    }
}
