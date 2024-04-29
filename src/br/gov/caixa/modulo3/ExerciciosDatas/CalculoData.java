package br.gov.caixa.modulo3.ExerciciosDatas;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;


public class CalculoData {
    public static void main(String[] args) {
        LocalDate data = LocalDate.now();
        CalculoData teste = new CalculoData();
        data = teste.avancaDias(data,5);
        System.out.println(data.toString());
        System.out.println(CalculoData.converteData("22/05/1984"));
    }

    public LocalDate avancaDias(LocalDate data, int dias) {
        return data.plusDays(dias);
    }
    public static String converteData(String dataRecebida) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data = LocalDate.parse(dataRecebida,formato);
        data = data.plusDays(3);
        return data.format(formato).toString();
    }
    public static int obterDiferencaEmAnos(String inicio, String fim) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataInicio = LocalDate.parse(inicio,formato);
        LocalDate dataFim = LocalDate.parse(fim,formato);
        Period periodo = Period.between(dataInicio, dataFim);


        return periodo.getYears();
    }
    public static boolean ehSexta13(int mes, int ano) {
        LocalDate data = LocalDate.of(ano,mes,13);
        if(data.getDayOfWeek() == DayOfWeek.FRIDAY) {
            return true;
        }
        return false;
    }

}
