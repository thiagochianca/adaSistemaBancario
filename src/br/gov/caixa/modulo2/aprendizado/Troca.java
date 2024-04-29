package br.gov.caixa.modulo2.aprendizado;

public class Troca <T,U> {
    private T valor1;
    private U valor2;

    public Troca(T valor1, U valor2) {
        this.valor1 = valor1;
        this.valor2 = valor2;
    }

    public T getValor1() {
        return valor1;
    }

    public U getValor2() {
        return valor2;
    }

    public void setValor1(T valor1) {
        this.valor1 = valor1;
    }

    public void setValor2(U valor2) {
        this.valor2 = valor2;
    }

    public void trocar()  {

        T temp = this.getValor1();
        this.setValor1((T)this.getValor2());
        this.setValor2((U) temp);
    }
}


/*
public class Troca <T, U> {
           private T valor1;
           private U valor2;



}



 */