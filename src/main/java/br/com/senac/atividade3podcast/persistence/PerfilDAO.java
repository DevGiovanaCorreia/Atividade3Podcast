
package br.com.senac.atividade3podcast.persistence;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.util.List;


/**
 * Classe DAO responsável pelo acesso aos dados relacionados
 * à entidade Perfil e suas permissões.
 * 
 * Contém métodos para verificação e listagem de permissões
 * associadas a um perfil.
 */
public class PerfilDAO {
     /**
     * Fábrica de EntityManager utilizada para criar conexões com o banco.
     */
     private EntityManagerFactory emf = Persistence.createEntityManagerFactory("PODCAST");

    /**
     * Verifica se o perfil do usuário possui uma permissão específica.
     *
     * @param usuario usuário que terá a permissão verificada
     * @param nomePermissao nome da permissão
     * @return true se o perfil possuir a permissão, false caso contrário
     */
    public boolean temPermissao(Usuario usuario, String nomePermissao) {
        if (usuario == null || usuario.getPerfil() == null) {
            return false;
        }

        EntityManager em = emf.createEntityManager();
        try {
          
            TypedQuery<Long> query = em.createQuery(
                "SELECT COUNT(p) FROM Perfil perf JOIN perf.permissoes p " +
                "WHERE perf.id = :perfilId AND p.nome = :nomePermissao", Long.class
            );
            query.setParameter("perfilId", usuario.getPerfil().getId());
            query.setParameter("nomePermissao", nomePermissao);

            Long count = query.getSingleResult();
            return count != null && count > 0;

        } finally {
            em.close();
        }
    }
    
     /**
     * Lista todas as permissões associadas a um perfil.
     *
     * @param perfilId identificador do perfil
     * @return lista com os nomes das permissões do perfil
     */
    public List<String> listarPermissoesDoPerfil(int perfilId) {
    EntityManager em = JPAUtil.getEntityManager();
    try {
        return em.createQuery(
                "SELECT p.nome FROM PerfilPermissao pp JOIN pp.permissao p WHERE pp.perfil.id = :id",
                String.class)
            .setParameter("id", perfilId)
            .getResultList();
    } finally {
        em.close();
    }
}
}
