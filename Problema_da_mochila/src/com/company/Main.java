package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int capacidadeMochila = 5, quantidadeItensAleatorios = 1;

        //region Inicializacao de variaveis
        Item aleatorio = new Item();
        Item[] items = aleatorio.geradorDeItens(capacidadeMochila, quantidadeItensAleatorios);
        Mochila mochila = new Mochila(items, capacidadeMochila);

        Solucao solutionBruteForce;
        Solucao solutionGreedy;
        //endregion

        int qtdExecucoesBrute = 0;
        int itensBrute = 0;
        int itensGreedy = 20;
        int qtdExecucoesGreedy = 0;

        long tempoInicial = 0;
        long tempoFinal = 0;

        //region Parte 1
        System.out.println("\n1 - Quantidade de itens resolvidos em 4 segundos:\n");

        for (quantidadeItensAleatorios = 25; tempoFinal < 4000; quantidadeItensAleatorios++) {
            items = aleatorio.geradorDeItens(capacidadeMochila, quantidadeItensAleatorios);
            mochila = new Mochila(items, capacidadeMochila);
            tempoInicial = System.currentTimeMillis();
            solutionBruteForce = mochila.resolverBruteForce();
            tempoFinal = System.currentTimeMillis() - tempoInicial;
        }

        System.out.println("Foi gerado uma quantidade de " + quantidadeItensAleatorios + " itens aleatorios dentro de 4 segundos");

        //System.currentTimeMillis()


        //endregion


        // itensBrute = qtdExecucoesBrute * quantidadeItensAleatorios;
        // System.out.println();
        // System.out.println("A mochila executou " + qtdExecucoesBrute +" vezes utilizando o 'BruteForce' e consegiu resolver " + itensBrute + " itens dentro de 4 segundos");

        // tempoInicial = System.currentTimeMillis();
        // tempoFinal = 0;

        // while (tempoFinal < 4000){
        //     solutionGreedy = mochila.resolverGreedy("valor");
        //     tempoFinal = System.currentTimeMillis() - tempoInicial;
        //     qtdExecucoesGreedy++;
        // }
        // itensGreedy = qtdExecucoesGreedy * quantidadeItensAleatorios ;
        // System.out.println("A mochila executou " + qtdExecucoesGreedy +" vezes utilizando o 'Greedy' consegiu e resolver: " + itensGreedy + " itens dentro de 4 segundos");
        // System.out.println();

        mochila.exibir();

        Item[] setItens;
        Mochila mochilaBrute, mochilaGreedy;

        int setsIguais = 0;

        System.out.println("2 - Teste automatizado:");
        for (int i = 0; i < 500; i++) {
            setItens = aleatorio.geradorDeItens(capacidadeMochila, itensGreedy);
            mochilaGreedy = mochilaBrute = new Mochila(setItens, capacidadeMochila);
            //Mochila mochilaGreedy = new Mochila(itemsGreedy, capacidadeMochila);
            solutionBruteForce = mochilaBrute.resolverBruteForce();
            solutionGreedy = mochilaGreedy.resolverGreedy("valorPorPeso");

            if (solutionBruteForce.value == solutionGreedy.value && solutionGreedy.value != 0) {
                solutionBruteForce.exibir();
                setsIguais++;
                System.out.println("\n");
            }

        }
        System.out.println("Fim da execucao");
        System.out.println(setsIguais);
    }


}
