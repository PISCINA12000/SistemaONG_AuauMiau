package miau.auau.amigosdequatropatas.view;

import miau.auau.amigosdequatropatas.db.entidades.Animal;
import miau.auau.amigosdequatropatas.util.Erro;
import miau.auau.amigosdequatropatas.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("apis/animal")
public class AnimalRestController {
    // DECLARAÇÕES
    @Autowired
    private AnimalRepository animalRepository;

    // MÉTODOS ---------------------------------------------
    // BUSCAR
    @GetMapping("buscar")
    public ResponseEntity<Object> getAnimais() {

        List<Animal>lista = new ArrayList<>();
        lista = animalRepository.findAll();
        // busca todos os animais e atribui para 'lista'
        if(lista.size() > 0){
            return ResponseEntity.ok(lista);
        }
        return ResponseEntity.badRequest().body(new Erro("Não há nenhum animal cadastrado!"));
    }

    @GetMapping("buscar-nome/{nome}")
    public ResponseEntity<Object> getAnimais(@PathVariable(value = "nome") String nomeAnimal) {
        List<Animal> lista = new ArrayList<>();
        lista.addAll(animalRepository.findAll());
        if(lista.size() > 0)
        {
            int i = 0;
            while(i < lista.size() && !lista.get(i).getNome().toLowerCase().equals(nomeAnimal)) //
                i++;
            if (i < lista.size()) // não terminou
            {
                List<Animal> lista2 = new ArrayList<>();
                lista2.add(lista.get(i));
                return ResponseEntity.ok(lista2);
            }
            return ResponseEntity.badRequest().body(new Erro("Esse animal não foi encontrado!"));
        }
        else
            return ResponseEntity.badRequest().body(new Erro("Nenhum animal cadastrado!"));
    }

    // GRAVAR
    @PostMapping("gravar")
    public ResponseEntity<Object> gravarAnimal(@RequestBody Animal animal) {
        // grava no banco de dados o respectivo objeto 'animal'

        return ResponseEntity.ok(animalRepository.save(animal));

    }

    // DELETE
    @DeleteMapping("excluir/{id}") //
    public ResponseEntity<Object> excluirAnimal(@PathVariable (value = "id") int id) {

        if (animalRepository.existsById(id)) {
            animalRepository.deleteById(id);
            return ResponseEntity.ok(new Erro("Animal deletado com sucesso!"));
        }
        else
        {
            return ResponseEntity.badRequest().body((new Erro(id +" não encontrado")));
        }
        // deleta do banco de dados o animal com o 'cod' == 'id' e atribui seu nome para 'nomeAnimal'

    }

    // ATUALIZAR
    @PutMapping("atualizar/{id}")
    public ResponseEntity<Object> atualizarAnimal(@PathVariable(value = "id") int id, @RequestBody Animal animal)
    {
        if(animalRepository.existsById(id))
        {
            Animal animalNovo = animalRepository.findById(id).get();
            if (!animal.getNome().isEmpty())
                animalNovo.setNome(animal.getNome());
            if (animal.isAdotado() != animalNovo.isAdotado())
                animalNovo.setAdotado(animal.isAdotado());
            if (!animal.getFileName().isEmpty())
                animalNovo.setFileName(animal.getFileName());
            if (animal.isCastrado() != animalNovo.isCastrado())
                animalNovo.setCastrado(animal.isCastrado());
            if (animal.getIdade() > 0)
                animalNovo.setIdade(animal.getIdade());
            if (animal.getSexo()  != ' ')
                animalNovo.setSexo(animal.getSexo());
            if(animal.getPeso() > 0)
                animalNovo.setPeso(animal.getPeso());
            if(!animal.getRaca().isEmpty())
                animalNovo.setRaca(animal.getRaca());

            return ResponseEntity.ok(animalRepository.save(animalNovo));
        }
        else
        {
            return ResponseEntity.badRequest().body(new Erro("id não encontrado"));
        }
        // atualizar no banco de dados o animal com o mesmo id do objeto 'animal'

    }
}
