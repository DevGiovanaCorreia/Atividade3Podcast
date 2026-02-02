
package br.com.senac.atividade3podcast.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.util.List;


/**
 * Classe DAO responsável pelo acesso aos dados da entidade Usuario.
 * 
 * Contém métodos para salvar usuários no banco de dados
 * e autenticar usuários a partir do login e senha.
 */
public class UsuarioDAO {
    /** 
     * Fábrica de EntityManager utilizada para criar conexões com o banco.
     */
   private EntityManagerFactory emf = Persistence.createEntityManagerFactory("PODCAST");

   /**
     * Salva um usuário no banco de dados.
     *
     * @param usuario objeto Usuario que será persistido
     */
    public void salvar(Usuario usuario) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();
        em.close();
    }
   
   /**
     * Autentica um usuário no sistema a partir do login e senha.
     *
     * @param login login informado pelo usuário
     * @param senha senha informada pelo usuário
     * @return Usuario autenticado caso os dados estejam corretos,
     *         ou null se não encontrar o usuário
     */
public Usuario autenticar(String login, String senha)
    { EntityManager em = emf.createEntityManager(); 
try { TypedQuery<Usuario> query = em.createQuery( "SELECT u FROM Usuario u WHERE "
        + "u.login = :login AND u.senha = :senha", Usuario.class ); 
query.setParameter("login", login); query.setParameter("senha", senha);
List<Usuario> resultado = query.getResultList();
if (!resultado.isEmpty()) { return resultado.get(0); } 
} catch (Exception e) { e.printStackTrace(); } finally { em.close(); } return null; }
   
}


   

    

 

        
        


 
    
   
    

