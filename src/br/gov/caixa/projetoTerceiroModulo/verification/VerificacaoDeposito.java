package br.gov.caixa.projetoTerceiroModulo.verification;

import br.gov.caixa.projetoTerceiroModulo.model.Conta;

import java.math.BigDecimal;

public class VerificacaoDeposito implements Verificacao {
    @Override
    public boolean verificar(Conta conta, BigDecimal valor) {
       if(valor.compareTo(BigDecimal.ZERO) < 0) {
           return false;
       }
       return true;
    }
}
