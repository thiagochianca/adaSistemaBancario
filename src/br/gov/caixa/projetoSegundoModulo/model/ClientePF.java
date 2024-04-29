package br.gov.caixa.projetoSegundoModulo.model;

public class ClientePF extends Cliente {
    private String cpf;
    public ClientePF(String cpf, String nome) {
        super(nome);
        this.cpf = cpf;
    }

    public String getId() {
        return cpf;
    }

}
