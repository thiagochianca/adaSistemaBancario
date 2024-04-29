package br.gov.caixa.modulo3.aula5;


import br.gov.caixa.modulo3.aula4.streams.clientes.Cliente;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

public class OptionalExemplo {

    public static void main(String[] args) {

        Cliente cliente =
                new Cliente(null, LocalDate.now(), BigDecimal.ONE);

        String nomeEmMaiusculo = getNomeCliente(cliente)
                //.map(nome -> nome.toUpperCase())
                .map(String::toUpperCase)
                .orElse("Cliente nao possui nome");



        System.out.println(nomeEmMaiusculo);

        //getNomeCliente(cliente)
        //        .ifPresent(nome -> System.out.println(nome.toUpperCase()));

        //Optional<String> nome = getNomeCliente(cliente);

        //if (nome.isPresent()) {
        //    System.out.println(nome.get().toUpperCase());
        //}

    }

    static Optional<String> getNomeCliente(Cliente cliente) {
        //return Optional.empty();
        return Optional.ofNullable(cliente.nome());
    }

}
