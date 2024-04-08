package br.gov.caixa.projetoSegundoModulo.Operation;

import br.gov.caixa.projetoSegundoModulo.Model.Conta;
import br.gov.caixa.projetoSegundoModulo.Model.ContaInvestimento;
import br.gov.caixa.projetoSegundoModulo.Model.Historico;

import java.util.Date;


public class Investimento implements Operacao{

    @Override
    public void executar(Conta conta, double valor) {
        conta.setSaldo(conta.consultarSaldo() - valor);
        ContaInvestimento conta2 = conta.getCliente().getContaInvestimento();
        conta2.setSaldo(conta2.consultarSaldo() + valor);
        conta.getHistorico().add(gerarHistorico(conta, valor));
        conta.getHistorico().add(gerarHistorico(conta2, valor));
    }

    @Override
    public Historico gerarHistorico(Conta conta, double valor) {
        Historico historico = new Historico(new Date(), "Investimento",
                valor, conta.consultarSaldo(), conta.getCliente().getId()
                , conta.getCliente().getId(), "");
        return historico;
    }

}
