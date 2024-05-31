package br.edu.ifsp.domain.model.consulta;

import br.edu.ifsp.domain.model.appointment.Payment;
import br.edu.ifsp.domain.model.client.Pet;
import br.edu.ifsp.domain.model.user.Veterinarian;

import java.time.LocalDateTime;

public class ConsultaService {
    private ConsultaRepository consultaRepository;

    public ConsultaService(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }

    public void agendarConsulta(LocalDateTime data, LocalDateTime hora, String historico, Veterinarian veterinario, Pet pet, Payment payment, double value) {
        Consulta consulta = ConsultaFactory.createConsulta(data, hora, historico, veterinario, pet, StatusConsulta.AGENDADA, payment, value);
        consultaRepository.save(consulta);
    }

    public Consulta buscarConsultaPorId(int id) {
        return consultaRepository.findById(id);
    }

    public void cancelarConsulta(int id) {
        Consulta consulta = consultaRepository.findById(id);
        if (consulta != null && consulta.getStatus() != StatusConsulta.CANCELADA) {
            consulta.setStatus(StatusConsulta.CANCELADA);
            consultaRepository.save(consulta);
        } else {
            throw new IllegalArgumentException("Consulta não encontrada ou já cancelada.");
        }
    }

    public void marcarConsultaComoRealizada(int id) {
        Consulta consulta = consultaRepository.findById(id);
        if (consulta != null && consulta.getStatus() == StatusConsulta.AGENDADA) {
            consulta.setStatus(StatusConsulta.REALIZADA);
            consultaRepository.save(consulta);
        } else {
            throw new IllegalArgumentException("Consulta não encontrada ou não pode ser marcada como realizada.");
        }
    }

    public void atualizarPagamento(int id, Payment payment) {
        Consulta consulta = consultaRepository.findById(id);
        if (consulta != null) {
            consulta.setPayment(payment);
            consultaRepository.save(consulta);
        } else {
            throw new IllegalArgumentException("Consulta não encontrada.");
        }
    }
}
