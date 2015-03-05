package com.jpa.servises;

import com.jpa.entity.StopStation;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Дарья on 06.03.2015.
 */
public class StopStationService {


    public EntityManager em = Persistence.createEntityManagerFactory("COLIBRI").createEntityManager();

    public StopStation add(StopStation stopStation){
        em.getTransaction().begin();
        StopStation trainFromDB = em.merge(stopStation);
        em.getTransaction().commit();
        return trainFromDB;
    }

    public void delete(long id){
        em.getTransaction().begin();
        em.remove(get(id));
        em.getTransaction().commit();
    }

    public StopStation get(long id){
        return em.find(StopStation.class, id);
    }

    public void update(StopStation stopStation){
        em.getTransaction().begin();
        em.merge(stopStation);
        em.getTransaction().commit();
    }

    public List<StopStation> getAll(){
        TypedQuery<StopStation> namedQuery = em.createNamedQuery("StopStation.getAll", StopStation.class);
        return namedQuery.getResultList();
    }

}
