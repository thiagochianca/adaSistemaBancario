package br.gov.caixa.projetoPrimeiroModulo;


import java.util.ArrayList;
import java.util.Date;

public class Cliente {

    // *** ATRIBUTOS ***

    private String id;
    private String classificacao;
    private String nome;
    private Date dataCadastro;
    private boolean status;
    private static int contaInvestimento = 0;
    private static int contaPoupanca = 0;
    private ArrayList<ContaCorrente> contas = new ArrayList<>();

    // *** CONSTRUTOR ***

    public Cliente(String id, String classificacao, String nome, Date dataCadastro, boolean status) {
        this.id = id;
        this.classificacao = classificacao;
        this.nome = nome;
        this.dataCadastro = dataCadastro;
        this.status = status;
    }

    // *** MÉTODOS ***

    public ContaCorrente abrirContaCorrente(int id, double valorInicial, boolean status) {
        ContaCorrente conta = new ContaCorrente(id, valorInicial, status);
        contas.add(conta);
        associaContaCliente(conta);
        return conta;
    }
    public void associaContaCliente(ContaCorrente conta) {
        conta.contaCliente = this;

    }

    public ContaPoupanca abrirContaPoupanca(int id, double valorInicial, boolean status) {
        if (this.contaPoupanca == 0 && this.classificacao == "PF") {
            ContaPoupanca conta = new ContaPoupanca(id,valorInicial,status);
            contaPoupanca++;
            contas.add(conta);
            associaContaCliente(conta);
            return conta;
        }
        System.out.println("Você só pode ter uma conta poupança e ser pessoa física");
        return null;
    }

    public ContaInvestimento abrirContaInvestimento(int id, double valorInicial, boolean status) {
        if(this.contaInvestimento == 0) {
            ContaInvestimento conta = new ContaInvestimento(id,valorInicial,status);
            contaInvestimento++;
            contas.add(conta);
            associaContaCliente(conta);
            return conta;
        }
        System.out.println("Você só pode ter uma conta investimento");
        return null;

    }

    // *** GETTERS AND SETTERS ***

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}