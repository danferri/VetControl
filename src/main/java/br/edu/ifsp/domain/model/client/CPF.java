package br.edu.ifsp.domain.model.client;

public final class CPF {
    private final String numero;
    private final Boolean valido;

    public CPF(String numero) {
        this.numero = numero;
        this.valido = validarCPF();
    }

    public String getNumero() {
        return numero;
    }

    public Boolean isValido() {
        return valido;
    }

    private Boolean validarCPF() {
        String cpfLimpo = numero.replaceAll("[^0-9]", "");
        if (cpfLimpo.length() != 11 || cpfLimpo.matches(cpfLimpo.charAt(0) + "{11}")) return false;

        for (int j = 0; j < 2; j++) {
            int soma = 0;
            for (int i = 0; i < 9 + j; i++) {
                soma += (cpfLimpo.charAt(i) - '0') * (10 + j - i);
            }
            int digitoVerificador = (soma * 10 % 11) % 10;
            if (cpfLimpo.charAt(9 + j) != digitoVerificador + '0') {
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
        return numero.equals(cpf.numero);
    }

    @Override
    public int hashCode() {
        return numero.hashCode();
    }

    @Override
    public String toString() {
        return this.numero;
    }
}
