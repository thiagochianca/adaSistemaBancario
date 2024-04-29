package br.gov.caixa.projetoProfessor.service.factory;

import br.gov.caixa.projetoProfessor.exceptions.TipoClienteInvalidoException;
import br.gov.caixa.projetoProfessor.model.Cliente;
import br.gov.caixa.projetoProfessor.model.ClientePF;
import br.gov.caixa.projetoProfessor.model.ClientePJ;
import br.gov.caixa.projetoProfessor.service.OperacoesBancarias;
import br.gov.caixa.projetoProfessor.service.impl.OperacoesContaClientePF;
import br.gov.caixa.projetoProfessor.service.impl.OperacoesContaClientePJ;

public final class OperacoesBancariasFactory {

    private final OperacoesBancarias<ClientePF> opeBancPF;
    private final OperacoesBancarias<ClientePJ> opeBancPJ;

    private static OperacoesBancariasFactory instance;

    private OperacoesBancariasFactory() {
        this.opeBancPF = new OperacoesContaClientePF();
        this.opeBancPJ = new OperacoesContaClientePJ();
    }

    public static OperacoesBancariasFactory getInstance() {
        if (instance == null) {
            instance = new OperacoesBancariasFactory();
        }
        return instance;
    }

    public OperacoesBancarias get(Cliente cliente) {
        if (cliente instanceof ClientePF) {
            return this.opeBancPF;
        } else if (cliente instanceof ClientePJ) {
            return this.opeBancPJ;
        } else {
            throw new TipoClienteInvalidoException();
        }
    }

}
