package br.edu.ifsp.domain.model.appointment;

import br.edu.ifsp.domain.model.client.Pet;
import br.edu.ifsp.domain.model.user.Veterinarian;

import java.time.LocalDateTime;

public class Appointment {
    private LocalDateTime date;
    private LocalDateTime time;
    private String history;
    private Veterinarian veterinarian;
    private Pet pet;
    private AppointmentStatus status;
    private Payment payment;
    private double value;

    public Appointment(LocalDateTime date, LocalDateTime time, String history, Veterinarian veterinarian, Pet pet, AppointmentStatus status, Payment payment, double value) {
        this.date = date;
        this.time = time;
        this.history = history;
        this.veterinarian = veterinarian;
        this.pet = pet;
        this.status = status;
        this.payment = payment;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "date=" + date +
                ", time=" + time +
                ", history='" + history + '\'' +
                ", veterinarian=" + veterinarian +
                ", pet=" + pet +
                ", status=" + status +
                ", payment=" + payment +
                ", value=" + value +
                '}';
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Veterinarian getVeterinarian(

    ) {return veterinarian;
    }
}
