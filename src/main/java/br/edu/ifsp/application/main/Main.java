package br.edu.ifsp.application.main;

import br.edu.ifsp.domain.model.client.*;
import br.edu.ifsp.domain.model.consulta.Consulta;
import br.edu.ifsp.domain.model.consulta.ConsultaRepository;
import br.edu.ifsp.domain.model.consulta.ConsultaService;
import br.edu.ifsp.domain.model.persistence.ClientPersistence;
import br.edu.ifsp.domain.model.persistence.ConsultaPersistence;
import br.edu.ifsp.domain.model.persistence.PetPersistence;
import br.edu.ifsp.domain.model.user.CRMV;
import br.edu.ifsp.domain.model.user.Veterinarian;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        CRMV crmv = new CRMV("16257");
        Veterinarian veterinarian = new Veterinarian("Oie", "Lucas", "Benjamin Constant", "Grdes Animais", "991354610", crmv);
        System.out.println(veterinarian.toString());;

        ClientRepository clienteRepository = new ClientPersistence();
        PetRepository animalRepository = new PetPersistence();
        ConsultaRepository consultaRepository = new ConsultaPersistence();

        // Create services
        ClientServices clienteService = new ClientServices(clienteRepository);
        PetService animalService = new PetService(animalRepository);
        ConsultaService consultaService = new ConsultaService(consultaRepository);

        // Register a new cliente
        clienteService.cadastrarCliente("João Silva", "Rua A, 123", "123.456.789-00");
        Client cliente = clienteService.buscarClientePorCPF("123.456.789-00");

        // Register a new animal
        animalService.cadastrarAnimal("Rex", "Labrador", "Cachorro", cliente);
        Pet animal = animalService.buscarAnimalPorId(1);

        // Schedule a new consulta
        CRMV crmv1 = new CRMV("1237");
        Veterinarian veterinario = new Veterinarian("veterinario1", "Dr. José", "Rua B, 456", "","16991354610",crmv1 );
        consultaService.agendarConsulta(LocalDateTime.now(), LocalDateTime.now().plusHours(1), "Consulta de rotina", veterinario, animal);
        Consulta consulta = consultaService.buscarConsultaPorId(1);

        // Print the result
        System.out.println("Consulta agendada: " + consulta);
        System.out.println("veterinario:" + veterinario);
        System.out.println("animal: "+animal.toString());
        System.out.println("cliente: " + cliente.toString());
    }


    }

