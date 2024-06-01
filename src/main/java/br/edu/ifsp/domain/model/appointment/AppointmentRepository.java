package br.edu.ifsp.domain.model.appointment;

import br.edu.ifsp.domain.model.user.Veterinarian;

import java.util.List;

public interface AppointmentRepository {
    void save(Appointment appointment);
    Appointment findById(int id);
    List<Appointment> findAll();

    List<Appointment> findByVeterinarian(Veterinarian veterinarian);

}