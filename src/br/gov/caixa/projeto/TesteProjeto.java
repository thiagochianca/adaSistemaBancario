package br.gov.caixa.projeto;

import java.util.Date;

public class TesteProjeto {

    public static void main(String[] args) {


        // Cria cliente
        Cliente cliente1 =
                new Cliente("00896220141", "PF",
                        "Thiago Chianca", new Date(), true
                );

        //Cria 3 tipos de conta
        ContaCorrente contaCorrenteCliente1 = cliente1.abrirContaCorrente(1, 0, true);
        System.out.println("Conta Corrente aberta para: " + cliente1.getNomeCliente());

        ContaPoupanca poupa = cliente1.abrirContaPoupanca(2, 0, true);
        System.out.println("Conta Poupança aberta para: " + cliente1.getNomeCliente());

        ContaInvestimento bitcoin = cliente1.abrirContaInvestimento(3, 0, true);
        System.out.println("Conta Investimento aberta para: " + cliente1.getNomeCliente() + "\n");

        //Deposito CC
        System.out.println("Depositando 100 reais na conta corrente.");
        if (contaCorrenteCliente1.depositoConta(100)) {
            System.out.println("Deposito realizado com sucesso! Seu novo saldo: " + contaCorrenteCliente1.consultaSaldo() + "\n");
        }

        //Deposito CP
        System.out.println("Depositando 50 reais na conta poupança.");
        if (poupa.depositoConta(50)) {
            System.out.println("Deposito realizado com sucesso! Seu novo saldo: " + poupa.consultaSaldo() + "\n");
        }

        //Transfere CC para CP
        if (contaCorrenteCliente1.saqueParaPoupanca(poupa, 1)) {
            System.out.println("Transferindo um real entre conta corrente e poupança");
            System.out.println("Saque realizado com sucesso! Seu novo saldo em conta corrente: " + contaCorrenteCliente1.consultaSaldo());
            System.out.println("Deposito realizado com sucesso! Seu novo saldo em conta poupança: " + poupa.consultaSaldo() + "\n");
        }

        //Deposito CI
        System.out.println("Depositando 20 reais na conta investimento.");
        if (bitcoin.depositoConta(20)) {
            System.out.println("Deposito realizado com sucesso! Seu novo saldo: " + bitcoin.consultaSaldo() + "\n");
        }


        //Gerar rendimento Poupança
        System.out.println("Saldo Conta Poupança: "+ poupa.consultaSaldo());
        if (poupa.geraRendimentoPoupanca()) {
            System.out.println("Foi gerado rendimento em Conta Poupança, seu novo saldo é: " + poupa.consultaSaldo() +"\n");
        }

        //Gerar rendimento Investimento
        System.out.println("Saldo Conta Investimento: "+ bitcoin.consultaSaldo());
        if (bitcoin.geraRendimentoInvestimento()) {
            System.out.println("Foi gerado rendimento em Conta Investimento, seu novo saldo é: " + bitcoin.consultaSaldo() +"\n");
        }

        //Criar nova conta corrente para outro cliente
        Cliente cliente2 =
                new Cliente("00000000000", "PF",
                        "João da Silva", new Date(), true
                );
        ContaCorrente contaCorrenteCliente2 = cliente2.abrirContaCorrente(4, 1000, true);
        System.out.println("Conta Corrente aberta para: " + cliente2.getNomeCliente() + "\n");

        //Transferir entre contas
        System.out.println("Saldo Conta1:" +contaCorrenteCliente1.consultaSaldo());
        System.out.println("Saldo Conta2:" +contaCorrenteCliente2.consultaSaldo());
        System.out.println("Transferir 500 reais de Conta2 para Conta1");
        if(contaCorrenteCliente2.transferenciaValores(contaCorrenteCliente1,500)) {
            System.out.println("Transferência realizada com sucesso!!!!"+"\n");
        }
        System.out.println("Novo saldo Conta1:" +contaCorrenteCliente1.consultaSaldo());
        System.out.println("Novo saldo Conta2:" +contaCorrenteCliente2.consultaSaldo());



    }
}
