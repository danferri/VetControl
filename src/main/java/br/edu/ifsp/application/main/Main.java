package br.edu.ifsp.application.main;

import br.edu.ifsp.application.persistence.AppointmentPersistence;
import br.edu.ifsp.application.persistence.ClientPersistence;
import br.edu.ifsp.application.persistence.PetPersistence;
import br.edu.ifsp.domain.model.appointment.*;
import br.edu.ifsp.domain.model.client.*;
import br.edu.ifsp.domain.model.user.*;
import br.edu.ifsp.domain.model.user.CPF;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Inicializando repositórios e serviços
        ClientRepository clientRepository = new ClientPersistence(); // Supondo a existência dessa classe
        PetRepository petRepository = new PetPersistence(); // Supondo a existência dessa classe
        AppointmentRepository appointmentRepository = new AppointmentPersistence(); // Supondo a existência dessa classe
        VeterinarianRepository veterinarianRepository = new Veterinarian
        VeterinarianServices veterinarianServices = new VeterinarianServices()
        ClientServices clientServices = new ClientServices(clientRepository);
        PetServices petServices = new PetServices(petRepository, clientRepository);
        AppointmentService appointmentService = new AppointmentService(appointmentRepository);

        // Criação do Veterinário
        CRMV crmv = new CRMV("16257");

        CPF cpf = new CPF("123.456.789-00");
        clientServices.addClient("João Silva", "Rua A, 123", cpf);
        Client client = clientServices.findClient(cpf.getNumber());
        System.out.println("Cliente cadastrado: " + client);

        // Criação do Pet
        petServices.addPet(1, "Rex", "Labrador", "Cachorro", cpf.getNumber());
        Pet pet = petServices.findPet(1);
        System.out.println("Pet cadastrado: " + pet);

        // Criação da Consulta
        appointmentService.addAppointment(1, LocalDate.now(), LocalTime.of(10, 0), "Consulta de rotina", veterinarian, pet, 100.0);
        Appointment appointment = appointmentService.findAppointment(1);
        System.out.println("Consulta cadastrada: " + appointment);
    }
}
