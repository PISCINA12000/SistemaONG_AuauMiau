package miau.auau.amigosdequatropatas.view;

import miau.auau.amigosdequatropatas.repository.UsuarioRepository;
import miau.auau.amigosdequatropatas.util.Erro;
import miau.auau.amigosdequatropatas.db.entidades.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("apis/usuario")
public class UsuarioRestController
{
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("buscar")
    public ResponseEntity<Object> getUsuarios() {
        List<Usuario>lista = new ArrayList<>();
        lista.addAll(usuarioRepository.findAll());
        if(lista.size() > 0){
            return ResponseEntity.ok(lista); // vetor de strings
        }
        else
            return ResponseEntity.badRequest().body(new Erro("Não há nenhum Usuario cadastrado!"));
    }
    @GetMapping("buscar-cpf/{cpf}")
    public ResponseEntity<Object> getUsuarios(@PathVariable (value = "cpf") String cpf) {
        List<Usuario> lista = new ArrayList<>();
        lista.addAll(usuarioRepository.findAll());
        if(lista.size() > 0)
        {
            int i = 0;
            while(i < lista.size() && !lista.get(i).getCpf().equals(cpf)) //
                i++;
            if (i < lista.size()) // não terminou
            {
                List<Usuario> lista2 = new ArrayList<>();
                lista2.add(lista.get(i));
                return ResponseEntity.ok(lista2);
            }
            return ResponseEntity.badRequest().body(new Erro("Usuário não foi encontrado!"));
        }
        else
            return ResponseEntity.badRequest().body(new Erro("Nenhum usuário cadastrado!"));
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