package br.gov.caixa.projetoSegundoModulo.verification;

import br.gov.caixa.projetoSegundoModulo.model.Conta;

import java.math.BigDecimal;

public class VerificacaoTransferencia implements Verificacao{
    private Conta contaDestino;

    public VerificacaoTransferencia(Conta contaDestino) {
        this.contaDestino = contaDestino;
    }
    @Override
    public boolean verificar(Conta conta, BigDecimal valor) {
        Verificacao verificacao1 = new VerificacaoSaque();
        boolean verificaSaldo = verificacao1.verificar(conta,valor);
        boolean verificaExistenciaConta = verificarExistenciaConta(contaDestino);
        return verificaSaldo && verificaExistenciaConta;
    }

    private static boolean verificarExistenciaConta(Conta conta) {
        if(conta != null) {
            return true;
        }
        return false;
    }
}


