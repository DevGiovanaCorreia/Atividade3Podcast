
package br.com.senac.atividade3podcast.persistence;
import jakarta.persistence.*;



/**
 * Entidade que representa um usuário do sistema.
 * 
 * Cada usuário possui um nome, login único, senha
 * e está associado a um perfil que define suas permissões.
 */


@Entity
@Table(name = "usuario")
public class Usuario {
    
     /**
     * Identificador único do usuário.
     * Gerado automaticamente pelo banco de dados.
     */
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

     /**
     * Nome do usuário.
     */
    @Column(nullable = false, length = 30)
    private String nome;

     /**
     * Login do usuário.
     * Deve ser único no sistema.
     */
    @Column(nullable = false, length = 100, unique = true)
    private String login;

    
     /**
     * Senha do usuário.
     */
    @Column(nullable = false, columnDefinition = "TEXT")
    private String senha;

      /**
     * Perfil associado ao usuário.
     * Define o nível de acesso e permissões.
     */
    @ManyToOne
    @JoinColumn(name = "perfil_id", nullable = false)
    private Perfil perfil; 

     /** @return identificador do usuário */
    public int getId() { return id; }
     /** @param id identificador do usuário */
    public void setId(int id) { this.id = id; }

     /** @return nome do usuário */
    public String getNome() { return nome; }
    /** @param nome nome do usuário */
    public void setNome(String nome) { this.nome = nome; }

     /** @return login do usuário */
    public String getLogin() { return login; }
     /** @param login login do usuário */
    public void setLogin(String login) { this.login = login; }

   /** @return senha do usuário */  
    public String getSenha() { return senha; }
      /** @param senha senha do usuário */
    public void setSenha(String senha) { this.senha = senha; }

     /** @return perfil associado ao usuário */
    public Perfil getPerfil() { return perfil; }
    /** @param perfil perfil associado ao usuário */
    public void setPerfil(Perfil perfil) { this.perfil = perfil; }
}

