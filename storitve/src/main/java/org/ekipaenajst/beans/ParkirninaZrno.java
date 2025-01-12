package org.ekipaenajst.beans;

import com.kumuluz.ee.rest.beans.QueryParameters;
import com.kumuluz.ee.rest.utils.JPAUtils;
import org.ekipaenajst.entitete.Parkirnina;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ParkirninaZrno {

    @PersistenceContext(unitName = "external-jpa")
    private EntityManager em;

    @Transactional // DEBUG
    public List<Parkirnina> getParkirnine(QueryParameters query) {

        System.out.println(query.getFields());
        System.out.println(query.getFilters());

        //Query q = em.createNamedQuery("Uporabnik.findAll", Uporabnik.class);

        List<Parkirnina> parkirnine = JPAUtils.queryEntities(em, Parkirnina.class, query);
        return parkirnine;

        //List<Uporabnik> resultList = (List<Uporabnik>)q.getResultList();

        //return resultList;
    }

    @Transactional //DEBUG
    public Parkirnina getParkirninaById(int id) {
        Query q = em.createNamedQuery("Parkirnina.findId", Parkirnina.class);
        q.setParameter("idParam", id);

        List<Parkirnina> resultList = (List<Parkirnina>)q.getResultList();

        return resultList.isEmpty() ? null : resultList.get(0);
    }

    @Transactional //DEBUG
    public List<Parkirnina> getParkirninaByAvto(int avto_id) {
        Query q = em.createNamedQuery("Parkirnina.findAvto", Parkirnina.class);
        q.setParameter("avtoParam", avto_id);

        List<Parkirnina> resultList = (List<Parkirnina>)q.getResultList();

        return resultList;
    }

    @Transactional //DEBUG
    public List<Parkirnina> getParkirninaByUser(int user_id) {
        Query q = em.createNamedQuery("Parkirnina.findUser", Parkirnina.class);
        q.setParameter("userParam", user_id);

        List<Parkirnina> resultList = (List<Parkirnina>)q.getResultList();

        return resultList;
    }

    @Transactional
    public void updateParkirnina(Parkirnina parkirnine) {

        em.merge(parkirnine);

    }
    @Transactional
    public void deleteParkirnina(Parkirnina parkirnine) {

        Parkirnina p = em.find(Parkirnina.class, parkirnine.getId());
        em.remove(p);
    }

    @Transactional
    public Parkirnina createParkirnina(Parkirnina parkirnina) {

        try {

            em.persist(parkirnina); //ni važn a se podvajajo, ni treba preverjat
            return parkirnina;
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println("Creating not work");
        }

        return null;

    }
}
