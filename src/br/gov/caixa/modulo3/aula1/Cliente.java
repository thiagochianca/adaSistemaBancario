package br.gov.caixa.modulo3.aula1;

import java.time.LocalDate;

public class Cliente {

    private final LocalDate dataNascimento;

    public Cliente(final LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

}
