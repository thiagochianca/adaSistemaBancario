package br.gov.caixa.modulo3.aula4.streams.clientes;

import java.math.BigDecimal;
import java.time.LocalDate;

public record Cliente(String nome, LocalDate dataNascimento, BigDecimal rendimento) {

}
