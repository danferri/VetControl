package br.edu.ifsp.application.persistence;

import br.edu.ifsp.domain.model.user.CRMV;
import br.edu.ifsp.domain.model.user.Veterinarian;
import br.edu.ifsp.domain.model.user.VeterinarianRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VeterinarianPersistence implements VeterinarianRepository {
    private static List<Veterinarian> veterinarians = new ArrayList<>();

    @Override
    public boolean save(Veterinarian veterinarian) {
        veterinarians.add(veterinarian);
        return true;
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

    @Override
    public  List<Veterinarian> findAllActive(){
        List<Veterinarian> activeVeterinarians = new ArrayList<>();
        for (Veterinarian vet : veterinarians) {
            if (vet.getStatusString() == "Active") {
                activeVeterinarians.add(vet);
            }
        }
        return activeVeterinarians;
}

}
