/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu.controller;

import edu.ccsu.controller.exceptions.NonexistentEntityException;
import edu.ccsu.controller.exceptions.PreexistingEntityException;
import edu.ccsu.controller.exceptions.RollbackFailureException;
import edu.ccsu.model.Animals;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceUnit;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

/**
 *
 * @author Cameron
 */
public class AnimalsJpaController implements Serializable {

    public AnimalsJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = null;
        this.utx = utx;
        this.emf = emf;
    }
    @Resource
    private UserTransaction utx;
    @PersistenceUnit(unitName="WebApplication1PU")
    private EntityManagerFactory emf = null;

    AnimalsJpaController() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    
    public void create(Animals animals) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(animals);
            utx.commit();
        } catch (NotSupportedException | SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException | IllegalStateException ex) {
            try {
                utx.rollback();
            } catch (IllegalStateException | SecurityException | SystemException re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findAnimals(animals.getId()) != null) {
                throw new PreexistingEntityException("Animals " + animals + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Animals animals) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            animals = em.merge(animals);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = animals.getId();
                if (findAnimals(id) == null) {
                    throw new NonexistentEntityException("The animals with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Animals animals;
            try {
                animals = em.getReference(Animals.class, id);
                animals.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The animals with id " + id + " no longer exists.", enfe);
            }
            em.remove(animals);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Animals> findAnimalsEntities() {
        return findAnimalsEntities(true, -1, -1);
    }

    public List<Animals> findAnimalsEntities(int maxResults, int firstResult) {
        return findAnimalsEntities(false, maxResults, firstResult);
    }

    private List<Animals> findAnimalsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Animals.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Animals findAnimals(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Animals.class, id);
        } finally {
            em.close();
        }
    }

    public int getAnimalsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Animals> rt = cq.from(Animals.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
