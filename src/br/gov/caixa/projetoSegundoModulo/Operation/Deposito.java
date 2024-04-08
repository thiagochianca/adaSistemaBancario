package br.gov.caixa.projetoSegundoModulo.Operation;

import br.gov.caixa.projetoSegundoModulo.Model.Conta;
import br.gov.caixa.projetoSegundoModulo.Model.Historico;

import java.util.Date;

public class Deposito implements Operacao {

    @Override
    public void executar(Conta conta, double valor) {
        conta.setSaldo(conta.consultarSaldo() + valor);
        conta.getHistorico().add(gerarHistorico(conta, valor));
    }

    @Override
    public Historico gerarHistorico(Conta conta, double valor) {
        Historico historico = new Historico(new Date(), "Deposito",
                valor, conta.consultarSaldo(), "0"
                , conta.getCliente().getId(), "");
        return historico;
    }
}
