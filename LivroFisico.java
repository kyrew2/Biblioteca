public class LivroFisico extends Livro {
    private int numeroExemplares;
    private String dimensaoes;

    public int getNumeroExemplares() {
        return numeroExemplares;
    }

    public void setNumeroExemplares(int numeroExemplares) {
        this.numeroExemplares = numeroExemplares;
    }

    public String getDimensaoes() {
        return dimensaoes;
    }

    public void setDimensaoes(String dimensaoes) {
        this.dimensaoes = dimensaoes;
    }

    @Override
    public String toString() {
        String dadosLivro = "titulo = " + this.getTitulo() +
            ", autor = " + this.getAutor() +
            ", anoPublicacao = " + this.getAnoPublicacao() +
            ", numeroPaginas = " + this.getNumeroPaginas() +
            ", numeroExemplares = " + this.getNumeroExemplares() +
            ", dimensaoes = " + this.getDimensaoes();
        return dadosLivro;
    }
}
