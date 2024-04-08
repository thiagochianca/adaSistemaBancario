package br.gov.caixa.projetoSegundoModulo.Verification;



import br.gov.caixa.projetoSegundoModulo.Model.Conta;
import br.gov.caixa.projetoSegundoModulo.Factory.FabricaDeContas;

public class VerificacaoInvestimento implements Verificacao{

    @Override
    public boolean verificar(Conta conta, double valor) {
        if(verificarExistenciaContaInvestimento(conta) && verificarSaldo(conta,valor)) {
            return true;
        }
       return false;
    }
    private boolean verificarExistenciaContaInvestimento(Conta conta) {
        if (conta.getCliente().getContaInvestimento() == null) {
            FabricaDeContas.criarContaInvestimento(conta.getCliente());
            return true;
        } else {
            return true;
        }
    }
    private boolean verificarSaldo(Conta conta, double valor) {
        if(conta.consultarSaldo()>=valor) {
            return true;
        }
        return false;
    }
}

