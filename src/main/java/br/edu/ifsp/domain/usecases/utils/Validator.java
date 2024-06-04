package br.edu.ifsp.domain.usecases.utils;

import br.edu.ifsp.domain.model.client.CPF;
import br.edu.ifsp.domain.model.user.CRMV;

import java.util.Collection;

public abstract class Validator<T> {
    public abstract Notification validate(T type);

    public static boolean nullOrEmpty(String string) {
        return string == null || string.isEmpty();
    }

    public static boolean nullOrEmpty(Collection collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean nullOrEmpty(CRMV crmv) {
        return crmv == null || !crmv.isValid();
    }

    public static boolean nullOrEmpty(CPF cpf) {
        return cpf == null || !cpf.isValid(cpf);
    }
}
