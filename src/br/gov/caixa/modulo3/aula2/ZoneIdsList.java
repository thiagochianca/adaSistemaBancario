package br.gov.caixa.modulo3.aula2;

import java.time.ZoneId;

public class ZoneIdsList {

    public static void main(String[] args) {

        for (String zoneId : ZoneId.getAvailableZoneIds()) {
            System.out.println(zoneId);
        }

    }

}
