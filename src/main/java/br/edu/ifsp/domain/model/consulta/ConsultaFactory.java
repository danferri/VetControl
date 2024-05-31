package br.edu.ifsp.domain.model.consulta;

import br.edu.ifsp.domain.model.appointment.Payment;
import br.edu.ifsp.domain.model.client.Pet;
import br.edu.ifsp.domain.model.consulta.Consulta;
import br.edu.ifsp.domain.model.consulta.StatusConsulta;
import br.edu.ifsp.domain.model.user.Veterinarian;

import java.time.LocalDateTime;

public class ConsultaFactory {
    public static Consulta createConsulta(LocalDateTime data, LocalDateTime hora, String historico, Veterinarian veterinario, Pet pet, StatusConsulta status, Payment payment, double value) {
        return new Consulta(data, hora, historico, veterinario, pet, status, payment, value);
    }
}
