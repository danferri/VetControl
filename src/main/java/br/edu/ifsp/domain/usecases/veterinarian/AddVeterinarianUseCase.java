package br.edu.ifsp.domain.usecases.veterinarian;

import br.edu.ifsp.domain.model.user.CRMV;
import br.edu.ifsp.domain.model.user.Veterinarian;
import br.edu.ifsp.domain.usecases.utils.EntityAlreadyExistsException;
import br.edu.ifsp.domain.usecases.utils.Notification;
import br.edu.ifsp.domain.usecases.utils.Validator;

public class AddVeterinarianUseCase {

    private VeterinarianDAO veterinarianDAO;

    public AddVeterinarianUseCase(VeterinarianDAO veterinarianDAO) {
        this.veterinarianDAO = veterinarianDAO;
    }

    public CRMV insert(Veterinarian veterinarian) {
        Validator<Veterinarian> validator = new VeterinarianAddRequestValidator();
        Notification notification = validator.validate(veterinarian);

        if (notification.hasErrors()) {
            throw new IllegalArgumentException(notification.errorMessage());
        }

        String contact = veterinarian.getContact();
        if (!veterinarianDAO.findByContact(contact).isPresent()) {
            throw new EntityAlreadyExistsException("This veterinarian already exists");
        }
        return veterinarianDAO.create(veterinarian);
    }


}
