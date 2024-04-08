package br.gov.caixa.projetoPrimeiroModulo;

import java.util.ArrayList;
import java.util.Date;

public class ContaCorrente {

    // *** ATRIBUTOS ***

    protected int idConta;
    protected double saldoConta;
    protected ArrayList<Historico> historicoConta = new ArrayList<>();
    protected Date dataAtualizacaoConta;
    protected boolean statusConta;
    protected Cliente contaCliente;

    // *** CONSTRUTOR ***


   public ContaCorrente(int idConta, double saldoConta, boolean statusConta) {
       this.idConta = idConta;
       this.saldoConta = saldoConta;
       this.statusConta = statusConta;
   }


    // *** MÉTODOS ***

    public void criaHistorico(String tipo, double valorPretendido, double valorReal,
                              String idOrigem, String idDestino, String observacao) {
        Historico novoHistorico = new Historico(new Date(), tipo, valorPretendido, valorReal,
                idOrigem, idDestino, observacao);
        historicoConta.add(novoHistorico);
    }

    public int mostraQuantidadeHistorico() {
        return historicoConta.size();
    }

    public boolean saqueParaInvestimento(ContaInvestimento invest, double valorInvestido) {
        if (this.saldoConta >= valorInvestido) {
            this.saldoConta -= valorInvestido;
            invest.saldoConta += valorInvestido;
            return true;
        }
        return false;
    }

    public boolean saqueParaPoupanca(ContaPoupanca poupa, double valorInvestido) {
        if (this.saldoConta >= valorInvestido) {
            this.saldoConta -= valorInvestido;
            poupa.saldoConta += valorInvestido;
            return true;
        }
        return false;
    }

    public double consultaSaldo() {
        return this.saldoConta;
    }

    public boolean transferenciaValores(ContaCorrente contaDepositado, double valorTransferencia) {
        if (this.contaCliente.getClassificacao()=="PF") {
            if (valorTransferencia > 0 && this.consultaSaldo() > valorTransferencia) {
                this.saldoConta -= valorTransferencia;
                contaDepositado.saldoConta += valorTransferencia;
                criaHistorico("Transferencia", valorTransferencia, this.consultaSaldo(), this.contaCliente.getId(),
                        contaDepositado.contaCliente.getId(), "Transferencia realizada com sucesso");
                return true;
            } else {
                criaHistorico("Transferencia", valorTransferencia, this.consultaSaldo(), this.contaCliente.getId(),
                        contaDepositado.contaCliente.getId(), "Transferencia não realizada");
                return false;
            }
        } else if (this.contaCliente.getClassificacao()=="PJ") {
            if (valorTransferencia > 0 && this.consultaSaldo() > valorTransferencia) {
                double taxa = valorTransferencia*0.005;
                this.saldoConta -= (valorTransferencia+taxa);
                contaDepositado.saldoConta += valorTransferencia;
                criaHistorico("Transferencia", valorTransferencia, this.consultaSaldo(), this.contaCliente.getId(),
                        contaDepositado.contaCliente.getId(), "Transferencia realizada com sucesso");
                return true;
            } else {
                criaHistorico("Transferencia", valorTransferencia, this.consultaSaldo(), this.contaCliente.getId(),
                        contaDepositado.contaCliente.getId(), "Transferencia não realizada");
                return false;
            }
        }
        return false;
    }

    public boolean depositoConta(double valorDeposito) {
        if (valorDeposito > 0) {
            this.saldoConta += valorDeposito;
            criaHistorico("Deposito", valorDeposito, this.saldoConta, this.contaCliente.getId(), this.contaCliente.getId(), "Deposito realizado com sucesso");
            return true;
        }
        criaHistorico("Deposito", valorDeposito, this.saldoConta, this.contaCliente.getId(), this.contaCliente.getId(), "Deposito não foi realizado");
        return false;

    }

    public boolean saqueConta(double valorSaque) {
        if (this.contaCliente.getClassificacao()=="PF") {
            if (valorSaque <= this.saldoConta) {
                this.saldoConta -= valorSaque;
                criaHistorico("Saque", valorSaque, this.saldoConta, this.contaCliente.getId(), this.contaCliente.getId(), "Saque realizado com sucesso");
                return true;
            }
            criaHistorico("Saque", valorSaque, this.saldoConta, this.contaCliente.getId(), this.contaCliente.getId(), "Saque não foi realizado");
            return false;
        } else if (this.contaCliente.getClassificacao()=="PJ") {
            if (valorSaque <= this.saldoConta) {
                double taxa = valorSaque*0.005;
                this.saldoConta -= (valorSaque+taxa);
                criaHistorico("Saque", valorSaque, this.saldoConta, this.contaCliente.getId(), this.contaCliente.getId(), "Saque realizado com sucesso");
                return true;
            }
            criaHistorico("Saque", valorSaque, this.saldoConta, this.contaCliente.getId(), this.contaCliente.getId(), "Saque não foi realizado");
            return false;
        }
        return false;
    }


    // *** GETTERS AND SETTERS ***

    public int getIdConta() {
        return idConta;
    }

    public boolean isStatusConta() {
        return statusConta;
    }

    public void setStatusConta(boolean statusConta) {
        this.statusConta = statusConta;
    }
    public Cliente getContaCliente() {
        return contaCliente;
    }

    public void setContaCliente(Cliente contaCliente) {
        this.contaCliente = contaCliente;
    }

}

