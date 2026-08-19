package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.ProfessorTurmaDTO;
import br.com.olharpedagogicoia.application.port.in.ConsultarProfessorTurmaPorFuncionarioPortIn;
import br.com.olharpedagogicoia.application.port.out.ConsultarProfessorTurmaPorFuncionarioPortOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ConsultarProfessorTurmaPorFuncionarioUseCase
        implements ConsultarProfessorTurmaPorFuncionarioPortIn {

    private final ConsultarProfessorTurmaPorFuncionarioPortOut
            consultarProfessorTurmaPorFuncionarioPortOut;

    @Override
    public List<ProfessorTurmaDTO> consultarPorFuncionario(
            final Integer idFuncionario) {

        return consultarProfessorTurmaPorFuncionarioPortOut
                .consultarPorFuncionario(idFuncionario);
    }
}