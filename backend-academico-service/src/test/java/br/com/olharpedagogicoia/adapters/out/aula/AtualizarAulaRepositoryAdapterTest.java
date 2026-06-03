package br.com.olharpedagogicoia.adapters.out.aula;

import br.com.olharpedagogicoia.adapters.out.aula.entity.AulaEntity;
import br.com.olharpedagogicoia.adapters.out.aula.mapper.AulaMapper;
import br.com.olharpedagogicoia.adapters.out.aula.repository.AulaRepository;
import br.com.olharpedagogicoia.application.dto.AulaDTO;
import br.com.olharpedagogicoia.application.stub.AulaStub;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AtualizarAulaRepositoryAdapterTest {

    @Mock
    private AulaRepository aulaRepository;

    @Mock
    private AulaMapper aulaMapper;

    @InjectMocks
    private AtualizarAulaRepositoryAdapter atualizarAulaRepositoryAdapter;

    @Test
    void deveAtualizarAulaComSucesso() {

        final AulaDTO aulaDTO = AulaStub.getAulaCompleta();
        final AulaEntity aulaEntity = new AulaEntity();

        when(aulaMapper.deAulaDTOParaAulaEntity(aulaDTO)).thenReturn(aulaEntity);
        when(aulaRepository.save(aulaEntity)).thenReturn(aulaEntity);
        when(aulaMapper.deAulaEntityParaAulaDTO(aulaEntity)).thenReturn(aulaDTO);

        final AulaDTO resposta = atualizarAulaRepositoryAdapter.atualizar(aulaDTO);

        assertNotNull(resposta);
        assertEquals(aulaDTO, resposta);

        verify(aulaMapper).deAulaDTOParaAulaEntity(aulaDTO);
        verify(aulaRepository).save(aulaEntity);
        verify(aulaMapper).deAulaEntityParaAulaDTO(aulaEntity);
    }
}