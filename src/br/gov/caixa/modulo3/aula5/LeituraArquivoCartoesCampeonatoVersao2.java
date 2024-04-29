package br.gov.caixa.modulo3.aula5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class LeituraArquivoCartoesCampeonatoVersao2 {

    private static final String PATH_BASE = "C:/Users/c148738/OneDrive - Caixa Economica Federal/Documentos/";

    public static void main(String[] args) throws IOException {

        Path path = Path.of(PATH_BASE + "campeonato-brasileiro-cartoes.csv");

        //Map<Clube, Map<Atleta, Map<Cartao, Count>>>
        Map<String, Map<String, Map<String, Long>>> clubesCartoes = Files.lines(path) //fonte
                .skip(1)
                //.limit(10)
                .map(linha -> {
                    String[] colunas = linha.split(",");
                    return new EventoCartao(colunas[2], colunas[3], colunas[4]);
                })
                .collect(Collectors.groupingBy(eventoCartao -> eventoCartao.clube(),
                        Collectors.groupingBy(EventoCartao::atleta,
                                Collectors.groupingBy(EventoCartao::cartao, Collectors.counting()))));

        clubesCartoes
                .entrySet()
                .stream()
                .parallel()
                .forEach(clube -> {
                    System.out.println("CLUBE: " + clube.getKey().substring(1,clube.getKey().length()-1) + " " + clube.getValue().size());

                    Map<String, Map<String,Long>> atletas = clube.getValue();



                    //atleta;amarelos;vermelhos
                    List<String> linhaDadosAtleta = atletas.entrySet().stream()
                            .map(atleta -> {
                                String nomeAtleta =  atleta.getKey();
                                Long amarelos = Optional.ofNullable(atleta.getValue().get("\"Amarelo\"")).orElse(0L);
                                Long vermelhos = Optional.ofNullable(atleta.getValue().get("\"Vermelho\"")).orElse(0L);
                                return nomeAtleta + ";" + amarelos + ";" + vermelhos;
                            })
                            .toList();

                    try {
                        Path destino = Path.of(PATH_BASE + "output/");
                        if (Files.notExists(destino)) {
                            Files.createDirectories(destino);
                        }
                        Path arquivo = destino.resolve(clube.getKey().substring(1,clube.getKey().length()-1) + ".csv");
                        Files.write(arquivo, linhaDadosAtleta);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                });






    }

}
