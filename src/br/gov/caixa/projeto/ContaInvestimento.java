package br.gov.caixa.projeto;

public class ContaInvestimento extends ContaCorrente {

    // *** CONSTRUTOR ***

    public ContaInvestimento(int idConta, double saldoConta, boolean statusConta) {
        super(idConta, saldoConta, statusConta);
    }

    // *** MÉTODOS ***

    public boolean geraRendimentoInvestimento() {
        if(this.contaCliente.getClassificacaoCliente()=="PF") {
            this.saldoConta += this.saldoConta*0.01;
            return true;
        } else if (this.contaCliente.getClassificacaoCliente()=="PF") {
            this.saldoConta += this.saldoConta*0.02;
            return true;
        }
        return false;
    }
}
