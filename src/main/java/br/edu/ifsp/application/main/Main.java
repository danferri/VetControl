package br.edu.ifsp.application.main;

import br.edu.ifsp.application.persistence.*;
import br.edu.ifsp.domain.model.appointment.*;
import br.edu.ifsp.domain.model.client.*;
import br.edu.ifsp.domain.model.payment.Payment;
import br.edu.ifsp.domain.model.payment.PaymentRepository;
import br.edu.ifsp.domain.model.payment.PaymentServices;
import br.edu.ifsp.domain.model.user.*;


import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {

        // Inicializando repositórios e serviços
        ClientRepository clientRepository = new ClientPersistence();
        PetRepository petRepository = new PetPersistence();
        AppointmentRepository appointmentRepository = new AppointmentPersistence();
        VeterinarianRepository veterinarianRepository = new VeterinarianPersistence();
        PaymentRepository paymentRepository = new PaymentPersistence();

        AttendantServices attendantServices = new AttendantServices(veterinarianRepository,
                clientRepository, petRepository, appointmentRepository, paymentRepository);

        VeterinarianServices veterinarianServices = new VeterinarianServices(petRepository, appointmentRepository,
                veterinarianRepository);

        PaymentServices paymentServices = new PaymentServices(paymentRepository);

        // Usuário interagindo com o sistema
        Attendant admUser;
        Veterinarian vetUser;


        // Criação do Atendente
        String credencialAtendente = "masterCredentials";
        admUser = new Attendant(credencialAtendente);

        // Validação do usuário para acesso aos métodos de Atendente
        if (admUser.accessLevel() && admUser.authenticateUser()){
            System.out.println("Atendente logado");

            // Criação do Veterinário
            CRMV crmv = new CRMV("SP-16257");
            attendantServices.addVeterinarian( "Dr. João", "Rua A, 123",
                    "Clínica Geral", "123456789", crmv,"16991354610" );
            vetUser = attendantServices.findVeterinarian(crmv);

            //Teste UseCasesVeterinario
            System.out.println("\n" + "Teste dos Métodos de Veterinário" + "\n");
            System.out.println("Veterinário criado: " + vetUser);

            attendantServices.updateVeterinarian(crmv, "Cleison", "",
                    "", "5555");

            System.out.println("Veterinário editado : " + vetUser);

            // Criação do Cliente
            CPF cpf = new CPF("43788984848" );
            attendantServices.addClient("João Silva", "Rua A, 123", cpf);
            Client client = attendantServices.findOneClient(cpf);

            // Teste UseCasesCliente
            System.out.println("\n" + "Teste dos Métodos de Cliente" + "\n");
            System.out.println("Cliente criado: " + client);

            attendantServices.updateClient(cpf, "João da Silva Macedo Carvalho", "");

            System.out.println("Cliente editado : " + client);

            // Criação do Pet
            attendantServices.addPet(1, "Rex", "Labrador", "Cachorro", client);
            Pet pet = attendantServices.findPet(1);

            // Teste UseCasesPet
            System.out.println("\n" + "Teste dos Métodos de Pet" + "\n");
            System.out.println("Pet cadastrado: " + pet);

            attendantServices.updatePet(1, "", "", "Girafa");

            System.out.println("Pet editado: " + pet);

            System.out.println("Dono antes do adição do pet: " + client.getPets());

            attendantServices.addPetToCLient(pet, cpf);

            System.out.println("Dono depois da adição do pet: " + client.getPets());

            System.out.println("Status do PET: "+ pet.getStatus());

            // Criação do Pagamento
            paymentServices.addPayment(1, "Cartao", 1000.00);
            Payment payment = attendantServices.findPayment(1);

            // Teste UseCasesPagamento
            System.out.println("\n" + "Teste dos Métodos de Pagamento" + "\n");
            System.out.println("Método de Pagamento: "+ payment.getMethod() + "\n"+ "Valor: "
                    + payment.getAmount()+ "\n" + "Status do Pagamento: "+payment.getStatus());

            // Criação da Consulta
            Veterinarian vet = vetUser;
            attendantServices.addAppointment(1, LocalDate.now(), LocalTime.of(10, 0),
                    "Consulta de rotina", vet, pet, payment, 100.0);
            Appointment appointment = attendantServices.findOneAppointment(1);

            // Teste UseCasesConsulta
            System.out.println("\n" + "Teste dos Métodos de Consulta" + "\n");
            System.out.println("Consulta cadastrada: " + appointment+ "\n");

            attendantServices.updateAppointment(1, null, null,
                    "Consulta de ferramentas");

            System.out.println("Consulta editada: " + appointment + "\n");

            System.out.println("Listando consultas por determinado Veterinário:");
            for(Appointment appointmentListItem : attendantServices.viewAppointments(vet)){
                System.out.println(appointmentListItem);
            }

            System.out.println("\n");

            System.out.println("Listando consultas por determinado Pet");
            for(Appointment appointmentListItem : attendantServices.listAppointmentsByPet(pet)){
                System.out.println(appointmentListItem);
            }

            System.out.println("\n");

            attendantServices.cancelAppointment(1);

            System.out.println("Buscando consulta cancelada: ");
            System.out.println("Id: " + appointment.getId() + "\n" + "Data: " + appointment.getDate() + "\n"
                    + "Status: " + appointment.getStatus());

            // Teste de Relatórios
            System.out.println("\nTeste de Relatórios\n");

            System.out.println("Exibição do Relatório");
            attendantServices.printApointment(1);


            System.out.println("Exportando o relatório em PDF");
            attendantServices.exportReport(1);


            System.out.println();
            System.out.println(attendantServices.generateApointmentReport(vetUser, pet, LocalDate.now().minusDays(1),
                    LocalDate.now().plusDays(1)));

            // Mudança para estados inválidos
            System.out.println("\nMudança de estado dos objetos para inválidos:");
            attendantServices.deactivateVeterinarian(crmv);

            System.out.println("\nNome Veterinário: " + vetUser.getName() + "Veterinário Status : " + vetUser.informVeterinarianStatus());

            attendantServices.deactivatePet(1);

            System.out.println("\n" + "Status do PET desativado : "+ pet.getStatus());

            attendantServices.processPayment(1);

            System.out.println("\n" + "Pagamento efetivado: " + "\n");

            System.out.println("Payment Method: "+ payment.getMethod() + "\n"+ "PayMent Amount: "
                    + payment.getAmount()+ "\n" +
                    "" +
                    "Payment Status: "+payment.getStatus());
        }

        // Criação do Veterinário para teste de Fluxo
        CRMV crmv1 = new CRMV( "MT-12368");
        //CRMV crmv1 = new CRMV("SP-16257");
        attendantServices.addVeterinarian  ("Dan", "Rua da rua", "Zoista", "16 9999999-8888", crmv1, "vet@vet.vet");
        vetUser = attendantServices.findVeterinarian(crmv1);

        System.out.println("\n================================================================================\n");


        // Validação do Usuário para acesso aos métodos de Veterinário
        if (!vetUser.accessLevel() && vetUser.authenticateUser()) {
            System.out.println("Veterinário logado");

            // Criação de Classes para teste de fluxo Veterinário
            System.out.println("\nCriação de Classes para teste de fluxo Veterinário");

            CPF cpf = new CPF("56344906006" );
            attendantServices.addClient("Maria Cláudia", "Rua B, 456", cpf);
            Client clientTest = attendantServices.findOneClient(cpf);

            attendantServices.addPet(2, "Gigante", "Pincher", "Cachorro", clientTest);
            Pet petTest = attendantServices.findPet(2);

            attendantServices.addPetToCLient(petTest, cpf);

            paymentServices.addPayment(2, "Dinheiro", 3500.00);
            Payment paymentTest = attendantServices.findPayment(2);

            System.out.println(clientTest.getPets());

            attendantServices.addAppointment(2, LocalDate.now(), LocalTime.of(10, 0),
                    "Consulta de rotina", vetUser, petTest, paymentTest, 100.0);

            veterinarianServices.perform(2);

            System.out.println("Status da consulta finalizada por médico: "
                    + attendantServices.findOneAppointment(2).getStatus());
        }

        else System.out.println("Login Inválido!");

    }
}
