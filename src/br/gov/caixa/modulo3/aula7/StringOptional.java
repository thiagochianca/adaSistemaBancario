package br.gov.caixa.modulo3.aula7;

import java.util.Optional;

class StringOptional {
    public Optional<String> optionalOfString(String text) {
        // text = "" => empty e blank
        // text = "     " => blank
        if (text == null || text.isBlank()) {
            return Optional.empty();
        } else {
            return Optional.of(text);
        }
    }
}