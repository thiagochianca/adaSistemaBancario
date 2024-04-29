package br.gov.caixa.projetoTerceiroModulo.verification;

import br.gov.caixa.projetoTerceiroModulo.model.Conta;

import java.math.BigDecimal;

public interface Verificacao {
    public boolean verificar(Conta conta, BigDecimal valor);
}
