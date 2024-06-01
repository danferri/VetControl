package br.edu.ifsp.domain.usecases.payment;

import br.edu.ifsp.domain.model.appointment.Appointment;
import br.edu.ifsp.domain.model.appointment.AppointmentRepository;


public class ProcessPaymentUseCase {
    private final AppointmentRepository consultaRepository;

    public ProcessPaymentUseCase(AppointmentRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }

    public void ProcessPayment(int id, Payment payment) {
        Appointment consulta = consultaRepository.findById(id);
        if (consulta != null) {
            consulta.setPayment(payment);
            consultaRepository.save(consulta);
        } else {
            throw new IllegalArgumentException("Appointment não encontrada.");
        }
    }
}
