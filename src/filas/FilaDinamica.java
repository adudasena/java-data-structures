package filas;

import base.No;

public class FilaDinamica<T> {
    private No<T> inicio, fim;

    public void enqueue(T dado) {
        No<T> novo = new No<>(dado);
        if (inicio == null) {
            inicio = novo;
        } else {
            fim.proximo = novo;
        }
        fim = novo;
    }

    public T dequeue() {
        if (inicio == null) throw new RuntimeException("Vazia");
        T valor = inicio.dado;
        inicio = inicio.proximo;
        if (inicio == null) fim = null;
        return valor;
    }
}