package br.gov.caixa.projeto;

public class ContaPoupanca extends ContaCorrente {

    // *** CONSTRUTOR ***

    public ContaPoupanca(int idConta, double saldoConta, boolean statusConta) {
        super(idConta, saldoConta, statusConta);
    }

    // *** MÉTODOS ***

    public boolean geraRendimentoPoupanca() {
        if (this.contaCliente.getClassificacaoCliente()=="PF") {
            this.saldoConta *= 1.01;
            return true;
        }

        return false;
    }
}
