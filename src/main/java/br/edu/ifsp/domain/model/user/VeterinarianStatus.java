package br.edu.ifsp.domain.model.user;

import java.util.Arrays;

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

    public static VeterinarianStatus toEnum(String value){
        return Arrays.stream(VeterinarianStatus.values())
                .filter(v -> value.equals(v.toString()))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }
}

