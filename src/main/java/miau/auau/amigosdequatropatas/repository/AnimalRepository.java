package miau.auau.amigosdequatropatas.repository;

import miau.auau.amigosdequatropatas.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {

}
