package br.edu.ifsp.domain.usecases.veterinarian;

import br.edu.ifsp.domain.model.user.CRMV;
import br.edu.ifsp.domain.model.user.Veterinarian;
import br.edu.ifsp.domain.model.user.VeterinarianRepository;

public class UpdateVeterinarianUseCase {
    private VeterinarianRepository veterinarianRepository;

    public UpdateVeterinarianUseCase(VeterinarianRepository veterinarianRepository) {
        this.veterinarianRepository = veterinarianRepository;
    }

    public void alterarVeterinario(CRMV crmv, String newName, String newAddress, String newSpecialty, String newPhone) {
        Veterinarian veterinarian = veterinarianRepository.findByCrmv(crmv);
        if (veterinarian != null) {
            if (newName != null && !newName.isEmpty()) veterinarian.setName(newName);
            if (newAddress != null && !newAddress.isEmpty()) veterinarian.setAddress(newAddress);
            if (newSpecialty != null && !newSpecialty.isEmpty()) veterinarian.setSpecialty(newSpecialty);
            if (newPhone != null && !newPhone.isEmpty()) veterinarian.setPhone(newPhone);
            veterinarianRepository.update(veterinarian);
        } else {
            throw new IllegalArgumentException("Veterinário não encontrado com o CRMV fornecido.");
        }
    }
}