package br.gov.caixa.projetoSegundoModulo.Verification;

import br.gov.caixa.projetoSegundoModulo.Model.Conta;

public interface Verificacao {
    public boolean verificar(Conta conta, double valor);
}
