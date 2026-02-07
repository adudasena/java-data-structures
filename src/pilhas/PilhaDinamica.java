package pilhas;

import base.No;

public class PilhaDinamica<T> {
    private No<T> topo;

    public void push(T dado) {
        No<T> novo = new No<>(dado);
        novo.proximo = topo; // o novo nó aponta para o antigo topo
        topo = novo;         // o novo nó vira o topo
    }

    public T pop() {
        if (topo == null) throw new RuntimeException("Vazia");
        T valor = topo.dado;
        topo = topo.proximo; // o topo pula para o de baixo
        return valor;
    }
}
