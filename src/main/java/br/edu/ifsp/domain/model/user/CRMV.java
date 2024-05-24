package br.edu.ifsp.domain.model.user;

public final class CRMV {
    private final String number;
    private final boolean valid;

    public CRMV(String number) {
        this.number = number;
        this.valid = validateCRMV();
    }

    private boolean validateCRMV() {

        if (number == null || number.isEmpty()) {
            return false;
        }
        String cleanedNumber = number.replaceAll("[^0-9]", "");
        return cleanedNumber.length() == 6 && cleanedNumber.startsWith("123");  // Example criteria
    }

    public String getNumber() {
        return number;
    }

    public boolean isValid() {
        return valid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CRMV crmv = (CRMV) o;
        return number.equals(crmv.number);
    }

    @Override
    public int hashCode() {
        return number.hashCode();
    }

    @Override
    public String toString() {
        return "CRMV{" +
                "number='" + number + '\'' +
                ", valid=" + valid +
                '}';
    }
}
