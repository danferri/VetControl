package br.edu.ifsp.domain.usecases.veterinarian;

import br.edu.ifsp.domain.model.user.CRMV;
import br.edu.ifsp.domain.model.user.Veterinarian;
import br.edu.ifsp.domain.model.user.VeterinarianRepository;
import br.edu.ifsp.domain.usecases.utils.Notification;
import br.edu.ifsp.domain.usecases.utils.Validator;


public class AddVeterinarianUseCase {
    private VeterinarianRepository veterinarianRepository;

    public AddVeterinarianUseCase(VeterinarianRepository veterinarianRepository) {
        this.veterinarianRepository = veterinarianRepository;
    }

    public boolean cadastrarVeterinario( String name, String address, String specialty, String phone,
                                         CRMV crmv, String contact) {

        Veterinarian veterinarian = new Veterinarian( name, address, specialty, phone, crmv, contact);

        Validator<Veterinarian> validator = new VeterinarianValidator();
        Notification notification = validator.validate(veterinarian);

        if(notification.hasErrors())
            throw new IllegalArgumentException(notification.errorMessage());

        return veterinarianRepository.save(veterinarian);
    }
}