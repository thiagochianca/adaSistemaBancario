package br.gov.caixa.projetoSegundoModulo;

import br.gov.caixa.projetoSegundoModulo.model.*;
import br.gov.caixa.projetoSegundoModulo.service.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Solution {
    public static void main(String[] args) {

        Cliente cliente1 = new ClientePF("008.962.201-41", "Thiago Elias Chianca");

        Cliente cliente2 = new ClientePF("012.345.678-90","Joao da Silva");
        Conta conta1 = cliente1.getContaCorrente();
        Conta conta2 = cliente2.getContaCorrente();

        System.out.printf("Saldo atual: R$%.2f \n", conta1.consultarSaldo());

        System.out.println("----------------------------------------");

        System.out.println("Depositando 300 reais...........");
        Servico service1 = new ServicoDeposito();
        if (service1.executarOperacao(conta1, BigDecimal.valueOf(300.00))) {
            System.out.printf("Deposito realizado! Novo Saldo: R$%.2f \n", conta1.consultarSaldo());
        }
        System.out.println("----------------------------------------");


        System.out.println("Sacando 30 reais...........");
        Servico service2 = new ServicoSaque();
        if(service2.executarOperacao(conta1,BigDecimal.valueOf(30))) {
            System.out.printf("Saque realizado! Novo Saldo: R$%.2f \n", conta1.consultarSaldo());
        } else {
            System.out.println("Saque não realizado!");
        }
        System.out.println("----------------------------------------");


        System.out.printf("Saldo Conta1: R$%.2f \n", conta1.consultarSaldo());
        System.out.printf("Saldo Conta2: R$%.2f \n", conta2.consultarSaldo());


        System.out.println("----------------------------------------");

        Servico service3 = new ServicoTranferencia(conta2);
        if(service3.executarOperacao(conta1,BigDecimal.valueOf(100))) {
            System.out.println("Testando transferencia de 100.");
            System.out.printf("Saldo Conta1: R$%.2f \n", conta1.consultarSaldo());
            System.out.printf("Saldo Conta2: R$%.2f \n", conta2.consultarSaldo());
            System.out.println("----------------------------------------");
        }


        Servico servico1 = new ServicoDeposito();
        servico1.executarOperacao(cliente1.getContaCorrente(),BigDecimal.valueOf(5000));
        System.out.println("Depositei 5000. Saldo: " + cliente1.getContaCorrente().consultarSaldo());
        ServicoInvestimento servico4 = new ServicoInvestimento();
        servico4.executarOperacao(cliente1.getContaCorrente(),BigDecimal.valueOf(1000));
        System.out.println("Saldo após transferir 1000 para conta Investimento: " + cliente1.getContaCorrente().consultarSaldo());

        System.out.println("Saldo da Conta Investimento: " + cliente1.getContaInvestimento().consultarSaldo());


        ServicoRendimento rendimento = new ServicoRendimento();
        rendimento.gerarRendimentos(cliente1.getContaInvestimento());
        System.out.println("Saldo na conta Investimento após rendimento: " + cliente1.getContaInvestimento().consultarSaldo());

        ListagemHistorico.listar(cliente1.getContaCorrente());
        ListagemHistorico.listar(cliente1.getContaInvestimento());
        ListagemHistorico.listar(conta2);


    }
}
