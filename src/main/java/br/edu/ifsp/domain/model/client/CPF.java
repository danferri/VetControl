package br.edu.ifsp.domain.model.client;

public final class CPF {
    private final String number;
    private final Boolean valid;

    public CPF(String number) {
        this.number = number;
        this.valid = validateCPF();
    }

    public String getNumero() {
        return number;
    }

    public Boolean isValid() {
        return valid;
    }

    private Boolean validateCPF() {
        String cpfClean = number.replaceAll("[^0-9]", "");
        if (cpfClean.length() != 11 || cpfClean.matches(cpfClean.charAt(0) + "{11}")) return false;

        for (int j = 0; j < 2; j++) {
            int soma = 0;
            for (int i = 0; i < 9 + j; i++) {
                soma += (cpfClean.charAt(i) - '0') * (10 + j - i);
            }
            int digitoVerificador = (soma * 10 % 11) % 10;
            if (cpfClean.charAt(9 +  j) != digitoVerificador + '0') {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CPF cpf = (CPF) o;
        return number.equals(cpf.number);
    }

    @Override
    public int hashCode() {
        return number.hashCode();
    }

    @Override
    public String toString() {
        return this.number;
    }
}
