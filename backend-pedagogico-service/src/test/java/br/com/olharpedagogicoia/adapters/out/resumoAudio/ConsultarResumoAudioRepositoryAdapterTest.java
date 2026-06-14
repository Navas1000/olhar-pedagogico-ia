package br.com.olharpedagogicoia.adapters.out.resumoAudio;

import br.com.olharpedagogicoia.adapters.out.resumoAudio.entity.ResumoAudioEntity;
import br.com.olharpedagogicoia.adapters.out.resumoAudio.mapper.ResumoAudioMapper;
import br.com.olharpedagogicoia.adapters.out.resumoAudio.repository.ResumoAudioRepository;
import br.com.olharpedagogicoia.application.dto.ResumoAudioDTO;
import br.com.olharpedagogicoia.application.exceptions.ResumoAudioNaoEncontradoException;
import br.com.olharpedagogicoia.application.stub.ResumoAudioStub;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ConsultarResumoAudioRepositoryAdapterTest {

    @Mock
    private ResumoAudioRepository resumoAudioRepository;

    @Mock
    private ResumoAudioMapper resumoAudioMapper;

    @InjectMocks
    private ConsultarResumoAudioRepositoryAdapter consultarResumoAudioRepositoryAdapter;

    @Test
    void deveConsultarResumoAudioComSucesso() throws ResumoAudioNaoEncontradoException {

        final Integer idAudio = 1;
        final ResumoAudioDTO resumoAudioDTO = ResumoAudioStub.getResumoAudioCompleta();
        final ResumoAudioEntity resumoAudioEntity = new ResumoAudioEntity();

        when(resumoAudioRepository.findById(idAudio))
                .thenReturn(Optional.of(resumoAudioEntity));

        when(resumoAudioMapper.deResumoAudioEntityParaResumoAudioDTO(resumoAudioEntity))
                .thenReturn(resumoAudioDTO);

        final ResumoAudioDTO resposta =
                consultarResumoAudioRepositoryAdapter.consultar(idAudio);

        assertNotNull(resposta);
        assertEquals(resumoAudioDTO, resposta);

        verify(resumoAudioRepository).findById(idAudio);
        verify(resumoAudioMapper).deResumoAudioEntityParaResumoAudioDTO(resumoAudioEntity);
    }

    @Test
    void deveLancarExcecaoQuandoResumoAudioNaoForEncontrado() {

        final Integer idAudio = 1;

        when(resumoAudioRepository.findById(idAudio))
                .thenReturn(Optional.empty());

        assertThrows(
                ResumoAudioNaoEncontradoException.class,
                () -> consultarResumoAudioRepositoryAdapter.consultar(idAudio)
        );

        verify(resumoAudioRepository).findById(idAudio);
        verifyNoInteractions(resumoAudioMapper);
    }
}