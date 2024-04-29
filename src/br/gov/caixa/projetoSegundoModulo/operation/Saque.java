package br.gov.caixa.projetoSegundoModulo.operation;

import br.gov.caixa.projetoSegundoModulo.model.Conta;
import br.gov.caixa.projetoSegundoModulo.model.Historico;
import br.gov.caixa.projetoSegundoModulo.verification.VerificacaoSaque;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Saque implements Operacao {

    @Override
    public void executar(Conta conta, BigDecimal valor) {
        conta.setSaldo(conta.consultarSaldo().subtract(VerificacaoSaque.verificarClassificacao(conta, valor)));
        conta.getHistorico().add(gerarHistorico(conta, valor));
    }

    @Override
    public Historico gerarHistorico(Conta conta, BigDecimal valor) {
        Historico historico = new Historico(this.getClass().getSimpleName(),
                valor, conta.consultarSaldo(), conta.getCliente().getId()
                , "0", "");
        return historico;
    }
}
