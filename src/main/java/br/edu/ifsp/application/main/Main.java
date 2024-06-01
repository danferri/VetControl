// Package
package br.edu.ifsp.application.main;


//Imports
import java.time.LocalDateTime;
import java.util.Date;

import br.edu.ifsp.domain.model.appointment.*;
import br.edu.ifsp.domain.model.client.*;
import br.edu.ifsp.domain.model.persistence.AppointmentPersistence;
import br.edu.ifsp.domain.model.user.CRMV;
import br.edu.ifsp.domain.model.user.Veterinarian;
import br.edu.ifsp.domain.model.persistence.PetPersistence;

import br.edu.ifsp.domain.model.persistence.ClientPersistence;






public class Main {
    public static void main(String[] args) {
        CRMV crmv = new CRMV("16257");
        Veterinarian veterinarian = new Veterinarian("Oie", "Lucas", "Benjamin Constant", "Grdes Animais", "991354610", crmv);


        ClientRepository clienteRepository = new ClientPersistence();
        PetRepository animalRepository = new PetPersistence();
        AppointmentRepository appointmentRepository = new AppointmentPersistence();

        // Inicializando os serviços
        ClientServices clienteService = new ClientServices(clienteRepository);
        PetService animalService = new PetService(animalRepository);
        AppointmentService appointmentService = new AppointmentService(appointmentRepository);

        // Cadastrando um novo cliente
        clienteService.cadastrarCliente("João Silva", "Rua A, 123", "123.456.789-00");
        Client cliente = clienteService.buscarClientePorCPF("123.456.789-00");

        // Cadastrando um novo animal
        animalService.cadastrarAnimal("Rex", "Labrador", "Cachorro", cliente);
        Pet animal = animalService.buscarAnimalPorId(1);

        // Agendando uma nova consulta
        CRMV crmv1 = new CRMV("1237");
        Veterinarian veterinario = new Veterinarian("veterinario1", "Dr. José", "Rua B, 456", "", "16991354610", crmv1);
        Payment payment = new Payment(1, "Cartão", PaymentStatus.PENDENTE);
        appointmentService.Insert(LocalDateTime.now(), LocalDateTime.now().plusHours(1), "Consulta qualquer", veterinario, animal, payment, 100.00);

        // Buscando uma consulta agendada
        Appointment appointment = appointmentService.findOne(1);
        System.out.println("Consulta agendada:");
        System.out.println(appointment);

        // Cancelando uma consulta
        appointmentService.cancel(1);
        Appointment cancelledAppointment = appointmentService.findOne(1);
        System.out.println("Consulta após cancelamento:");
        System.out.println(cancelledAppointment);

        // Realizando uma consulta
        // Primeiro é necessário agendar novamente para realizar
        appointmentService.Insert(LocalDateTime.now(), LocalDateTime.now().plusHours(1), "Consulta qualquer", veterinario, animal, payment, 100.00);
       // appointmentService.Perform(2);
       // Appointment performedAppointment = appointmentService.findOne(2);
       // System.out.println("Consulta realizada:");
        //System.out.println(performedAppointment);

        // Processando um pagamento
        appointmentService.ProcessPayment(2, new Payment(2, "Cartão", PaymentStatus.CONCLUIDO));
        Appointment paidAppointment = appointmentService.findOne(2);
        System.out.println("Consulta após pagamento:");
        System.out.println(paidAppointment);

        // Visualizando consultas realizadas por um veterinário
        System.out.println("Consultas realizadas pelo Dr. José:");
        appointmentService.viewAppointments(veterinario).forEach(System.out::println);
    }
}