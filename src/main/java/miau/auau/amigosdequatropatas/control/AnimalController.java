package miau.auau.amigosdequatropatas.control;

import miau.auau.amigosdequatropatas.db.dals.AnimalDAL;
import miau.auau.amigosdequatropatas.db.entidades.Animal;
import miau.auau.amigosdequatropatas.util.Erro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AnimalController {

    @Autowired
    private Animal animalModel;

    public boolean onGravar(Animal animal)
    {
        if(validar(animal))
            return animalModel.incluir(animal);
        else
            return false;

    }
    public boolean onDelete(int id)
    {
        if(animalModel.consultarID(id) != null) // achou animal
        {
            return animalModel.excluir(animalModel.consultarID(id));
        }
        else
            return false;
    }
    public Animal onBuscarId(int id)
    {
        if(animalModel.consultarID(id) != null) // achou animal
        {
            return animalModel.consultarID(id);
        }
        else
            return null;
    }

    public List<Animal> onBuscar(String filtro)
    {
        if(animalModel.consultar(filtro) != null)
        {
            return animalModel.consultar(filtro);
        }
        else
            return null;
    }

    public boolean onAlterar(Animal animal)
    {
        if(validarAlterar(animal))
        {
            return animalModel.alterar(animal);
        }
        else
            return false;

    }
    public boolean validar(Animal animal)
    {

        return animal != null &&
                !animal.getNome().isEmpty() &&
                animal.getSexo() != null && !animal.getSexo().isEmpty() &&
                !animal.getRaca().isEmpty() &&
                animal.getIdade() > 0 &&
                animal.getPeso() > 0.0 &&
                !animal.getCastrado().isEmpty() &&
                !animal.getAdotado().isEmpty() &&
                !animal.getFileName().isEmpty();

    }
    public boolean validarAlterar(Animal animal)
    {

        return animal != null &&
                animal.getCodAnimal() > 0 &&
                !animal.getNome().isEmpty() &&
                animal.getSexo() != null && !animal.getSexo().isEmpty() &&
                !animal.getRaca().isEmpty() &&
                animal.getIdade() > 0 &&
                animal.getPeso() > 0.0 &&
                !animal.getCastrado().isEmpty() &&
                !animal.getAdotado().isEmpty() &&
                !animal.getFileName().isEmpty();

    }

}
