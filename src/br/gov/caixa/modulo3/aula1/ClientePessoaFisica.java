package br.gov.caixa.modulo3.aula1;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Comparator;

public class ClientePessoaFisica extends Cliente {

    private String cpf;

    public ClientePessoaFisica(LocalDate dataNascimento) {
        super(dataNascimento);
    }

    public String getCpf() {
        return cpf;
    }

}
