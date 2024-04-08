package br.gov.caixa.projetoSegundoModulo.Verification;

import br.gov.caixa.projetoSegundoModulo.Model.Conta;

public class VerificacaoTransferencia implements Verificacao{
    private Conta contaDestino;

    public VerificacaoTransferencia(Conta contaDestino) {
        this.contaDestino = contaDestino;
    }
    @Override
    public boolean verificar(Conta conta, double valor) {
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


