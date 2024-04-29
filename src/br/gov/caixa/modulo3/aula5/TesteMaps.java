package br.gov.caixa.modulo3.aula5;

import java.util.HashMap;
import java.util.Map;

public class TesteMaps {

    public static void main(String[] args) {
        Map<String, String> mapTeste = new HashMap<>();
        mapTeste.put("32323232", "nome do cliente");
        mapTeste.put("32323232", "nome novo");
        System.out.println(mapTeste.get("1"));

        for (String cpf : mapTeste.keySet()) {
            String nome = mapTeste.get(cpf);
            if (nome.equals("nome novo")) {
                System.out.println(cpf);
            }
        }

        mapTeste.entrySet().stream()
                .filter(entry -> entry.getValue().equals("nome novo"))
                .findFirst()
                .ifPresent(stringStringEntry -> System.out.println(stringStringEntry.getKey()));

    }

}
