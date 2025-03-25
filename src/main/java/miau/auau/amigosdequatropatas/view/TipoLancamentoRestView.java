package miau.auau.amigosdequatropatas.view;

import miau.auau.amigosdequatropatas.util.Erro;
import miau.auau.amigosdequatropatas.db.entidades.TipoLancamento;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("apis/tipo_lanc")
public class TipoLancamentoRestView {
    // DECLARAÇÕES


    // MÉTODOS ---------------------------------------------
    // BUSCAR
    @GetMapping("buscar")
    public ResponseEntity<Object> getTpLanc() {
        List<TipoLancamento> lista = new ArrayList<>();
        //lista.addAll(tipoLancamentoRepository.findAll());
        // busca todos os tipos de lancamento e atribui para 'lista'
        if(lista.size() > 0)
        {
            return ResponseEntity.ok(lista); // vetor de string
        }
        else
            return ResponseEntity.badRequest().body(new Erro("Nenhum Tipo de Lançamento cadastrado!"));
    }
    @GetMapping("buscar-nome/{nome}")
    public ResponseEntity<Object> getTpLanc(@PathVariable (value = "nome") String tipoLanc) {
        List<TipoLancamento> lista = new ArrayList<>();
        //lista.addAll(tipoLancamentoRepository.findAll());
        if(lista.size() > 0)
        {
            int i = 0;
            while(i < lista.size() && !lista.get(i).getDescricao().toLowerCase().equals(tipoLanc)) //
                i++;
            if (i < lista.size()) // não terminou
            {
                List<TipoLancamento> lista2 = new ArrayList<>();
                lista2.add(lista.get(i));
                return ResponseEntity.ok(lista2);
            }
            return ResponseEntity.badRequest().body(new Erro("Esse Tipo de Lançamento não foi encontrado!"));
        }
        else
            return ResponseEntity.badRequest().body(new Erro("Nenhum Tipo de Lançamento cadastrado!"));
    }

    // GRAVAR
    @PostMapping("gravar")
    public ResponseEntity<Object> gravarTpLanc(@RequestBody TipoLancamento tpLanc) {
        // grava no banco de dados o respectivo objeto 'tpLanc'
       // return ResponseEntity.ok(tipoLancamentoRepository.save(tpLanc)); // depois da gravação bem sucedida
        return null;
    }

    // DELETE
    @DeleteMapping("excluir")
    public ResponseEntity<Object> excluirTpLanc(int id) {
        String tpLanc = "";
        // deleta do banco de dados o Tipo com o 'cod' == 'id' e atribui seu nome para 'tpLanc'
        return ResponseEntity.ok("O Tipo de Lançamento " + tpLanc + " foi excluído com sucesso!");
    }

    // ATUALIZAR
    @PutMapping("atualizar")
    public ResponseEntity<Object> atualizarAnimal(@RequestBody TipoLancamento tpLanc) {
        // atualizar no banco de dados o Tipo Lançamento com o mesmo id do objeto 'tpLanc'
        return ResponseEntity.ok("O Tipo de Lançamento foi atualizado com sucesso!");
    }
}
