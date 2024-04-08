package br.gov.caixa.modulodois.calculadora;

public class Calculadora {
    public static void main(String[] args) {


        int [] dados = new int[2];
        String operacao;
        int resultado;


        dados = EntradaDado.solicitarDadosNumericos();
        operacao = EntradaDado.solicitarOperacao();
        resultado = Conta.resolveConta(dados,operacao);
        SaidaDado.escreveSaida(dados,operacao,resultado);

        /*
        SaidaDado.escreveSaida(EntradaDado.solicitarDadosNumericos(),EntradaDado.solicitarOperacao(),
                Conta.resolveConta(EntradaDado.dados,EntradaDado.operacaoDesejada));

*/
    }


}
