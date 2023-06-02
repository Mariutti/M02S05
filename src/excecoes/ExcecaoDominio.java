package excecoes;

public class ExcecaoDominio extends Exception{
    public ExcecaoDominio() {
    }

    public ExcecaoDominio(String message) {
        super(message);
    }
}
