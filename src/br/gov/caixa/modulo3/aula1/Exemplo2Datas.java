package br.gov.caixa.modulo3.aula1;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Exemplo2Datas {

    static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public static void main(String[] args) {

        System.out.println(new Date());

        LocalDateTime dataAtual = LocalDateTime.now();
        System.out.println(DATE_TIME_FORMATTER.format(dataAtual));

        String dataStr = "10/04/2024 09:05:00";
        LocalDateTime dataStrToDate = LocalDateTime.parse(dataStr, DATE_TIME_FORMATTER);
        System.out.println(dataStrToDate);

        System.out.println(LocalDateTime.parse("2024-04-20T09:00:00"));


        //System.out.println("01-01-1970 mili: " + Instant.now().toEpochMilli());
        //System.out.println("01-01-1970 seg: " + Instant.now().getEpochSecond());

        //01-01-1970
        //System.out.println(System.currentTimeMillis());

        System.out.println(DateUtils.dateToString(LocalDateTime.now()));
    }

}
