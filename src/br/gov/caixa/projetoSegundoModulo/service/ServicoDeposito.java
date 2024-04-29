package br.gov.caixa.projetoSegundoModulo.service;

import br.gov.caixa.projetoSegundoModulo.model.Conta;
import br.gov.caixa.projetoSegundoModulo.operation.Deposito;
import br.gov.caixa.projetoSegundoModulo.operation.Operacao;
import br.gov.caixa.projetoSegundoModulo.verification.Verificacao;
import br.gov.caixa.projetoSegundoModulo.verification.VerificacaoDeposito;

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
