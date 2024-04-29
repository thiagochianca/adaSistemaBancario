package br.gov.caixa.modulo3.aula4.streams.farmacia;

public class Farmacia {

    public Farmacia(String status, Representante representante) {
        this.status = status;
        this.representante = representante;
    }

    private String status;

    private Representante representante;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Representante getRepresentante() {
        return representante;
    }

    public void setRepresentante(Representante representante) {
        this.representante = representante;
    }
}
