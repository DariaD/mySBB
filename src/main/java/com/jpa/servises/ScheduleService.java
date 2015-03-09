package com.jpa.servises;

import com.jpa.entity.Schedule;
import com.jpa.entity.Schedule;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Дарья on 06.03.2015.
 */
public class ScheduleService {


    public EntityManager em = Persistence.createEntityManagerFactory("COLIBRI").createEntityManager();

    public Schedule add(Schedule stopStation){
        em.getTransaction().begin();
        Schedule trainFromDB = em.merge(stopStation);
        em.getTransaction().commit();
        return trainFromDB;
    }

    public void delete(long id){
        em.getTransaction().begin();
        em.remove(get(id));
        em.getTransaction().commit();
    }

    public Schedule get(long id){
        return em.find(Schedule.class, id);
    }

    public void update(Schedule stopStation){
        em.getTransaction().begin();
        em.merge(stopStation);
        em.getTransaction().commit();
    }

    public List<Schedule> getAll(){
        TypedQuery<Schedule> namedQuery = em.createNamedQuery("StopStation.getAll", Schedule.class);
        return namedQuery.getResultList();
    }

}
