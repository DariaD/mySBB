package com.jpa.servises;

import com.jpa.entity.Ticket;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Дарья on 09.03.2015.
 */
public class TicketServices {

    public EntityManager em = Persistence.createEntityManagerFactory("COLIBRI").createEntityManager();

    public Ticket add(Ticket stopStation){
        em.getTransaction().begin();
        Ticket trainFromDB = em.merge(stopStation);
        em.getTransaction().commit();
        return trainFromDB;
    }

    public void delete(long id){
        em.getTransaction().begin();
        em.remove(get(id));
        em.getTransaction().commit();
    }

    public Ticket get(long id){
        return em.find(Ticket.class, id);
    }

    public void update(Ticket stopStation){
        em.getTransaction().begin();
        em.merge(stopStation);
        em.getTransaction().commit();
    }

    public List<Ticket> getAll(){
        TypedQuery<Ticket> namedQuery = em.createNamedQuery("Ticket.getAll", Ticket.class);
        return namedQuery.getResultList();
    }
}
