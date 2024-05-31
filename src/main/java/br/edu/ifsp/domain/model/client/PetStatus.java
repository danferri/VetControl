package br.edu.ifsp.domain.model.client;

public enum PetStatus {
    ACTIVE("Active"),
    INACTIVE("Inactive");

    private String status;

    private PetStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PetStatus{" +
                "status='" + status + '\'' +
                '}';
    }
}
