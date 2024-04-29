package br.gov.caixa.modulo3.aula3.callbackFunction;

@FunctionalInterface
public interface CallbackErro {

    void erro(String erro);

    default void salvarFile(Exception e) {
        System.out.println("salvando o erro no arquivo..." + e.getMessage());
    }

    default String formatarMensagemDeErro(Exception e) {
        return e.getMessage().toUpperCase();
    }

}
