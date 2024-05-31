package br.edu.ifsp.domain.model.consulta;

import br.edu.ifsp.domain.model.appointment.Payment;
import br.edu.ifsp.domain.model.client.Pet;
import br.edu.ifsp.domain.model.user.Veterinarian;

import java.time.LocalDateTime;

public class Consulta {
    private LocalDateTime data;
    private LocalDateTime hora;
    private String historico;
    private Veterinarian veterinario;
    private Pet animal;
    private StatusConsulta status;
    private Payment payment;
    private double value;

    public Consulta(LocalDateTime data, LocalDateTime hora, String historico, Veterinarian veterinario, Pet pet, StatusConsulta status, Payment payment, double value) {
        this.data = data;
        this.hora = hora;
        this.historico = historico;
        this.veterinario = veterinario;
        this.animal = pet;
        this.status = status;
        this.payment = payment;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Consulta{" +
                "data=" + data +
                ", hora=" + hora +
                ", historico='" + historico + '\'' +
                ", veterinario=" + veterinario +
                ", animal=" + animal +
                ", status=" + status +
                ", payment=" + payment +
                ", value=" + value +
                '}';
    }

    public StatusConsulta getStatus() {
        return status;
    }

    public void setStatus(StatusConsulta status) {
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
}
