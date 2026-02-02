/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senac.atividade3podcast.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Classe DAO responsável pelo acesso aos dados da entidade Podcast.
 * 
 * Contém métodos para cadastro, listagem, verificação de existência,
 * exclusão de podcasts e preenchimento de tabelas na interface gráfica.
 */
public class PodcastDAO {
    /**
     * Fábrica de EntityManager utilizada para criar conexões com o banco.
     */
   private EntityManagerFactory emf = Persistence.createEntityManagerFactory("PODCAST");

    /**
     * Cadastra um novo podcast no banco de dados.
     *
     * @param podcast objeto Podcast que será persistido
     */
    public void cadastrar(Podcast podcast) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(podcast);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }
    }

    
    /**
     * Lista todos os podcasts cadastrados no sistema.
     *
     * @return lista de podcasts
     */
    public List<Podcast> listar() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT p FROM Podcast p", Podcast.class).getResultList();
        } finally {
            em.close();
        }
    }

  
    /**
     * Lista os podcasts filtrados pelo produtor.
     *
     * @param produtor nome do produtor
     * @return lista de podcasts do produtor informado
     */
    public List<Podcast> listarPorProdutor(String produtor) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT p FROM Podcast p WHERE p.produtor = :produtor", Podcast.class)
                     .setParameter("produtor", produtor)
                     .getResultList();
        } finally {
            em.close();
        }
    }

   
     /**
     * Verifica se já existe um podcast cadastrado com o mesmo
     * nome de episódio e produtor.
     *
     * @param nomeEpisodio nome do episódio
     * @param produtor nome do produtor
     * @return true se o podcast já existir, false caso contrário
     */
    public boolean existePodcast(String nomeEpisodio, String produtor) {
        EntityManager em = emf.createEntityManager();
        try {
            Long count = em.createQuery(
                    "SELECT COUNT(p) FROM Podcast p WHERE p.nomeEpisodio = :nome AND p.produtor = :produtor",
                    Long.class)
                    .setParameter("nome", nomeEpisodio)
                    .setParameter("produtor", produtor)
                    .getSingleResult();
            return count > 0;
        } finally {
            em.close();
        }
    }

  
     /**
     * Exclui um podcast do banco de dados a partir do seu ID.
     *
     * @param id identificador do podcast
     */
    public void excluir(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            Podcast podcast = em.find(Podcast.class, id);
            if (podcast != null) {
                em.getTransaction().begin();
                em.remove(podcast);
                em.getTransaction().commit();
            }
        } finally {
            em.close();
        }
    }

    
   /**
     * Preenche uma tabela (JTable) com os podcasts filtrados por produtor.
     *
     * @param tabela JTable que será preenchida
     * @param produtor nome do produtor utilizado como filtro
     */
    public void preencherTabelaPorProdutor(JTable tabela, String produtor) {
        List<Podcast> lista = listarPorProdutor(produtor);
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setRowCount(0);

        for (Podcast p : lista) {
            modelo.addRow(new Object[]{
                p.getId(),
                p.getNomeEpisodio(),
                p.getProdutor(),
                p.getNumeroEpisodio(),
                p.getDuracao(),
                p.getUrl()
            });
        }
    }



   
 
   
}
