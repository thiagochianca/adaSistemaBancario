package br.gov.caixa.projetoTerceiroModulo;

import br.gov.caixa.projetoTerceiroModulo.model.*;
import br.gov.caixa.projetoTerceiroModulo.service.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) throws IOException {

        Path arquivoClientes = Path.of("C:/Users/c148738/IdeaProjects/myFirstProject/src/br/gov/caixa/projetoTerceiroModulo/pessoas.csv");
        Stream<String> linhasArquivo = Files.lines(arquivoClientes);

        List<String> clientes = linhasArquivo
                .skip(1)
                .map(linha -> linha.split(","))
                .filter(coluna -> verificarIdadePF(coluna))
                .map(linha -> criarClientePromocional(linha))
                .map(cliente -> transformarClienteEmLinhaDeArquivo(cliente))
                .toList();


        Path destino = Path.of("C:/Users/c148738/IdeaProjects/myFirstProject/src/br/gov/caixa/projetoTerceiroModulo/output/");
        Path arquivo = destino.resolve("clientes.csv");
        Files.write(arquivo, clientes);

    }

    static boolean verificarIdadePF(String[] coluna) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return ("2".equals(coluna[3])) ? ChronoUnit.YEARS.between(LocalDate.parse(coluna[1], format), LocalDate.now()) > 17L : true;
    }

    static String transformarClienteEmLinhaDeArquivo(Cliente cliente) {
        return cliente.getNome() + ";" + cliente.getId() + ";" + (cliente instanceof ClientePF ? "PF" : "PJ" ) + ";"
                + cliente.getContaCorrente().getId() + ";" + cliente.getContaCorrente().consultarSaldo();
    }
    static Cliente criarClientePromocional(String[] linha) {
        Cliente cliente = ("1".equals(linha[3])) ? new ClientePJ(linha[2], linha[0]) : new ClientePF(linha[2], linha[0]);
        ServicoDeposito deposito = new ServicoDeposito();
        deposito.executarOperacao(cliente.getContaCorrente(), BigDecimal.valueOf(50));
        return cliente;
    }

}
