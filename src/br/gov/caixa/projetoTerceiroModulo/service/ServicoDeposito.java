package br.gov.caixa.projetoTerceiroModulo.service;

import br.gov.caixa.projetoTerceiroModulo.model.Conta;
import br.gov.caixa.projetoTerceiroModulo.operation.Deposito;
import br.gov.caixa.projetoTerceiroModulo.operation.Operacao;
import br.gov.caixa.projetoTerceiroModulo.verification.Verificacao;
import br.gov.caixa.projetoTerceiroModulo.verification.VerificacaoDeposito;

import java.math.BigDecimal;

public class ServicoDeposito extends Servico {

    @Override
    protected Verificacao criarVerificacao() {
        return new VerificacaoDeposito();
    }

    @Override
    protected Operacao criarOperacao() {
        return new Deposito();
    }
    @Override
    public boolean executarOperacao(Conta conta, BigDecimal valor) {
         return super.executarOperacao(conta,valor);
    }

}
