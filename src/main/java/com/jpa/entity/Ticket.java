package com.jpa.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Дарья on 08.03.2015.
 */

@Entity
@Table(name = "ticket")
@NamedQuery(name = "Ticket.getAll", query = "SELECT c from Ticket  c")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idTicket;

    public Ticket() {}

    public long getId() {
        return idTicket;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + idTicket +
                "User =" + user.toString() +
                "Train =" + scheduleRecord.toString() +
                '}';
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "IdSchedule", nullable = false)
    private Schedule scheduleRecord;

    public Schedule getSchedule() {
        return scheduleRecord;
    }

    public void setSchedule(Schedule scheduleRecord) {
        this.scheduleRecord = scheduleRecord;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "idUser", nullable = false)
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
