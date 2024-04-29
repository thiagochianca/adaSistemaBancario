package br.gov.caixa.modulo2;


public class Animal {
}

interface AnimalVoador {
    void voar();
}

interface AnimalTerrestre {
    void andar();
}

interface AnimalFelino extends AnimalTerrestre {
    void miar();
}

interface AnimalAquatico {
    void nadar();
}

class Passaro extends Animal implements AnimalVoador {
    @Override
    public void voar() {
        System.out.println("Voe passarinho.");
    }
}

class Gato extends Animal implements AnimalFelino {
    @Override
    public void miar() {
    }

    @Override
    public void andar() {
    }
}

class Peixe extends Animal implements AnimalAquatico {
    public void nadar() {
    }
}

abstract class AbstractPato extends Animal implements AnimalTerrestre, AnimalAquatico, AnimalVoador {
    abstract void outroMetodo();
}

class Pato extends AbstractPato {
    @Override
    public void voar() {

    }

    @Override
    public void andar() {

    }

    @Override
    public void nadar() {

    }

    @Override
    void outroMetodo() {

    }
}

