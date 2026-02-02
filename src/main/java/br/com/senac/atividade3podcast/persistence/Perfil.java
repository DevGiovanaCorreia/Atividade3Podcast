
package br.com.senac.atividade3podcast.persistence;
import jakarta.persistence.*;


/**
 * Entidade que representa um perfil de usuário no sistema.
 * 
 * O perfil define o tipo de acesso do usuário,
 * como ADMIN, OPERADOR ou USUARIO.
 */
@Entity
@Table(name = "perfil")

public class Perfil {
    
    /**
     * Identificador único do perfil.
     * Gerado automaticamente pelo banco de dados.
     */
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

   /**
     * Nome do perfil.
     * Deve ser único no sistema.
     */
    @Column(name = "nome", nullable = false, unique = true)
    private String nome;

     /**
     * Construtor padrão.
     */
    public Perfil() {}

    
    /**
     * Construtor que define o nome do perfil.
     *
     * @param nome nome do perfil
     */
    public Perfil(String nome) {
        this.nome = nome;
    }

   /** @return identificador do perfil */
    public int getId() {
        return id;
    }
  /** @param id identificador do perfil */
    public void setId(int id) {
        this.id = id;
    }

    /** @return nome do perfil */
    public String getNome() {
        return nome;
    }
 /** @param nome nome do perfil */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna uma representação textual do perfil.
     *
     * @return string com os dados do perfil
     */
    @Override
    public String toString() {
        return "Perfil{id=" + id + ", nome='" + nome + "'}";
    }  
}
