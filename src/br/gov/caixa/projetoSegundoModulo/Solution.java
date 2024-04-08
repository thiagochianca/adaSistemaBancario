package br.gov.caixa.projetoSegundoModulo;

import br.gov.caixa.projetoSegundoModulo.Model.*;
import br.gov.caixa.projetoSegundoModulo.Service.*;

import java.util.Date;

public class Solution {
    public static void main(String[] args) {

        Cliente cliente1 = new Cliente("1", Classificacao.PF,"Thiago Elias Chianca", new Date(), Status.ATIVADO);

        Cliente cliente2 = new Cliente("2", Classificacao.PF,"Joao da Silva", new Date(), Status.ATIVADO);
        Conta conta1 = cliente1.getContaCorrente();
        Conta conta2 = cliente2.getContaCorrente();

        System.out.printf("Saldo atual: R$%.2f \n", conta1.consultarSaldo());

        System.out.println("----------------------------------------");

        System.out.println("Depositando 300 reais...........");
        Servico service1 = new ServicoDeposito();
        if (service1.executarOperacao(conta1,300)) {
            System.out.printf("Deposito realizado! Novo Saldo: R$%.2f \n", conta1.consultarSaldo());
        }
        System.out.println("----------------------------------------");


        System.out.println("Sacando 30 reais...........");
        Servico service2 = new ServicoSaque();
        if(service2.executarOperacao(conta1,30)) {
            System.out.printf("Saque realizado! Novo Saldo: R$%.2f \n", conta1.consultarSaldo());
        } else {
            System.out.println("Saque não realizado!");
        }
        System.out.println("----------------------------------------");


        System.out.printf("Saldo Conta1: R$%.2f \n", conta1.consultarSaldo());
        System.out.printf("Saldo Conta2: R$%.2f \n", conta2.consultarSaldo());


        System.out.println("----------------------------------------");

        Servico service3 = new ServicoTranferencia(conta2);
        if(service3.executarOperacao(conta1,100)) {
            System.out.println("Testando transferencia.");
            System.out.printf("Saldo Conta1: R$%.2f \n", conta1.consultarSaldo());
            System.out.printf("Saldo Conta2: R$%.2f \n", conta2.consultarSaldo());
        }


        Servico servico1 = new ServicoDeposito();
        servico1.executarOperacao(cliente1.getContaCorrente(),5000);
        ServicoInvestimento servico4 = new ServicoInvestimento();
        servico4.executarOperacao(cliente1.getContaCorrente(),1000);

        System.out.println(cliente1.getContaCorrente().consultarSaldo());
        System.out.println(cliente1.getContaInvestimento().consultarSaldo());
        ServicoRendimento rendimento = new ServicoRendimento();
        rendimento.gerarRendimentos(cliente1.getContaInvestimento());
        System.out.println(cliente1.getContaInvestimento().consultarSaldo());

        ListagemHistorico.listar(cliente1.getContaCorrente());
        ListagemHistorico.listar(cliente1.getContaInvestimento());
        ListagemHistorico.listar(conta2);


    }
}
