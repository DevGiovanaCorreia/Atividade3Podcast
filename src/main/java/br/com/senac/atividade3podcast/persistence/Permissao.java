
package br.com.senac.atividade3podcast.persistence;
import jakarta.persistence.*;
import java.sql.Timestamp;


/**
 * Entidade que representa uma permissão do sistema.
 * 
 * As permissões definem as ações que podem ser realizadas
 * pelos usuários, de acordo com o perfil associado.
 */
@Entity
@Table(name = "permissao")


public class Permissao {
    
     /**
     * Identificador único da permissão.
     * Gerado automaticamente pelo banco de dados.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

      /**
     * Nome da permissão.
     * Deve ser único no sistema.
     */
    @Column(nullable = false, unique = true)
    private String nome;

     /**
     * Status da permissão.
     * Pode indicar se está ativa ou inativa.
     */
    private int status; 

    /**
     * Data e hora de criação da permissão.
     */
    private Timestamp timecreated;
     /**
     * Data e hora da última modificação da permissão.
     */
    private Timestamp timemodified;

    
     /** @return identificador da permissão */
    public int getId() { return id; }
     /** @param id identificador da permissão */
    public void setId(int id) { this.id = id; }

     /** @return nome da permissão */
    public String getNome() { return nome; }
      /** @param nome nome da permissão */
    public void setNome(String nome) { this.nome = nome; }

     /** @return status da permissão */
    public int getStatus() { return status; }
      /** @param status status da permissão */
    public void setStatus(int status) { this.status = status; }

      /** @return data e hora de criação */
    public Timestamp getTimecreated() { return timecreated; }
    /** @param timecreated data e hora de criação */
    public void setTimecreated(Timestamp timecreated) { this.timecreated = timecreated; }

     /** @return data e hora da última modificação */
    public Timestamp getTimemodified() { return timemodified; }
    /** @param timemodified data e hora da última modificação */
    public void setTimemodified(Timestamp timemodified) { this.timemodified = timemodified; }
}
