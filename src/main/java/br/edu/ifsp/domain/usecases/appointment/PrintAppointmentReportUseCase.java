package br.edu.ifsp.domain.usecases.appointment;

//CDU025

import br.edu.ifsp.domain.model.appointment.Appointment;

import java.util.List;

public class PrintAppointmentReportUseCase {
    public void printAppointments(List<Appointment> appointments) {
        if (appointments == null || appointments.isEmpty()) {
            System.out.println("Nenhuma consulta encontrada com os dados fornecidos");
        } else {
            for (Appointment appointment : appointments) {
                System.out.println(formatAppointment(appointment));
            }
        }
    }

    private static String formatAppointment(Appointment appointment) {
        return String.format(
                "Consulta ID: %d\nData: %s\nHora: %s\nDescrição: %s\nVeterinário: %s\nPet: %s\nDono: %s\nStatus: %s\nCusto: %.2f\nPagamento: %s\n",
                appointment.getId(),
                appointment.getDate(),
                appointment.getHour(),
                appointment.getDescription(),
                appointment.getVeterinarian().getCrmv(),
                appointment.getPet().getName(),
                appointment.getPet().getOwner().getName(),
                appointment.getStatus(),
                appointment.getCost(),
                appointment.getPayment().getStatus()
        );
    }
}
