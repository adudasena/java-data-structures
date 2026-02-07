package pilhas;

public class PilhaSimples<T> {
    private T[] elementos;
    private int topo = -1; // começa em -1 porque o array é 0...n

    public PilhaSimples(int capacidade) {
        this.elementos = (T[]) new Object[capacidade];
    }

    public void push(T dado) {
        if (topo == elementos.length - 1) throw new RuntimeException("Pilha Cheia");
        elementos[++topo] = dado; // sobe o topo e insere
    }

    public T pop() {
        if (topo == -1) throw new RuntimeException("Pilha Vazia");
        return elementos[topo--]; // retorna e desce o topo
    }
}