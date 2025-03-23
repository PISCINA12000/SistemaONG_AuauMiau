package miau.auau.amigosdequatropatas.repository;

import miau.auau.amigosdequatropatas.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

public interface AnimalRepository extends JpaRepository<Animal, Integer>
{


}
