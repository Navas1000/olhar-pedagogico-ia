package br.com.olharpedagogicoia.adapters.out.pessoas;

import br.com.olharpedagogicoia.application.dto.LoginDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "login-usuario", url = "${backend.pessoas.url}")
public interface LoginClient {

    @GetMapping(value = "/funcionario/validar", consumes = MediaType.APPLICATION_JSON_VALUE)
    LoginDTO validarUsuario(@RequestBody final LoginDTO usuario);

}
