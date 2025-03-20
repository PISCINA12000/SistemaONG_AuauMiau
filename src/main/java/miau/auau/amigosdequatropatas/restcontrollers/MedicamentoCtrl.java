package miau.auau.amigosdequatropatas.restcontrollers;

import miau.auau.amigosdequatropatas.Entidades.Erro;
import miau.auau.amigosdequatropatas.Entidades.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "apis/medicamento")
public class MedicamentoCtrl
{
    @GetMapping(value = "busca_usuario")
    public ResponseEntity<Object> getUsuario()
    {
        List<Usuario> usuarioList=new ArrayList<>();
        Biblioteca biblioteca = new Biblioteca();
        usuarioList=biblioteca.getByAuthor(autor);
        if(usuarioList.size()>0)
            return ResponseEntity.ok(usuarioList);
        else
            return ResponseEntity.badRequest().body(new Erro("Não existe nenhum usuario cadastrado."));
    }

    @GetMapping(value = "busca_usuario2")
    public ResponseEntity<Object> getUsuario(String usuario)
    {
        Usuario usuario=new Usuario();
        if(usuario!=null)
            return ResponseEntity.ok(usuario);
        else
            return ResponseEntity.badRequest().body(new Erro("Não existe nenhum usuario cadastrado."));
    }

    @PostMapping(value = "ad_usuario")
    public ResponseEntity<Object> gravarUsuario(@RequestBody Usuario usuario)
    {
        biblioteca.adicionarLivro(usuario);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping(value = "excluir_usuario")
    public ResponseEntity<Object> excluirUsuario(int id)
    {
        String nome = "";

        return ResponseEntity.ok("O usuario"+ nome +" foi excluido com sucesso!");
    }

    @PutMapping(value = "atualizar_usuario")
    public ResponseEntity<Object> atualizarUsuario(@RequestBody Usuario usuario)
    {

    }
}
