package br.edu.ifsp.domain.model.client;

public class Record {
    private String description;

    public Record(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
