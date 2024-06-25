package br.edu.ifsp.application.persistence;

import br.edu.ifsp.domain.model.appointment.Appointment;
import br.edu.ifsp.domain.model.appointment.AppointmentRepository;
import br.edu.ifsp.domain.model.client.Pet;
import br.edu.ifsp.domain.model.user.Veterinarian;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AppointmentPersistence implements AppointmentRepository {
    private static List<Appointment> appointments = new ArrayList<>();
    private static int currentId = 1;

    @Override
    public boolean save(Appointment appointment) {
        appointment.setId(currentId++);

        appointments.add(appointment);
        return true;
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

    @Override
    public void update(Appointment updatedAppointment) {
        Appointment existingAppointment = findById(updatedAppointment.getId());
        if (existingAppointment != null) {
            existingAppointment.setDate(updatedAppointment.getDate());
            existingAppointment.setHour(updatedAppointment.getHour());
            existingAppointment.setDescription(updatedAppointment.getDescription());
            existingAppointment.setVeterinarian(updatedAppointment.getVeterinarian());
            existingAppointment.setStatus(updatedAppointment.getStatus());
            existingAppointment.setCost(updatedAppointment.getCost());
        }
    }
}

