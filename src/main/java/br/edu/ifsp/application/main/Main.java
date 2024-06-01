// Package
package br.edu.ifsp.application.main;

// Imports
import java.time.LocalDateTime;
import br.edu.ifsp.domain.model.appointment.*;
import br.edu.ifsp.domain.model.client.*;
import br.edu.ifsp.domain.model.persistence.AppointmentPersistence;
import br.edu.ifsp.domain.model.user.CRMV;
import br.edu.ifsp.domain.model.user.Veterinarian;
import br.edu.ifsp.domain.model.persistence.PetPersistence;
import br.edu.ifsp.domain.model.persistence.ClientPersistence;

public class Main {
    public static void main(String[] args) {
        // Inicializando repositorios e serviços
        ClientRepository clientRepository = new ClientPersistence();
        PetRepository petRepository = new PetPersistence();
        AppointmentRepository appointmentRepository = new AppointmentPersistence();

        ClientServices clientService = new ClientServices(clientRepository);
        PetService petService = new PetService(petRepository);
        AppointmentService appointmentService = new AppointmentService(appointmentRepository);

        // Testes
        cadastrarCliente(clientService);
        cadastrarAnimal(clientService, petService);
        //agendarConsulta(appointmentService);
        //cancelarConsulta(appointmentService);
        //ealizarConsulta(appointmentService);
        processarPagamento(appointmentService);
    }

    private static void cadastrarCliente(ClientServices clientService) {
        clientService.insert("João Silva", "Rua A, 123", "123.456.789-00");
        Client client = clientService.FindOne("123.456.789-00");
        System.out.println("Cliente cadastrado:");
        System.out.println(client);
    }

    private static void cadastrarAnimal(ClientServices clientService, PetService petService) {
        Client client = clientService.FindOne("123.456.789-00");
        petService.cadastrarAnimal("Rex", "Labrador", "Cachorro", client);
        Pet pet = petService.buscarAnimalPorId(1);
        System.out.println("Animal cadastrado:");
        System.out.println(pet);
    }

    /*private static void agendarConsulta(AppointmentService appointmentService) {
        Veterinarian veterinarian = new Veterinarian("veterinario1", "Dr. José", "Rua B, 456", "", "16991354610", new CRMV("1237"));
        Pet pet = PetService(1);
        Payment payment = new Payment(1, "Cartão", PaymentStatus.PENDENTE);
        appointmentService.Insert(LocalDateTime.now(), LocalDateTime.now().plusHours(1), "Consulta qualquer", veterinarian, pet, payment, 100.00);

        Appointment appointment = appointmentService.findOne(1);
        System.out.println("Consulta agendada:");
        System.out.println(appointment);
    }*/

    private static void cancelarConsulta(AppointmentService appointmentService) {
        appointmentService.cancel(1);
        Appointment cancelledAppointment = appointmentService.findOne(1);
        System.out.println("Consulta após cancelamento:");
        System.out.println(cancelledAppointment);
    }

   /* private static void realizarConsulta(AppointmentService appointmentService) {
        Veterinarian veterinarian = new Veterinarian("veterinario1", "Dr. José", "Rua B, 456", "", "16991354610", new CRMV("1237"));
        Pet pet = petService.buscarAnimalPorId(1);
        Payment payment = new Payment(2, "Cartão", PaymentStatus.PENDENTE);
        appointmentService.Insert(LocalDateTime.now(), LocalDateTime.now().plusHours(1), "Consulta qualquer", veterinarian, pet, payment, 100.00);

        // Realizando a consulta (código comentado para simular o processo)
        // appointmentService.Perform(2);
        // Appointment performedAppointment = appointmentService.findOne(2);
        // System.out.println("Consulta realizada:");
        // System.out.println(performedAppointment);
    }*/

    private static void processarPagamento(AppointmentService appointmentService) {
        appointmentService.ProcessPayment(2, new Payment(2, "Cartão", PaymentStatus.CONCLUIDO));
        Appointment paidAppointment = appointmentService.findOne(2);
        System.out.println("Consulta após pagamento:");
        System.out.println(paidAppointment);
    }

    private static void visualizarConsultas(AppointmentService appointmentService, Veterinarian veterinarian) {
        System.out.println("Consultas realizadas pelo Dr. José:");
        appointmentService.viewAppointments(veterinarian).forEach(System.out::println);
    }
}
