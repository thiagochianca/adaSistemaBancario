package br.gov.caixa.modulo3.aula7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class LeituraArquivoCarrosV2Funcional {

    public static void main(String[] args) throws IOException {

        Path arquivoCarros = Path.of("C:/developer/projects/aulas_ada/caixa/turma-backend/mod-tecnicas-prog-streams/cars.csv");

        Stream<String> linhasArquivos = Files.lines(arquivoCarros);

        List<String> carrosPequenos = linhasArquivos
                        .map(linhaCarro -> linhaCarro.split(","))
                        .filter(colunasCarro -> "PEQUENO".equals(colunasCarro[1].trim()))
                        .map(linhaCarro -> {
                            String nomeDoCarro = linhaCarro[0];
                            return nomeDoCarro;
                        })
                        .toList();


        Path destino = Path.of("C:/developer/projects/aulas_ada/caixa/turma-backend/mod-tecnicas-prog-streams/carrosPequenos.csv");
        Files.write(destino, carrosPequenos);

    }

}
