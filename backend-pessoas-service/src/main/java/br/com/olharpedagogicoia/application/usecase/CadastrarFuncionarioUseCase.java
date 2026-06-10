package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.FuncionarioDTO;
import br.com.olharpedagogicoia.application.port.in.CadastrarFuncionarioPortIn;
import br.com.olharpedagogicoia.application.port.out.CadastrarFuncionarioPortOut;
import br.com.olharpedagogicoia.application.util.FuncionarioSenhaUtil;
import br.com.olharpedagogicoia.config.Salt;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;

@Slf4j
@Component
@AllArgsConstructor
public class CadastrarFuncionarioUseCase implements CadastrarFuncionarioPortIn {

    final CadastrarFuncionarioPortOut cadastrarFuncionarioPortOut;

    final Salt salt;

    @Override
    public FuncionarioDTO cadastrar(final FuncionarioDTO funcionarioDTO) {

        if (Objects.isNull(funcionarioDTO.getSenha()) || funcionarioDTO.getSenha().isBlank())
            throw new IllegalArgumentException("A senha do funcionário é obrigatória");

        funcionarioDTO.setDataModificacao(LocalDateTime.now());
        funcionarioDTO.setDataCriacao(LocalDateTime.now());

        final String senhaCriptografada =
                FuncionarioSenhaUtil.gerarSenhaCriptografada(funcionarioDTO.getSenha(), salt.getSalt());

        funcionarioDTO.setSenha(senhaCriptografada);

        final FuncionarioDTO funcionarioCadastrado =
                cadastrarFuncionarioPortOut.cadastrar(funcionarioDTO);

        funcionarioCadastrado.setSenha(null);

        log.info("Funcionário cadastrado com sucesso: {}", funcionarioCadastrado);

        return funcionarioCadastrado;
    }
}