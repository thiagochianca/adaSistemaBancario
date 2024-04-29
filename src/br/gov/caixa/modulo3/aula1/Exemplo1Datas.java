package br.gov.caixa.modulo3.aula1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public class Exemplo1Datas {

    public static void main(String[] args) {

        //"YYYY-MM-DD HH:MM:SS";

        //LocalDate dataAtual = LocalDate.now();

        //System.out.println(dataAtual);

        //System.out.println(LocalTime.now());

        //System.out.println(LocalDateTime.now());

        Date dataAtualDate = new Date();
        dataAtualDate.setHours(10);
        System.out.println(dataAtualDate);

        LocalDateTime dataAtualLocalDateTime = LocalDateTime.now();
        dataAtualLocalDateTime = dataAtualLocalDateTime.plusHours(10);
        System.out.println(dataAtualLocalDateTime);

        Cliente cliente = new Cliente(LocalDate.of(1990, 1,1));
        //cliente.setDataNascimento(LocalDate.of(1980, 2, 20));
        System.out.println(cliente.getDataNascimento());

        //cliente.setDataNascimento(LocalDate.of(1980, 3, 20));
        System.out.println(cliente.getDataNascimento());

        System.out.println(LocalDateTime.of(2024, 4, 9, 10, 5));


    }

}
