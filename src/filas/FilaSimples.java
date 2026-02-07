package filas;

public class FilaSimples <T> {

        private T[] elementos;
        private int inicio;
        private int fim;
        private int total;

        @SuppressWarnings("unchecked")
        public FilaSimples(int capacidade) {
            this.elementos = (T[]) new Object[capacidade];
            this.inicio = 0;
            this.fim = 0;
            this.total = 0;
        }

        public void enqueue(T dado) {
            if (total == elementos.length) throw new RuntimeException("Fila Cheia");
            elementos[fim] = dado;
            fim = (fim + 1) % elementos.length; // Lógica circular
            total++;
        }

        public T dequeue() {
            if (total == 0) throw new RuntimeException("Fila Vazia");
            T valor = elementos[inicio];
            inicio = (inicio + 1) % elementos.length; // Lógica circular
            total--;
            return valor;
        }

        public boolean estaVazia() {
            return total == 0;
        }
    }
