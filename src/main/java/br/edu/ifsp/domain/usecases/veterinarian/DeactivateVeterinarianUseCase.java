package br.edu.ifsp.domain.usecases.veterinarian;

import br.edu.ifsp.domain.model.user.CRMV;
import br.edu.ifsp.domain.model.user.Veterinarian;
import br.edu.ifsp.domain.model.user.VeterinarianRepository;
import br.edu.ifsp.domain.model.user.VeterinarianStatus;

public class DeactivateVeterinarianUseCase {
    private VeterinarianRepository veterinarianRepository;

    public DeactivateVeterinarianUseCase(VeterinarianRepository veterinarianRepository) {
        this.veterinarianRepository = veterinarianRepository;
    }

    public void inativarVeterinario(CRMV crmv) {
        Veterinarian veterinarian = veterinarianRepository.findByCrmv(crmv);
        if (veterinarian != null) {
            VeterinarianStatus deactivated = VeterinarianStatus.INACTIVE;
            veterinarian.setStatus(deactivated);
            veterinarianRepository.update(veterinarian);
        } else {
            throw new IllegalArgumentException("Veterinário não encontrado com o CRMV fornecido.");
        }
    }
}
