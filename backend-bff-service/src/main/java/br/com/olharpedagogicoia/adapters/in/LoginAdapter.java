package br.com.olharpedagogicoia.adapters.in;

import br.com.olharpedagogicoia.application.dto.LoginDTO;
import br.com.olharpedagogicoia.application.port.in.LoginPortIn;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@AllArgsConstructor
public class LoginAdapter {

    private final LoginPortIn loginPortIn;

    @PostMapping
    public ResponseEntity<LoginDTO> login(
            @RequestBody @Valid final LoginDTO loginDTO) {

        final LoginDTO loginResponse =
                loginPortIn.login(loginDTO);

        return ResponseEntity.ok(loginResponse);
    }
}