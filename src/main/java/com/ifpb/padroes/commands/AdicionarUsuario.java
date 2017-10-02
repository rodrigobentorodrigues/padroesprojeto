package com.ifpb.padroes.commands;

import com.ifpb.padroes.daos.GerenciadorUsuario;
import com.ifpb.padroes.entidades.Usuario;
import com.ifpb.padroes.enums.Papel;
import com.ifpb.padroes.interfaces.Command;
import com.ifpb.padroes.interfaces.UsuarioDao;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//
public class AdicionarUsuario implements Command {

    @EJB
    private UsuarioDao dao;

    @Override
    public void execute(HttpServletRequest requisicao, HttpServletResponse resposta) {
        String nome = requisicao.getParameter("nome");
        String email = requisicao.getParameter("email");
        String senha = requisicao.getParameter("senha");
        int matricula = Integer.parseInt(requisicao.getParameter("matricula"));
        Papel papel = Enum.valueOf(Papel.class, requisicao.getParameter("papel"));
        Usuario usuario = new Usuario(nome, email, senha, matricula, papel);
        dao.adicionar(usuario);
        try {
            resposta.sendRedirect("frontController?comando=GerenciarUsuarios");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
