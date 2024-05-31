package br.edu.ifsp.application.main;

import br.edu.ifsp.domain.model.user.CRMV;
import br.edu.ifsp.domain.model.user.Veterinarian;

public class Main {
    public static void main(String[] args) {
        CRMV crmv = new CRMV("16257");
        Veterinarian veterinarian = new Veterinarian("Oie", "Lucas", "Benjamin Constant", "Grdes Animais", "991354610", crmv);
        System.out.println(veterinarian.toString());;

    }
}
