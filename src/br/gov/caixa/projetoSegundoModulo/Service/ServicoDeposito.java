package br.gov.caixa.projetoSegundoModulo.Service;

import br.gov.caixa.projetoSegundoModulo.Model.Conta;
import br.gov.caixa.projetoSegundoModulo.Operation.Deposito;
import br.gov.caixa.projetoSegundoModulo.Operation.Operacao;
import br.gov.caixa.projetoSegundoModulo.Verification.Verificacao;
import br.gov.caixa.projetoSegundoModulo.Verification.VerificacaoDeposito;

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
    public boolean executarOperacao(Conta conta, double valor) {
         return super.executarOperacao(conta,valor);
    }

}
