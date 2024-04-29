package br.gov.caixa.modulo3.aula2;

import java.time.*;
import java.time.temporal.TemporalUnit;

public class PeriodInstantDuration {

    public static void main(String[] args) {

        //01-01-1970 -> millisegundos
        Instant instant = Instant.now();
        System.out.println(instant.getEpochSecond());

        //dia, mes, ano
        Period period = Period.between(LocalDate.now(), LocalDate.of(2024, 12, 25));
        System.out.println(period);

        //hora, minutos, segundos
        Duration duration = Duration.between(
                LocalDateTime.now(),
                LocalDateTime.of(2024, 4, 13, 0,0));
        System.out.println(duration);

        System.out.println(duration.getSeconds() / 60 / 60);
    }

}
