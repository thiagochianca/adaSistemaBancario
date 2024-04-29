package br.gov.caixa.modulo3.aula3.callbackFunction;


import br.gov.caixa.modulo3.aula1.Cliente;

@FunctionalInterface
public interface ValidarCliente {

    boolean validar(Cliente cliente);

}
