public final class LivroFisico extends Livro {
    private int numeroExemplares;
    private String dimensoes;

    public LivroFisico(String titulo, String autor, int anoPublicacao, int numeroPaginas, int numeroExemplares,
            String dimensoes) {
        // super(titulo, autor, anoPublicacao, numeroPaginas);
        this.setTitulo(titulo);
        this.setAutor(autor);
        this.setAnoPublicacao(anoPublicacao);
        this.setNumeroPaginas(numeroPaginas);
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
    public String toString() {
        String dadosLivro = "titulo = " + this.getTitulo() +
                ", autor = " + this.getAutor() +
                ", anoPublicacao = " + this.getAnoPublicacao() +
                ", numeroPaginas = " + this.getNumeroPaginas() +
                ", numeroExemplares = " + this.getNumeroExemplares() +
                ", dimensoes = " + this.getDimensoes();
        return dadosLivro;
    }

    @Override
    public String getTipoLivro() {
        return "Livro fisico";
    }
}