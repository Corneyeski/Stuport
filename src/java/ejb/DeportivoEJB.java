/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entities.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 *
 * @author Alan
 */
@Stateless
public class DeportivoEJB {

    @PersistenceUnit
    EntityManagerFactory emf;
    
    public boolean existUser(String n,String p) {
        EntityManager em = emf.createEntityManager();
        Usuario encontrado = em.find(Usuario.class, n);
        em.close();
        return encontrado != null;
    }
    
    public boolean insertUser(Usuario u) {
        if (!existUser(u.getNombre(), null)) {
            EntityManager em = emf.createEntityManager();
            em.persist(u);
//        em.flush();   Para forzar que se haga ahora
            em.close();
            return true;
        }
        return false;
    }
}
