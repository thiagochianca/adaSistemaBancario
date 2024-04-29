package br.gov.caixa.modulo3.aula4.streams.farmacia;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FarmaciaMain {

    public static void main(String[] args) {

        List<Farmacia> farmacias = List.of(
                new Farmacia("ATIVO", new Representante("rep b")),
                new Farmacia("ATIVO", new Representante("rep d")),
                new Farmacia("CANCELADO", new Representante("rep a")),
                new Farmacia("ATIVO", new Representante("rep c"))
        );

        List<Representante> representantes = farmacias.stream()
                .filter(new Predicate<Farmacia>() {
                    @Override
                    public boolean test(Farmacia farmacia) {
                        return "ATIVO".equals(farmacia.getStatus());
                    }
                })
                .map(new Function<Farmacia, Representante>() {
                    @Override
                    public Representante apply(Farmacia farmacia) {
                        return farmacia.getRepresentante();
                    }
                })
                .sorted(new Comparator<Representante>() {
                    @Override
                    public int compare(Representante rep1, Representante rep2) {
                        return rep1.getNome().compareTo(rep2.getNome());
                    }
                })
                .toList();
//                .forEach(new Consumer<Representante>() {
//                    @Override
//                    public void accept(Representante representante) {
//                        System.out.println(representante.getNome());
//                    }
//                });

        representantes.forEach(new Consumer<Representante>() {
                    @Override
                    public void accept(Representante representante) {
                        System.out.println(representante.getNome());
                    }
                });

//        List<Representante> representantes = new ArrayList<>();
//
//        farmacias.stream()
//                .filter(item -> item.getStatus().equals("ATIVO"))
//                .forEach(item -> {
//                    representantes.add(item.getRepresentante());
//                });

    }


    /*

     */

}
