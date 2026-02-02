/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senac.atividade3podcast.persistence;
import jakarta.persistence.*;

/**
 * Entidade que representa a associação entre Perfil e Permissao.
 * 
 * Utilizada para mapear o relacionamento muitos-para-muitos
 * entre as entidades Perfil e Permissao por meio de uma
 * tabela intermediária.
 */
@Entity
@Table(name = "perfil_permissao")

public class PerfilPermissao {
    
   /**
     * Chave composta da entidade PerfilPermissao.
     * Formada pelos identificadores de Perfil e Permissao.
     */ 
  @EmbeddedId
    private PerfilPermissaoId id;

   /**
     * Perfil associado.
     */
    @ManyToOne
    @MapsId("perfilId")
    @JoinColumn(name = "perfil_id")
    private Perfil perfil;

     /**
     * Permissão associada.
     */
    @ManyToOne
    @MapsId("permissaoId")
    @JoinColumn(name = "permissao_id")
    private Permissao permissao;

      /** @return chave composta do relacionamento */
    public PerfilPermissaoId getId() { return id; }
     /** @param id chave composta do relacionamento */
    public void setId(PerfilPermissaoId id) { this.id = id; }

     /** @return perfil associado */
    public Perfil getPerfil() { return perfil; }
    /** @param perfil perfil associado */
    public void setPerfil(Perfil perfil) { this.perfil = perfil; }

      /** @return permissão associada */
    public Permissao getPermissao() { return permissao; }
     /** @param permissao permissão associada */
    public void setPermissao(Permissao permissao) { this.permissao = permissao; }  
}
