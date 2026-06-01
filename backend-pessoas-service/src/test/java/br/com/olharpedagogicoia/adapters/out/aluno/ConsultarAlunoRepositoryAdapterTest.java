package br.com.olharpedagogicoia.adapters.out.aluno;

import br.com.olharpedagogicoia.adapters.out.aluno.entity.AlunoEntity;
import br.com.olharpedagogicoia.adapters.out.aluno.mapper.AlunoMapper;
import br.com.olharpedagogicoia.adapters.out.aluno.repository.AlunoRepository;
import br.com.olharpedagogicoia.application.dto.AlunoDTO;
import br.com.olharpedagogicoia.application.exceptions.AlunoNaoEncontradoException;
import br.com.olharpedagogicoia.application.stub.AlunoStub;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ConsultarAlunoRepositoryAdapterTest {

    @Mock
    private AlunoRepository alunoRepository;

    @Mock
    private AlunoMapper alunoMapper;

    @InjectMocks
    private ConsultarAlunoRepositoryAdapter consultarAlunoRepositoryAdapter;

    @Test
    void deveConsultarAlunoComSucesso() throws AlunoNaoEncontradoException {

        final Integer idAluno = 1;
        final AlunoDTO alunoDTO = AlunoStub.getAlunoCompleta();
        final AlunoEntity alunoEntity = new AlunoEntity();

        when(alunoRepository.findById(idAluno)).thenReturn(Optional.of(alunoEntity));
        when(alunoMapper.deAlunoEntityParaAlunoDTO(alunoEntity)).thenReturn(alunoDTO);

        final AlunoDTO resposta = consultarAlunoRepositoryAdapter.consultar(idAluno);

        assertNotNull(resposta);
        assertEquals(alunoDTO, resposta);

        verify(alunoRepository).findById(idAluno);
        verify(alunoMapper).deAlunoEntityParaAlunoDTO(alunoEntity);
    }

    @Test
    void deveLancarExcecaoQuandoAlunoNaoForEncontrado() {

        final Integer idAluno = 1;

        when(alunoRepository.findById(idAluno)).thenReturn(Optional.empty());

        assertThrows(AlunoNaoEncontradoException.class,
                () -> consultarAlunoRepositoryAdapter.consultar(idAluno));

        verify(alunoRepository).findById(idAluno);
        verifyNoInteractions(alunoMapper);
    }
}