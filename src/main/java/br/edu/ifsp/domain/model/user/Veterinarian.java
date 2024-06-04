package br.edu.ifsp.domain.model.user;

public class Veterinarian {
    private String id;
    private String name;
    private String address;
    private String specialty;
    private String phone;
    private CRMV crmv;
    private String contact;
    private VeterinarianStatus status;

    public Veterinarian( String name, String address, String specialty, String phone, CRMV crmv, String contact) {
        this.name = name;
        this.address = address;
        this.specialty = specialty;
        this.phone = phone;
        this.crmv = crmv;
        this.status = VeterinarianStatus.ACTIVE;
        this.contact = contact;
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

 public void setStatus(VeterinarianStatus status){
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
                ", status =" + status +
                '}';
    }

    public String getContact() {
        return contact;
    }
}
