package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.ProfessorTurmaDTO;
import br.com.olharpedagogicoia.application.port.in.CadastrarProfessorTurmaPortIn;
import br.com.olharpedagogicoia.application.port.out.CadastrarProfessorTurmaPortOut;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
@AllArgsConstructor
public class CadastrarProfessorTurmaUseCase implements CadastrarProfessorTurmaPortIn {

    final CadastrarProfessorTurmaPortOut cadastrarProfessorTurmaPortOut;

    @Override
    public ProfessorTurmaDTO cadastrar(final ProfessorTurmaDTO professorTurmaDTO) {

        professorTurmaDTO.setDataCriacao(LocalDateTime.now());

        final ProfessorTurmaDTO professorTurmaCadastrado =
                cadastrarProfessorTurmaPortOut.cadastrar(professorTurmaDTO);

        log.info("Professor Turma cadastrado com sucesso: {}", professorTurmaCadastrado);

        return professorTurmaCadastrado;
    }
}