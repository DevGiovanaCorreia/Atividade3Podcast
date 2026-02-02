
package br.com.senac.atividade3podcast.persistence;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Classe utilitária responsável por gerenciar a criação
 * e o fechamento do EntityManager e do EntityManagerFactory.
 * 
 * Centraliza o acesso à unidade de persistência do sistema.
 */
public class JPAUtil {
    
     /**
     * Nome da unidade de persistência definida no persistence.xml.
     */
    private static final String PERSISTENCE_UNIT = "PODCAST";
    
    /** EntityManager utilizado na aplicação */
    private static EntityManager em;
    
     /** EntityManagerFactory responsável por criar EntityManagers */
    private static EntityManagerFactory fabrica;
    
    
    /**
     * Retorna uma instância de EntityManager.
     * 
     * Caso não exista ou esteja fechada, cria uma nova instância.
     *
     * @return EntityManager ativo
     */
    public static EntityManager getEntityManager(){
        if(fabrica == null || !fabrica.isOpen())
            fabrica = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        
        if(em == null || !em.isOpen()) 
            em = fabrica.createEntityManager();

        return em;
    }
    
    
    /**
     * Fecha o EntityManager e o EntityManagerFactory.
     */
    public static void closeEtityManager(){
        if(em.isOpen() && em != null){
            em.close();
            fabrica.close();
        }}
    }


