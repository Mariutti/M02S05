package entidades;

import java.time.Duration;
import java.util.Date;

public class Reserva {
    private String quarto;
    private Date dataEntrada;
    private Date dataSaida;

    public Reserva() {
    }

    public Reserva(String quarto, Date dataEntrada) {
        this.quarto = quarto;
        this.dataEntrada = dataEntrada;
    }
    public Reserva(String quarto, Date dataEntrada, Date dataSaida) {
        this.quarto = quarto;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
    }

    public int getTotalDias(){
        Duration totTempo = Duration.between( dataEntrada.toInstant(), dataSaida.toInstant());
        return (int) totTempo.toDays();
    }

    public String getQuarto() {
        return quarto;
    }

    public void setQuarto(String quarto) {
        this.quarto = quarto;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }
}
