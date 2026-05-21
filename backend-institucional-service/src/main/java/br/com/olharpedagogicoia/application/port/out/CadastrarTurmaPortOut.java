package br.com.olharpedagogicoia.application.port.out;

import br.com.olharpedagogicoia.application.dto.TurmaDto;
import br.com.olharpedagogicoia.application.dto.UnidadeDto;

public interface CadastrarTurmaPortOut {

    public TurmaDto cadastrar(final TurmaDto turmaDto);

}
