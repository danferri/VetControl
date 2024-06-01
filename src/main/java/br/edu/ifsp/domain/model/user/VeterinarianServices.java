package br.edu.ifsp.domain.model.user;

import br.edu.ifsp.domain.usecases.veterinarian.*;

public class VeterinarianServices {
    private VeterinarianRepository veterinarianRepository;

    public VeterinarianServices(VeterinarianRepository veterinarianRepository) {
        this.veterinarianRepository = veterinarianRepository;
    }

    public void addVeterinarian(String id, String name, String address, String specialty, String phone, CRMV crmv, VeterinarianStatus Status, String contact) {
        AddVeterinarianUseCase addVeterinarianUseCase = new AddVeterinarianUseCase(veterinarianRepository);
        addVeterinarianUseCase.cadastrarVeterinario(id, name, address, specialty, phone, crmv, Status, contact);
    }

    public void updateVeterinarian(String crmv, String newName, String newAddress, String newSpecialty, String newPhone) {
        UpdateVeterinarianUseCase updateVeterinarianUseCase = new UpdateVeterinarianUseCase(veterinarianRepository);
        updateVeterinarianUseCase.alterarVeterinario(crmv, newName, newAddress, newSpecialty, newPhone);
    }

    public Veterinarian findVeterinarian(String crmv) {
        FindVeterinarianUseCase findVeterinarianUseCase = new FindVeterinarianUseCase(veterinarianRepository);
        return findVeterinarianUseCase.visualizarVeterinario(crmv);
    }

    public void deactivateVeterinarian(String crmv) {
        DeactivateVeterinarianUseCase deactivateVeterinarianUseCase = new DeactivateVeterinarianUseCase(veterinarianRepository);
        deactivateVeterinarianUseCase.inativarVeterinario(crmv);
    }
}