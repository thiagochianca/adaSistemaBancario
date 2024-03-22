package br.gov.caixa.moduloum;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class NotaFiscal {
    int numeroNotaFiscal;
    String descricaoProduto;
    int quantidadeComprada;
    double precoProduto;

    public NotaFiscal(int numeroNotaFiscal, String descricaoProduto, int quantidadeComprada, double precoProduto) {
        this.numeroNotaFiscal = numeroNotaFiscal;
        this.descricaoProduto = descricaoProduto;
        this.quantidadeComprada = quantidadeComprada;
        this.precoProduto = precoProduto;
    }

    public String nf_to_String() {
        String saida;
        NumberFormat formatter = new DecimalFormat("#0.00");

        saida = this.numeroNotaFiscal + "|" + this.descricaoProduto + "|" + this.quantidadeComprada + "|" + formatter.format(this.precoProduto);
        return saida;
    }
}

class NotaFiscalEletronica extends NotaFiscal {
    String qrCode;

    public NotaFiscalEletronica(int numeroNotaFiscal, String descricaoProduto, int quantidadeComprada, double precoProduto, String qrCode) {
        super(numeroNotaFiscal, descricaoProduto, quantidadeComprada, precoProduto);
        this.qrCode = qrCode;
    }


    public String nf_to_String() {
        String saida;
        NumberFormat formatter = new DecimalFormat("#0.00");

        saida = this.numeroNotaFiscal + "|" + this.descricaoProduto + "|" + this.quantidadeComprada + "|" + formatter.format(this.precoProduto) + "|" + this.qrCode;
        return saida;
    }
}

class Solution {
    public static String solution(String entrada) {
        //"nf:1_desc:Camiseta_qtde:1_precoUnitario:49,90_qrCode:abc"
        String[] entradaSemUnderScore = entrada.split("_");
        int numeroNotaFiscal = 0;
        String descricaoProduto = "";
        int quantidadeComprada = 0;
        double precoProduto = 0.00;
        String qrCode = "";
        for (int i = 0; i < entradaSemUnderScore.length; i++) {
            switch (entradaSemUnderScore[i].substring(0, entradaSemUnderScore[i].indexOf(":"))) {
                case "nf":
                    numeroNotaFiscal = Integer.parseInt(entradaSemUnderScore[i].substring(entradaSemUnderScore[i].indexOf(":") + 1));
                case "desc":
                    descricaoProduto = entradaSemUnderScore[i].substring(5);
                case "qtde":
                    quantidadeComprada = Integer.parseInt(entradaSemUnderScore[i].substring(5));
                case "precoUnitario":
                    precoProduto = Double.parseDouble(entradaSemUnderScore[i].substring(14).replace(',', '.'));
                case "qrCode":
                    qrCode = entradaSemUnderScore[i].substring(7);
            }


        }
            NotaFiscalEletronica nfe = new NotaFiscalEletronica(numeroNotaFiscal, descricaoProduto, quantidadeComprada, precoProduto, qrCode);
            return nfe.nf_to_String();

        }
    }



class TesteNotas {
    public static void main(String[] args) {
        String entrada = "nf:1_desc:Camiseta_qtde:1_precoUnitario:49,90_qrCode:abc";
        //String entrada2 = "nf:1_desc:Camiseta_qtde:1_precoUnitario:49,90";

        System.out.println(Solution.solution(entrada));



    }
}
