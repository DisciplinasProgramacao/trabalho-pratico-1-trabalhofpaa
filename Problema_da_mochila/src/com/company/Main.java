package com.company;

public class Main {

    public static void main(String[] args) {
        Item[] items = {new Item("A1", 4, 12),
                new Item("B2", 2, 1),
                new Item("C3", 2, 2),
                new Item("D4", 1, 1),
                new Item("E5", 10, 4)};

        Mochila mochila = new Mochila(items, 15 );
        mochila.exibir();
        Solucao solutionBruteForce = mochila.resolverBruteForce();
        solutionBruteForce.exibir();
    }
}
