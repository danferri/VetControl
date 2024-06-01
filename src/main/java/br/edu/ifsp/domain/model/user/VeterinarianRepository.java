package br.edu.ifsp.domain.model.user;

public interface VeterinarianRepository {
    void save(Veterinarian veterinarian);
    Veterinarian findByCrmv(String crmv);
    void update(Veterinarian veterinarian);
    void deactivate(Veterinarian veterinarian);
}
