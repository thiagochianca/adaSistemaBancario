package br.gov.caixa.projetoSegundoModulo.verification;

import br.gov.caixa.projetoSegundoModulo.model.Conta;

import java.math.BigDecimal;

public class VerificacaoDeposito implements Verificacao{
    @Override
    public boolean verificar(Conta conta, BigDecimal valor) {
       if(valor.compareTo(BigDecimal.ZERO) < 0) {
           return false;
       }
       return true;
    }
}
