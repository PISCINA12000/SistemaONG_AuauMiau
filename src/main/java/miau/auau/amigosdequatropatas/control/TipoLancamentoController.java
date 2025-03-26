package miau.auau.amigosdequatropatas.control;

import miau.auau.amigosdequatropatas.entidades.TipoLancamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TipoLancamentoController {

    @Autowired
    private TipoLancamento tipoLancamentoModel;

    public boolean onGravar(TipoLancamento tipoLancamento) {
        if (validar(tipoLancamento))
            return tipoLancamentoModel.incluir(tipoLancamento);
        else
            return false;
    }

    public boolean onDelete(int id) {
        if (tipoLancamentoModel.consultarID(id) != null) // achou tipo de lançamento
        {
            return tipoLancamentoModel.excluir(tipoLancamentoModel.consultarID(id));
        } else
            return false;
    }

    public TipoLancamento onBuscarId(int id) {
        if (tipoLancamentoModel.consultarID(id) != null) // achou tipo de lançamento
        {
            return tipoLancamentoModel.consultarID(id);
        } else
            return null;
    }

    public List<TipoLancamento> onBuscar(String filtro) {
        if (tipoLancamentoModel.consultar(filtro) != null) {
            return tipoLancamentoModel.consultar(filtro);
        } else
            return null;
    }

    public boolean onAlterar(TipoLancamento tipoLancamento) {
        if (validarAlterar(tipoLancamento)) {
            return tipoLancamentoModel.alterar(tipoLancamento);
        } else
            return false;
    }

    public boolean validar(TipoLancamento tipoLancamento) {
        return tipoLancamento != null && !tipoLancamento.getDescricao().isEmpty();
    }

    public boolean validarAlterar(TipoLancamento tipoLancamento) {
        return tipoLancamento != null && tipoLancamento.getCod() > 0 && !tipoLancamento.getDescricao().isEmpty();
    }
}
