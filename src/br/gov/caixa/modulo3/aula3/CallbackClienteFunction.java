package br.gov.caixa.modulo3.aula3;


import br.gov.caixa.modulo3.aula1.Cliente;

//Interface funcional = interface com apenas 1 metodo 'abstrato'
@FunctionalInterface
public interface CallbackClienteFunction {

    void executar(Cliente cliente);

    //void exec();

    default void validar() {
        System.out.println("implementacao metodo validar");
    }

}
