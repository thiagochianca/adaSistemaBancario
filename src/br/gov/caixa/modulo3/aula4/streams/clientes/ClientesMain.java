package br.gov.caixa.modulo3.aula4.streams.clientes;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClientesMain {

    public static void main(String[] args) {

        List<Cliente> clientes = List.of(
                new Cliente("Cliente 1", LocalDate.of(1990, 1, 1), BigDecimal.valueOf(4000)),
                new Cliente("Cliente 2", LocalDate.of(1980, 10, 1), BigDecimal.valueOf(6000)),
                new Cliente("Cliente 3", LocalDate.of(1991, 1, 1), BigDecimal.valueOf(2000)),
                new Cliente("Cliente 4", LocalDate.of(1984, 6, 7), BigDecimal.valueOf(8000))
        );

        List<Cliente> clienteRendimentoMaior4000 = getClientesComRendimentoMaior4000(clientes);
        for (Cliente cliente : clienteRendimentoMaior4000) {
            System.out.println(cliente);
        }

    }

    static List<Cliente> getClientesComRendimentoMaior4000(List<Cliente> clientes) {
        List<Cliente> clientesFiltro = new ArrayList<>();
        for (Cliente cliente : clientes) {
            if (cliente.rendimento().compareTo(BigDecimal.valueOf(4000)) > 0) {
                clientesFiltro.add(cliente);
            }
        }
        return clientesFiltro;
    }

}
