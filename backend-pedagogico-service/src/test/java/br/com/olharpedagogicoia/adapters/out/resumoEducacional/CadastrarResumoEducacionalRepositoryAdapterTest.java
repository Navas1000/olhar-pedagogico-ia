package br.com.olharpedagogicoia.adapters.out.resumoEducacional;

import br.com.olharpedagogicoia.adapters.out.resumoEducacional.entity.ResumoEducacionalEntity;
import br.com.olharpedagogicoia.adapters.out.resumoEducacional.mapper.ResumoEducacionalMapper;
import br.com.olharpedagogicoia.adapters.out.resumoEducacional.repository.ResumoEducacionalRepository;
import br.com.olharpedagogicoia.application.dto.ResumoEducacionalDTO;
import br.com.olharpedagogicoia.application.stub.ResumoEducacionalStub;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CadastrarResumoEducacionalRepositoryAdapterTest {

    @Mock
    private ResumoEducacionalRepository resumoEducacionalRepository;

    @Mock
    private ResumoEducacionalMapper resumoEducacionalMapper;

    @InjectMocks
    private CadastrarResumoEducacionalRepositoryAdapter cadastrarResumoEducacionalRepositoryAdapter;

    @Test
    void deveCadastrarResumoEducacionalComSucesso() {

        final ResumoEducacionalDTO resumoEducacionalDTO =
                ResumoEducacionalStub.getResumoEducacionalCompleta();

        final ResumoEducacionalEntity resumoEducacionalEntity =
                new ResumoEducacionalEntity();

        when(resumoEducacionalMapper.deResumoEducacionalDTOParaResumoEducacionalEntity(resumoEducacionalDTO))
                .thenReturn(resumoEducacionalEntity);

        when(resumoEducacionalRepository.save(resumoEducacionalEntity))
                .thenReturn(resumoEducacionalEntity);

        when(resumoEducacionalMapper.deResumoEducacionalEntityParaResumoEducacionalDTO(resumoEducacionalEntity))
                .thenReturn(resumoEducacionalDTO);

        final ResumoEducacionalDTO resposta =
                cadastrarResumoEducacionalRepositoryAdapter.cadastrar(resumoEducacionalDTO);

        assertNotNull(resposta);
        assertEquals(resumoEducacionalDTO, resposta);

        verify(resumoEducacionalMapper).deResumoEducacionalDTOParaResumoEducacionalEntity(resumoEducacionalDTO);
        verify(resumoEducacionalRepository).save(resumoEducacionalEntity);
        verify(resumoEducacionalMapper).deResumoEducacionalEntityParaResumoEducacionalDTO(resumoEducacionalEntity);
    }
}