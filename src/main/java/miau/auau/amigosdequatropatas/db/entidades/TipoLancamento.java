package miau.auau.amigosdequatropatas.db.entidades;

public class TipoLancamento {

    private int codTipoLancamento;

    private String descricao;

    // Construtores
    public TipoLancamento(int cod, String descricao) {
        this.codTipoLancamento = cod;
        this.descricao = descricao;
    }
    public TipoLancamento() {
        this(0,"");
    }

    // Gets e Sets
    public int getCod() {
        return codTipoLancamento;
    }

    public void setCod(int cod) {
        this.codTipoLancamento = cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
