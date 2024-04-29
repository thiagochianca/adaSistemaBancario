package br.gov.caixa.projetoSegundoModulo.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Historico {
    private LocalDate dataOperacao;
    private String tipo;
    private BigDecimal valorPretendido;
    private BigDecimal valorReal;
    private String clienteOrigem;
    private String clienteDestino;
    private String observacao;

    public Historico(String tipo, BigDecimal valorPretendido, BigDecimal valorReal, String clienteOrigem, String clienteDestino, String observacao) {
        this.dataOperacao = LocalDate.now();
        this.tipo = tipo;
        this.valorPretendido = valorPretendido;
        this.valorReal = valorReal;
        this.clienteOrigem = clienteOrigem;
        this.clienteDestino = clienteDestino;
        this.observacao = observacao;
    }

    public LocalDate getDataOperacao() {
        return dataOperacao;
    }

    public String getTipo() {
        return tipo;
    }

    public BigDecimal getValorPretendido() {
        return valorPretendido;
    }

    public BigDecimal getValorReal() {
        return valorReal;
    }

    public String getClienteOrigem() {
        return clienteOrigem;
    }

    public String getClienteDestino() {
        return clienteDestino;
    }

    public String getObservacao() {
        return observacao;
    }

}
