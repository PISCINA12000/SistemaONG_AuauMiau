package miau.auau.amigosdequatropatas.controller;

import miau.auau.amigosdequatropatas.model.Animal;
import miau.auau.amigosdequatropatas.model.Erro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("apis/animal")
public class AnimaisRestCtrl {
    // DECLARAÇÕES
    @Autowired
    private Animal animal;

    // MÉTODOS ---------------------------------------------
    // BUSCAR
    @GetMapping("buscar")
    public ResponseEntity<Object> getAnimais() {
        List<Animal>lista = new ArrayList<>();
        lista = animal.getAnimal();
        // busca todos os animais e atribui para 'lista'
        if(lista.size() > 0){
            return ResponseEntity.ok(lista);
        }
        return ResponseEntity.badRequest().body(new Erro("Não há nenhum animal cadastrado!"));
    }
    @GetMapping("buscar")
    public ResponseEntity<Object> getAnimais(String nomeAnimal) {
        List<Animal>lista = new ArrayList<>();
        // busca os animais com o respectivo 'nomeAnimal' e retorna para o objeto
        if(lista.size() > 0){
            return ResponseEntity.ok(lista);
        }
        return ResponseEntity.badRequest().body(new Erro("Nenhum animal foi encontrado!"));
    }

    // GRAVAR
    @PostMapping("gravar")
    public ResponseEntity<Object> gravarAnimal(@RequestBody Animal animal) {
        // grava no banco de dados o respectivo objeto 'animal'
        return ResponseEntity.ok(animal); // depois da gravação bem sucedida
    }

    // DELETE
    @DeleteMapping("excluir")
    public ResponseEntity<Object> excluirAnimal(int id) {
        String nomeAnimal = "";
        // deleta do banco de dados o animal com o 'cod' == 'id' e atribui seu nome para 'nomeAnimal'
        return ResponseEntity.ok("O animal " + nomeAnimal + " foi excluído com sucesso!");
    }

    // ATUALIZAR
    @PutMapping("atualizar")
    public ResponseEntity<Object> atualizarAnimal(@RequestBody Animal animal) {
        // atualizar no banco de dados o animal com o mesmo id do objeto 'animal'
        return ResponseEntity.ok("O animal foi atualizado com sucesso!");
    }
}
