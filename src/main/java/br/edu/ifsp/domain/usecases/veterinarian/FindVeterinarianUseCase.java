package br.edu.ifsp.domain.usecases.veterinarian;

import br.edu.ifsp.domain.model.user.Veterinarian;
import br.edu.ifsp.domain.model.user.VeterinarianRepository;

public class FindVeterinarianUseCase {
    private VeterinarianRepository veterinarianRepository;

    public FindVeterinarianUseCase(VeterinarianRepository veterinarianRepository) {
        this.veterinarianRepository = veterinarianRepository;
    }

    public Veterinarian visualizarVeterinario(String crmv) {
        return veterinarianRepository.findByCrmv(crmv);
    }
}
