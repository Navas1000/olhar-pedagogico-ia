package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.FuncionarioDTO;
import br.com.olharpedagogicoia.application.exceptions.Constantes;
import br.com.olharpedagogicoia.application.exceptions.FuncionarioNaoEncontradoException;
import br.com.olharpedagogicoia.application.exceptions.IdFuncionarioObrigatorioException;
import br.com.olharpedagogicoia.application.port.in.AtualizarFuncionarioPortIn;
import br.com.olharpedagogicoia.application.port.out.AtualizarFuncionarioPortOut;
import br.com.olharpedagogicoia.application.port.out.ConsultarFuncionarioPortOut;
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
public class AtualizarFuncionarioUseCase implements AtualizarFuncionarioPortIn {

    final AtualizarFuncionarioPortOut atualizarFuncionarioPortOut;
    final ConsultarFuncionarioPortOut consultarFuncionarioPortOut;

    final Salt salt;

    @Override
    public FuncionarioDTO atualizar(final FuncionarioDTO funcionarioDTO)
            throws FuncionarioNaoEncontradoException, IdFuncionarioObrigatorioException {

        if (Objects.isNull(funcionarioDTO.getSenha()) || funcionarioDTO.getSenha().isBlank())
            throw new IllegalArgumentException("A senha do funcionário é obrigatória");

        if (Objects.isNull(funcionarioDTO.getIdFuncionario()))
            throw new IdFuncionarioObrigatorioException(Constantes.ID_FUNCIONARIO_OBRIGATORIO);

        final FuncionarioDTO funcionarioConsultado =
                consultarFuncionarioPortOut.consultar(funcionarioDTO.getIdFuncionario());

        funcionarioDTO.setDataCriacao(funcionarioConsultado.getDataCriacao());
        funcionarioDTO.setDataModificacao(LocalDateTime.now());


        final String senhaCriptografada =
                FuncionarioSenhaUtil.gerarSenhaCriptografada(funcionarioDTO.getSenha(), salt.getSalt());

        funcionarioDTO.setSenha(senhaCriptografada);

        final FuncionarioDTO funcionarioAtualizado =
                atualizarFuncionarioPortOut.atualizar(funcionarioDTO);

        funcionarioAtualizado.setSenha(null);

        log.info("Funcionário atualizado com sucesso: {}", funcionarioAtualizado);

        return funcionarioAtualizado;
    }
}