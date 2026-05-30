package br.com.olharpedagogicoia.application.port.in;

import br.com.olharpedagogicoia.application.dto.AlunoDTO;
import br.com.olharpedagogicoia.application.exceptions.AlunoNaoEncontradoException;
import br.com.olharpedagogicoia.application.exceptions.IdAlunoObrigatorioException;

public interface AtualizarAlunoPortIn {

    public AlunoDTO atualizar(final AlunoDTO alunoDTO) throws AlunoNaoEncontradoException, IdAlunoObrigatorioException;

}