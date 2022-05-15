package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // ================= INICIALIZANDO =================
        int MOCHILA_CAPACITY = 15;
        Item aleatorio = new Item();
        Solucao solutionBruteForce;
        Solucao solutionGreedy;
        // ======================= //


        
        // ================= QUESTÃO A =================
        System.out.println("\n1 - Quantidade de itens resolvidos em 4 segundos:\n");
        int quantidadeItensAleatorios = 1;
        Item[] itemList1 = aleatorio.geradorDeItens(MOCHILA_CAPACITY, quantidadeItensAleatorios);
        Mochila mochilaItem1 = new Mochila(itemList1, MOCHILA_CAPACITY);

        long tempoInicial = 0;
        long tempoFinal = 0;

        for (quantidadeItensAleatorios = 1; tempoFinal < 4000; quantidadeItensAleatorios++) {
            itemList1 = aleatorio.geradorDeItens(MOCHILA_CAPACITY, quantidadeItensAleatorios);
            mochilaItem1.setItems(itemList1);
            tempoInicial = System.currentTimeMillis();
            solutionBruteForce = mochilaItem1.resolverBruteForce();
            tempoFinal = System.currentTimeMillis() - tempoInicial;
        }

        System.out.println("Foi gerado uma quantidade de " + quantidadeItensAleatorios + " itens aleatorios dentro de "
                + tempoFinal + " segundos\n");
        // ======================= //



        // ================= QUESTÃO B =================
        System.out.println("\n2 - entre 500 iterações, quantidade de soluções iguais para greedy e brute force\n");
        Item[] itemList2;
        Mochila mochilaItem2;
        int GREEDY_ITEM_COUNT = 20;

        itemList2 = aleatorio.geradorDeItens(MOCHILA_CAPACITY, GREEDY_ITEM_COUNT);
        mochilaItem2 = new Mochila(itemList2, MOCHILA_CAPACITY);

        int setsIguais = 0;

        for (int i = 0; i < 500; i++) {
            itemList2 = aleatorio.geradorDeItens(MOCHILA_CAPACITY, GREEDY_ITEM_COUNT);
            mochilaItem2.setItems(itemList2);
            solutionBruteForce = mochilaItem2.resolverBruteForce();
            solutionGreedy = mochilaItem2.resolverGreedy("valorPorPeso");

            if (solutionBruteForce.value == solutionGreedy.value && solutionGreedy.value != 0) {
                solutionBruteForce.exibir();
                setsIguais++;
            }
        }
        System.out.println("\n");
        System.out.println("Fim da execucao, sets iguais no item 2: " + setsIguais);
        // ======================= //
    }

}
