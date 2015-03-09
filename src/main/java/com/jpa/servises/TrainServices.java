package com.jpa.servises;

import com.jpa.entity.Train;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Дарья on 05.03.2015.
 */
public class TrainServices {

        public EntityManager em = Persistence.createEntityManagerFactory("COLIBRI").createEntityManager();

        public Train add(Train train){
            em.getTransaction().begin();
            Train trainFromDB = em.merge(train);
            em.getTransaction().commit();
            return trainFromDB;
        }

        public void delete(long id){
            em.getTransaction().begin();
            em.remove(get(id));
            em.getTransaction().commit();
        }

        public Train get(long id){
            return em.find(Train.class, id);
        }

        public void update(Train train){
            em.getTransaction().begin();
            em.merge(train);
            em.getTransaction().commit();
        }

        public List<Train> getAll(){
            TypedQuery<Train> namedQuery = em.createNamedQuery("Train.getAll", Train.class);
            return namedQuery.getResultList();
        }

    }
