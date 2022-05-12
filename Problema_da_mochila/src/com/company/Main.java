package com.company;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int  capacidaeMochila = 5, quantidadeItensAleatorios = 10;
         //int  capacidaeMochila = 15, quantidadeItensAleatorios = 3000000;

        Item aleatorio = new Item();
        Item[] items =  aleatorio.geradorDeItens(capacidaeMochila,quantidadeItensAleatorios);
        Mochila mochila = new Mochila(items, capacidaeMochila);
        mochila.exibir();

        long tempoInicial = System.currentTimeMillis();


        Solucao solutionBruteForce = mochila.resolverBruteForce();
        Solucao Greedy = mochila.resolverGreedy("peso");
        long tempoFinal = System.currentTimeMillis() -tempoInicial;
        //Syst em.out.println((tempoFinal /60));
        System.out.println("\nForca bruta");
        solutionBruteForce.exibir();
        System.out.println("\nGreedy");
        Greedy.exibir();

    }
}
