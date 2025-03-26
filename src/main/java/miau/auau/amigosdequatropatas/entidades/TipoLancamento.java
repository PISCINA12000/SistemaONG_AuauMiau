package miau.auau.amigosdequatropatas.entidades;

import miau.auau.amigosdequatropatas.db.dals.TipoLancamentoDAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TipoLancamento {

    @Autowired
    private TipoLancamentoDAL tipoLancamentoDAL;
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

    public boolean incluir(TipoLancamento lancamento)
    {
        return tipoLancamentoDAL.gravar(lancamento); // grava no banco
    }
    public boolean excluir(TipoLancamento lancamento)
    {
        return tipoLancamentoDAL.apagar(lancamento);
    }
    public TipoLancamento consultarID(int id)
    {
        return tipoLancamentoDAL.get(id);
    }
    public List<TipoLancamento> consultar(String filtro)
    {
        return tipoLancamentoDAL.get(filtro);
    }
    public boolean alterar(TipoLancamento lancamento)
    {
        return tipoLancamentoDAL.alterar(lancamento);
    }
}
