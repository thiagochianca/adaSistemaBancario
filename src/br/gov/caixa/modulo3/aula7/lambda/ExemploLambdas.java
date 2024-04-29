package br.gov.caixa.modulo3.aula7.lambda;



import br.gov.caixa.modulo3.aula4.streams.clientes.Cliente;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.function.Function;
import java.util.function.Predicate;

public class ExemploLambdas {

    public static void main(String[] args) {

        Predicate<Cliente> filtroClientesRendimentoMaior4000 = new Predicate<Cliente>() {
            @Override
            public boolean test(Cliente cliente) {
                return cliente.rendimento().compareTo(BigDecimal.valueOf(4000)) > 0;
            }
        };

        Predicate<Cliente> filtroClientesRendimentoMaior4000_2 = (cliente) -> {
            return false;
        };

        Function<Cliente, String> nomeClienteMaiusculo = (cliente) -> {
            return cliente.nome().toUpperCase();
        };

        Function<Cliente, String> nomeClienteMaiusculo_2 = cliente -> cliente.nome().toUpperCase();

        Cliente cliente = new Cliente("cliente 1", LocalDate.now(), BigDecimal.ZERO);
        String nomeCliente = nomeClienteMaiusculo.apply(cliente);

        MinhaInterfaceFuncional textoMinusculo = text -> text.toLowerCase();
        String textTransformado = textoMinusculo.aplicar("Esse é UM TEXTO em Minusculo");
        System.out.println(textTransformado);

        MinhaInterfaceConsumidora imprimirTexto = (text) -> System.out.println(text);

        imprimirTexto.executar("vai imprimir esse texto");

        String textoMaiusculo = transformaString(t -> t.toUpperCase(), "xxxxxxxxx cccc");
        System.out.println(textoMaiusculo);

        consumirString(System.out::println, "texto para imprimir");

    }

    static void consumirString(MinhaInterfaceConsumidora minhaInterfaceConsumidora, String text) {
        minhaInterfaceConsumidora.executar(text);
    }

    static String transformaString(MinhaInterfaceFuncional minhaInterfaceFuncional, String text) {
        return minhaInterfaceFuncional.aplicar(text);
    }

}
