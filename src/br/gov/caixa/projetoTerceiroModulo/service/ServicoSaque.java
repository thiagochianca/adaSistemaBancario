package br.gov.caixa.projetoTerceiroModulo.service;

import br.gov.caixa.projetoTerceiroModulo.model.ClientePJ;
import br.gov.caixa.projetoTerceiroModulo.model.Conta;
import br.gov.caixa.projetoTerceiroModulo.operation.Operacao;
import br.gov.caixa.projetoTerceiroModulo.operation.Saque;
import br.gov.caixa.projetoTerceiroModulo.verification.Verificacao;
import br.gov.caixa.projetoTerceiroModulo.verification.VerificacaoSaque;

import java.math.BigDecimal;

public class ServicoSaque extends Servico {
    private static final BigDecimal TAXA_SAQUE = BigDecimal.valueOf(1.005);

    @Override
    protected Verificacao criarVerificacao() {
        return new VerificacaoSaque();
    }

    @Override
    protected Operacao criarOperacao() {
        return new Saque();
    }

    @Override
    public boolean executarOperacao(Conta conta, BigDecimal valor) {
        BigDecimal taxa = conta.getCliente() instanceof ClientePJ ? valor.multiply(TAXA_SAQUE) : BigDecimal.ZERO;
        return super.executarOperacao(conta,valor.add(taxa));
    }

}

/*

 */
