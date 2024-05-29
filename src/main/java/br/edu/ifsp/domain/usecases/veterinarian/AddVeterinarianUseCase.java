package br.edu.ifsp.domain.usecases.veterinarian;

import br.edu.ifsp.domain.model.user.CRMV;
import br.edu.ifsp.domain.model.user.Veterinarian;

public class AddVeterinarianUseCase {

    private VeterinarianDAO veterinarianDAO;

    public AddVeterinarianUseCase(VeterinarianDAO veterinarianDAO) {
        this.veterinarianDAO = veterinarianDAO;
    }

    public CRMV insert (Veterinarian veterinarian) {
        return veterinarianDAO.create(veterinarian);
    }


}
