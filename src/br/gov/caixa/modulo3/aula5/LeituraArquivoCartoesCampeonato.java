package br.gov.caixa.modulo3.aula5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LeituraArquivoCartoesCampeonato {

    public static void main(String[] args) throws IOException {

        Path path = Path.of("C:/Users/c148738/OneDrive - Caixa Economica Federal/Documentos/campeonato-brasileiro-cartoes.csv");

        Map<String, Map<String, Map<String, List<EventoCartao>>>> clubesCartoes = Files.lines(path) //fonte
                .skip(1)
                //.limit(10)
                .map(linha -> {
                    String[] colunas = linha.split(",");
                    return new EventoCartao(colunas[2], colunas[3], colunas[4]);
                })
                .collect(Collectors.groupingBy(eventoCartao -> eventoCartao.clube(),
                        Collectors.groupingBy(EventoCartao::atleta,
                                Collectors.groupingBy(EventoCartao::cartao))));

        clubesCartoes
                .entrySet()
                .stream()
                .forEach(clube -> {
                    System.out.println("+ CLUBE: " + clube.getKey());
                    clube.getValue().entrySet()
                            .stream()
                            .forEach(atleta -> {
                                System.out.println("++ ATLETA: " + atleta.getKey());
                                atleta.getValue().entrySet()
                                        .stream()
                                        .forEach(cartao -> {
                                            System.out.println("+++ cartao: " + cartao.getKey() + " qtde: " + cartao.getValue().size());
                                        });
                            });
                });

        //atleta;amarelos;vermelhos




    }

}
