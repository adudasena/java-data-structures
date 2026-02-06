
import listas.ListaSimples;

public class Main {
    public static void main(String[] args) {
        // instanciando uma lista de Strings com capacidade para 3 nomes
        ListaSimples<String> nomes = new ListaSimples<>(3);

        System.out.println("--- Teste de Inserção ---");
        nomes.insert("Duda");
        nomes.insert("Maria");
        nomes.insert("João");
        System.out.println("Tamanho atual: " + nomes.size()); // Deve ser 3

        System.out.println("\n--- Teste de Leitura (Get) ---");
        System.out.println("Posição 0: " + nomes.get(0)); // Duda
        System.out.println("Posição 1: " + nomes.get(1)); // Maria

        System.out.println("\n--- Teste de Erro (Lista Cheia) ---");
        try {
            nomes.insert("Erro"); //isso deve disparar RuntimeException
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n--- Teste de Erro (Índice Inválido) ---");
        try {
            System.out.println(nomes.get(10)); //índice inexistente
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n--- Teste de remoção ---");
        nomes.removeAt(1);
        System.out.println("Posição 1: " + nomes.get(1)); // agora é João, substituiu Maria

    }
}