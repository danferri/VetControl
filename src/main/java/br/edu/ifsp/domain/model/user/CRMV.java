package br.edu.ifsp.domain.model.user;

public final class CRMV {
    private final String number;
    private final boolean valid;

    public CRMV(String number) {
        this.number = number;
        this.valid = validateCRM(this.number);
    }

    public static boolean validateCRM(String number) {
        if (number != null && number.matches("SP-\\d+")) {
            System.out.println("Valid CRM.");
            return true;
        } else {
            System.out.println("Invalid CRM.");
            return false;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CRMV other = (CRMV) obj;
        return this.number.equals(other.number) && this.valid == other.valid;
    }

    @Override
    public String toString() {
        return "CRM{" +
                "number='" + number + '\'' +
                ", valid=" + valid +
                '}';
    }

    public String getNumber() {
        return number;
    }

    public boolean isValid() {
        return valid;
    }
}

