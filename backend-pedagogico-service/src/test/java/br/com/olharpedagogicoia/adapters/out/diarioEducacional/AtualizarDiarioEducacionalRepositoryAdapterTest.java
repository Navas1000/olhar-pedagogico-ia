package br.com.olharpedagogicoia.adapters.out.diarioEducacional;

import br.com.olharpedagogicoia.adapters.out.diarioEducacional.entity.DiarioEducacionalEntity;
import br.com.olharpedagogicoia.adapters.out.diarioEducacional.mapper.DiarioEducacionalMapper;
import br.com.olharpedagogicoia.adapters.out.diarioEducacional.repository.DiarioEducacionalRepository;
import br.com.olharpedagogicoia.application.dto.DiarioEducacionalDTO;
import br.com.olharpedagogicoia.application.stub.DiarioEducacionalStub;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AtualizarDiarioEducacionalRepositoryAdapterTest {

    @Mock
    private DiarioEducacionalRepository diarioEducacionalRepository;

    @Mock
    private DiarioEducacionalMapper diarioEducacionalMapper;

    @InjectMocks
    private AtualizarDiarioEducacionalRepositoryAdapter atualizarDiarioEducacionalRepositoryAdapter;

    @Test
    void deveAtualizarDiarioEducacionalComSucesso() {

        final DiarioEducacionalDTO diarioEducacionalDTO = DiarioEducacionalStub.getDiarioEducacionalCompleta();
        final DiarioEducacionalEntity diarioEducacionalEntity = new DiarioEducacionalEntity();

        when(diarioEducacionalMapper.deDiarioEducacionalDTOParaDiarioEducacionalEntity(diarioEducacionalDTO))
                .thenReturn(diarioEducacionalEntity);

        when(diarioEducacionalRepository.save(diarioEducacionalEntity))
                .thenReturn(diarioEducacionalEntity);

        when(diarioEducacionalMapper.deDiarioEducacionalEntityParaDiarioEducacionalDTO(diarioEducacionalEntity))
                .thenReturn(diarioEducacionalDTO);

        final DiarioEducacionalDTO resposta =
                atualizarDiarioEducacionalRepositoryAdapter.atualizar(diarioEducacionalDTO);

        assertNotNull(resposta);
        assertEquals(diarioEducacionalDTO, resposta);

        verify(diarioEducacionalMapper).deDiarioEducacionalDTOParaDiarioEducacionalEntity(diarioEducacionalDTO);
        verify(diarioEducacionalRepository).save(diarioEducacionalEntity);
        verify(diarioEducacionalMapper).deDiarioEducacionalEntityParaDiarioEducacionalDTO(diarioEducacionalEntity);
    }
}