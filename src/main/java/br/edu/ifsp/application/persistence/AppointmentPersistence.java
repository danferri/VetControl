package br.edu.ifsp.application.persistence;

import br.edu.ifsp.domain.model.appointment.Appointment;
import br.edu.ifsp.domain.model.appointment.AppointmentRepository;
import br.edu.ifsp.domain.model.client.Pet;
import br.edu.ifsp.domain.model.user.Veterinarian;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AppointmentPersistence implements AppointmentRepository {
    private List<Appointment> appointments = new ArrayList<>();
    private int currentId = 1;

    @Override
    public void save(Appointment appointment) {
        appointments.add(appointment);
    }

    @Override
    public Appointment findById(int id) {
        return appointments.get(id - 1); // Assuming id is 1-based and corresponds to list index
    }

    @Override
    public List<Appointment> findAll() {
        return new ArrayList<>(appointments);
    }


    @Override
    public List<Appointment> findByVeterinarian(Veterinarian veterinarian) {
        return appointments.stream()
                .filter(appointment -> appointment.getVeterinarian().equals(veterinarian))
                .collect(Collectors.toList());
    }

    @Override
    public List<Appointment> findByPet(Pet pet) {
        return appointments.stream()
                .filter(appointment -> appointment.getPet().equals(pet))
                .collect(Collectors.toList());
    }
}

