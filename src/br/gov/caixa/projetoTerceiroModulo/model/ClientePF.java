package br.gov.caixa.projetoTerceiroModulo.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ClientePF extends Cliente {
    private String cpf;
    private BigDecimal taxaSaque;
    public ClientePF(String cpf, String nome) {
        super(nome);
        this.cpf = cpf;
    }

    public String getId() {
        return cpf;
    }

}
