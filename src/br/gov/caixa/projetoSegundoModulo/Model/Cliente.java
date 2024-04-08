package br.gov.caixa.projetoSegundoModulo.Model;

import br.gov.caixa.projetoSegundoModulo.Factory.FabricaDeContas;

import java.util.Date;

public class Cliente {

    private String id;
    private Classificacao classificacao;
    private String nome;
    private Date dataCadastro;
    private Status status;
    private ContaCorrente contaCorrente;
    private ContaInvestimento contaInvestimento;
    private ContaPoupanca contaPoupanca;

    public Cliente(String id, Classificacao classificacao, String nome, Date dataCadastro, Status status) {
        this.id = id;
        this.classificacao = classificacao;
        this.nome = nome;
        this.dataCadastro = dataCadastro;
        this.status = status;
        this.contaCorrente = FabricaDeContas.criarContaCorrente(this);
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Classificacao getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(Classificacao classificacao) {
        this.classificacao = classificacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
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

    public void setContaCorrente(ContaCorrente contaCorrente) {
        this.contaCorrente = contaCorrente;
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
