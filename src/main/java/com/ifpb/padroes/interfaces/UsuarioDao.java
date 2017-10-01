
package com.ifpb.padroes.interfaces;

import com.ifpb.padroes.entidades.Usuario;
import java.util.List;

public interface UsuarioDao{

    void adicionar(Usuario usuario);
    void remover(Usuario usuario);
    void atualizar(Usuario usuario);
    Usuario buscaPorId(int id);
    List<Usuario> listarTodos();
    
}
