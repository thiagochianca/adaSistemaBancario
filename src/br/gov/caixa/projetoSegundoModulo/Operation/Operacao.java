package br.gov.caixa.projetoSegundoModulo.Operation;

import br.gov.caixa.projetoSegundoModulo.Model.Conta;
import br.gov.caixa.projetoSegundoModulo.Model.Historico;

public interface Operacao {
    public abstract void executar(Conta conta, double valor);
    public abstract Historico gerarHistorico(Conta conta, double valor);
}
