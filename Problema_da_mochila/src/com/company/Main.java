package com.company;


public class Main {

    public static void main(String[] args) {

        int  capacidaeMochila = 15, quantidadeItensAleatorios = 3000000;
         //int  capacidaeMochila = 15, quantidadeItensAleatorios = 3000000;

        Item aleatorio = new Item();
        Item[] items =  aleatorio.geradorDeItens(capacidaeMochila,quantidadeItensAleatorios);

        Mochila mochila = new Mochila(items, capacidaeMochila);
        //mochila.exibir();

        long tempoInicial = System.currentTimeMillis();
        //Solucao solutionBruteForce = mochila.resolverBruteForce();
        Solucao Greedy = mochila.resolverGreedy("peso");
        long tempoFinal = System.currentTimeMillis() -tempoInicial;
//        System.out.println((tempoFinal /60));
//        System.out.println("\nForca bruta");
//        //solutionBruteForce.exibir();
//        System.out.println("\nGreedy");
//        Greedy.exibir();

    }
}
