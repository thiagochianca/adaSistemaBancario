package br.gov.caixa.projetoSegundoModulo.Service;

import br.gov.caixa.projetoSegundoModulo.Model.Classificacao;
import br.gov.caixa.projetoSegundoModulo.Model.Conta;
import br.gov.caixa.projetoSegundoModulo.Model.ContaInvestimento;
import br.gov.caixa.projetoSegundoModulo.Model.Historico;

import java.util.Date;

public class ServicoRendimento {

    public void gerarRendimentos(ContaInvestimento conta) {
        double valorHoje = conta.consultarSaldo();
        if (conta.getCliente().getClassificacao() == Classificacao.PF) {
            conta.setSaldo(valorHoje * 1.01);
        } else {
            conta.setSaldo(valorHoje * 1.02);
        }
        conta.getHistorico().add(gerarHistorico(conta, valorHoje));
    }

    private Historico gerarHistorico(Conta conta, double valor) {
        Historico historico = new Historico(new Date(), "Rendimento",
                valor, conta.consultarSaldo(), conta.getCliente().getId()
                , conta.getCliente().getId(), "Rendimento mensal");
        return historico;
    }
}
