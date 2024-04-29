package br.gov.caixa.modulo3.aula1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ExemploOperacoesDatas {

    public static void main(String[] args) {

        LocalDate dataAtual = LocalDate.now();
        LocalDate dataNascimento = LocalDate.of(1984, 5,10);

        System.out.println(dataAtual);
        System.out.println(dataNascimento);

        long idade = ChronoUnit.YEARS.between(dataNascimento, dataAtual);
        System.out.println(idade);

    }

}
