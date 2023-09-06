package com.victorvilar.projetoempresa.domain;

import com.victorvilar.projetoempresa.enums.Schedule;
import com.victorvilar.projetoempresa.enums.Weekday;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Class that represents the frequency of collection of an item. Itens have different needs of collection.
 * For instance an itemContract service must have to be execute every monday, tuesday and friday, or may be every saturday once a week, or
 * once a month on a wednesday. So, this class represent these infinite possibilities that may exist
 * It has a list of days, that can be from sunday to saturday
 * also has a frequency, it will be daily, weekly, monthly  etc.?
 * @author Victor Vilar
 *
 */
@Entity
public class CollectionFrequency implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ElementCollection(targetClass = Weekday.class)
    @CollectionTable(name = "collection_frequency_weekdays")
    @Enumerated(EnumType.ORDINAL)
    private Set<Weekday> days = new HashSet<>();

    @Enumerated(EnumType.ORDINAL) //
    private Schedule schedule;


    public CollectionFrequency() {
    }

    public CollectionFrequency(Long id, Set<Weekday> days, Schedule schedule) {
        this.id = id;
        this.days = days;
        this.schedule = schedule;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Weekday> getDays() {
        return days;
    }

    public void setDays(Set<Weekday> days) {
        this.days = days;
    }

    public Schedule getFrequency() {
        return schedule;
    }

    public void setFrequency(Schedule schedule) {
        this.schedule = schedule;
    }


    @Override
    public String toString() {
        return "Dias de Coleta:" + days + " - Frequência: " + schedule;

    }
}
