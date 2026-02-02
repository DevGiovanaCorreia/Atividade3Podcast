
package br.com.senac.atividade3podcast.persistence;
import jakarta.persistence.*;
import java.sql.Time;


/**
 * Entidade que representa um podcast no sistema.
 * 
 * Armazena informações sobre o episódio, como nome,
 * número do episódio, produtor, duração e URL.
 */
@Entity
@Table(name = "podcast")

public class Podcast {
    /**
     * Identificador único do podcast.
     * Gerado automaticamente pelo banco de dados.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

     /**
     * Nome do produtor do podcast.
     */
    @Column(length = 50)
    private String produtor;

    /**
     * Nome do episódio do podcast.
     */
    @Column(name = "nomeEpisodio", length = 100, nullable = false)
    private String nomeEpisodio;

    /**
     * Número do episódio.
     */
    @Column(name = "NumeroEpisodio")
    private int numeroEpisodio;

    /**
     * Duração do episódio.
     * 
     * Armazenada no banco como TIME.
     */
    @Column(nullable = false)
    private Time duracao; 

     /**
     * URL de acesso ao podcast.
     */
    @Column(length = 100)
    private String url;

     /** @return identificador do podcast */
    public int getId() { return id; }
    /** @param id identificador do podcast */
    public void setId(int id) { this.id = id; }

     /** @return nome do produtor */
    public String getProdutor() { return produtor; }
     /** @param produtor nome do produtor */
    public void setProdutor(String produtor) { this.produtor = produtor; }

      /** @return nome do episódio */
    public String getNomeEpisodio() { return nomeEpisodio; }
     /** @param nomeEpisodio nome do episódio */
    public void setNomeEpisodio(String nomeEpisodio) { this.nomeEpisodio = nomeEpisodio; }

    /** @return número do episódio */
    public int getNumeroEpisodio() { return numeroEpisodio; }
    /** @param numeroEpisodio número do episódio */
    public void setNumeroEpisodio(int numeroEpisodio) { this.numeroEpisodio = numeroEpisodio; }

     /** @return duração do episódio */
    public Time getDuracao() { return duracao; }
     /** @param duracao duração do episódio */
    public void setDuracao(Time duracao) { this.duracao = duracao; }

    /** @return URL do podcast */
    public String getUrl() { return url; }
    /** @param url URL do podcast */
    public void setUrl(String url) { this.url = url; }
    
    
}
