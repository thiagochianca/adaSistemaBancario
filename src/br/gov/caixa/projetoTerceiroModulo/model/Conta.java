package br.gov.caixa.projetoTerceiroModulo.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class Conta {
    private Integer id;
    private BigDecimal saldo;
    private LocalDate dataAtualizacao;
    private Status status;
    private Cliente cliente;
    private static int proximoIdConta = 1;

    public Conta(Cliente cliente) {
        this.id = proximoIdConta;
        this.saldo = BigDecimal.ZERO;
        this.dataAtualizacao = LocalDate.now();
        this.status = Status.ATIVADO;
        this.cliente = cliente;
        proximoIdConta++;
    }

    public Integer getId() {
        return id;
    }

    public BigDecimal consultarSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public LocalDate getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDate dataAtualizacao) {
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

}
