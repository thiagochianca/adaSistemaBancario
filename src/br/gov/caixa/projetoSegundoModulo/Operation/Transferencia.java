package br.gov.caixa.projetoSegundoModulo.Operation;

import br.gov.caixa.projetoSegundoModulo.Model.Conta;
import br.gov.caixa.projetoSegundoModulo.Model.Historico;

import java.util.Date;

public class Transferencia implements Operacao {
    private Conta contaDestino;

    public Transferencia(Conta contaDestino) {
        this.contaDestino = contaDestino;
    }

    @Override
    public void executar(Conta conta, double valor) {
        Saque saque = new Saque();
        Deposito deposito = new Deposito();
        saque.executar(conta,valor);
        deposito.executar(contaDestino,valor);
        conta.getHistorico().add(gerarHistorico(conta,valor));
        contaDestino.getHistorico().add(gerarHistorico(conta,valor));
    }

    @Override
    public Historico gerarHistorico(Conta conta, double valor) {
        Historico historico = new Historico(new Date(), "Transferencia",
                valor, conta.consultarSaldo(), conta.getCliente().getId()
                , contaDestino.getCliente().getId(), "Desconsiderar valores, realizada pela operação anterior" );
        return historico;
    }
}
