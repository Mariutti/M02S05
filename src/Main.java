import entidades.Reserva;
import excecoes.ExcecaoDominio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.temporal.Temporal;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        String quarto;
        Date entrada;
        Date saida;

        SimpleDateFormat parser = new SimpleDateFormat("dd/MM/yyyy");

        Scanner sc = new Scanner(System.in);

            System.out.println("Qual o quarto que você gostaria de reservar?");
            quarto = sc.nextLine();
            System.out.println("Qual a data de entrada?");
            entrada = parser.parse(sc.nextLine());
            System.out.println("Qual a data de saída?");
            saida = parser.parse(sc.nextLine());
        try {entradaDeDatas(entrada, saida);
        } catch (ExcecaoDominio e) {

        }

            Reserva reserva1 = new Reserva(quarto, entrada, saida);

        System.out.println("número do quarto " + reserva1.getQuarto());
        System.out.println(parser.format(reserva1.getDataEntrada()));
        System.out.println(parser.format(reserva1.getDataSaida()));
        System.out.println(reserva1.getTotalDias() + " dias");
    }

    public static void entradaDeDatas(Date entrada, Date saida) throws ExcecaoDominio {
        if (saida.before(entrada)) {
            throw new ExcecaoDominio("Data de saída precisa ser posterior à data de entrada");
        } else if (entrada.equals(saida)) {
            throw new ExcecaoDominio("Data de saída precisa não pode ser igual à data de entrada");

        }
    }

}

