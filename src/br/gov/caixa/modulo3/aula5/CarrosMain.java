package br.gov.caixa.modulo3.aula5;



import br.gov.caixa.modulo3.aula4.streams.carros.Carro;

import java.time.YearMonth;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class CarrosMain {

    public static void main(String[] args) {

        List<Carro> carros = List.of(
                new Carro("GM", "Corsa", YearMonth.of(2022, 1)),
                new Carro("Volks", "Gol", YearMonth.of(2004, 1)),
                new Carro("Volks", "Gol", YearMonth.of(2003, 1)),
                new Carro("VOLKS", "Fusca", YearMonth.of(1990, 1)),
                new Carro("FIAT", "Uno", YearMonth.of(2023, 1)),
                new Carro("FIAT", "Palio", YearMonth.of(2021, 1))
        );

        carros.stream()
                .parallel()
                .filter(carro -> "gol".equalsIgnoreCase(carro.modelo()))
                .sorted((Carro o1, Carro o2) -> o1.fabricacao().compareTo(o2.fabricacao()))
                //.toList()
                .forEachOrdered(carro -> System.out.println(carro));

        carros.stream()
                .parallel()
                .filter(carro -> "gol".equalsIgnoreCase(carro.modelo()))
                .findAny()
                .ifPresent(carro -> System.out.println("Gol: " + carro));

        //criar um metodo que receba como argumento o filtro (Predicate) e retorne
        //os carros da Marca Volks ordenados por ano de fabricacao desc.

        List<Carro> carrosFiltro = filtrarCarros(
                carros,
                (carro) -> "volks".equalsIgnoreCase(carro.marca())
        );

        carrosFiltro.parallelStream().forEach(carro -> System.out.println(carro));

        carrosFiltro.parallelStream().forEach(System.out::println);

        Optional<Carro> carroRenaultMaisNovo = carrosFiltro.stream().findAny();

        //carroRenaultMaisNovo.ifPresent(carro -> System.out.println("Carro mais novo: " + carro));

        carroRenaultMaisNovo.ifPresentOrElse(
                carro -> System.out.println("Carro mais novo: " + carro),
                ()-> System.out.println("Carro nao encontrado"));

        String modeloMaisNovo = carroRenaultMaisNovo
                .stream()
                //.map(carro -> carro.modelo())
                .map(Carro::modelo)
                .findFirst()
                .orElse("Nao nao encontrado");

        System.out.println(modeloMaisNovo);

//        if (carroRenaultMaisNovo.isPresent()) {
//            System.out.println("Carro mais novo: " + carroRenaultMaisNovo.get());
//        }

        //if (!carrosFiltro.isEmpty())
//        if (carrosFiltro.size() > 0) {
//            System.out.println("Carro mais novo: " + carrosFiltro.get(0));
//        }


    }

    static List<Carro> filtrarCarros(List<Carro> carros, Predicate<Carro> filtro) {
        return carros.stream()
                .filter(filtro)
                .sorted((Carro o1, Carro o2) -> o2.fabricacao().compareTo(o1.fabricacao()))
                .toList();
    }

}
