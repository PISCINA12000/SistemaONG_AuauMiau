package miau.auau.amigosdequatropatas.entidades;

public class Endereco {
    private String cep;
    private String rua;
    private String numero;
    private String bairro;
    private String cidade;

    // Construtores
    public Endereco(String cep, String rua, String numero, String bairro, String cidade) {
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
    }
    public Endereco() {
        this("","","","","");
    }

    // Gets e Sets
    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
