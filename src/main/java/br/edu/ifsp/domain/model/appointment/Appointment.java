package br.edu.ifsp.domain.model.appointment;

import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {
    private int id;
    private LocalDate date;
    private LocalTime time;
    private int value;

    public Appointment(int id, LocalDate date, LocalTime time, int value) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", date=" + date +
                ", time=" + time +
                ", value=" + value +
                '}';
    }
}
