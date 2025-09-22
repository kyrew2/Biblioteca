public class LivroDigital extends Livro {
    private String formatoArquivo;
    private double tamanhoArquivo;

public LivroDigital(){

}

    public LivroDigital(String formatoArquivo, double tamanhoArquivo, String titulo, String autor, int anoPublicacao,
            int numeroPaginas) {
        // super(titulo, autor, anoPublicacao, numeroPaginas);
        this.setTitulo(titulo);
        this.setAutor(autor);
        this.setAnoPublicacao(anoPublicacao);
        this.setNumeroPaginas(numeroPaginas);
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
}
