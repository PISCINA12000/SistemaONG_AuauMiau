package miau.auau.amigosdequatropatas.Entidades;

public class TipoMedicamento {
    private int cod;
    private String nome;

    // Construtores
    public TipoMedicamento(int cod, String nome) {
        this.cod = cod;
        this.nome = nome;
    }
    public TipoMedicamento() {
        this(0,"");
    }

    // Gets e Sets
    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
