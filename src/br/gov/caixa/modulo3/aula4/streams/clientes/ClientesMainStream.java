package br.gov.caixa.modulo3.aula4.streams.clientes;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ClientesMainStream {

    public static void main(String[] args) {

        List<Cliente> clientes = List.of(
                new Cliente("Cliente 1", LocalDate.of(1990, 1, 1), BigDecimal.valueOf(4000)),
                new Cliente("Cliente 2", LocalDate.of(1980, 10, 1), BigDecimal.valueOf(6000)),
                new Cliente("Cliente 3", LocalDate.of(1991, 1, 1), BigDecimal.valueOf(2000)),
                new Cliente("Cliente 4", LocalDate.of(2000, 6, 7), BigDecimal.valueOf(8000))
        );

        Predicate<Cliente> filtroClientesRendimentoMaior4000 = new Predicate<Cliente>() {
            @Override
            public boolean test(Cliente cliente) {
                return cliente.rendimento().compareTo(BigDecimal.valueOf(4000)) > 0;
            }
        };

        Predicate<Cliente> filtroClientesMenores30Anos = new Predicate<Cliente>() {
            @Override
            public boolean test(Cliente cliente) {
                return ChronoUnit.YEARS.between(cliente.dataNascimento(), LocalDate.now()) <= 30;
            }
        };

        Predicate<Cliente> filtroClientesMenores30Anosv2 =
                (cliente) -> {
                    return ChronoUnit.YEARS.between(cliente.dataNascimento(), LocalDate.now()) <= 30;
                };

        List<Cliente> clienteFiltros = filtrarClientes(
                clientes,
                (cliente) -> ChronoUnit.YEARS.between(cliente.dataNascimento(), LocalDate.now()) <= 30
        );
        for (Cliente cliente : clienteFiltros) {
            System.out.println(cliente);
        }

    }

    static List<Cliente> filtrarClientes(List<Cliente> clientes, Predicate<Cliente> filtro) {
        return clientes.stream() //fonte
                .filter(filtro) //operacao intermediaria
                //.toList()
                .collect(Collectors.toList())
                ; // operacao terminal
    }

}
