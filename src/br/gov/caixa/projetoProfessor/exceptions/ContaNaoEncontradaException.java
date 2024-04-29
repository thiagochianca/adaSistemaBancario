package br.gov.caixa.projetoProfessor.exceptions;

public class ContaNaoEncontradaException extends RuntimeException {

    public ContaNaoEncontradaException() {
        super("Conta não encontrada!");
    }

}
