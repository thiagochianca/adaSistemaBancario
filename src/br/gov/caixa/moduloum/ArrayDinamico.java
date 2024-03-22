package br.gov.caixa.moduloum;

public class ArrayDinamico {
    private String[] array;

    public ArrayDinamico(int tamanhoArray) {
        this.array = new String[tamanhoArray];
    }

    public int tamanhoArray(String [] array) {
        return array.length;
    }
}
