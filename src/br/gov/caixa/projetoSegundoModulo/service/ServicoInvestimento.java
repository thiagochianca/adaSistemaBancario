package br.gov.caixa.projetoSegundoModulo.service;


import br.gov.caixa.projetoSegundoModulo.model.Conta;
import br.gov.caixa.projetoSegundoModulo.operation.Investimento;
import br.gov.caixa.projetoSegundoModulo.operation.Operacao;
import br.gov.caixa.projetoSegundoModulo.verification.Verificacao;
import br.gov.caixa.projetoSegundoModulo.verification.VerificacaoInvestimento;

import java.math.BigDecimal;


public class ServicoInvestimento extends Servico {

    @Override
    protected Verificacao criarVerificacao() {
        return new VerificacaoInvestimento();
    }

    @Override
    protected Operacao criarOperacao() {
        return new Investimento();
    }

    @Override
    public boolean executarOperacao(Conta conta, BigDecimal valor) {
        return super.executarOperacao(conta,valor);
    }

}

