package br.gov.caixa.projetoSegundoModulo.Model;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Conta {
    protected int id;
    protected double saldo;
    protected Date dataAtualizacao;
    protected Status status;
    protected Cliente cliente;
    protected List<Historico> historico = new ArrayList<>();
    private static int proximoIdConta = 1;

    public Conta(int id, double saldo, Date data, Status status, Cliente cliente) {
        this.id = id;
        this.saldo = saldo;
        this.dataAtualizacao = data;
        this.status = status;
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double consultarSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Historico> getHistorico() {
        return historico;
    }

    public void setHistorico(List<Historico> historico) {
        this.historico = historico;
    }

    public static int getProximoIdConta() {
        return proximoIdConta++;
    }
}
