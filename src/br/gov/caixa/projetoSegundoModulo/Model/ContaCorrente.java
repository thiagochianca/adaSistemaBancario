package br.gov.caixa.projetoSegundoModulo.Model;

import java.util.Date;

public class ContaCorrente extends Conta {
    public ContaCorrente(int id, double saldo, Date data, Status status, Cliente cliente) {
        super(id, saldo, data, status, cliente);
    }

}
