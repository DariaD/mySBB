package com.jpa.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by Дарья on 05.03.2015.
 */

@Entity
@Table(name = "schedule")
@NamedQuery(name = "StopStation.getAll", query = "SELECT c from Schedule  c")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idSchedule;

    @Column(name = "DateFrom")
    private Date dateFrom;
    @Column(name = "DateTo")
    private Date dateTo;

    @Column(name = "AvPlaces")
    private int avPlaces;


    public Schedule() {}


    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date date) {
        this.dateFrom = date;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date date) {
        this.dateTo = date;
    }

    public int getAvPlaces() {
        return avPlaces;
    }

    public void setAvPlaces(int avPlaces) {
        if(avPlaces <= this.train.getPlases()) {
            this.avPlaces = avPlaces;
        } else {
            //FIXME: add exception here
            System.err.println("Train has only " + this.train.getPlases() + " places.");
            System.err.println("Number of free places can't be more then number of all places in the train.");
        }
    }

    public long getId() {
        return idSchedule;
    }

    @Override
    public String toString() {
        return "Train{" +
                "id =" + idSchedule +
                ", Train = '" + train.toString() +
                ", Station From = '" + stationFrom.toString() +
                ", Date = '" + dateFrom.toString() +
                ", Station To = '" + stationTo.toString() +
                ", Date = '" + dateTo.toString() +
                ", Available places = '" + avPlaces +
                '}';
    }


    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "idTrain", nullable = false)
    private Train train;

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "idStationFrom", nullable = false)
    private Station stationFrom;

    public Station getStationFrom() {
        return stationFrom;
    }

    public void setStationFrom(Station station) {
        this.stationFrom = station;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "idStationTo", nullable = false)
    private Station stationTo;

    public Station getStationTo() {
        return stationTo;
    }

    public void setStationTo(Station station) {
        this.stationTo = station;
    }

    public String recordAsSearchResult(){
        String res = String.format("Train %s %s, FROM: %s TO %s DEPARTURE: %s,ARRIVE: %s,NUMBER OF FREE PLACES: %s",
           idSchedule, train.getName(), stationFrom.getName(), stationTo.getName(), dateFrom.toString(), dateTo.toString(), avPlaces);

        return res;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "scheduleRecord")
    private Set<Ticket> tickets;

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }
}
