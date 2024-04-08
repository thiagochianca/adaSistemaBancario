package br.gov.caixa.projetoSegundoModulo.Service;

import br.gov.caixa.projetoSegundoModulo.Model.Conta;
import br.gov.caixa.projetoSegundoModulo.Operation.Operacao;
import br.gov.caixa.projetoSegundoModulo.Verification.Verificacao;

public abstract class Servico {
    protected abstract Verificacao criarVerificacao();
    protected abstract Operacao criarOperacao();
    public boolean executarOperacao(Conta conta, double valor) {
        Verificacao verificacao = criarVerificacao();
        Operacao operacao = criarOperacao();
        if (verificacao.verificar(conta, valor)) {
            operacao.executar(conta, valor);
            return true;
        }
        return false;
    }
}
