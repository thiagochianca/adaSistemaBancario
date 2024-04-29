package br.gov.caixa.modulo2.ExercicioTreze;

import java.util.Comparator;

public class Solution {
}


class ComparaAlunoMatricula implements Comparator<Aluno> {

    @Override
    public int compare(Aluno a1, Aluno a2) {
        return a1.getMatricula().compareTo(a2.getMatricula());

    }
}

class Aluno {
    private String nome;
    private Integer matricula;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }
}