package miau.auau.amigosdequatropatas.control;

import miau.auau.amigosdequatropatas.entidades.TipoMedicamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TipoMedicamentoController {

    @Autowired
    private TipoMedicamento tipoMedicamentoModel;

    public boolean onGravar(TipoMedicamento tipoMedicamento) {
        if (validar(tipoMedicamento))
            return tipoMedicamentoModel.incluir(tipoMedicamento);
        else
            return false;
    }

    public boolean onDelete(int id) {
        if (tipoMedicamentoModel.consultarID(id) != null) // achou tipo de medicamento
        {
            return tipoMedicamentoModel.excluir(tipoMedicamentoModel.consultarID(id));
        } else
            return false;
    }

    public TipoMedicamento onBuscarId(int id) {
        if (tipoMedicamentoModel.consultarID(id) != null) // achou tipo de medicamento
        {
            return tipoMedicamentoModel.consultarID(id);
        } else
            return null;
    }

    public List<TipoMedicamento> onBuscar(String filtro) {
        if (tipoMedicamentoModel.consultar(filtro) != null) {
            return tipoMedicamentoModel.consultar(filtro);
        } else
            return null;
    }

    public boolean onAlterar(TipoMedicamento tipoMedicamento) {
        if (validarAlterar(tipoMedicamento)) {
            return tipoMedicamentoModel.alterar(tipoMedicamento);
        } else
            return false;
    }

    public boolean validar(TipoMedicamento tipoMedicamento) {
        return tipoMedicamento != null && !tipoMedicamento.getNome().isEmpty();
    }

    public boolean validarAlterar(TipoMedicamento tipoMedicamento) {
        return tipoMedicamento != null && tipoMedicamento.getCod() > 0 && !tipoMedicamento.getNome().isEmpty();
    }
}
