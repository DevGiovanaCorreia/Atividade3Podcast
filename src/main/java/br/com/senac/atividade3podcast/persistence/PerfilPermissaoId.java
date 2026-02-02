/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senac.atividade3podcast.persistence;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Classe que representa a chave composta da entidade PerfilPermissao.
 * 
 * Utilizada para mapear o relacionamento muitos-para-muitos
 * entre Perfil e Permissao.
 */
@Embeddable
class PerfilPermissaoId implements Serializable{
     /**
     * Identificador do perfil.
     */
    private int perfilId;
    /**
     * Identificador da permissão.
     */
    private int permissaoId;

     /**
     * Construtor padrão.
     */
    public PerfilPermissaoId() {}

      /**
     * Construtor com os identificadores.
     *
     * @param perfilId identificador do perfil
     * @param permissaoId identificador da permissão
     */
    public PerfilPermissaoId(int perfilId, int permissaoId) {
        this.perfilId = perfilId;
        this.permissaoId = permissaoId;
    }

     /** @return identificador do perfil */
    public int getPerfilId() { return perfilId; }
    /** @param perfilId identificador do perfil */
    public void setPerfilId(int perfilId) { this.perfilId = perfilId; }

     /** @return identificador da permissão */
    public int getPermissaoId() { return permissaoId; }
     /** @param permissaoId identificador da permissão */
    public void setPermissaoId(int permissaoId) { this.permissaoId = permissaoId; }

    
     /**
     * Compara dois objetos PerfilPermissaoId.
     *
     * @param o objeto a ser comparado
     * @return true se forem iguais
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PerfilPermissaoId)) return false;
        PerfilPermissaoId that = (PerfilPermissaoId) o;
        return perfilId == that.perfilId && permissaoId == that.permissaoId;
    }

    /**
     * Gera o hash do objeto.
     *
     * @return valor do hash
     */
    @Override
    public int hashCode() {
        return Objects.hash(perfilId, permissaoId);
    }
}
