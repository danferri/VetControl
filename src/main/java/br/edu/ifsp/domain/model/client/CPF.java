package br.edu.ifsp.domain.model.client;

public final class CPF {
    private String number;
    private Boolean valid;

    public CPF(String num) {
        num = num.replaceAll("[^0-9]", "");
        this.setNumber(num);
        this.valid = validCPF(this.number);
    }

    public static boolean validCPF(String cpf) {
        if (cpf.length() != 11){
            System.out.println("CPF deve conter 11 dígitos.");
            return false;
        }

        if (cpf.matches(cpf.charAt(0) + "{11}")) {
            System.out.println("CPF com unico digito repetido.");
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

    public void showCPF() {
        System.out.println("CPF: " + this.number);
        System.out.print("Verificação: ");
        if(valid) System.out.println("Válido"); else System.out.println("Inválido");
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }
}
