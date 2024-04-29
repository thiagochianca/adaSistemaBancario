package br.gov.caixa.modulo3.aula3;


import br.gov.caixa.modulo3.aula1.Cliente;

public class CallbackValidarClienteEnvioEmail implements CallbackClienteFunction {

    @Override
    public void executar(Cliente cliente) {
        System.out.println("Enviar email");
    }
}
