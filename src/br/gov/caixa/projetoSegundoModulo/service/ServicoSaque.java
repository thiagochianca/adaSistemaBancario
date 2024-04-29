package br.gov.caixa.projetoSegundoModulo.service;

import br.gov.caixa.projetoSegundoModulo.model.Conta;
import br.gov.caixa.projetoSegundoModulo.operation.Operacao;
import br.gov.caixa.projetoSegundoModulo.operation.Saque;
import br.gov.caixa.projetoSegundoModulo.verification.Verificacao;
import br.gov.caixa.projetoSegundoModulo.verification.VerificacaoSaque;

import java.math.BigDecimal;

public class ServicoSaque extends Servico {

    @Override
    protected Verificacao criarVerificacao() {
        return new VerificacaoSaque();
    }

    @Override
    protected Operacao criarOperacao() {
        return new Saque();
    }

    @Override
    public boolean executarOperacao(Conta conta, BigDecimal valor) {
        return super.executarOperacao(conta, valor);
    }

}
