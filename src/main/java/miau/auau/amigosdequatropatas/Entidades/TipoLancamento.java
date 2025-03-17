package miau.auau.amigosdequatropatas.Entidades;

public class TipoLancamento {
    private int cod;
    private String descricao;

    // Construtores
    public TipoLancamento(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }
    public TipoLancamento() {
        this(0,"");
    }

    // Gets e Sets
    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
