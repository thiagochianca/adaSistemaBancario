package br.gov.caixa.modulo3.aula2;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class AjustesDatasHoras {

    public static void main(String[] args) {

        LocalDateTime localDateTime = LocalDateTime.now();

        LocalDateTime proximoSabado =
                localDateTime.with(TemporalAdjusters.previous(DayOfWeek.SATURDAY));

        System.out.println(proximoSabado);

        LocalDate fevereiro2024 = LocalDate.of(2024, 2, 1);
        LocalDate ultimoDiaFev2024 =
                fevereiro2024.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(ultimoDiaFev2024);

        System.out.println("tem 29 dias? " + (ultimoDiaFev2024.getDayOfMonth() == 29));

        System.out.println(Year.isLeap(fevereiro2024.getYear()));

        LocalDate.now().isLeapYear();

    }

}
