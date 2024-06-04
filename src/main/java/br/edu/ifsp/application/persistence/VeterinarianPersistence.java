package br.edu.ifsp.application.persistence;

import br.edu.ifsp.domain.model.user.CRMV;
import br.edu.ifsp.domain.model.user.Veterinarian;
import br.edu.ifsp.domain.model.user.VeterinarianRepository;

import java.util.ArrayList;
import java.util.List;

public class VeterinarianPersistence implements VeterinarianRepository {
    private List<Veterinarian> veterinarians = new ArrayList<>();

    @Override
    public void save(Veterinarian veterinarian) {
        veterinarians.add(veterinarian);
    }

    @Override
    public Veterinarian findByCrmv(CRMV crmv) {
        for (Veterinarian veterinarian : veterinarians) {
            if (veterinarian.getCrmv().equals(crmv)) {
                return veterinarian;
            }
        }
        return null;
    }

    @Override
    public void update(Veterinarian veterinarian) {
        Veterinarian existingVet = findByCrmv(veterinarian.getCrmv());
        if (existingVet != null) {
            existingVet.setName(veterinarian.getName());
            existingVet.setAddress(veterinarian.getAddress());
            existingVet.setSpecialty(veterinarian.getSpecialty());
            existingVet.setPhone(veterinarian.getPhone());
        }
    }

    @Override
    public List<Veterinarian> findAll() {
        return new ArrayList<>(veterinarians);
    }
}
