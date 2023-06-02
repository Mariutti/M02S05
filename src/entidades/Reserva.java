package entidades;

import excecoes.ExcecaoDominio;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class Reserva {
    private String quarto;
    private Date dataEntrada;
    private Date dataSaida;
    SimpleDateFormat parser = new SimpleDateFormat("dd/MM/yyyy");

    public Reserva() {
    }

    public Reserva(String quarto, Date dataEntrada, Date dataSaida) throws ExcecaoDominio {
        this.quarto = quarto;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.checarDatas(this.dataEntrada, this.dataSaida);
    }

    public int getTotalDias() {
        Duration totTempo = Duration.between(dataEntrada.toInstant(), dataSaida.toInstant());
        return (int) totTempo.toDays();
    }

    public int getTotalDias(Date data1, Date data2) {
        Duration totTempo = Duration.between(data1.toInstant(), data2.toInstant());
        return (int) totTempo.toDays();
    }

    public void checarDatas(Date data1, Date data2) throws ExcecaoDominio {
        if (this.getTotalDias(data1, data2) < 0) {
            throw new ExcecaoDominio("Erro de Reserva: Data de saída deve ser maior que data de Entrada.");
        } else if (this.getTotalDias(data1, data2) == 0) {
            throw new ExcecaoDominio("Erro de Reserva: Data de saída não pode ser igual à data de entrada");
        }
    }
    public void checarDatas(Date data1, Date data2, String msg1, String msg2) throws ExcecaoDominio {
        if (this.getTotalDias(data1, data2) < 0) {
            throw new ExcecaoDominio(msg1);
        } else if (this.getTotalDias(data1, data2) == 0) {
            throw new ExcecaoDominio(msg2);
        }
    }
    public void alterarReserva(Date novaEntrada, Date novaSaida) throws ExcecaoDominio {
        checarDatas(novaEntrada, this.dataEntrada, "Erro de Reserva: Datas da Reserva devem ser atualizada para datas " +
                "futuras", "Erro de Reserva: Data de saída não pode ser igual à data de entrada");
        this.dataEntrada = novaEntrada;
        this.dataSaida = novaSaida;
        checarDatas(this.dataEntrada, this.dataSaida, "Erro de Reserva: Data de saída deve ser maior que data de Entrada.", "Erro de Reserva: Data de saída não pode ser igual à data de " +
                "entrada");
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

    @Override
    public String toString() {
        return "Reserva: Quarto " + this.getQuarto() + ", Entrada: " + parser.format(this.getDataEntrada()) + ", " +
                "Saída: " + parser.format(this.getDataSaida()) + ", total de " + this.getTotalDias() + " dias ";
    }
}
