package miau.auau.amigosdequatropatas.view;

import miau.auau.amigosdequatropatas.control.AnimalController;
import miau.auau.amigosdequatropatas.entidades.Animal;
import miau.auau.amigosdequatropatas.util.Erro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("apis/animal")
public class AnimalRestView {
    // DECLARAÇÕES
    @Autowired
    private AnimalController animalController;
    // MÉTODOS ---------------------------------------------
    // BUSCAR
    @GetMapping("buscar/{filtro}") // vazio, retorna todos
    public ResponseEntity<Object> getAnimais(@PathVariable(value = "filtro") String filtro)
    {
        if(!animalController.onBuscar(filtro).isEmpty())
            return ResponseEntity.ok().body(animalController.onBuscar(filtro));
        else
            return ResponseEntity.badRequest().body(new Erro("Animal nao encontrado ou nenhum animal cadastrado"));
    }

    @GetMapping("buscar-id/{id}")
    public ResponseEntity<Object> getAnimais(@PathVariable(value = "id") int id)
    {

        if(animalController.onBuscarId(id) != null)
        {
            return ResponseEntity.ok(animalController.onBuscarId(id));
        }
        else
            return ResponseEntity.badRequest().body(new Erro("Animal não encontrado!"));

    }

    // GRAVAR
    @PostMapping("gravar")
    public ResponseEntity<Object> gravarAnimal(@RequestBody Animal animal)
    {

        if (animalController.onGravar(animal))
            return ResponseEntity.ok(animal);
        else
            return ResponseEntity.badRequest().body(new Erro("Erro ao gravar animal"));

    }

    // DELETE
    @DeleteMapping("excluir/{id}") //
    public ResponseEntity<Object> excluirAnimal(@PathVariable (value = "id") int id) {

       if(animalController.onDelete(id))
       {
           return ResponseEntity.ok(new Erro("Animal excluido com sucesso!"));
       }
       else
           return ResponseEntity.badRequest().body(new Erro("Erro ao excluir animal"));

    }

    // ATUALIZAR
    @PutMapping("atualizar")
    public ResponseEntity<Object> atualizarAnimal(@RequestBody Animal animal)
    {
        if(animalController.onAlterar(animal))
        {
            return ResponseEntity.ok(animal);
        }
        else
            return ResponseEntity.badRequest().body(new Erro("Erro ao atualizar animal"));
    }
}
