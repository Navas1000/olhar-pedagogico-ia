package br.com.olharpedagogicoia.application.port.in;

import br.com.olharpedagogicoia.application.dto.LoginDTO;

public interface LoginPortIn {

    LoginDTO login(final LoginDTO loginDTO);

}