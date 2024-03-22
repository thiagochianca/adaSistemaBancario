package br.gov.caixa.modulodois;

public abstract class Veiculo {
    private String cor;
    private String tamanho;
    private String marca;
    private int ano;
    private int qtdPneus;
    private String nome;
    private int velocidadeMaxima;

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getQtdPneus() {
        return qtdPneus;
    }

    public void setQtdPneus(int qtdPneus) {
        this.qtdPneus = qtdPneus;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVelocidadeMaxima() {
        return velocidadeMaxima;
    }

    public void setVelocidadeMaxima(int velocidadeMaxima) {
        this.velocidadeMaxima = velocidadeMaxima;
    }
}

interface VeiculoMotorizado {
    void ligar();
    void andar();
    void acelerar();
    void freiar();
    void desligar();
    void abastecer();
}

interface VeiculoNaoMotorizado {
    void andar();
    void acelerar();
    void freiar();
}

