package br.gov.caixa.projetoTerceiroModulo.service;

import br.gov.caixa.projetoTerceiroModulo.model.Conta;
import br.gov.caixa.projetoTerceiroModulo.operation.Operacao;
import br.gov.caixa.projetoTerceiroModulo.verification.Verificacao;

import java.math.BigDecimal;

public abstract class Servico {
    protected abstract Verificacao criarVerificacao();
    protected abstract Operacao criarOperacao();
    public boolean executarOperacao(Conta conta, BigDecimal valor) {
        Verificacao verificacao = criarVerificacao();
        Operacao operacao = criarOperacao();
        if (verificacao.verificar(conta, valor)) {
            operacao.executar(conta, valor);
            return true;
        }
        return false;
    }
}
