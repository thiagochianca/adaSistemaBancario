package br.gov.caixa.projetoSegundoModulo.Model;

import java.util.Date;


public class ContaInvestimento extends Conta {

    public ContaInvestimento(int id, double saldo, Date data, Status status, Cliente cliente) {
        super(id, saldo, data, status, cliente);
    }


}
