package br.com.olharpedagogicoia.application.port.out;

import br.com.olharpedagogicoia.application.dto.LoginDTO;

public interface ValidarFuncionarioPortOut {

    LoginDTO validar(final LoginDTO loginDTO);

}