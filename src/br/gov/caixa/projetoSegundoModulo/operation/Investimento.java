package br.gov.caixa.projetoSegundoModulo.operation;

import br.gov.caixa.projetoSegundoModulo.model.Conta;
import br.gov.caixa.projetoSegundoModulo.model.ContaInvestimento;
import br.gov.caixa.projetoSegundoModulo.model.Historico;

import java.math.BigDecimal;
import java.time.LocalDate;


public class Investimento implements Operacao{

    @Override
    public void executar(Conta conta, BigDecimal valor) {
        conta.setSaldo(conta.consultarSaldo().subtract(valor));
        ContaInvestimento conta2 = conta.getCliente().getContaInvestimento();
        conta2.setSaldo(conta2.consultarSaldo().add(valor));
        conta.getHistorico().add(gerarHistorico(conta, valor));
        conta.getHistorico().add(gerarHistorico(conta2, valor));
    }

    @Override
    public Historico gerarHistorico(Conta conta, BigDecimal valor) {
        Historico historico = new Historico(this.getClass().getSimpleName(),
                valor, conta.consultarSaldo(), conta.getCliente().getId()
                , conta.getCliente().getId(), "");
        return historico;
    }

}
