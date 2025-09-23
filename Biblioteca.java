import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private final List<Livro> acervo;
    private final int ANO_PUBLICACAO_MINIMO = 1900;

    public Biblioteca() {
        this.acervo = new ArrayList<>();
    }

    public Livro adicionar(Livro livro) throws Exception {

        if (livro == null) {
            throw new Exception("Livro não pode ser nulo!");
        }

        livro.setAutor(livro.getAutor().trim());

        if (livro.getTitulo() == null || livro.getTitulo().isEmpty()) {
            throw new Exception("Autor não pode ser em branco");
        }

        int anoAtual = LocalDate.now().getYear();
        if (livro.getAnoPublicacao() < ANO_PUBLICACAO_MINIMO || livro.getAnoPublicacao() > anoAtual) {
            throw new Exception("Ano de publicação deve estar entre 1900 e " + anoAtual);
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

    public List<Livro> pesquisar() {
        return acervo;
    }

    public List<Livro> pesquisar(String titulo) {
        return pesquisar(titulo, null);
    }

    public List<Livro> pesquisar(String titulo, String autor) {
        List<Livro> livrosEncontrados = new ArrayList<>();
        for (Livro livro : acervo) {
            if (livro.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                if (autor == null || livro.getAutor().toLowerCase().contains(autor.toLowerCase()))
                    livrosEncontrados.add(livro);
            }
        }
        return livrosEncontrados;
    }
}