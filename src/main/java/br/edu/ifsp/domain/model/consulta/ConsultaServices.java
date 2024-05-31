package br.edu.ifsp.domain.model.consulta;

import br.edu.ifsp.domain.model.client.Pet;
import br.edu.ifsp.domain.model.user.Veterinarian;

import java.time.LocalDateTime;

public class ConsultaService {
    private ConsultaRepository consultaRepository;

    public ConsultaService(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }

    public void agendarConsulta(LocalDateTime data, LocalDateTime hora, String historico, Veterinarian veterinario, Pet animal) {
        Consulta consulta = ConsultaFactory.createConsulta(data, hora, historico, veterinario, animal, StatusConsulta.AGENDADA);
        consultaRepository.save(consulta);
    }

    public Consulta buscarConsultaPorId(int id) {
        return consultaRepository.findById(id);
    }
}
