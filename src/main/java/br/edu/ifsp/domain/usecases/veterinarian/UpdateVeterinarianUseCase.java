package br.edu.ifsp.domain.usecases.veterinarian;

import br.edu.ifsp.domain.model.user.CRMV;
import br.edu.ifsp.domain.model.user.Veterinarian;
import br.edu.ifsp.domain.usecases.utils.EntityNotFoundException;
import br.edu.ifsp.domain.usecases.utils.Notification;
import br.edu.ifsp.domain.usecases.utils.Validator;

public class UpdateVeterinarianUseCase {
    private VeterinarianDAO veterinarianDAO;

    public UpdateVeterinarianUseCase(VeterinarianDAO veterinarianDAO) {
        this.veterinarianDAO = veterinarianDAO;
    }

    public boolean update(Veterinarian veterinarian) {
        Validator<Veterinarian> validator = new VeterinarianAddRequestValidator();
        Notification notification = validator.validate(veterinarian);

        if (notification.hasErrors()) {
            throw new IllegalArgumentException(notification.errorMessage());
        }

        CRMV crmv = veterinarian.getCrmv();
        if (veterinarianDAO.findOne(crmv).isEmpty()) {
            throw new EntityNotFoundException("Veterinarian not found.");
        }
        return veterinarianDAO.update(veterinarian);

    }
}
