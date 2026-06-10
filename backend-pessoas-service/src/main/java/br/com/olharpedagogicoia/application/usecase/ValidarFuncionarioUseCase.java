package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.FuncionarioDTO;
import br.com.olharpedagogicoia.application.exceptions.FuncionarioNaoEncontradoException;
import br.com.olharpedagogicoia.application.port.in.ValidarFuncionarioPortIn;
import br.com.olharpedagogicoia.application.port.out.ValidarFuncionarioPortOut;
import br.com.olharpedagogicoia.application.util.FuncionarioSenhaUtil;
import br.com.olharpedagogicoia.config.Salt;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Slf4j
@Component
@AllArgsConstructor
public class ValidarFuncionarioUseCase implements ValidarFuncionarioPortIn {

    final ValidarFuncionarioPortOut validarFuncionarioPortOut;

    final Salt salt;

    @Override
    public FuncionarioDTO validar(final FuncionarioDTO funcionarioDTO) throws FuncionarioNaoEncontradoException {

        if (Objects.isNull(funcionarioDTO.getNomeUsuario()) || funcionarioDTO.getNomeUsuario().isBlank())
            throw new IllegalArgumentException("O nome de usuário é obrigatório");

        if (Objects.isNull(funcionarioDTO.getSenha()) || funcionarioDTO.getSenha().isBlank())
            throw new IllegalArgumentException("A senha do funcionário é obrigatória");

        final String senhaCriptografada =
                FuncionarioSenhaUtil.gerarSenhaCriptografada(funcionarioDTO.getSenha(), salt.getSalt());

        final FuncionarioDTO funcionarioValidado =
                validarFuncionarioPortOut.validar(funcionarioDTO.getNomeUsuario(), senhaCriptografada);

        funcionarioValidado.setSenha(null);

        log.info("Funcionário validado com sucesso: {}", funcionarioValidado);

        return funcionarioValidado;
    }
}