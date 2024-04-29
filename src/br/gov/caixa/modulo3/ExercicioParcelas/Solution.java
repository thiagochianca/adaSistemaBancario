package br.gov.caixa.modulo3.ExercicioParcelas;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o valor da compra: ");
        BigDecimal valor = sc.nextBigDecimal();
        System.out.println("Digite a quantidade de parcelas: ");
        int parcela = sc.nextInt();

        BigDecimal valorParcela = valor.divide(BigDecimal.valueOf(parcela),2, RoundingMode.CEILING);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        for(int i = 1; i <= parcela; i++) {
            LocalDate dataPagamento = LocalDate.now().plusMonths(i);
            if (dataPagamento.getDayOfWeek().equals(DayOfWeek.SATURDAY) ||
                    dataPagamento.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
                System.out.println(format.format(dataPagamento.with(TemporalAdjusters.next(DayOfWeek.MONDAY))) + " - " + valorParcela);
            } else {
                System.out.println(format.format(dataPagamento) + " - " + valorParcela);
            }


        }




    }
}
