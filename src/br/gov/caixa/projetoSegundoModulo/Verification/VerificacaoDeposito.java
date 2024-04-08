package br.gov.caixa.projetoSegundoModulo.Verification;

import br.gov.caixa.projetoSegundoModulo.Model.Conta;

public class VerificacaoDeposito implements Verificacao{
    @Override
    public boolean verificar(Conta conta, double valor) {
        if(valor <= 0) {
            return false;
        }
        return true;
    }
}
