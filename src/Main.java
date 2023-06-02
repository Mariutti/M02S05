import entidades.Reserva;

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

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat parser = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Qual o quarto que você gostaria de reservar?");
        quarto = sc.nextLine();
        System.out.println("Qual a data de entrada?");
        String entradaString = sc.nextLine();
        entrada = parser.parse(entradaString);
        System.out.println("Qual a data de saída?");
        String saidaString = sc.nextLine();
        saida = parser.parse(saidaString);

        Duration totTempo = Duration.between( entrada.toInstant(), saida.toInstant());
        int totDias = (int) totTempo.toDays();


        System.out.println("número do quarto "+ quarto);
        System.out.println(entradaString);
        System.out.println(saidaString);
        System.out.println(totDias + " dias");
    }


}