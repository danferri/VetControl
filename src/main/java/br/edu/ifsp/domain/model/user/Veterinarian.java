package br.edu.ifsp.domain.model.user;

import br.edu.ifsp.application.persistence.AppointmentPersistence;
import br.edu.ifsp.application.persistence.ClientPersistence;
import br.edu.ifsp.application.persistence.PetPersistence;
import br.edu.ifsp.application.persistence.VeterinarianPersistence;
import br.edu.ifsp.domain.model.appointment.AppointmentRepository;
import br.edu.ifsp.domain.model.client.ClientRepository;
import br.edu.ifsp.domain.model.client.PetRepository;
import br.edu.ifsp.domain.model.payment.PaymentRepository;

import java.util.ArrayList;
import java.util.List;

public class Veterinarian implements User {
    private String id;
    private String name;
    private String address;
    private String specialty;
    private String phone;
    private CRMV crmv;
    private String contact;
    private VeterinarianStatus status;
    private static List<Veterinarian> registeredVeterinarians = new ArrayList<>();

    public Veterinarian(String name, String address, String specialty, String phone, CRMV crmv, String contact) {
        if (crmv == null || !crmv.isValid(crmv)) {
            throw new IllegalArgumentException("CRMV inválido.");
        }
        if (isCrmvAlreadyRegistered(crmv)!= null ) {
            throw new IllegalArgumentException("CRMV já cadastrado em outro veterinário.");
        }
        this.name = name;
        this.address = address;
        this.specialty = specialty;
        this.phone = phone;
        this.crmv = crmv;
        this.status = VeterinarianStatus.ACTIVE;
        this.contact = contact;
        registeredVeterinarians.add(this);
    }

    private Veterinarian isCrmvAlreadyRegistered(CRMV crmv) {
        VeterinarianRepository veterinarianRepository = new VeterinarianPersistence();
        PetRepository petRepository  = new PetPersistence();
        AppointmentRepository appointmentRepository = new AppointmentPersistence();

        VeterinarianServices vetServices = new VeterinarianServices(petRepository, appointmentRepository,
                veterinarianRepository);
        return vetServices.findVeterinarian(crmv);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public CRMV getCrmv() {
        return crmv;
    }

    public void setStatus(VeterinarianStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Veterinarian{" +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", specialty='" + specialty + '\'' +
                ", phone='" + phone + '\'' +
                ", crmv=" + crmv +
                ", status=" + status +
                '}';
    }

    public String getContact() {
        return contact;
    }

    public VeterinarianStatus informVeterinarianStatus() {
        return status;
    }

    @Override
    public boolean authenticateUser() {
        if (registeredVeterinarians.contains(this)){
            return true;
        };
        return false;
    }

    @Override
    public boolean accessLevel() {
        return false;
    }
}
