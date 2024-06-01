package br.edu.ifsp.domain.usecases.veterinarian;

import br.edu.ifsp.domain.model.user.CRMV;
import br.edu.ifsp.domain.model.user.Veterinarian;
import br.edu.ifsp.domain.model.user.VeterinarianRepository;
import br.edu.ifsp.domain.model.user.VeterinarianStatus;

public class AddVeterinarianUseCase {
    private VeterinarianRepository veterinarianRepository;

    public AddVeterinarianUseCase(VeterinarianRepository veterinarianRepository) {
        this.veterinarianRepository = veterinarianRepository;
    }

    public void cadastrarVeterinario(String id, String name, String address, String specialty, String phone, CRMV crmv, VeterinarianStatus status, String contact) {
        Veterinarian veterinarian = new Veterinarian(id, name, address, specialty, phone, crmv, status, contact);
        veterinarianRepository.save(veterinarian);
    }
}
