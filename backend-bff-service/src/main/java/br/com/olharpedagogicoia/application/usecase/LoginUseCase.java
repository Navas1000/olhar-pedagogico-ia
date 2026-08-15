package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.LoginDTO;
import br.com.olharpedagogicoia.application.port.in.LoginPortIn;
import br.com.olharpedagogicoia.application.port.out.ValidarFuncionarioPortOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class LoginUseCase implements LoginPortIn {

    private final ValidarFuncionarioPortOut validarFuncionarioPortOut;

    @Override
    public LoginDTO login(final LoginDTO loginDTO) {

        return validarFuncionarioPortOut.validar(loginDTO);

    }
}