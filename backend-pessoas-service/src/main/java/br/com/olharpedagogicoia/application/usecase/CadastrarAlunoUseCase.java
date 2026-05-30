package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.AlunoDTO;
import br.com.olharpedagogicoia.application.port.in.CadastrarAlunoPortIn;
import br.com.olharpedagogicoia.application.port.out.CadastrarAlunoPortOut;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
@AllArgsConstructor
public class CadastrarAlunoUseCase implements CadastrarAlunoPortIn {

    final CadastrarAlunoPortOut cadastrarAlunoPortOut;

    @Override
    public AlunoDTO cadastrar(final AlunoDTO alunoDTO) {

        alunoDTO.setDataModificacao(LocalDateTime.now());
        alunoDTO.setDataCriacao(LocalDateTime.now());

        final AlunoDTO alunoCadastrado = cadastrarAlunoPortOut.cadastrar(alunoDTO);

        log.info("Aluno cadastrado com sucesso: {}", alunoCadastrado);
        return alunoCadastrado;
    }
}