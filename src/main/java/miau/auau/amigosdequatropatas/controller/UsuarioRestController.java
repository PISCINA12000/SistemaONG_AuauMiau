package miau.auau.amigosdequatropatas.controller;

import miau.auau.amigosdequatropatas.repository.UsuarioRepository;
import miau.auau.amigosdequatropatas.util.Erro;
import miau.auau.amigosdequatropatas.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("apis/usuario")
public class UsuarioRestController
{
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("buscar")
    public ResponseEntity<Object> getUsuarios() {
        List<Usuario>lista = new ArrayList<>();
        if(lista.size() > 0){
            return ResponseEntity.ok(lista);
        }
        return ResponseEntity.badRequest().body(new Erro("Não há nenhum Usuario cadastrado!"));
    }
    @GetMapping("buscar-nome")
    public ResponseEntity<Object> getUsuarios(String nomeUsuario) {
        List<Usuario>lista = new ArrayList<>();
        if(lista.size() > 0){
            return ResponseEntity.ok(lista);
        }
        return ResponseEntity.badRequest().body(new Erro("Nenhum Usuario foi encontrado!"));
    }

    @PostMapping("gravar")
    public ResponseEntity<Object> gravarUsuario(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioRepository.save(usuario));
    }

    // DELETE
    @DeleteMapping("excluir")
    public ResponseEntity<Object> excluirUsuario(int id) {
        String nomeUsuario = "";
        return ResponseEntity.ok("O usuario " + nomeUsuario + " foi excluído com sucesso!");
    }

    @PutMapping("atualizar")
    public ResponseEntity<Object> atualizarUsuario(@RequestBody Usuario usuario) {
        return ResponseEntity.ok("O usuario foi atualizado com sucesso!");
    }
}