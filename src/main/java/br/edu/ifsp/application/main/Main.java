package br.edu.ifsp.application.main;

import br.edu.ifsp.domain.model.appointment.AppointmentPersistence;
import br.edu.ifsp.domain.model.appointment.AppointmentRepository;
import br.edu.ifsp.domain.model.client.ClientPersistence;
import br.edu.ifsp.domain.model.client.ClientRepository;
import br.edu.ifsp.domain.model.client.PetPersistence;
import br.edu.ifsp.domain.model.client.PetRepository;
import br.edu.ifsp.domain.model.user.*;

public class Main {
    public static void main(String[] args) {
        // Inicializando repositórios e serviços
        ClientRepository clientRepository = new ClientPersistence();
        PetRepository petRepository = new PetPersistence();
        AppointmentRepository appointmentRepository = new AppointmentPersistence();
        VeterinarianRepository veterinarianRepository = new VeterinarianPersistence(); // Supondo a existência dessa classe

        ClientServices clientServices = new ClientServices(clientRepository);
        PetService petService = new PetService(petRepository);
        AppointmentService appointmentService = new AppointmentService(appointmentRepository);
        VeterinarianServices veterinarianServices = new VeterinarianServices(veterinarianRepository);

        // Teste de Veterinário
        String crmv = "16257";
        veterinarianServices.addVeterinarian("1", "Dr. João", "Rua A, 123", "Clínica Geral", "123456789", new CRMV(crmv));

        Veterinarian vet = veterinarianServices.findVeterinarian(crmv);
        System.out.println("Veterinário cadastrado: " + vet);

        veterinarianServices.updateVeterinarian(crmv, "Dr. João da Silva", "Rua B, 456", "Especialista", "987654321");
        vet = veterinarianServices.findVeterinarian(crmv);
        System.out.println("Veterinário atualizado: " + vet);

        veterinarianServices.deactivateVeterinarian(crmv);
        vet = veterinarianServices.findVeterinarian(crmv);
        System.out.println("Veterinário inativado: " + vet);
    }
}
