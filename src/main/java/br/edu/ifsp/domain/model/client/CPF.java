package br.edu.ifsp.domain.model.client;

public final class CPF {
    private final String number;
    private final boolean valid;

    public CPF(String num) {
        num = num.replaceAll("[^0-9]", "");
        this.number = num;
        this.valid = validateCPF(this.number);
    }

    public static boolean validateCPF(String cpf) {
        if (cpf.length() != 11) {
            System.out.println("CPF deve conter 11 dígitos.");
            return false;
        }

        if (cpf.matches(cpf.charAt(0) + "{11}")) {
            System.out.println("CPF com único dígito repetido.");
            return false;
        }

        int sum = 0;
        for (int i = 0; i < 9; i++)
            sum += Integer.parseInt(cpf.charAt(i) + "") * (10 - i);
        int rest = sum % 11;
        int dig1 = (rest < 2) ? 0 : 11 - rest;

        sum = 0;
        for (int i = 0; i < 10; i++)
            sum += Integer.parseInt(cpf.charAt(i) + "") * (11 - i);
        rest = sum % 11;
        int dig2 = (rest < 2) ? 0 : 11 - rest;

        return dig1 == Integer.parseInt(cpf.charAt(9) + "") && dig2 == Integer.parseInt(cpf.charAt(10) + "");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        CPF other = (CPF) obj;
        return number.equals(other.number) && valid == other.valid;
    }

    @Override
    public String toString() {
        return number;
    }

    public String getNumber() {
        return number;
    }

    public boolean isValid(CPF cpf) {
        return valid;
    }
}

