package br.gov.caixa.modulo3.aula2;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class AulaLocale {

    public static void main(String[] args) {

        ZonedDateTime zonedDateTime = ZonedDateTime.now();

        Locale locBR = new Locale("pt", "BR");

        String dataFormatoBR =
                zonedDateTime.format(DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy").withLocale(locBR));

        System.out.println("Formato BR: " + dataFormatoBR);

        Locale locJapao = new Locale("ja");

        String dataFormatoJapao =
                zonedDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).withLocale(locJapao));

        System.out.println("Formato JA: " + dataFormatoJapao);

        Locale locEUA = new Locale("en", "US");

        String dataFormatoEUA =
                zonedDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).withLocale(locEUA));

        System.out.println("Formato EUA: " + dataFormatoEUA);

        Locale locUK = new Locale("en", "UK");

        String dataFormatoUK =
                zonedDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).withLocale(locUK));

        System.out.println("Formato UK: " + dataFormatoUK);


        imprimirDataAtual(Locale.FRANCE);
    }

    static void imprimirDataAtual(Locale locale) {
        String dataFormatada = ZonedDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).withLocale(locale));
        System.out.println(dataFormatada);
    }

}
