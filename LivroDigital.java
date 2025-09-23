public final class LivroDigital extends Livro {
    private String formatoArquivo;
    private double tamanhoArquivo;

    public LivroDigital() {

    }

    public LivroDigital(String titulo, String autor, int anoPublicacao, int numeroPaginas, String formatoArquivo,
            double tamanhoArquivo) {
        super(titulo, autor, anoPublicacao, numeroPaginas);
        this.formatoArquivo = formatoArquivo;
        this.tamanhoArquivo = tamanhoArquivo;
    }

    public String getFormatoArquivo() {
        return formatoArquivo;
    }

    public void setFormatoArquivo(String formatoArquivo) {
        this.formatoArquivo = formatoArquivo;
    }

    public double getTamanhoArquivo() {
        return tamanhoArquivo;
    }

    public void setTamanhoArquivo(double tamanhoArquivo) {
        this.tamanhoArquivo = tamanhoArquivo;
    }

    @Override
    public String getTipoLivro() {
        return "Livro digital";
    }

    @Override
    public String toString() {
        String dadosLivro =
                "Tipo de Livro = " + this.getTipoLivro() +
                ", Titulo = " + this.getTitulo() +
                ", Autor = " + this.getAutor() +
                ", Ano de Publicação = " + this.getAnoPublicacao() +
                ", Número de Páginas = " + this.getNumeroPaginas() +
                ", Formato do Arquivo = " + this.getFormatoArquivo() +
                ", Tamanho do Arquivo = " + this.getTamanhoArquivo();
        return dadosLivro;
    }
}