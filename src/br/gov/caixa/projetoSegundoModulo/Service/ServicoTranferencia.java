package br.gov.caixa.projetoSegundoModulo.Service;

import br.gov.caixa.projetoSegundoModulo.Model.Conta;
import br.gov.caixa.projetoSegundoModulo.Operation.Operacao;
import br.gov.caixa.projetoSegundoModulo.Operation.Transferencia;
import br.gov.caixa.projetoSegundoModulo.Verification.Verificacao;
import br.gov.caixa.projetoSegundoModulo.Verification.VerificacaoTransferencia;

public class ServicoTranferencia extends Servico {
    private Conta contaDestino;

    public ServicoTranferencia(Conta contaDestino) {
        this.contaDestino = contaDestino;
    }

    @Override
    protected Verificacao criarVerificacao() {
        return new VerificacaoTransferencia(contaDestino);
    }

    @Override
    protected Operacao criarOperacao() {
        return new Transferencia(contaDestino);
    }

    @Override
    public boolean executarOperacao(Conta conta, double valor) {
        return super.executarOperacao(conta, valor);
    }

    }

