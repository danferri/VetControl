package br.edu.ifsp.domain.usecases.login;

//CDU001 - Fazer login

import br.edu.ifsp.domain.model.user.User;
import br.edu.ifsp.domain.model.user.VeterinarianRepository;

public class LoginUserUseCase {
    private VeterinarianRepository veterinarianRepository;

    public LoginUserUseCase(VeterinarianRepository veterinarianRepository) {
        this.veterinarianRepository = veterinarianRepository;
    }
}
