package br.gov.caixa.projetoSegundoModulo.verification;



import br.gov.caixa.projetoSegundoModulo.model.Conta;
import br.gov.caixa.projetoSegundoModulo.factory.FabricaDeContas;

import java.math.BigDecimal;

public class VerificacaoInvestimento implements Verificacao{

    @Override
    public boolean verificar(Conta conta, BigDecimal valor) {
        if(verificarExistenciaContaInvestimento(conta) && verificarSaldo(conta,valor)) {
            return true;
        }
       return false;
    }
    private boolean verificarExistenciaContaInvestimento(Conta conta) {
        if (conta.getCliente().getContaInvestimento() == null) {
            FabricaDeContas.criarContaInvestimento(conta.getCliente());
            return true;
        } else {
            return true;
        }
    }
    private boolean verificarSaldo(Conta conta, BigDecimal valor) {
        if(valor.compareTo(conta.consultarSaldo()) > 0) {
            return false;
        }
        return true;
    }
}

