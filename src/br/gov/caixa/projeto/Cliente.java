package br.gov.caixa.projeto;


import java.util.ArrayList;
import java.util.Date;

public class Cliente {

    // *** ATRIBUTOS ***

    private String idCliente;
    private String classificacaoCliente;
    private String nomeCliente;
    private Date dataCadastroCliente;
    private boolean statusCliente;
    private static int contaContaInvestimento = 0;
    private static int contaContaPoupanca = 0;
    private ArrayList<ContaCorrente> contas = new ArrayList<>();

    // *** CONSTRUTOR ***

    public Cliente(String idCliente, String classificacaoCliente, String nomeCliente, Date dataCadastroCliente, boolean statusCliente) {
        this.idCliente = idCliente;
        this.classificacaoCliente = classificacaoCliente;
        this.nomeCliente = nomeCliente;
        this.dataCadastroCliente = dataCadastroCliente;
        this.statusCliente = statusCliente;
    }

    // *** MÉTODOS ***

    public ContaCorrente abrirContaCorrente(int idConta, double valorInicial, boolean statusConta) {
        ContaCorrente conta = new ContaCorrente(idConta, valorInicial, statusConta);
        contas.add(conta);
        associaContaCliente(conta);
        return conta;
    }
    public void associaContaCliente(ContaCorrente conta) {
        conta.contaCliente = this;

    }

    public ContaPoupanca abrirContaPoupanca(int idConta, double valorInicial, boolean statusConta) {
        if (this.contaContaPoupanca == 0 && this.classificacaoCliente == "PF") {
            ContaPoupanca conta = new ContaPoupanca(idConta,valorInicial,statusConta);
            contaContaPoupanca++;
            contas.add(conta);
            associaContaCliente(conta);
            return conta;
        }
        System.out.println("Você só pode ter uma conta poupança e ser pessoa física");
        return null;
    }

    public ContaInvestimento abrirContaInvestimento(int idConta, double valorInicial, boolean statusConta) {
        if(this.contaContaInvestimento == 0) {
            ContaInvestimento conta = new ContaInvestimento(idConta,valorInicial,statusConta);
            contaContaInvestimento++;
            contas.add(conta);
            associaContaCliente(conta);
            return conta;
        }
        System.out.println("Você só pode ter uma conta investimento");
        return null;

    }

    // *** GETTERS AND SETTERS ***

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getClassificacaoCliente() {
        return classificacaoCliente;
    }

    public void setClassificacaoCliente(String classificacaoCliente) {
        this.classificacaoCliente = classificacaoCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public Date getDataCadastroCliente() {
        return dataCadastroCliente;
    }

    public void setDataCadastroCliente(Date dataCadastroCliente) {
        this.dataCadastroCliente = dataCadastroCliente;
    }

    public boolean isStatusCliente() {
        return statusCliente;
    }

    public void setStatusCliente(boolean statusCliente) {
        this.statusCliente = statusCliente;
    }
}