package br.com.olharpedagogicoia.adapters.out.aluno;

import br.com.olharpedagogicoia.adapters.out.aluno.entity.AlunoEntity;
import br.com.olharpedagogicoia.adapters.out.aluno.mapper.AlunoMapper;
import br.com.olharpedagogicoia.adapters.out.aluno.repository.AlunoRepository;
import br.com.olharpedagogicoia.application.dto.AlunoDTO;
import br.com.olharpedagogicoia.application.stub.AlunoStub;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AtualizarAlunoRepositoryAdapterTest {

    @Mock
    private AlunoRepository alunoRepository;

    @Mock
    private AlunoMapper alunoMapper;

    @InjectMocks
    private AtualizarAlunoRepositoryAdapter atualizarAlunoRepositoryAdapter;

    @Test
    void deveAtualizarAlunoComSucesso() {

        final AlunoDTO alunoDTO = AlunoStub.getAlunoCompleta();
        final AlunoEntity alunoEntity = new AlunoEntity();

        when(alunoMapper.deAlunoDTOParaAlunoEntity(alunoDTO)).thenReturn(alunoEntity);
        when(alunoRepository.save(alunoEntity)).thenReturn(alunoEntity);
        when(alunoMapper.deAlunoEntityParaAlunoDTO(alunoEntity)).thenReturn(alunoDTO);

        final AlunoDTO resposta = atualizarAlunoRepositoryAdapter.atualizar(alunoDTO);

        assertNotNull(resposta);
        assertEquals(alunoDTO, resposta);

        verify(alunoMapper).deAlunoDTOParaAlunoEntity(alunoDTO);
        verify(alunoRepository).save(alunoEntity);
        verify(alunoMapper).deAlunoEntityParaAlunoDTO(alunoEntity);
    }
}