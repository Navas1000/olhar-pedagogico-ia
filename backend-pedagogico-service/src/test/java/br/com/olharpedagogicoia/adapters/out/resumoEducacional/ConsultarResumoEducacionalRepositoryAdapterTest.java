package br.com.olharpedagogicoia.adapters.out.resumoEducacional;

import br.com.olharpedagogicoia.adapters.out.resumoEducacional.entity.ResumoEducacionalEntity;
import br.com.olharpedagogicoia.adapters.out.resumoEducacional.mapper.ResumoEducacionalMapper;
import br.com.olharpedagogicoia.adapters.out.resumoEducacional.repository.ResumoEducacionalRepository;
import br.com.olharpedagogicoia.application.dto.ResumoEducacionalDTO;
import br.com.olharpedagogicoia.application.exceptions.ResumoEducacionalNaoEncontradoException;
import br.com.olharpedagogicoia.application.stub.ResumoEducacionalStub;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ConsultarResumoEducacionalRepositoryAdapterTest {

    @Mock
    private ResumoEducacionalRepository resumoEducacionalRepository;

    @Mock
    private ResumoEducacionalMapper resumoEducacionalMapper;

    @InjectMocks
    private ConsultarResumoEducacionalRepositoryAdapter consultarResumoEducacionalRepositoryAdapter;

    @Test
    void deveConsultarResumoEducacionalComSucesso() throws ResumoEducacionalNaoEncontradoException {

        final Integer idResumo = 1;

        final ResumoEducacionalDTO resumoEducacionalDTO =
                ResumoEducacionalStub.getResumoEducacionalCompleta();

        final ResumoEducacionalEntity resumoEducacionalEntity =
                new ResumoEducacionalEntity();

        when(resumoEducacionalRepository.findById(idResumo))
                .thenReturn(Optional.of(resumoEducacionalEntity));

        when(resumoEducacionalMapper.deResumoEducacionalEntityParaResumoEducacionalDTO(resumoEducacionalEntity))
                .thenReturn(resumoEducacionalDTO);

        final ResumoEducacionalDTO resposta =
                consultarResumoEducacionalRepositoryAdapter.consultar(idResumo);

        assertNotNull(resposta);
        assertEquals(resumoEducacionalDTO, resposta);

        verify(resumoEducacionalRepository).findById(idResumo);
        verify(resumoEducacionalMapper).deResumoEducacionalEntityParaResumoEducacionalDTO(resumoEducacionalEntity);
    }

    @Test
    void deveLancarExcecaoQuandoResumoEducacionalNaoForEncontrado() {

        final Integer idResumo = 1;

        when(resumoEducacionalRepository.findById(idResumo))
                .thenReturn(Optional.empty());

        assertThrows(
                ResumoEducacionalNaoEncontradoException.class,
                () -> consultarResumoEducacionalRepositoryAdapter.consultar(idResumo)
        );

        verify(resumoEducacionalRepository).findById(idResumo);
        verifyNoInteractions(resumoEducacionalMapper);
    }
}