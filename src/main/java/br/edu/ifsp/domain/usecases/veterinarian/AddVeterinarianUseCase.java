package br.edu.ifsp.domain.usecases.veterinarian;

import br.edu.ifsp.domain.model.user.CRMV;
import br.edu.ifsp.domain.model.user.Veterinarian;
import br.edu.ifsp.domain.model.user.VeterinarianRepository;


public class AddVeterinarianUseCase {
    private VeterinarianRepository veterinarianRepository;

    public AddVeterinarianUseCase(VeterinarianRepository veterinarianRepository) {
        this.veterinarianRepository = veterinarianRepository;
    }

    public void cadastrarVeterinario( String name, String address, String specialty, String phone, CRMV crmv, String contact) {
        Veterinarian veterinarian = new Veterinarian( name, address, specialty, phone, crmv, contact);
        veterinarianRepository.save(veterinarian);
    }
}
