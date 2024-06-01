package br.edu.ifsp.domain.model.appointment;

public class Payment {
    private int id;
    private String paymentMethod;
    private  PaymentStatus paymentStatus;

    public Payment(int id, String paymentMethod, PaymentStatus paymentStatus) {
        this.id = id;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String toString() {
        return " \n Id=" + id +'\n'+
                ", Method='" + paymentMethod + '\n' +
                ", Status=" + paymentStatus +
                '}';
    }
}
