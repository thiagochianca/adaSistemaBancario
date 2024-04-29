package br.gov.caixa.modulo3.aula1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class ExercicioDatas1 {

    public static void main(String[] args) {

        /*
        Exercicio 1:
            Solicitar a data de nascimento do usuario (dd/MM/yyyy) e imprimir:
                Idade:
                Dia da semana: (day of week)
         */

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a data de nascimento: (dd/MM/yyyy)");

        String dataStr = scanner.nextLine();

        LocalDate dataNasc = LocalDate.parse(dataStr, dateTimeFormatter);

        long idade = ChronoUnit.YEARS.between(dataNasc, LocalDate.now());

        System.out.println("Idade: " + idade);

        System.out.println("Dia da semana: " + dataNasc.getDayOfWeek());

        System.out.println(LocalDate.now().getYear() - dataNasc.getYear());

        //10/01/1990
        //Idade:
        //Dia da semana:

    }

}
