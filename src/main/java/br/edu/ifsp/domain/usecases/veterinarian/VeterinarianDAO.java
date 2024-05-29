package br.edu.ifsp.domain.usecases.veterinarian;

import br.edu.ifsp.domain.model.user.CRMV;
import br.edu.ifsp.domain.model.user.Veterinarian;
import br.edu.ifsp.domain.usecases.utils.DAO;

import java.util.Optional;

public interface VeterinarianDAO extends DAO<Veterinarian, CRMV> {
    Optional<Veterinarian> findByContact(String contact);
}
