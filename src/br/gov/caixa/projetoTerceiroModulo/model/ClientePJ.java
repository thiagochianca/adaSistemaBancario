package br.gov.caixa.projetoTerceiroModulo.model;

public class ClientePJ extends Cliente {
    private String cnpj;
    public ClientePJ(String cnpj, String nome) {
        super(nome);
        this.cnpj = cnpj;
    }
    public String getId() {
        return cnpj;
    }
}
