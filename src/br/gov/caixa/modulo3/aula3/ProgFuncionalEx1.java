package br.gov.caixa.modulo3.aula3;

import br.gov.caixa.modulo3.aula1.Cliente;

import java.time.LocalDate;

public class ProgFuncionalEx1 {

    public static void main(String[] args) {

        Cliente cliente = new Cliente(LocalDate.of(1990, 1,1));

        //cliente = new Cliente(LocalDate.now());

        CallbackClienteFunction callbackSalvar = new CallbackClienteFunction() {
           @Override
            public void executar(Cliente cliente) {
               System.out.println("Salvando no banco de dados.. classe anonima");
            }
        };

        CallbackClienteFunction callbackSalvarFuncional =
                /*public void executar */ (clienteValidaca) -> {
                    System.out.println("Salvando no banco de dados.. classe anonima" + clienteValidaca);
                };

        validarCliente(cliente,
                callbackSalvar,
                callbackSalvarFuncional,
                (clienteValidacao) -> System.out.println("faz alguma coisa 1 " + clienteValidacao.getDataNascimento()),
                //(clienteValidacao) -> System.out.println("faz alguma coisa 2"),
                (clienteValidacao) -> System.out.println("faz alguma coisa 3"));

    }

    static void validarCliente(Cliente cliente, CallbackClienteFunction... callbackSucesso) {
        if (cliente.getDataNascimento() == null) {
            return;
        }
        System.out.println("validacao ok....");
        for (CallbackClienteFunction callbackClienteFunction : callbackSucesso) {
            //cliente.setDataNascimento(LocalDate.now().plusDays(10));
            callbackClienteFunction.executar(cliente);
            callbackClienteFunction.validar();
        }
    }

//    static boolean validarCliente(Cliente cliente) {
//        if (cliente.getDataNascimento() == null) {
//            return false;
//        }
//        return true;
//    }

    static void salvarCliente(Cliente cliente) {
        //insert - banco de dados
    }

}
