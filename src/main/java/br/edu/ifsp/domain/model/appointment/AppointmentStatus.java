package br.edu.ifsp.domain.model.appointment;

public enum AppointmentStatus {
    SCHEDULED("Scheduled"),
    CANCELED("Canceled"),
    COMPLETED("Completed");

    private String status;

    AppointmentStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}

