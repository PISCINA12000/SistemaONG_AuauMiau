package miau.auau.amigosdequatropatas.controller;

import miau.auau.amigosdequatropatas.repository.TipoMedicamentosRepository;
import miau.auau.amigosdequatropatas.util.Erro;
import miau.auau.amigosdequatropatas.model.TipoMedicamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin
@RestController
@RequestMapping("apis/tipo_medic")

public class TipoMedicamentosRestController {

    @Autowired
    private TipoMedicamentosRepository tipoMedicamentosRepository;
    // MÉTODOS ---------------------------------------------

    @GetMapping("buscar")
    public ResponseEntity<Object> getTpMedic() {
        List<TipoMedicamento> lista = new ArrayList<>();
        lista.addAll(tipoMedicamentosRepository.findAll());
        if(lista.size() > 0){
            return ResponseEntity.ok(lista);
        }
        else
            return ResponseEntity.badRequest().body(new Erro("Nenhum Tipo de Medicamento cadastrado!"));
    }

    @GetMapping("buscar-nome/{nome}")
    public ResponseEntity<Object> getTpMeidic(@PathVariable (value = "nome") String tipoMedic) {
        List<TipoMedicamento> lista = new ArrayList<>();
        lista.addAll(tipoMedicamentosRepository.findAll());
        if(lista.size() > 0)
        {
            int i = 0;
            while(i < lista.size() && !lista.get(i).getNome().toLowerCase().equals(tipoMedic)) //
                i++;
            if (i < lista.size()) // não terminou
            {
                List<TipoMedicamento> lista2 = new ArrayList<>();
                lista2.add(lista.get(i));
                return ResponseEntity.ok(lista2);
            }
            return ResponseEntity.badRequest().body(new Erro("Esse Tipo de Medicamento não foi encontrado!"));
        }
        else
            return ResponseEntity.badRequest().body(new Erro("Nenhum Tipo de Medicamento cadastrado!"));
    }

    // GRAVAR
    @PostMapping("gravar")
    public ResponseEntity<Object> gravarTpMedic(@RequestBody TipoMedicamento tpMedic) {

        return ResponseEntity.ok(tipoMedicamentosRepository.save(tpMedic)); // depois da gravação bem sucedida
    }

    // DELETE
    @DeleteMapping("excluir")
    public ResponseEntity<Object> excluirTpMedic(int id) {
        String tpMedic = "";

        return ResponseEntity.ok("O Tipo de Medicamento " + tpMedic + " foi excluído com sucesso!");
    }

    // ATUALIZAR
    @PutMapping("atualizar")
    public ResponseEntity<Object> atualizarAnimal(@RequestBody TipoMedicamento tpMedic) {

        return ResponseEntity.ok("O Tipo de Medicamento foi atualizado com sucesso!");
    }
}