package br.gov.caixa.projetoTerceiroModulo.operation;

import br.gov.caixa.projetoTerceiroModulo.factory.FabricaDeContas;
import br.gov.caixa.projetoTerceiroModulo.model.Cliente;
import br.gov.caixa.projetoTerceiroModulo.model.ClientePF;
import br.gov.caixa.projetoTerceiroModulo.model.Conta;
import br.gov.caixa.projetoTerceiroModulo.model.ContaInvestimento;
import br.gov.caixa.projetoTerceiroModulo.service.Servico;
import br.gov.caixa.projetoTerceiroModulo.service.ServicoDeposito;
import br.gov.caixa.projetoTerceiroModulo.service.ServicoSaque;

import java.math.BigDecimal;


public class Investimento {

    public void executar(Cliente cliente, BigDecimal valor) {
        Conta conta = cliente.getContaInvestimento();
        if (conta == null) {
            conta = FabricaDeContas.criarContaInvestimento(cliente);
        }
        Servico saque = new ServicoSaque();
        saque.executarOperacao(cliente.getContaCorrente(), valor);
        Servico deposito = new ServicoDeposito();
        deposito.executarOperacao(conta,valor);
    }

    public void render(ContaInvestimento conta) {
        BigDecimal taxa = conta.getCliente() instanceof ClientePF ? BigDecimal.valueOf(1.01) : BigDecimal.valueOf(1.02);
        conta.setSaldo(conta.consultarSaldo().multiply(taxa));
    }

}
