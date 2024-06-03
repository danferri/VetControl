package br.edu.ifsp.domain.usecases.appointment;

//CDU023

import br.edu.ifsp.application.persistence.AppointmentPersistence;
import br.edu.ifsp.domain.model.appointment.Appointment;
import br.edu.ifsp.domain.model.client.Pet;
import br.edu.ifsp.domain.model.user.Veterinarian;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GenerateAppointmentReportUseCase {
    private AppointmentPersistence appointmentPersistence;

    public GenerateAppointmentReportUseCase(AppointmentPersistence appointmentPersistence) {
        this.appointmentPersistence = appointmentPersistence;
    }

    public List<Appointment> GenerateAppointment (Veterinarian veterinarian, Pet pet, LocalDate startDate, LocalDate endDate){
        List<Appointment> appointmentReport = new ArrayList<> ();
        if (veterinarian != null){
            List<Appointment> vetList = appointmentPersistence.findByVeterinarian(veterinarian);
            if (pet != null){
                List<Appointment> petList = appointmentPersistence.findByPet(pet);
                for (Appointment appointment : vetList){
                    if (petList.contains(appointment)){
                        if (appointment.getDate().isAfter(startDate) && appointment.getDate().isBefore(endDate)){
                            appointmentReport.add(appointment);
                        }
                    }
                }
            } else {
                for (Appointment appointment : vetList){
                    if (appointment.getDate().isAfter(startDate) && appointment.getDate().isBefore(endDate)){
                        appointmentReport.add(appointment);
                    }
                }
            }
        } else if (pet != null){
            List<Appointment> petList = appointmentPersistence.findByPet(pet);
            for (Appointment appointment : petList){
                if (appointment.getDate().isAfter(startDate) && appointment.getDate().isBefore(endDate)){
                    appointmentReport.add(appointment);
                }
            }
        } else {
            List<Appointment> allAppointments = appointmentPersistence.findAll();
            for (Appointment appointment : allAppointments){
                if (appointment.getDate().isAfter(startDate) && appointment.getDate().isBefore(endDate)){
                    appointmentReport.add(appointment);
                }
            }
        }
        return appointmentReport;
    }
}
