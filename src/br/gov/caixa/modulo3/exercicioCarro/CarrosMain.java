package br.gov.caixa.modulo3.exercicioCarro;



import java.time.Month;
import java.time.YearMonth;
import java.util.List;

public class CarrosMain {

    public static void main(String[] args) {

        List<Carro> carros = List.of(
                new Carro("GM", "Corsa", YearMonth.of(2022, 1)),
                new Carro("Volks", "Gol", YearMonth.of(2004, 1)),
                new Carro("Volks", "Fusca", YearMonth.of(1990, 1)),
                new Carro("FIAT", "Uno", YearMonth.of(2023, 1)),
                new Carro("FIAT", "Palio", YearMonth.of(2021, 1))
        );


    }

}
