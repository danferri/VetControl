package br.edu.ifsp.domain.model.user;

public final class CRMV {
    private String crmv;

    public CRMV(String crmv) {
        this.crmv = crmv;
    }

    private boolean validCRMV(CRMV crmv) {
        if (crmv != null && crmv.crmv.matches("SP-\\d+")) {
            System.out.println("CRMV válido.");
            return true;
        } else {
            System.out.println("CRMV inválido.");
            return false;
        }
    }

    public boolean isValid(CRMV crmv){
        return validCRMV(crmv);
    }



    public void showCRMV() {
        System.out.println("CRMV: " + this.crmv);
    }

    public String getCrmv() {
        return crmv;
    }

    public void setCrmv(String crmv) {
        this.crmv = crmv;
    }
}
