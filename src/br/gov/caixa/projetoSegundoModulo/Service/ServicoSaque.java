package br.gov.caixa.projetoSegundoModulo.Service;

import br.gov.caixa.projetoSegundoModulo.Model.Conta;
import br.gov.caixa.projetoSegundoModulo.Operation.Operacao;
import br.gov.caixa.projetoSegundoModulo.Operation.Saque;
import br.gov.caixa.projetoSegundoModulo.Verification.Verificacao;
import br.gov.caixa.projetoSegundoModulo.Verification.VerificacaoSaque;

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
    public boolean executarOperacao(Conta conta, double valor) {
        return super.executarOperacao(conta, valor);
    }

}
