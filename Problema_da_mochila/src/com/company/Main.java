package com.company;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

         int  capacidaeMochila = 15, quantidadeItensAleatorios = 20;

        System.out.println("Menu");
        System.out.println("1-Quantidade de itens resolvidos em 4 segundos\n2-teste automatizado");

        Item aleatorio = new Item();
        Item[] items =  aleatorio.geradorDeItens(capacidaeMochila,quantidadeItensAleatorios);
        Mochila mochila = new Mochila(items, capacidaeMochila);
        Solucao solutionBruteForce;
        Solucao Greedy;

        switch (entrada.nextInt())
        {
            case  1:
                long tempoInicial = System.currentTimeMillis();
                long tempoFinal = 0;
                int quantidadeExecucaoes =0;

                quantidadeItensAleatorios = 5;

                while (tempoFinal < 4000)
                {
                    solutionBruteForce = mochila.resolverBruteForce();
                    tempoFinal = System.currentTimeMillis() -tempoInicial;
                    quantidadeExecucaoes++;
                }

                System.out.println("A mochila executou " + quantidadeExecucaoes +" vezes utilizando o 'BruteForce' e consegiu resolver " + quantidadeExecucaoes * quantidadeItensAleatorios + " itens dentro de 4 segundos");

                tempoInicial = System.currentTimeMillis();
                tempoFinal = 0;
                quantidadeExecucaoes = 0;

                while (tempoFinal < 4000)
                {
                    Greedy = mochila.resolverGreedy("valor");
                    tempoFinal = System.currentTimeMillis() -tempoInicial;
                    quantidadeExecucaoes++;
                }

                System.out.println("A mochila executou " + quantidadeExecucaoes +" vezes utilizando o 'Greedy' consegiu e resolver: " + quantidadeExecucaoes * quantidadeItensAleatorios + " itens dentro de 4 segundos");
                break;
            case  2:
                for (int i = 0; i < 500; i++) {
                    
                }
                break;

            default:
                break;

        }
       // mochila.exibir();

        long tempoInicial = System.currentTimeMillis();


        long tempoFinal = System.currentTimeMillis() -tempoInicial;
        //Syst em.out.println((tempoFinal /60));
        //System.out.println("\nForca bruta");
//        solutionBruteForce.exibir();
        //System.out.println("\nGreedy");
//        Greedy.exibir();

    }
}
