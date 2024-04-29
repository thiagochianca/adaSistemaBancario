package br.gov.caixa.modulo1;

import java.util.ArrayList;

class Veiculo {
    public String placa;
    public String tipo;

    public Veiculo(String placa) {
        this.placa = placa;
    }
}

// Criar classe carro
class Carro extends Veiculo {

    // Construtor recebendo tipo
    public Carro(String placa) {
        super(placa);
        this.tipo = "carro";
    }
}

//Criar classe moto
class Moto extends Veiculo {

    // Construtor recebendo tipo
    public Moto(String placa) {
        super(placa);
        this.tipo = "moto";
    }
}

class Estacionamento {
    //ArrayList de veiculos
    ArrayList<Veiculo> veiculosEstacionados = new ArrayList<Veiculo>();

    //Metodo Estacionar
    public void estacionar(Veiculo v) {
        veiculosEstacionados.add(v);
    }

    //Metodo Sair do Estacionamento (Placa)
    public Veiculo sairDoEstacionamento(String placa) {
        for (Veiculo veiculo : veiculosEstacionados) {
            if(veiculo.placa.equals(placa)) {
                return veiculo;
            }
        }
        return null;
    }

    //Metodo de consultar
    public boolean consultarVeiculo(String placa){
        for (Veiculo veiculo : veiculosEstacionados) {
            if(veiculo.placa.equals(placa)) {
                return true;
            }
        }
        return false;
    }

    // Metodo da ocupação
    public int ocupacao() {
        int valor = veiculosEstacionados.size();
        return valor;
    }




}

class Teste {
    public static void main(String[] args) {
        Carro c = new Carro("123");
        Estacionamento e = new Estacionamento();
        System.out.println("Estacionando 123");
        e.estacionar(c);
        System.out.println(e.ocupacao());
        System.out.println("Retirando 123");
        Veiculo v = e.sairDoEstacionamento("123");

        System.out.println(e.ocupacao());
    }
}
