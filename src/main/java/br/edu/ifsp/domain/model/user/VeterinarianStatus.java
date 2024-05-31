package br.edu.ifsp.domain.model.user;

public enum VeterinarianStatus {
    ACTIVE("Active"),
    INACTIVE("Inactive");

    private String status;

    VeterinarianStatus(String status) {
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
        return "VeterinarianStatus{" +
                "status='" + status + '\'' +
                '}';
    }
}

