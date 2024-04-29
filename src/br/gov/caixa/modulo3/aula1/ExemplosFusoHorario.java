package br.gov.caixa.modulo3.aula1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ExemplosFusoHorario {

    public static void main(String[] args) {

        LocalDateTime dataAtual = LocalDateTime.now();

        ZoneId zoneIdParis = ZoneId.of("Europe/Paris");
        ZonedDateTime zonedDateTimeParis = ZonedDateTime.of(dataAtual, zoneIdParis);

        ZoneId zoneIdBrasilia = ZoneId.of("America/Sao_Paulo");
        ZonedDateTime zonedDateTimeBrasilia = ZonedDateTime.of(dataAtual, zoneIdBrasilia);

        System.out.println(dataAtual);

        System.out.println("Paris: " + zonedDateTimeParis);
        System.out.println("Brasilia: " + zonedDateTimeBrasilia);

        boolean isDaylightSavingParis = zoneIdParis.getRules().isDaylightSavings(zonedDateTimeParis.toInstant());
        System.out.println("Horario de verao Paris: " + isDaylightSavingParis);

        boolean isDaylightSavingBrasilia = zoneIdBrasilia.getRules().isDaylightSavings(zonedDateTimeBrasilia.toInstant());
        System.out.println("Horario de verao Brasilia: " + isDaylightSavingBrasilia);

        //System.out.println(zonedDateTimeParis.format(DateTimeFormatter.ofPattern("HH:mm:ss")));

        ZonedDateTime zonedDateTimeLocal = ZonedDateTime.now();
        ZonedDateTime zonedDateTimeParis2 = zonedDateTimeLocal.withZoneSameInstant(ZoneId.of("Europe/Paris"));

        System.out.println(zonedDateTimeParis2);

    }

}
