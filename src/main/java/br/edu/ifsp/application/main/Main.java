// Package
package br.edu.ifsp.application.main;


//Imports
import java.time.LocalDateTime;
import br.edu.ifsp.domain.model.client.*;
import br.edu.ifsp.domain.model.user.CRMV;
import br.edu.ifsp.domain.model.user.Veterinarian;
import br.edu.ifsp.domain.model.consulta.Consulta;
import br.edu.ifsp.domain.model.appointment.Payment;
import br.edu.ifsp.domain.model.consulta.ConsultaService;
import br.edu.ifsp.domain.model.appointment.PaymentStatus;
import br.edu.ifsp.domain.model.persistence.PetPersistence;
import br.edu.ifsp.domain.model.consulta.ConsultaRepository;
import br.edu.ifsp.domain.model.persistence.ClientPersistence;
import br.edu.ifsp.domain.model.persistence.ConsultaPersistence;





public class Main {
    public static void main(String[] args) {
        CRMV crmv = new CRMV("16257");
        Veterinarian veterinarian = new Veterinarian("Oie", "Lucas", "Benjamin Constant", "Grdes Animais", "991354610", crmv);


        ClientRepository clienteRepository = new ClientPersistence();
        PetRepository animalRepository = new PetPersistence();
        ConsultaRepository consultaRepository = new ConsultaPersistence();

        // Create services
        ClientServices clienteService = new ClientServices(clienteRepository);
        PetService animalService = new PetService(animalRepository);
        ConsultaService consultaService = new ConsultaService(consultaRepository);

        // Register a new client
        clienteService.cadastrarCliente("João Silva", "Rua A, 123", "123.456.789-00");
        Client cliente = clienteService.buscarClientePorCPF("123.456.789-00");

        // Register a new animal
        animalService.cadastrarAnimal("Rex", "Labrador", "Cachorro", cliente);
        Pet animal = animalService.buscarAnimalPorId(1);

        // Schedule a new consultation with payment and value
        CRMV crmv1 = new CRMV("1237");
        Veterinarian veterinario = new Veterinarian("veterinario1", "Dr. José", "Rua B, 456", "", "16991354610", crmv1);
        Payment payment = new Payment(1, "Cartão", PaymentStatus.PENDENTE);

        consultaService.agendarConsulta(LocalDateTime.now(), LocalDateTime.now().plusHours(1), "Consulta de rotina", veterinario, animal, payment, 100.0);

        Consulta consulta = consultaService.buscarConsultaPorId(1);

        // Print the scheduled consultation
        System.out.println("Consulta agendada: " + consulta);
        System.out.println("Veterinário: " + veterinario);
        System.out.println("Animal: " + animal);
        System.out.println("Cliente: " + cliente);

        System.out.println("/////////////////////////////////////////////////////////////////");
        System.out.println(" ");

        // Cancel the consultation
        consultaService.cancelarConsulta(1);
        // Print the status after cancellation
        System.out.println("Consulta após modificação: " + consulta.getStatus());
        // Schedule another consultation
        Payment payment2 = new Payment(2, "Cartão", PaymentStatus.PENDENTE);
        consultaService.agendarConsulta(LocalDateTime.now(), LocalDateTime.now().plusHours(2), "Consulta para verificação de problema", veterinario, animal, payment2, 150.0);
        Consulta consulta2 = consultaService.buscarConsultaPorId(2);
        // Print the second scheduled consultation
        System.out.println("Consulta2: " + consulta2);
        System.out.println(" ");
        System.out.println("/////////////////////////////////////////////////////////////////");






    }
}
