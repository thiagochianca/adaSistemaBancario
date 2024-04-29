package br.gov.caixa.modulo3.aula3.callbackFunction;


import br.gov.caixa.modulo3.aula1.Cliente;
import br.gov.caixa.modulo3.aula1.ClienteRecord;

import java.time.LocalDate;

public class ExemploCallbackFunction {

    public static void main(String[] args) {

        ClienteRecord clienteRecord = new ClienteRecord(LocalDate.of(1999,1,1));


        Cliente cliente = new Cliente(LocalDate.of(1990, 1,1));

        processarCliente(cliente,
                (clienteParaValidar) -> {System.out.println("validando cliente"); return true;},
                (clienteValidado) -> {System.out.println("salvando cliente"); return false;},
                (mensagemErro) -> System.out.println("Aconteceu um erro: " + mensagemErro));

    }

    static void processarCliente(final Cliente cliente,
                                 ValidarCliente validarCliente,
                                 SalvarCliente salvarCliente,
                                 CallbackErro callbackErro) {

        //cliente = new Cliente();

        //validar cliente - validar(cliente)
        //salvar o cliente - salvar(cliente)
        //tratamento erro - fluxo erro (exception)

        try {

            //cliente.setDataNascimento(LocalDate.now().plusDays(5));

            if (!validarCliente.validar(cliente) || !salvarCliente.salvar(cliente)) {
                throw new RuntimeException("Erro ao validar/salvar");
            }
        } catch (Exception e) {
            String mensagemErro = callbackErro.formatarMensagemDeErro(e);
            callbackErro.erro(mensagemErro);
            callbackErro.salvarFile(e);
        }

    }

}
