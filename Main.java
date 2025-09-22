import java.util.List;
import java.util.Scanner;

public class Main {
    // Atributos em main chama-se Dependências
    private static Biblioteca biblioteca = new Biblioteca();
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        String menu = """
                === Sistema Biblitoeca ===
                Escolha uma das opções abaixo:
                1 - Adicionar livro;
                2 - Listar acervo;
                3 - Pesquisar livro;
                4 - Remover livro;
                0 - Sair;
                """;
        int opcao;
        do {
            opcao = Input.scanInt(menu + "Digite sua escolha: ", scan);
            switch (opcao) {
                case 1: // CADASTRA VEÍCULO
                    cadastrarLivro();
                    System.out.println("Pressione ENTER para continuar");
                    scan.nextLine();
                    break;
                case 2:
                    listarAcervo();
                    System.out.println("Pressione ENTER para continuar");
                    scan.nextLine();
                    break;
                case 3:
                    pesquisarLivro();
                    System.out.println("Pressione ENTER para continuar");
                    scan.nextLine();
                    break;
                case 4:
                    removerLivro();
                    System.out.println("Pressione ENTER para continuar");
                    scan.nextLine();
                    break;
                case 0: // SAI DO SISTEMA
                    System.out.println("Volte sempre");
                    break;
                default:
                    System.out.println("Opção Inválida!");
                    break;
            }
        } while (opcao != 0);
    }

    private static void cadastrarLivro() {
        String titulo = Input.scanString("Digite o título do livro: ", scan);
        String autor = Input.scanString("Digite o autor do livro: ", scan);
        int anoPublicacao = Input.scanInt("Digite o ano de publicação do livro: ", scan);
        int numeroPaginas = Input.scanInt("Digite o número de páginas do livro: ", scan);
        List<Livro> acervo = biblioteca.pesquisar();
        for (Livro livro : acervo) {
            if (livro.getTitulo().equalsIgnoreCase(titulo) && livro.getAutor().equalsIgnoreCase(autor) && livro.getAnoPublicacao() == anoPublicacao) {
                System.out.println("Esse livro já esta cadastrado!");
                return;
            }
        }
        Livro novoLivro = new Livro(titulo, autor, anoPublicacao, numeroPaginas);
        try {
            biblioteca.adicionar(novoLivro);
            System.out.println("Livro adiconado com sucesso");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void listarAcervo() {
        var acervo = biblioteca.pesquisar(); // MESMA COISA QUE USAR: List<Livro> acervo = biblioteca.pesquisar();
        int tamanho = acervo.size();
        System.out.println("Quantidade de livros: "+ tamanho);
        System.out.println("Livros cadastrados: ");
        for (int i = 0; i < acervo.size(); i++) {
            System.out.println("Livro " + i + 1 + ":" + acervo.get(i));
        }
    }

    private static void pesquisarLivro() {
        String titulo = Input.scanString("Digite o titulo que procura: ", scan);
        String pesquisaAutor = Input.scanString("Deseja pesquisar por autor? S/N", scan);
        List<Livro> livros;
        if (pesquisaAutor.toLowerCase().charAt(0) == 's') {
            String autor = Input.scanString("Digite o nome do autor: ", scan);
            livros = biblioteca.pesquisar(titulo, autor);
        } else {
            livros = biblioteca.pesquisar(titulo);
        }
        imprimirLista(livros);
    }

    private static void imprimirLista(List<Livro> acervo) {
        if (acervo == null || acervo.isEmpty()) {
            System.out.println("Nenhum livro encontrados");
        } else {
            System.out.println("Livros Encontrados: ");
            for (int i = 0; i < acervo.size(); i++) {
                System.out.println("Livro " + i + 1 + ":" + acervo.get(i));
            }
        }
    }

    private static void removerLivro() {
        List<Livro> acervo = biblioteca.pesquisar();
        if (acervo.isEmpty()) {
            System.out.println("Nenhum livro cadastrado para remover!");
            return;
        }
        listarAcervo();
        int indice = Input.scanInt("Digite o índice do livro que deseja remover", scan);
        try {
            Livro removido = biblioteca.removerPorIndice(indice);
            System.out.println("Livro removido: " + removido);
        } catch (Exception e) {
            System.out.println("Erro ao remover: " + e.getMessage());
        }
    }
}