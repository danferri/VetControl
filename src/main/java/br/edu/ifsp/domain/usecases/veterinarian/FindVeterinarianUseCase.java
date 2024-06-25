package br.edu.ifsp.domain.usecases.veterinarian;

import br.edu.ifsp.domain.model.user.CRMV;
import br.edu.ifsp.domain.model.user.Veterinarian;
import br.edu.ifsp.domain.model.user.VeterinarianRepository;

public class FindVeterinarianUseCase {
    private VeterinarianRepository veterinarianRepository;

    public FindVeterinarianUseCase(VeterinarianRepository veterinarianRepository) {
        this.veterinarianRepository = veterinarianRepository;
    }

    public Veterinarian visualizarVeterinario(CRMV crmv) {

        if(!crmv.isValid(crmv))
            throw new IllegalArgumentException("Invalid CRMV informed");

        Veterinarian veterinarian = veterinarianRepository.findByCrmv(crmv);
        if (veterinarian == null) {
            throw new IllegalArgumentException("Veterinário não encontrado com o CRMV fornecido.");
        }
        return veterinarian;

    }
}
