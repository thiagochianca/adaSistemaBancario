package br.gov.caixa.modulo2.ExercicioOito;

import java.util.ArrayList;
import java.util.List;

public class Solution {
}

interface ValidadorConta {
    public boolean validar(Conta conta);
}

class Conta {
    private String agencia;
    private String conta;
    private Double saldo;

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
}


class ValidadorContaAgencia implements ValidadorConta {

    @Override
    public boolean validar(Conta conta) {
        if(conta.getAgencia() != null && !conta.getConta().isEmpty()) {
            return true;
        }
        return false;
    }
}

class ValidadorSaldoPositivo implements ValidadorConta {

    @Override
    public boolean validar(Conta conta) {
        if(conta.getSaldo()>0){
            return true;
        }
        return false;
    }
}

class ValidadorSaldoMaiorIgual100 implements ValidadorConta{

    @Override
    public boolean validar(Conta conta) {
        if(conta.getSaldo()>=100){
            return true;
        }
        return false;
    }
}

class MotorRisco {

    private List<ValidadorConta> validacoes = new ArrayList<ValidadorConta>();

    public void adicionarValidador(ValidadorConta validador){
        this.validacoes.add(validador);
    }

    public boolean realizarValidacoes(Conta conta) {
        Boolean resultado = true;
        for(ValidadorConta validador : validacoes) {
            if(validador.validar(conta) == false) {
                resultado = false;
                break;
            }
        }
        return resultado;
    }
}