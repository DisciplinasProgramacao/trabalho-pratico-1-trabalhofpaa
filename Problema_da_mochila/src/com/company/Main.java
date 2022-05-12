package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int  capacidadeMochila = 15, quantidadeItensAleatorios = 20;

        Item aleatorio = new Item();
        Item[] items =  aleatorio.geradorDeItens(capacidadeMochila, quantidadeItensAleatorios);
        Mochila mochila = new Mochila(items, capacidadeMochila);

        Solucao solutionBruteForce;
        Solucao solutionGreedy;

        int qtdExecucoesBrute = 0;
        int itensBrute = 0;
        int itensGreedy = 0;
        int qtdExecucoesGreedy = 0;

        long tempoInicial = System.currentTimeMillis();
        long tempoFinal = 0;   

        System.out.println("1 - Quantidade de itens resolvidos em 4 segundos:");
      
        while (tempoFinal < 4000){
            solutionBruteForce = mochila.resolverBruteForce();
            tempoFinal = System.currentTimeMillis() - tempoInicial;
            qtdExecucoesBrute++;
        }
        itensBrute = qtdExecucoesBrute * quantidadeItensAleatorios;
        System.out.println();
        System.out.println("A mochila executou " + qtdExecucoesBrute +" vezes utilizando o 'BruteForce' e consegiu resolver " + itensBrute + " itens dentro de 4 segundos");
                
        tempoInicial = System.currentTimeMillis();
        tempoFinal = 0;

        while (tempoFinal < 4000){
            solutionGreedy = mochila.resolverGreedy("valor");
            tempoFinal = System.currentTimeMillis() - tempoInicial;
            qtdExecucoesGreedy++;
        }
        itensGreedy = qtdExecucoesGreedy * quantidadeItensAleatorios ;
        System.out.println("A mochila executou " + qtdExecucoesGreedy +" vezes utilizando o 'Greedy' consegiu e resolver: " + itensGreedy + " itens dentro de 4 segundos");
        System.out.println();

        mochila.exibir();

        System.out.println("2 - Teste automatizado:");
        for (int i = 0; i < 500; i++) {
            Item[] itemsBrute = aleatorio.geradorDeItens(capacidadeMochila, itensBrute);
            Item[] itemsGreedy = aleatorio.geradorDeItens(capacidadeMochila, itensGreedy);
            Mochila mochilaBrute = new Mochila(itemsBrute, capacidadeMochila);
            Mochila mochilaGreedy = new Mochila(itemsGreedy, capacidadeMochila);
            solutionBruteForce = mochilaBrute.resolverBruteForce();
            solutionGreedy = mochilaGreedy.resolverGreedy("valor");

            if(solutionBruteForce == solutionGreedy){
                System.out.println("Teste");
            }

        }
    }

    long tempoInicial = System.currentTimeMillis();
    long tempoFinal = System.currentTimeMillis() - tempoInicial;
}
