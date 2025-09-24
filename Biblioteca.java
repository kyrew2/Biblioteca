import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private final List<Livro> acervo;
    private final int ANO_PUBLICACAO_MINIMO = 1900;
    private final int ANO_PUBLICACAO_MAXIMO = LocalDate.now().getYear();

    public Biblioteca() {
        this.acervo = new ArrayList<>();
    }

    public Livro adicionar(Livro livro) throws Exception {

        if (livro == null) {
            throw new Exception("Livro não pode ser nulo!");
        }

        if (livro.getTitulo() == null || livro.getTitulo().isEmpty()) {
            throw new Exception("Título não pode ser em branco");
        }

        livro.setAutor(livro.getAutor().trim());

        if (livro.getAutor() == null || livro.getAutor().isEmpty()) {
            throw new Exception("Autor não pode ser em branco");
        }

        if (livro.getAnoPublicacao() < ANO_PUBLICACAO_MINIMO || livro.getAnoPublicacao() > ANO_PUBLICACAO_MAXIMO) {
            throw new Exception("Ano de publicação deve estar entre 1900 e " + ANO_PUBLICACAO_MAXIMO);
        }

        if (livro.getNumeroPaginas() <= 0) {
            throw new Exception("Número de páginas deve ser maior que zero!");
        }

        acervo.add(livro);
        return livro;
    }

    public Livro removerPorIndice(int indice) throws Exception {
        if (indice < 0 || indice >= acervo.size()) {
            throw new Exception("Índice inválido!");
        }
        return acervo.remove(indice);
    }

    public Livro buscaPorIndice(int indice) throws Exception {
        if (indice < 0 || indice >= acervo.size()) {
            throw new Exception("Índice inválido!");
        }
        return acervo.get(indice);
    }

    public List<Livro> pesquisar() {
        return acervo;
    }

    public List<Livro> pesquisar(String titulo) {
        List<Livro> livrosEncontrados = new ArrayList<>();
        for (Livro livro : acervo) {
            if (livro.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                livrosEncontrados.add(livro);
            }
        }
        return livrosEncontrados;
    }
        public List<Livro> pesquisarPorAutor(String autor) {
        List<Livro> livrosEncontrados = new ArrayList<>();
        for (Livro livro : acervo) {
            if (livro.getAutor().toLowerCase().contains(autor.toLowerCase())) {
                livrosEncontrados.add(livro);
            }
        }
        return livrosEncontrados;
    }

    public List<Livro> pesquisar(int anoInicial, int anoFinal) {
        List<Livro> livrosEncontrados = new ArrayList<>();
        for (Livro livro : acervo) {
            if (livro.getAnoPublicacao() >= anoInicial && livro.getAnoPublicacao() <= anoFinal) {
                livrosEncontrados.add(livro);
            }
        }
        return livrosEncontrados;
    }

    public List<Livro> pesquisar(String titulo, String autor) {
        List<Livro> livrosEncontrados = new ArrayList<>();
        for (Livro livro : acervo) {
            if (livro.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                if (autor == null || autor.trim().isEmpty()
                        || livro.getAutor().toLowerCase().contains(autor.toLowerCase())) {
                    livrosEncontrados.add(livro);
                }
            }
        }
        return livrosEncontrados;
    }
}