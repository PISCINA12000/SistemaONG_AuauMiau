package miau.auau.amigosdequatropatas.repository;

import miau.auau.amigosdequatropatas.db.entidades.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {

}
