package br.com.olharpedagogicoia.application.usecase;


import br.com.olharpedagogicoia.application.dto.TurmaDto;
import br.com.olharpedagogicoia.application.dto.UnidadeDto;
import br.com.olharpedagogicoia.application.exceptions.TurmaNaoEncontradaException;
import br.com.olharpedagogicoia.application.exceptions.UnidadeNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.in.ConsultarTurmaPortIn;
import br.com.olharpedagogicoia.application.port.in.ConsultarUnidadePortIn;
import br.com.olharpedagogicoia.application.port.out.ConsultarTurmaPortOut;
import br.com.olharpedagogicoia.application.port.out.ConsultarUnidadePortOut;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class ConsultarTurmaUseCase implements ConsultarTurmaPortIn {

    final ConsultarTurmaPortOut consultarTurmaPortOut;

    @Override
    public TurmaDto consultar(final Integer id) throws TurmaNaoEncontradaException {


        TurmaDto turmaDto = consultarTurmaPortOut.consultar(id);

        log.info("Turma consultada com sucesso: {}", turmaDto);
        return turmaDto;



    }
}
