package br.gov.caixa.projetoSegundoModulo.Verification;

import br.gov.caixa.projetoSegundoModulo.Model.Classificacao;
import br.gov.caixa.projetoSegundoModulo.Model.Conta;

public class VerificacaoSaque implements Verificacao {

    @Override
    public boolean verificar(Conta conta, double valor) {
        if(verificarSaldoSaque(conta,verificarClassificacao(conta,valor))) {
            return true;
        }
        return false;
    }



    public static double verificarClassificacao(Conta conta, double valor) {
        if(conta.getCliente().getClassificacao()== Classificacao.PJ) {
            return valor*1.005;
        }
        return valor;
    }

    private boolean verificarSaldoSaque(Conta conta, double valor) {
        if(conta.consultarSaldo() >= valor) {
            return true;
        }
        return false;
    }

}
