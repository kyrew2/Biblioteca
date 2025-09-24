public final class LivroFisico extends Livro {
    private int numeroExemplares;
    private String dimensoes;

    public LivroFisico() {

    }

    public LivroFisico(String titulo, String autor, int anoPublicacao, int numeroPaginas, int numeroExemplares, String dimensoes) {
        super(titulo, autor, anoPublicacao, numeroPaginas);
        this.numeroExemplares = numeroExemplares;
        this.dimensoes = dimensoes;
    }

    public int getNumeroExemplares() {
        return numeroExemplares;
    }

    public void setNumeroExemplares(int numeroExemplares) {
        this.numeroExemplares = numeroExemplares;
    }

    public String getDimensoes() {
        return dimensoes;
    }

    public void setDimensoes(String dimensoes) {
        this.dimensoes = dimensoes;
    }

    @Override
    public String getTipoLivro() {
        return "Livro físico";
    }

    @Override
    public String toString() {
        String dadosLivro =
                "Tipo de Livro = " + this.getTipoLivro() +
                ", Titulo = " + this.getTitulo() +
                ", Autor = " + this.getAutor() +
                ", Ano de Publicação = " + this.getAnoPublicacao() +
                ", Número de Páginas = " + this.getNumeroPaginas() +
                ", Número de Exemplares = " + this.getNumeroExemplares() +
                ", Dimensões = " + this.getDimensoes();
        return dadosLivro;
    }
}