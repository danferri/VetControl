package br.edu.ifsp.domain.model.user;

public final class CRMV {
    private final String number;
    private final boolean valid;

    public CRMV(String number) {
        this.number = number;
        this.valid = validateCRMV();
    }

    public String getNumber() {
        return number;
    }

    public boolean isValid() {
        return valid;
    }

    private boolean validateCRMV() {

        if (number == null || number.isEmpty()) {
            return false;
        }
        String cleanedNumber = number.replaceAll("[^0-9]", "");
        return cleanedNumber.length() == 6 && cleanedNumber.startsWith("123");
    }

    @Override
    public String toString() {
        return "CRMV{" +
                "number='" + number + '\'' +
                ", valid=" + valid +
                '}';
    }
}
