package br.gov.caixa.modulo3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Teste {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);

        LocalDate data = LocalDate.now();
        System.out.println(data);

        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        System.out.println(format.format(data));




    }
}
