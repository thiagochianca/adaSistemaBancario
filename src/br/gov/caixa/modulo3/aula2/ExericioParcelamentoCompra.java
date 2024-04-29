package br.gov.caixa.modulo3.aula2;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Scanner;

public class ExericioParcelamentoCompra {

    public static void main(String[] args) {

        var scanner = new Scanner(System.in);

        System.out.println("Digite o valor total da compra: ");

        BigDecimal valorTotal = scanner.nextBigDecimal();

        System.out.println("Digite o total de parcelas: ");

        int parcelas = scanner.nextInt();

        if (parcelas > 12) {
            throw new RuntimeException("Valor de parcelas invalido!");
        }

        BigDecimal valorParcela = valorTotal
                .divide(BigDecimal.valueOf(parcelas), 2, RoundingMode.CEILING);

        for (int i = 1; i <= parcelas; i++) {
            //adiciona i meses
            LocalDate dataPag = LocalDate.now().plusMonths(i);
            DayOfWeek diaSemana = dataPag.getDayOfWeek();
            if (DayOfWeek.SATURDAY.equals(diaSemana) ||
                    DayOfWeek.SUNDAY.equals(diaSemana)) {
                //ajusta a data para a proxima segunda-feira
                dataPag = dataPag.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
            }
            System.out.println(valorParcela + " - " + dataPag);
        }

    }

}
