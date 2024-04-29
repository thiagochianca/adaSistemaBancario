package br.gov.caixa.projetoSegundoModulo.operation;

import br.gov.caixa.projetoSegundoModulo.model.Conta;
import br.gov.caixa.projetoSegundoModulo.model.Historico;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Deposito implements Operacao {

    @Override
    public void executar(Conta conta, BigDecimal valor) {
        conta.setSaldo(conta.consultarSaldo().add(valor));
        conta.getHistorico().add(gerarHistorico(conta, valor));
    }

    @Override
    public Historico gerarHistorico(Conta conta, BigDecimal valor) {
        Historico historico = new Historico(this.getClass().getSimpleName(),
                valor, conta.consultarSaldo(), "0"
                , conta.getCliente().getId(), "");
        return historico;
    }
}
