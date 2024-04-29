package br.gov.caixa.projetoTerceiroModulo.operation;

import br.gov.caixa.projetoTerceiroModulo.model.Conta;
import br.gov.caixa.projetoTerceiroModulo.verification.VerificacaoSaque;

import java.math.BigDecimal;

public class Saque implements Operacao {

    @Override
    public void executar(Conta conta, BigDecimal valor) {
        conta.setSaldo(conta.consultarSaldo().subtract(valor));
    }

}
