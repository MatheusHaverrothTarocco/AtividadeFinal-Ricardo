import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IEstruturaDinamica pilha = new PilhaDinamica();

        int opcao;

        do {
            System.out.println("\n--- MENU PILHA DINÂMICA ---");
            System.out.println("1. Inserir elemento");
            System.out.println("2. Inserir sequência de elementos");
            System.out.println("3. Remover elemento");
            System.out.println("4. Remover sequência de elementos");
            System.out.println("5. Remover todas ocorrências de um elemento");
            System.out.println("6. Verificar se a pilha está vazia");
            System.out.println("7. Buscar elemento");
            System.out.println("8. Ordenar crescente");
            System.out.println("9. Ordenar decrescente");
            System.out.println("10. Quantidade de elementos");
            System.out.println("11. Editar elemento");
            System.out.println("12. Limpar pilha");
            System.out.println("13. Exibir pilha");
            System.out.println("14. Obter primeiro elemento");
            System.out.println("15. Obter último elemento");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    System.out.print("Digite o elemento a inserir: ");
                    // Lê como inteiro
                    int elemento = scanner.nextInt();
                    pilha.inserirElemento(elemento);
                    break;
                case 2:
                    System.out.print("Digite os elementos para inserir (separados por vírgula): ");
                    String[] elementos = scanner.nextLine().split(",");
                    // Converte cada string para Integer
                    Integer[] elementosInt = new Integer[elementos.length];
                    for (int i = 0; i < elementos.length; i++) {
                        elementosInt[i] = Integer.parseInt(elementos[i].trim());
                    }
                    pilha.inserirSequencia(elementosInt);
                    break;
                case 3:
                    System.out.print("Digite o elemento a remover: ");
                    int remover = scanner.nextInt();
                    boolean removido = pilha.removerElemento(remover);
                    System.out.println(removido ? "Elemento removido com sucesso!" : "Elemento não encontrado.");
                    break;
                case 4:
                    System.out.print("Digite os elementos para remover (separados por vírgula): ");
                    String[] removerSequencia = scanner.nextLine().split(",");
                    Integer[] removerSequenciaInt = new Integer[removerSequencia.length];
                    for (int i = 0; i < removerSequencia.length; i++) {
                        removerSequenciaInt[i] = Integer.parseInt(removerSequencia[i].trim());
                    }
                    pilha.removerSequencia(removerSequenciaInt);
                    System.out.println("Sequência removida com sucesso.");
                    break;
                case 5:
                    System.out.print("Digite o elemento para remover todas as ocorrências: ");
                    int removerOcorrencias = scanner.nextInt();
                    pilha.removerTodasOcorrencias(removerOcorrencias);
                    System.out.println("Todas as ocorrências removidas.");
                    break;
                case 6:
                    System.out.println(pilha.estaVazia() ? "A pilha está vazia." : "A pilha não está vazia.");
                    break;
                case 7:
                    System.out.print("Digite o elemento para buscar: ");
                    int buscar = scanner.nextInt();
                    boolean encontrado = pilha.buscarElemento(buscar);
                    System.out.println(encontrado ? "Elemento encontrado!" : "Elemento não encontrado.");
                    break;
                case 8:
                    pilha.ordenarCrescente();
                    break;
                case 9:
                    pilha.ordenarDecrescente();
                    break;
                case 10:
                    System.out.println("Quantidade de elementos: " + pilha.quantidadeElementos());
                    break;
                case 11:
                    System.out.print("Digite o elemento antigo: ");
                    int antigo = scanner.nextInt();
                    System.out.print("Digite o novo elemento: ");
                    int novo = scanner.nextInt();
                    pilha.editarElemento(antigo, novo);
                    System.out.println("Elemento editado com sucesso.");
                    break;
                case 12:
                    pilha.limpar();
                    System.out.println("Pilha limpa.");
                    break;
                case 13:
                    pilha.exibir();
                    break;
                case 14:
                    No primeiro = pilha.obterPrimeiroElemento();
                    System.out.println(primeiro != null ? "Primeiro elemento: " + primeiro.getConteudo() : "Pilha vazia.");
                    break;
                case 15:
                    No ultimo = pilha.obterUltimoElemento();
                    System.out.println(ultimo != null ? "Último elemento: " + ultimo.getConteudo() : "Pilha vazia.");
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
