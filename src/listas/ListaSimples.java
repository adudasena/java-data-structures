package listas;

public class ListaSimples <T> {
    private T[] elementos;
    private int tamanho; //tamanho e posição são o mesmo número

    @SuppressWarnings("unchecked") //para não alertar sobre transformar o Generics (Object) em "tipo T"
    //garantir para o compilador que só entrarão itens do tipo T.
    public ListaSimples(int capacidade) {
        this.elementos = (T[]) new Object[capacidade];
        this.tamanho = 0;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public boolean estaCheia() {
        return tamanho == elementos.length;
    }

    public int size() {
        return tamanho;
    }

    public void insert(T elemento) {
        if (estaCheia()) {
            throw new RuntimeException("A lista já atingiu o limite de capacidade!");
        } //não precisa de else
        elementos[tamanho] = elemento; //com os colchetes, aponta pra posição específica
        tamanho++;
    }

    public T get(int indice) { //método pra retornar o elemento a partir da posição que o usuário pedir
        if (indice < 0 || indice >= tamanho) {
            throw new RuntimeException("O índice está fora do limite.");
        }
        return elementos[indice];
    }

    public T removeAt(int indice) {
        if (indice < 0 || indice >= tamanho) {
            throw new RuntimeException("O índice está fora do limite.");
        }
        T valorRemovido= elementos[indice];
        for (int i = indice; i < tamanho -1; i++) {
            elementos[i] = elementos[i + 1];
        }
        return valorRemovido;
    }
}



