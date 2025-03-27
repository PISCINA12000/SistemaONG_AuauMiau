package miau.auau.amigosdequatropatas.control;

import miau.auau.amigosdequatropatas.entidades.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsuarioController
{
    @Autowired
    private Usuario usuarioModel;

    public boolean onGravar(Usuario usuario)
    {
        if(validar(usuario))
            return usuarioModel.incluir(usuario);
        else
            return false;

    }
    public boolean onDelete(int id)
    {
        if(usuarioModel.consultarID(id) != null)
        {
            return usuarioModel.excluir(usuarioModel.consultarID(id));
        }
        else
            return false;
    }
    public Usuario onBuscarId(int id)
    {
        if(usuarioModel.consultarID(id) != null)
        {
            return usuarioModel.consultarID(id);
        }
        else
            return null;
    }

    public List<Usuario> onBuscar(String filtro)
    {
        if(usuarioModel.consultar(filtro) != null)
        {
            return usuarioModel.consultar(filtro);
        }
        else
            return null;
    }

    public boolean onAlterar(Usuario usuario)
    {
        if(validarAlterar(usuario))
        {
            return usuarioModel.alterar(usuario);
        }
        else
            return false;

    }
    public boolean validar(Usuario usuario)
    {

        return usuario != null &&
                !usuario.getNome().isEmpty() &&
                usuario.getEmail() != null && !usuario.getEmail().isEmpty() &&
                !usuario.getSenha().isEmpty() &&
                usuario.getTelefone().isEmpty() &&
                usuario.getCpf().isEmpty() &&
                !usuario.getPrivilegio().isEmpty() &&
                !usuario.getSexo().isEmpty() &&
                !usuario.getCep().isEmpty() &&
                !usuario.getRua().isEmpty() &&
                !usuario.getBairro().isEmpty() &&
                !usuario.getNumero().isEmpty();


    }
    public boolean validarAlterar(Usuario usuario)
    {

        return usuario != null &&
                usuario.getCodUsuario() > 0 &&
                usuario.getEmail() != null && !usuario.getEmail().isEmpty() &&
                !usuario.getSenha().isEmpty() &&
                usuario.getTelefone().isEmpty() &&
                usuario.getCpf().isEmpty() &&
                !usuario.getPrivilegio().isEmpty() &&
                !usuario.getSexo().isEmpty() &&
                !usuario.getCep().isEmpty() &&
                !usuario.getRua().isEmpty() &&
                !usuario.getBairro().isEmpty() &&
                !usuario.getNumero().isEmpty();

    }
}
