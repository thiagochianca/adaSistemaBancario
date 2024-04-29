package br.gov.caixa.modulo3.aula7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LeituraArquivoCarros {

    public static void main(String[] args) throws IOException {

        Path arquivoCarros = Path.of("C:/developer/projects/aulas_ada/caixa/turma-backend/mod-tecnicas-prog-streams/cars.csv");

        Stream<String> linhasArquivos = Files.lines(arquivoCarros);

        List<String> carrosMedios = new ArrayList<>();

        linhasArquivos.forEach(carro -> {
            String[] colunas = carro.split(",");
            String nomeCarro = colunas[0];
            String categoriaCarro = colunas[1];

            if ("MEDIO".equals(categoriaCarro)) {
                carrosMedios.add(nomeCarro);
            }
        });

        Path destino = Path.of("C:/developer/projects/aulas_ada/caixa/turma-backend/mod-tecnicas-prog-streams/carrosMedios.csv");
        Files.write(destino, carrosMedios);

    }

}
