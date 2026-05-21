package br.com.olharpedagogicoia.application.port.in;


import br.com.olharpedagogicoia.application.dto.TurmaDto;
import br.com.olharpedagogicoia.application.dto.UnidadeDto;

public interface CadastrarTurmaPortIn {

    public TurmaDto cadastrar(final TurmaDto turmaDto);

}
