package br.gov.caixa.modulo3.aula1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExemploFormatacaoDatas {

    public static void main(String[] args) {

        String dataStr = "PST 23:53:28 - 2024-12-25";

        String patternDate = "z HH:mm:ss - yyyy-MM-dd";

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(patternDate);

        LocalDateTime data = LocalDateTime.parse(dataStr, dateTimeFormatter);

        System.out.println(data);

    }

}
