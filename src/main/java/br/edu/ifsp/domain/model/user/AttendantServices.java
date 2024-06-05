package br.edu.ifsp.domain.model.user;

import br.edu.ifsp.domain.model.appointment.Appointment;
import br.edu.ifsp.domain.model.appointment.AppointmentRepository;
import br.edu.ifsp.domain.model.client.*;
import br.edu.ifsp.domain.model.payment.Payment;
import br.edu.ifsp.domain.model.payment.PaymentRepository;
import br.edu.ifsp.domain.usecases.appointment.*;
import br.edu.ifsp.domain.usecases.client.AddClientUseCase;
import br.edu.ifsp.domain.usecases.client.FindClientUseCase;
import br.edu.ifsp.domain.usecases.client.UpdateClientUseCase;
import br.edu.ifsp.domain.usecases.payment.FindPaymentUseCase;
import br.edu.ifsp.domain.usecases.payment.ProcessPaymentUseCase;
import br.edu.ifsp.domain.usecases.pet.*;
import br.edu.ifsp.domain.usecases.veterinarian.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class AttendantServices {
    private VeterinarianRepository veterinarianRepository;
    private ClientRepository clientRepository;
    private PetRepository petRepository;
    private final AppointmentRepository appointmentRepository;
    private PaymentRepository paymentRepository;

    public AttendantServices(VeterinarianRepository veterinarianRepository,
                             ClientRepository clientRepository,
                             PetRepository petRepository,
                             AppointmentRepository appointmentRepository,
                             PaymentRepository paymentRepository) {
        this.veterinarianRepository = veterinarianRepository;
        this.clientRepository = clientRepository;
        this.petRepository = petRepository;
        this.appointmentRepository = appointmentRepository;
        this.paymentRepository = paymentRepository;
    }

    // Gerencia Veterinários
    public void addVeterinarian( String name, String address, String specialty, String phone, CRMV crmv, String contact) {
        AddVeterinarianUseCase addVeterinarianUseCase = new AddVeterinarianUseCase(veterinarianRepository);
        addVeterinarianUseCase.cadastrarVeterinario( name, address, specialty, phone, crmv,  contact);
    }

    public void updateVeterinarian(CRMV crmv, String newName, String newAddress, String newSpecialty, String newPhone) {
        UpdateVeterinarianUseCase updateVeterinarianUseCase = new UpdateVeterinarianUseCase(veterinarianRepository);
        updateVeterinarianUseCase.alterarVeterinario(crmv, newName, newAddress, newSpecialty, newPhone);
    }

    public Veterinarian findVeterinarian(CRMV crmv) {
        FindVeterinarianUseCase findVeterinarianUseCase = new FindVeterinarianUseCase(veterinarianRepository);
        return findVeterinarianUseCase.visualizarVeterinario(crmv);
    }

    public void deactivateVeterinarian(CRMV crmv) {
        DeactivateVeterinarianUseCase deactivateVeterinarianUseCase = new DeactivateVeterinarianUseCase(veterinarianRepository);
        deactivateVeterinarianUseCase.inativarVeterinario(crmv);
    }

    // Gerencia Clientes
    public void addClient(String nome, String endereco, CPF cpf) {
        AddClientUseCase addClientUseCase = new AddClientUseCase(clientRepository);
        addClientUseCase.cadastrarCliente(nome, endereco,cpf);
    }

    public void updateClient(CPF cpf, String novoNome, String novoEndereco) {
        UpdateClientUseCase updateClientUseCase = new UpdateClientUseCase(clientRepository);
        updateClientUseCase.updateClient(cpf, novoNome, novoEndereco);
    }

    public Client findOneClient(CPF cpf) {
        FindClientUseCase findOne = new FindClientUseCase(clientRepository);
        return  findOne.FindClientByCPF(cpf);
    }

    // Gerencia Pets
    public void addPet(int id, String name, String breed, String species, Client owner) {
        AddPetUseCase addPetUseCase = new AddPetUseCase(petRepository);
        addPetUseCase.cadastrarPet(id, name, breed, species, owner, PetStatus.ACTIVE);
    }

    public void addPetToCLient(Pet pet, CPF cpf){
        RegisterPetToClientUseCase petToCliente = new RegisterPetToClientUseCase(petRepository, clientRepository);
        petToCliente.cadastrarPet(cpf, pet);
    }

    public void updatePet(int id, String newName, String newBreed, String newSpecies) {
        UpdatePetUseCase updatePetUseCase = new UpdatePetUseCase(petRepository);
        updatePetUseCase.alterarPet(id, newName, newBreed, newSpecies);
    }

    public Pet findPet(int id) {
        FindPetUseCase findPetUseCase = new FindPetUseCase(petRepository);
        return findPetUseCase.visualizarPet(id);
    }

    public void deactivatePet(int id) {
        DeactivatePetUseCase deactivatePetUseCase = new DeactivatePetUseCase(petRepository);
        deactivatePetUseCase.inativarPet(id);
    }

    // Gerencia Consultas
    public void addAppointment(Integer id , LocalDate data, LocalTime hora, String historico, Veterinarian veterinario, Pet pet, Payment payment, double value) {
        AddAppointmentUseCase addApointment = new AddAppointmentUseCase(appointmentRepository);
        addApointment.cadastrarConsulta(id, data, hora, historico, veterinario, pet,value, payment);
    }

    public void updateAppointment(int id, LocalDate newDate, LocalTime newHour, String newDescription) {
        UpdateAppointmentUseCase updateAppointmentUseCase = new UpdateAppointmentUseCase(appointmentRepository);
        updateAppointmentUseCase.alterarConsulta(id, newDate, newHour, newDescription);
    }

    public Appointment findOneAppointment(int id) {
        FindAppointmentUseCase findAppointment = new FindAppointmentUseCase(appointmentRepository);
        return findAppointment.visualizarConsulta(id);
    }

    public List<Appointment> viewAppointments(Veterinarian veterinarian) {
        FindVeterinariamAppointmentUseCase findVetAppoint = new FindVeterinariamAppointmentUseCase(appointmentRepository);
        return findVetAppoint.searchAppointmentsByVeterinarian(veterinarian);
    }

    public List<Appointment> listAppointmentsByPet(Pet pet) {
        FindAppointmentPetUseCase listAppointmentsByPetUseCase = new FindAppointmentPetUseCase(appointmentRepository);
        return listAppointmentsByPetUseCase.listarConsultasPorPet(pet);
    }

    public void cancelAppointment(int id) {
        CancelAppointmentUseCase cancelAppointment = new CancelAppointmentUseCase(appointmentRepository);
        cancelAppointment.cancelarConsulta(id);
    }

    // Gerencia Pagamento
    public void processPayment(int id) {
        ProcessPaymentUseCase processPaymentUseCase = new ProcessPaymentUseCase(paymentRepository);
        processPaymentUseCase.processarPagamento(id);
    }

    public Payment findPayment(int id) {
        FindPaymentUseCase findPaymentUseCase = new FindPaymentUseCase(paymentRepository);
        return  findPaymentUseCase.visualizarPagamento(id);
    }
}
