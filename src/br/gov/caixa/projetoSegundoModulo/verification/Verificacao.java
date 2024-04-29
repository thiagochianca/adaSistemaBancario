package br.gov.caixa.projetoSegundoModulo.verification;

import br.gov.caixa.projetoSegundoModulo.model.Conta;

import java.math.BigDecimal;

public interface Verificacao {
    public boolean verificar(Conta conta, BigDecimal valor);
}
