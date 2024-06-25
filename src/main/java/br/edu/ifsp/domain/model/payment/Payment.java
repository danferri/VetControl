package br.edu.ifsp.domain.model.payment;

import br.edu.ifsp.domain.model.appointment.Appointment;
import br.edu.ifsp.domain.model.payment.PaymentStatus;

public class Payment {
    private int id;
    private Appointment appointment;
    private String method;
    private PaymentStatus status;
    private double amount;

    public Payment(int id, Appointment appointment, String method, double amount) {
        this.id = id;
        this.appointment = appointment;
        this.method = method;
        this.status = PaymentStatus.PENDENTE;
        this.amount = amount;
    }

    public Payment(Appointment appointment, String method, double amount) {
        this.appointment = appointment;
        this.method = method;
        this.status = PaymentStatus.PENDENTE;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }


    public String toString() {
        return String.valueOf(id);
    }
}
