package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int capacidadeMochila = 15, quantidadeItensAleatorios = 1;

        //region Inicializacao de variaveis
        Item aleatorio = new Item();
        Item[] items = aleatorio.geradorDeItens(capacidadeMochila, quantidadeItensAleatorios);
        Mochila mochila = new Mochila(items, capacidadeMochila);

        Solucao solutionBruteForce;
        Solucao solutionGreedy;


        int qtdExecucoesBrute = 0;
        int itensBrute = 0;
        int itensGreedy = 20;
        int qtdExecucoesGreedy = 0;

        long tempoInicial = 0;
        long tempoFinal = 0;
        //endregion

        //region Parte 1
        System.out.println("\n1 - Quantidade de itens resolvidos em 4 segundos:\n");

        for (quantidadeItensAleatorios = 1; tempoFinal < 4; quantidadeItensAleatorios++) {
            items = aleatorio.geradorDeItens(capacidadeMochila, quantidadeItensAleatorios);
            mochila.setItems(items);
            tempoInicial = System.currentTimeMillis();
            solutionBruteForce = mochila.resolverBruteForce();
            tempoFinal = System.currentTimeMillis() - tempoInicial;
        }

        System.out.println("Foi gerado uma quantidade de " + quantidadeItensAleatorios + " itens aleatorios dentro de "+ tempoFinal +" segundos\n");

        //endregion

        //region Parte 2
        
        //Coloque a parte 2 aqui

        //endregion


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
