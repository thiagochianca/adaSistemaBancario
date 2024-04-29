package br.gov.caixa.projetoSegundoModulo.service;

import br.gov.caixa.projetoSegundoModulo.model.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ServicoRendimento {

    public void gerarRendimentos(ContaInvestimento conta) {
        BigDecimal valorHoje = conta.consultarSaldo();
        if (conta.getCliente() instanceof ClientePF) {
            conta.setSaldo(valorHoje.multiply(BigDecimal.valueOf(1.01)));
        } else {
            conta.setSaldo(valorHoje.multiply(BigDecimal.valueOf(1.02)));
        }
        conta.getHistorico().add(gerarHistorico(conta, valorHoje));
    }

    private Historico gerarHistorico(Conta conta, BigDecimal valor) {
        Historico historico = new Historico("Rendimento",
                valor, conta.consultarSaldo(), conta.getCliente().getId()
                , conta.getCliente().getId(), "Rendimento mensal");
        return historico;
    }
}
