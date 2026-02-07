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

        public void enfileirar(T dado) {
            if (total == elementos.length) throw new RuntimeException("Fila Cheia");
            elementos[fim] = dado;
            fim = (fim + 1) % elementos.length; // Lógica circular
            total++;
        }

        public boolean estaVazia() {
            return total == 0;
        }

         public T desenfileirar() {
         if (estaVazia()) {
            throw new RuntimeException("Fila Vazia");
         }
         T valor = elementos[inicio];
         inicio = (inicio + 1) % elementos.length; // lógica para não estourar o array
         total--;
         return valor;
    }
}
