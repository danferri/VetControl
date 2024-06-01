package br.edu.ifsp.domain.model.appointment;

import br.edu.ifsp.domain.model.payment.PaymentStatus;

public class Payment {
    private int id;
    private String method;
    private PaymentStatus status;
    private double amount;

    public Payment(int id, String method, PaymentStatus status, double amount) {
        this.id = id;
        this.method = method;
        this.status = status;
        this.amount = amount;
    }

    public int getId() {
        return id;
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

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", method='" + method + '\'' +
                ", status=" + status +
                ", amount=" + amount +
                '}';
    }
}
