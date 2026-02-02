/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senac.atividade3podcast.persistence;
import java.util.List;

/**
 * Classe responsável por gerenciar a sessão do usuário logado no sistema.
 * 
 * Armazena o usuário autenticado e suas permissões,
 * permitindo verificar o perfil e o nível de acesso.
 */
public class Sessao {
    /** Usuário atualmente logado no sistema */
 private static Usuario usuarioLogado;
 /** Lista de permissões associadas ao perfil do usuário */
    private static List<String> permissoes;

     /**
     * Define o usuário logado na sessão.
     * 
     * Ao definir o usuário, também carrega as permissões
     * relacionadas ao perfil do usuário.
     *
     * @param usuario usuário autenticado
     */
    public static void setUsuarioLogado(Usuario usuario) {
        usuarioLogado = usuario;
        if (usuario != null && usuario.getPerfil() != null) {
            PerfilDAO perfilDAO = new PerfilDAO();
            permissoes = perfilDAO.listarPermissoesDoPerfil(usuario.getPerfil().getId());
        } else {
            permissoes = null;
        }
    }

     /**
     * Retorna o usuário atualmente logado.
     *
     * @return usuário logado ou null caso não exista sessão ativa
     */
    public static Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    /**
     * Verifica se existe um usuário logado.
     *
     * @return true se houver usuário logado, false caso contrário
     */
    public static boolean isLogado() {
        return usuarioLogado != null;
    }

     /**
     * Verifica se o usuário logado possui perfil ADMIN.
     *
     * @return true se for administrador
     */
    public static boolean isAdmin() {
        return usuarioLogado != null
                && "ADMIN".equalsIgnoreCase(usuarioLogado.getPerfil().getNome());
    }
        
    
    /**
     * Verifica se o usuário logado possui perfil OPERADOR.
     *
     * @return true se for operador
     */
    public static boolean isOperador() {
        return usuarioLogado != null && "OPERADOR".equalsIgnoreCase(usuarioLogado.getPerfil().getNome());
    }

    
    /**
     * Verifica se o usuário logado possui perfil USUARIO.
     *
     * @return true se for usuário comum
     */
    public static boolean isUsuario() {
        return usuarioLogado != null && "USUARIO".equalsIgnoreCase(usuarioLogado.getPerfil().getNome());
    }

    /**
     * Verifica se o usuário possui uma permissão específica.
     *
     * @param nomePermissao nome da permissão
     * @return true se o usuário possuir a permissão
     */
    public static boolean temPermissao(String nomePermissao) {
        return permissoes != null && permissoes.contains(nomePermissao.toUpperCase());
    }

    /**
     * Retorna a lista de permissões do usuário logado.
     *
     * @return lista de permissões
     */
    public static List<String> getPermissoes() {
        return permissoes;
    }

     /**
     * Encerra a sessão do usuário.
     * 
     * Remove o usuário logado e suas permissões.
     */
    public static void logout() {
        usuarioLogado = null;
        permissoes = null;
    }
}
