package br.gov.caixa.projetoSegundoModulo.Service;

import br.gov.caixa.projetoSegundoModulo.Model.Conta;
import br.gov.caixa.projetoSegundoModulo.Model.Historico;

import java.util.List;

public class ListagemHistorico {
    public static void listar(Conta conta) {

        System.out.println("--------------------------------------------------------------------");
        System.out.println("Histórico da Conta ID: "+ conta.getId());
        System.out.println("Nome do Responsável pela conta: "+ conta.getCliente().getNome());

        List<Historico> historicos = conta.getHistorico();
        for (Historico historico: historicos
        ) {
            System.out.println("--------------------------------------------------------------------");
            System.out.println("Data: " + historico.getDataOperacao());
            System.out.println("Tipo da Operação: " + historico.getTipo());
            System.out.println("Valor pretendido: " + historico.getValorPretendido());
            System.out.println("Valor real: " + historico.getValorReal());
            System.out.println("Usuario de Origem: " + historico.getClienteOrigem());
            System.out.println("Usuario de Destino: " + historico.getClienteDestino());
            System.out.println("Observação: " + historico.getObservacao());
            System.out.println("--------------------------------------------------------------------");

        }
    }
}
