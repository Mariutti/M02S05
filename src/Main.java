import entidades.Reserva;
import excecoes.ExcecaoDominio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException, ExcecaoDominio {
        String quarto;
        Date entrada;
        Date saida;

        SimpleDateFormat parser = new SimpleDateFormat("dd/MM/yyyy");

        Scanner sc = new Scanner(System.in);

        System.out.println("Qual o quarto que você gostaria de reservar?");
        quarto = sc.nextLine();
        System.out.println("Qual a data de entrada (dd/mm/yyyy)?");
        entrada = parser.parse(sc.nextLine());
        System.out.println("Qual a data de saída (dd/mm/yyyy)?");
        saida = parser.parse(sc.nextLine());

        try {
            Reserva reserva1 = new Reserva(quarto, entrada, saida);
            System.out.println(reserva1.toString());

            System.out.println("Entre com as datas para atualização da reserva:");
            System.out.println("Qual a data de entrada (dd/mm/yyyy)?");
            Date novaEntrada = parser.parse(sc.nextLine());
            System.out.println("Qual a data de saída (dd/mm/yyyy)?");
            Date novaSaida = parser.parse(sc.nextLine());

            reserva1.alterarReserva(novaEntrada, novaSaida);
            System.out.println(reserva1.toString());

        } catch (ExcecaoDominio e) {
            System.out.println(e);
            System.out.println(e.getMessage());
        }
    }
}

