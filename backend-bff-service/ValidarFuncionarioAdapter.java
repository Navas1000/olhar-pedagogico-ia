package br.com.olharpedagogicoia.adapters.out.pessoas;

import br.com.olharpedagogicoia.application.dto.LoginDTO;
import br.com.olharpedagogicoia.application.port.out.ValidarFuncionarioPortOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ValidarFuncionarioAdapter implements ValidarFuncionarioPortOut {

    private LoginClient loginClient;

    @Override
    public LoginDTO validar(
            final LoginDTO loginDTO) {
        return loginClient.validarUsuario(loginDTO);
    }
}