package br.gov.caixa.modulodois.ExercicioQuatorze;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {
}

class OrdenaAlunosComparator implements Comparator<Aluno> {

    @Override
    public int compare(Aluno a1, Aluno a2) {
        if(a1.getIdade().compareTo(a2.getIdade())!=0) {
            return a1.getIdade().compareTo(a2.getIdade());
        }
        return a1.getNome().compareTo(a2.getNome());
    }
}

class Aluno implements Comparable<Aluno> {
    private String matricula;
    private String nome;
    private Integer idade;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    @Override
    public int compareTo(Aluno aluno){
        return this.matricula.compareTo(aluno.matricula);
    }

}
class Relatorio {
    public List<Aluno> ordenaAlunos(List<Aluno> alunos) {
        Collections.sort(alunos);
        return alunos;
    }
}
