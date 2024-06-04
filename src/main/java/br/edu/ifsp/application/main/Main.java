package br.edu.ifsp.application.main;

import br.edu.ifsp.application.persistence.AppointmentPersistence;
import br.edu.ifsp.application.persistence.ClientPersistence;
import br.edu.ifsp.application.persistence.PaymentPersistence;
import br.edu.ifsp.application.persistence.PetPersistence;
import br.edu.ifsp.domain.model.appointment.*;
import br.edu.ifsp.domain.model.client.*;
import br.edu.ifsp.domain.model.payment.Payment;
import br.edu.ifsp.domain.model.payment.PaymentRepository;
import br.edu.ifsp.domain.model.payment.PaymentServices;
import br.edu.ifsp.domain.model.persistence.VeterinarianPersistence;
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

        VeterinarianServices veterinarianServices = new VeterinarianServices(veterinarianRepository);
        ClientServices clientServices = new ClientServices(clientRepository);
        PetServices petServices = new PetServices(petRepository, clientRepository);
        AppointmentService appointmentService = new AppointmentService(appointmentRepository);
        PaymentServices paymentServices = new PaymentServices(paymentRepository);

        // Criação do Veterinário
        CRMV crmv = new CRMV("SP-16257");
       veterinarianServices.addVeterinarian( "Dr. João", "Rua A, 123", "Clínica Geral", "123456789", crmv,"16991354610" );
        Veterinarian veterinarian = veterinarianServices.findVeterinarian(crmv);

      /*

        Teste UseCasesVeterinario
      System.out.println("Veterinário criado: " + veterinarian);

       veterinarianServices.updateVeterinarian(crmv, "Cleison", "", "", "5555");

        System.out.println("Veterinário editado : " + veterinarian);

        veterinarianServices.deactivateVeterinarian(crmv);

        System.out.println("Veterinário Status : " + veterinarian);
*/

        CPF cpf = new CPF("43788984848" );
        clientServices.insert("João Silva", "Rua A, 123", cpf);
        Client client = clientServices.FindOne(cpf);


        // Criação do Pet
        petServices.addPet(1, "Rex", "Labrador", "Cachorro", client);
        Pet pet = petServices.findPet(1);

       /*
            Testes do PET
       petServices.updatePet(1, "", "", "Girafa");
        System.out.println("Pet cadastrado: " + pet);

        petServices.AddPetToCLient(pet, cpf);

        System.out.println("Status do PET: "+ pet.getStatus());

        petServices.deactivatePet(1);

        System.out.println("Status do PET desativado? : "+ pet.getStatus());
*/


        System.out.println("Cliente cadastrado: " + client);


        //Criando Pagamento

        paymentServices.addPayment(1, "Cartao", 1000.00);
        Payment payment = paymentServices.findPayment(1);

        /*
            TESTES DE PAYMENT USE CASE
        System.out.println("Payment Method: "+ payment.getMethod() + "\n"+ "PayMent Amount: "+ payment.getAmount()+ "Payment Status: "+payment.getStatus());
        paymentServices.processPayment(1);

        Payment processedPayment = paymentServices.findPayment(1);
        System.out.println("Payment Method: "+ processedPayment.getMethod() + "\n"+ "PayMent Amount: "+ processedPayment.getAmount()+ "Payment Status: "+processedPayment.getStatus());
        */


        // Criação da Consulta
        appointmentService.Insert(1, LocalDate.now(), LocalTime.of(10, 0), "Consulta de rotina", veterinarian, pet, payment, 100.0);
        Appointment appointment = appointmentService.findOne(1);
        System.out.println("Consulta cadastrada: " + appointment+ "\n");


        //AppointmentService.cancel(1);
        appointmentService.Perform(1);
        paymentServices.processPayment(1);

        appointmentService.updateAppointment(1, null,null, "Consulta de ferramentas");
        Appointment Updatedappointment = appointmentService.findOne(1);
        System.out.println("Consulta Update: " + Updatedappointment+ "\n");

        System.out.println("Consultas do VET: "+ appointmentService.viewAppointments(veterinarian));
        System.out.println("\n");
        System.out.println("//////////////////////////////////////////////////////////////////////////");
        System.out.println("\n");

        System.out.println("Consultas do PET: " + appointmentService.listAppointmentsByPet(pet));

    }





}
