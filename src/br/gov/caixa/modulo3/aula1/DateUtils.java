package br.gov.caixa.modulo3.aula1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    static final DateTimeFormatter DATE_TIME_FORMATTER =
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public static String dateToString(LocalDateTime data) {
        return DATE_TIME_FORMATTER.format(data);
    }

}
