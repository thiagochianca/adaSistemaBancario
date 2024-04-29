package br.gov.caixa.projetoSegundoModulo.verification;

import br.gov.caixa.projetoSegundoModulo.model.ClientePJ;
import br.gov.caixa.projetoSegundoModulo.model.Conta;

import java.math.BigDecimal;

public class VerificacaoSaque implements Verificacao {

    @Override
    public boolean verificar(Conta conta, BigDecimal valor) {
        if(verificarSaldoSaque(conta,verificarClassificacao(conta,valor))) {
            return true;
        }
        return false;
    }



    public static BigDecimal verificarClassificacao(Conta conta, BigDecimal valor) {
        if(conta.getCliente() instanceof ClientePJ) {
            return valor.multiply(BigDecimal.valueOf(1.005));
        }
        return valor;
    }

    private boolean verificarSaldoSaque(Conta conta, BigDecimal valor) {
        if(valor.compareTo(conta.consultarSaldo()) > 0) {
            return false;
        }
        return true;
    }

}
