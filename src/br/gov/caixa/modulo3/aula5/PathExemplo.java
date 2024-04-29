package br.gov.caixa.modulo3.aula5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.stream.Stream;

public class PathExemplo {

    public static void main(String[] args)  {

        Path arquivoCartoes = Path.of("C:/Users/c148738/OneDrive - Caixa Economica Federal/Documentos/campeonato-brasileiro-cartoes.csv");

        long time1 = 0;
        long time2 = 0;

        try (Stream<String> lines = Files.lines(arquivoCartoes)) {
            LocalTime start = LocalTime.now();
            lines.forEach(line -> System.out.println(line));
            time1 = ChronoUnit.MILLIS.between(start, LocalTime.now());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Stream<String> lines = Files.lines(arquivoCartoes);
            LocalTime start2 = LocalTime.now();
            lines.parallel().forEach(line -> System.out.println(line));
            time2 = ChronoUnit.MILLIS.between(start2, LocalTime.now());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Teste 1: " + time1);
        System.out.println("Teste 2: " + time2);

//        Stream<String> lines = null;
//        try {
//            lines = Files.lines(arquivoCartoes);
//        } catch (IOException e) {
//            e.getStackTrace();
//        } finally {
//            lines.close();
//        }

    }

}
