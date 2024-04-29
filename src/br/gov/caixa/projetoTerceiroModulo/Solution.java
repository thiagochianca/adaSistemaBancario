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


public class Solution {
    public static void main(String[] args) throws IOException {

        final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Path arquivoClientes = Path.of("C:/Users/c148738/IdeaProjects/myFirstProject/src/br/gov/caixa/projetoTerceiroModulo/pessoas.csv");
        List<String> linhasArquivo = Files.readAllLines(arquivoClientes);

        ServicoDeposito deposito = new ServicoDeposito();

        List<String> clientesPJ = linhasArquivo
                .stream()
                .skip(1)
                .map(linha -> linha.split(","))
                .filter(coluna -> "1".equals(coluna[3]))
                .map(linha -> {
                    ClientePJ cliente = new ClientePJ(linha[2], linha[0]);
                    deposito.executarOperacao(cliente.getContaCorrente(), BigDecimal.valueOf(50));
                    return cliente;
                })
                .map(cliente -> cliente.getNome() + ";" + cliente.getId() + ";PJ;" + cliente.getContaCorrente().getId() + ";" + cliente.getContaCorrente().consultarSaldo())
                .toList();


        List<String> clientesPF = linhasArquivo
                .stream()
                .skip(1)
                .map(linha -> linha.split(","))
                .filter(coluna -> "2".equals(coluna[3]))
                .filter(coluna -> ChronoUnit.YEARS.between(LocalDate.parse(coluna[1], DATE_TIME_FORMATTER), LocalDate.now()) > 17L)
                .map(linha -> {
                    ClientePF cliente = new ClientePF(linha[2], linha[0]);
                    deposito.executarOperacao(cliente.getContaCorrente(), BigDecimal.valueOf(50));
                    return cliente;
                })
                .map(cliente -> cliente.getNome() + ";" + cliente.getId() + ";PF;" + cliente.getContaCorrente().getId() + ";" + cliente.getContaCorrente().consultarSaldo())
                .toList();


        try {
            Path destino = Path.of("C:/Users/c148738/IdeaProjects/myFirstProject/src/br/gov/caixa/projetoTerceiroModulo/output/");
            if (Files.notExists(destino)) {
                Files.createDirectories(destino);
            }
            Path arquivoPF = destino.resolve("PF.csv");
            Files.write(arquivoPF, clientesPF);
            Path arquivoPJ = destino.resolve("PJ.csv");
            Files.write(arquivoPJ, clientesPJ);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
