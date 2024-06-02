package br.edu.ifsp.domain.model.user;

import java.util.List;

public interface VeterinarianRepository {
    void save(Veterinarian veterinarian);
    Veterinarian findByCrmv(CRMV crmv);
    void update(Veterinarian veterinarian);

    List<Veterinarian> findAll();
}
