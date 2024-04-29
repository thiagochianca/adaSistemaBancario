package br.gov.caixa.modulo1;

public class ArrayDinamico {
    private String[] array;

    public ArrayDinamico(int tamanhoArray) {
        this.array = new String[tamanhoArray];
    }

    public int tamanhoArray(String [] array) {
        return array.length;
    }
}
