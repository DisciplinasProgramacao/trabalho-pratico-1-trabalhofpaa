package com.company;
import java.util.List;

public class Solucao {

    public List<Item> itens; // Lista de items para colocar na mochila para obter o valor maximo
    public int value; // Maior valor possivel

    public Solucao(List<Item> itens, int valor) {
        this.itens = itens;
        this.value = valor;
    }

    public void exibir() {
        if (itens != null && !itens.isEmpty()){
            System.out.println("\nSolução da Mochila");
            System.out.println("Valor = " + value);
            System.out.println("Itens para escolher :");

            for (Item item : itens) {
                System.out.println("- " + item.toString());
            }
        }
    }
}
