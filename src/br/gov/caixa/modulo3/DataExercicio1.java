package br.gov.caixa.modulo3;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.Scanner;

public class DataExercicio1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Informe sua data de nascimento (dd/MM/yyyy):");
        String dataNascimento = sc.nextLine();

        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data = LocalDate.parse(dataNascimento,format);
        DayOfWeek diaSemana = data.getDayOfWeek();
        DateTimeFormatter diaSemanaformat = DateTimeFormatter.ofPattern("EEEE", new Locale("pt", "BR"));

        System.out.println("Idade: " + ChronoUnit.YEARS.between(data, LocalDate.now()));
        System.out.printf("Você nasceu numa %s.", diaSemanaformat.format(diaSemana));
    }
}
