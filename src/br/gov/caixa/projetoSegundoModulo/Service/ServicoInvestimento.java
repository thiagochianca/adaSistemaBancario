package br.gov.caixa.projetoSegundoModulo.Service;


import br.gov.caixa.projetoSegundoModulo.Model.Conta;
import br.gov.caixa.projetoSegundoModulo.Operation.Investimento;
import br.gov.caixa.projetoSegundoModulo.Operation.Operacao;
import br.gov.caixa.projetoSegundoModulo.Verification.Verificacao;
import br.gov.caixa.projetoSegundoModulo.Verification.VerificacaoInvestimento;




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
    public boolean executarOperacao(Conta conta, double valor) {
        return super.executarOperacao(conta,valor);
    }

}

