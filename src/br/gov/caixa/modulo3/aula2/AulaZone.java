package br.gov.caixa.modulo3.aula2;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class AulaZone {

    public static void main(String[] args) {

        ZoneId zoneIdSP = ZoneId.of("America/Sao_Paulo");

        ZonedDateTime zonedDateTimeSP =
                ZonedDateTime.of(LocalDateTime.of(2015, 01, 01, 0, 0), zoneIdSP);

        System.out.println(zonedDateTimeSP);

        ZoneId zoneIdLisboa = ZoneId.of("Europe/Lisbon");

        ZonedDateTime zonedDateTimeLisboa = zonedDateTimeSP.withZoneSameInstant(zoneIdLisboa);

        System.out.println(zonedDateTimeLisboa);

        ZonedDateTime zonedDateTimeRoma = zonedDateTimeSP.withZoneSameInstant(ZoneId.of("Europe/Rome"));

        System.out.println(zonedDateTimeRoma);

        boolean isDaylightSavingLisboa = zoneIdLisboa.getRules().isDaylightSavings(zonedDateTimeLisboa.toInstant());
        System.out.println("Horario de verao Lisboa?  " + isDaylightSavingLisboa);

        boolean isDaylightSavingSP = zoneIdSP.getRules().isDaylightSavings(zonedDateTimeSP.toInstant());
        System.out.println("Horario de verao SP?  " + isDaylightSavingSP);


        ZonedDateTime zonedDateTimeNow = ZonedDateTime.now();

        ZoneId zoneIdAcre = ZoneId.of("America/Porto_Acre");

        ZonedDateTime zonedDateTimeAcre = zonedDateTimeNow.withZoneSameInstant(zoneIdAcre);

        System.out.println("Acre: " + zonedDateTimeAcre);

    }

}
