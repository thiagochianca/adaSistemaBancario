package br.gov.caixa.projeto;

import java.util.Date;

public class Historico {
    private Date dataHistorico;
    private String tipo;
    private double valorPretendido;
    private double valorReal;
    private String contaOrigem;
    private String contaDestino;
    private String observacao;

    public Historico(Date dataHistorico, String tipo, double valorPretendido, double valorReal,
                     String contaOrigem, String contaDestino, String observacao) {

        this.dataHistorico = dataHistorico;
        this.tipo = tipo;
        this.valorPretendido = valorPretendido;
        this.valorReal = valorReal;
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
        this.observacao = observacao;
    }
}
