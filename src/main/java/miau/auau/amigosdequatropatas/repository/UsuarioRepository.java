package miau.auau.amigosdequatropatas.repository;

import miau.auau.amigosdequatropatas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
