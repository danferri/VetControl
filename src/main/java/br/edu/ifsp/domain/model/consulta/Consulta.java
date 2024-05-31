package br.edu.ifsp.domain.model.consulta;
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

    public Consulta(LocalDateTime data, LocalDateTime hora, String historico, Veterinarian veterinario, Pet pet, StatusConsulta status) {
        this.data = data;
        this.hora = hora;
        this.historico = historico;
        this.veterinario = veterinario;
        this.animal = pet;
        this.status = status;


    }
    public String toString() {
        return "Consult{" +
                "data'" + data + '\'' +
                ", hora='" + hora + '\'' +
                ", Veterinario='" + veterinario + '\'' +
                ", Pet='" + animal + '\'' +
                "Status='"+status+ '\''+
                "Histórico='"+ historico+ '\''+
                '}';
    }

}
