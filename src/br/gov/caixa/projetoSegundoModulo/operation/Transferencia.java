package br.gov.caixa.projetoSegundoModulo.operation;

import br.gov.caixa.projetoSegundoModulo.model.Conta;
import br.gov.caixa.projetoSegundoModulo.model.Historico;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Transferencia implements Operacao {
    private Conta contaDestino;

    public Transferencia(Conta contaDestino) {
        this.contaDestino = contaDestino;
    }

    @Override
    public void executar(Conta conta, BigDecimal valor) {
        Saque saque = new Saque();
        Deposito deposito = new Deposito();
        saque.executar(conta,valor);
        deposito.executar(contaDestino,valor);
        conta.getHistorico().add(gerarHistorico(conta,valor));
        contaDestino.getHistorico().add(gerarHistorico(conta,valor));
    }

    @Override
    public Historico gerarHistorico(Conta conta, BigDecimal valor) {
        Historico historico = new Historico(this.getClass().getSimpleName(),
                valor, conta.consultarSaldo(), conta.getCliente().getId()
                , contaDestino.getCliente().getId(), "Desconsiderar valores, realizada pela operação anterior" );
        return historico;
    }
}
