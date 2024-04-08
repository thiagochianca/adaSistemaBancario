package br.gov.caixa.modulodois.ExercicioDoze;

public class Solution {

}

class Aluno implements Comparable<Aluno> {
    public String nome;

    @Override
    public int compareTo(Aluno aluno) {
        return this.nome.compareTo(aluno.nome);

    }
}
