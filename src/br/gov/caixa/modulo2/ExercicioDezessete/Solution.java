package br.gov.caixa.modulo2.ExercicioDezessete;

public class Solution {
}

//record RedeSocial(String nomeRedeSocial, Integer quantidadeSeguidores) {}
//record Celebridade(String nome, RedeSocial redeSocial) {}

class RedeSocial {
    private String nomeRedeSocial;
    private Integer quantidadeSeguidores;

    public String getNomeRedeSocial() {
        return nomeRedeSocial;
    }

    public void setNomeRedeSocial(String nomeRedeSocial) {
        this.nomeRedeSocial = nomeRedeSocial;
    }

    public Integer getQuantidadeSeguidores() {
        return quantidadeSeguidores;
    }

    public void setQuantidadeSeguidores(Integer quantidadeSeguidores) {
        this.quantidadeSeguidores = quantidadeSeguidores;
    }
}

class Celebridade implements Comparable<Celebridade>{
    private String nome;
    private RedeSocial redeSocial;


    @Override
    public int compareTo(Celebridade celebridade) {
        return celebridade.getRedeSocial().getQuantidadeSeguidores().compareTo(this.getRedeSocial().getQuantidadeSeguidores());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public RedeSocial getRedeSocial() {
        return redeSocial;
    }

    public void setRedeSocial(RedeSocial redeSocial) {
        this.redeSocial = redeSocial;
    }

}
