package br.gov.caixa.projetoTerceiroModulo.model;

import br.gov.caixa.projetoTerceiroModulo.factory.FabricaDeContas;

import java.time.LocalDate;

public abstract class Cliente {

    private String nome;
    private LocalDate dataCadastro;
    private Status status;

    private ContaCorrente contaCorrente;
    private ContaInvestimento contaInvestimento;
    private ContaPoupanca contaPoupanca;

    public Cliente(String nome) {
        this.nome = nome;
        this.dataCadastro = LocalDate.now();
        this.status = Status.ATIVADO;
        this.contaCorrente = FabricaDeContas.criarContaCorrente(this);
    }

    public abstract String getId();

    public String getNome() {
        return nome;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Conta getContaCorrente() {
        return contaCorrente;
    }

    public ContaInvestimento getContaInvestimento() {
        return contaInvestimento;
    }

    public void setContaInvestimento(ContaInvestimento contaInvestimento) {
        this.contaInvestimento = contaInvestimento;
    }

    public ContaPoupanca getContaPoupanca() {
        return contaPoupanca;
    }

    public void setContaPoupanca(ContaPoupanca contaPoupanca) {
        this.contaPoupanca = contaPoupanca;
    }

}
