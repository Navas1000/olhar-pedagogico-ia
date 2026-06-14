package br.com.olharpedagogicoia.application.port.in;

import br.com.olharpedagogicoia.application.dto.DiarioEducacionalDTO;
import br.com.olharpedagogicoia.application.exceptions.DiarioEducacionalNaoEncontradoException;
import br.com.olharpedagogicoia.application.exceptions.IdDiarioEducacionalObrigatorioException;

public interface AtualizarDiarioEducacionalPortIn {

    public DiarioEducacionalDTO atualizar(final DiarioEducacionalDTO diarioEducacionalDTO)
            throws DiarioEducacionalNaoEncontradoException, IdDiarioEducacionalObrigatorioException;
}