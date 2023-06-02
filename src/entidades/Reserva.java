package entidades;

import java.util.Date;

public class Reserva {
    private String numero;
    private Date dataEntrada;
    private Date dataSaida;

    public Reserva(String numero, Date dataEntrada) {
        this.numero = numero;
        this.dataEntrada = dataEntrada;
    }
    public Reserva(String numero, Date dataEntrada, Date dataSaida) {
        this.numero = numero;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
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
