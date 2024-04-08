package br.gov.caixa.modulodois.ExercicioCinco;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ExercicioCinco {

    public static void main(String[] args) {
        Aluno alunoUm = new Aluno();
        Aluno alunoDois = new Aluno();
        Aluno alunoTres = new Aluno();

        alunoUm.setNome("Thiago");
        alunoDois.setNome("Arthur");
        alunoTres.setNome("Jeane");

        Professor prof = new Professor();
        prof.setNome("Hudson");
        Professor aux = new Professor();
        aux.setNome("João");

        List<Participante> participantes = new ArrayList<>();
        participantes.add(alunoUm);
        participantes.add(alunoDois);
        participantes.add(alunoTres);
        participantes.add(prof);
        participantes.add(aux);

        Chat chat = new Chat();
        participantes.add(chat.escolheRespondente(participantes));

        System.out.println(participantes.get(0).getNomeParticipante());
        System.out.println(participantes.get(1).getNomeParticipante());
        System.out.println(participantes.get(2).getNomeParticipante());
        System.out.println(participantes.get(3).getNomeParticipante());
        System.out.println(participantes.get(4).getNomeParticipante());
        System.out.println(participantes.get(5).getNomeParticipante());



    }
}

interface Participante {
    public String getNomeParticipante();
}

interface Respondente {
}
class Aluno implements Participante, Respondente {
    private String nome;

    @Override
    public String getNomeParticipante() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

class Professor implements Participante {
    private String nome;

    @Override
    public String getNomeParticipante() {
        return "Prof. " + this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

class Chat {
    public Participante escolheRespondente(List<Participante> participantes) {
        // COLOQUE SEU CÓDIGO AQUI
        for (Object resp : participantes
             ) {
            if(resp instanceof Respondente) {
                return (Participante) resp;
            }
        }
        return null;
        }
    }
