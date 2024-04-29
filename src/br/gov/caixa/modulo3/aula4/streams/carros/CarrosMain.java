package br.gov.caixa.modulo3.aula4.streams.carros;

import java.time.YearMonth;
import java.util.List;
import java.util.function.Predicate;

public class CarrosMain {

    public static void main(String[] args) {

        List<Carro> carros = List.of(
                new Carro("GM", "Corsa", YearMonth.of(2022, 1)),
                new Carro("Volks", "Gol", YearMonth.of(2004, 1)),
                new Carro("VOLKS", "Fusca", YearMonth.of(1990, 1)),
                new Carro("FIAT", "Uno", YearMonth.of(2023, 1)),
                new Carro("FIAT", "Palio", YearMonth.of(2021, 1))
        );

        //criar um metodo que receba como argumento o filtro (Predicate) e retorne
        //os carros da Marca Volks ordenados por ano de fabricacao desc.

        List<Carro> carrosFiltro = filtrarCarros(
                carros,
                (carro) -> "volks".equalsIgnoreCase(carro.marca())
        );

        carrosFiltro.forEach(carro -> System.out.println(carro));

        carrosFiltro.forEach(System.out::println);


    }

    static List<Carro> filtrarCarros(List<Carro> carros, Predicate<Carro> filtro) {
        return carros.stream()
                .filter(filtro)
//                .sorted(new Comparator<Carro>() {
//                    @Override
//                    public int compare(Carro o1, Carro o2) {
//                        return o2.fabricacao().compareTo(o1.fabricacao());
//                    }
//                })
                .sorted((Carro o1, Carro o2) -> o2.fabricacao().compareTo(o1.fabricacao()))
                //.sorted(Comparator.comparing())
                //.sorted(Comparator.comparing(Carro::fabricacao))
                .toList();
    }

}
