package br.gov.caixa.modulo3.aula2;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;

public class ConversaoDateToLocalDate {

    public static void main(String[] args) {

        LocalDateTime localDateTime = LocalDateTime.now();

        Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());

        System.out.println(date);



    }

}
