import listas.ListaDinamica;
import listas.ListaSimples;
import pilhas.PilhaDinamica;
import filas.FilaDinamica;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("LISTA SIMPLES- testes");
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

        System.out.println("LISTA DINÂMICA- testes");
        ListaDinamica<String> lista = new ListaDinamica<>();
        lista.inserir("Opa");
        lista.inserir("Olá");
        lista.inserir("Boa noite");

        // na dinâmica, o tamanho cresce conforme inserimos
        System.out.println("Tamanho atual: " + lista.size());

        System.out.println("\n--- Teste do Exibir ---");
        // Deve mostrar: Opa - Olá - Boa noite
        lista.exibir();

        System.out.println("\n--- Teste do Get (Busca por Pulo) ---");
        // O get percorre os nós até o índice 1
        System.out.println("Elemento no índice 1: " + lista.get(1));

        System.out.println("\n--- Teste de Limites ---");
        try {
            System.out.println(lista.get(10)); // deve estourar seu erro de índice inválido
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n--- Teste de pilha e fila dinâmica---");
        PilhaDinamica<String> pilha = new PilhaDinamica<>();
        FilaDinamica<String> fila = new FilaDinamica<>();

        System.out.println("\n--- Lendo Arquivo com BufferedReader ---");
        try (BufferedReader br = new BufferedReader(new FileReader("dados.txt"))) { //abre o arquivo
            String linha;
            while ((linha = br.readLine()) != null) { //enquanto o arquivo tiver linhas, lê e adc nessa variável. Quando chegar no fim, readLine retorna null e para o loop
                System.out.println("Lendo linha: " + linha);
                pilha.push(linha);    //adiciona na pilha (LIFO)
                fila.enfileirar(linha);  //adiciona na fila (FIFO)
            }
        } catch (IOException e) {
            System.out.println("Arquivo 'dados.txt' não encontrado. Pule o teste de leitura.");
        }

        System.out.println("\n--- Resultado da Pilha (Ordem Inversa) ---");
        while (!pilha.estaVazia()) {
            // vai imprimir: Terceiro - Segundo - Primeiro
            System.out.println("Removendo da Pilha: " + pilha.pop());
        }

        System.out.println("\n--- Resultado da Fila (Ordem de Chegada) ---");
        while (!fila.estaVazia()) {
            // vai imprimir: Primeiro - Segundo - Terceiro
            System.out.println("Removendo da Fila: " + fila.desenfileirar());
        }
    }
}