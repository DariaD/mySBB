package com.jpa.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Дарья on 05.03.2015.
 */

@Entity
@Table(name = "stopstation")
@NamedQuery(name = "StopStation.getAll", query = "SELECT c from StopStation  c")
public class StopStation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idStop;

    @Column(name = "Date")
    private Date date;

    @Column(name = "AvPlases")
    private int avPlases;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "idTrain", nullable = false)
    private Train train;

    public Train getTrain() {
        return train;
    }

    public void setBook(Train train) {
        this.train = train;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "idStation", nullable = false)
    private Station station;

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }





}
