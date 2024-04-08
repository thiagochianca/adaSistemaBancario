package br.gov.caixa.projetoSegundoModulo.Operation;

import br.gov.caixa.projetoSegundoModulo.Model.Conta;
import br.gov.caixa.projetoSegundoModulo.Model.Historico;
import br.gov.caixa.projetoSegundoModulo.Verification.VerificacaoSaque;

import java.util.Date;

public class Saque implements Operacao {

    @Override
    public void executar(Conta conta, double valor) {
        conta.setSaldo(conta.consultarSaldo() - VerificacaoSaque.verificarClassificacao(conta, valor));
        conta.getHistorico().add(gerarHistorico(conta, valor));
    }

    @Override
    public Historico gerarHistorico(Conta conta, double valor) {
        Historico historico = new Historico(new Date(), "Saque",
                valor, conta.consultarSaldo(), conta.getCliente().getId()
                , "0", "");
        return historico;
    }
}
