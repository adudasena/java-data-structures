package listas;
import base.No;

public class ListaDinamica <T>{
    private No<T> inicio; // o primeiro nó da lista (a cabeça)
    private int tamanho;  // contador para não precisarmos percorrer a lista toda só para saber o tamanho

    public ListaDinamica() {
        this.inicio = null; // começa vazia, sem ninguém apontando para nada. Se perde a ref do início, perde a lista toda
        this.tamanho = 0;
    }

    public int size() {
        return this.tamanho;
    }

    public void inserir(T dado) {
        No<T> novoNo = new No<>(dado); // cria a caixinha nova

        if (this.inicio == null) {
            this.inicio = novoNo; // se for a primeira, ela vira o início
        } else {
            // senão, temos que navegar até o fim
            No<T> atual = this.inicio;
            while (atual.proximo != null) {
                atual = atual.proximo; // pula para o próximo nó
            }
            atual.proximo = novoNo; // o último agora aponta para o novo
        }
        this.tamanho++;
    }
    public void exibir() {
        No<T> atual = this.inicio; // começa na cabeça
        while (atual != null) { // enquanto não chegar no vazio
            System.out.print(atual.dado + " - ");
            atual = atual.proximo; // "pula" para o próximo nó
        }
        System.out.println("null");
    }
    public T get(int indice) {
        if (indice < 0 || indice >= tamanho) {
            throw new RuntimeException("Índice inválido.");
        }

        No<T> atual = this.inicio;
        for (int i = 0; i < indice; i++) {
            atual = atual.proximo; // pula até chegar no índice desejado
        }
        return atual.dado;
    }
}

