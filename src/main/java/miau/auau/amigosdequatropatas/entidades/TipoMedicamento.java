package miau.auau.amigosdequatropatas.entidades;

import miau.auau.amigosdequatropatas.db.dals.TipoMedicamentoDAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TipoMedicamento {

    @Autowired
    private TipoMedicamentoDAL tipoMedicamentoDAL;
    private int codTipoMedicamento;
    private String nome;

    // Construtores
    public TipoMedicamento(int cod, String nome) {
        this.codTipoMedicamento = cod;
        this.nome = nome;
    }
    public TipoMedicamento() {
        this(0,"");
    }

    // Gets e Sets
    public int getCod() {
        return codTipoMedicamento;
    }

    public void setCod(int cod) {
        this.codTipoMedicamento = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean incluir(TipoMedicamento medicamento)
    {
        return tipoMedicamentoDAL.gravar(medicamento); // grava no banco
    }
    public boolean excluir(TipoMedicamento medicamento)
    {
        return tipoMedicamentoDAL.apagar(medicamento);
    }
    public TipoMedicamento consultarID(int id)
    {
        return tipoMedicamentoDAL.get(id);
    }
    public List<TipoMedicamento> consultar(String filtro)
    {
        return tipoMedicamentoDAL.get(filtro);
    }
    public boolean alterar(TipoMedicamento medicamento)
    {
        return tipoMedicamentoDAL.alterar(medicamento);
    }
}
