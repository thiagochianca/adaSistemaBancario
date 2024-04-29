package br.gov.caixa.projetoTerceiroModulo.service;

import br.gov.caixa.projetoTerceiroModulo.model.Conta;
import br.gov.caixa.projetoTerceiroModulo.operation.Operacao;
import br.gov.caixa.projetoTerceiroModulo.operation.Transferencia;
import br.gov.caixa.projetoTerceiroModulo.verification.Verificacao;
import br.gov.caixa.projetoTerceiroModulo.verification.VerificacaoTransferencia;

import java.math.BigDecimal;

public class ServicoTranferencia extends Servico {
    private Conta contaDestino;

    public ServicoTranferencia(Conta contaDestino) {
        this.contaDestino = contaDestino;
    }

    @Override
    protected Verificacao criarVerificacao() {
        return new VerificacaoTransferencia(contaDestino);
    }

    @Override
    protected Operacao criarOperacao() {
        return new Transferencia(contaDestino);
    }

    @Override
    public boolean executarOperacao(Conta conta, BigDecimal valor) {
        return super.executarOperacao(conta, valor);
    }

    }

