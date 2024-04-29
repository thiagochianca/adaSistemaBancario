package br.gov.caixa.projetoProfessor.exceptions;

public class TipoClienteInvalidoException extends RuntimeException {

    public TipoClienteInvalidoException() {
        super("Tipo de Cliente é Invalido!");
    }

}
