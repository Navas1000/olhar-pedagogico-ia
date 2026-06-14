package br.com.olharpedagogicoia.adapters.out.resumoAudio;

import br.com.olharpedagogicoia.adapters.out.resumoAudio.entity.ResumoAudioEntity;
import br.com.olharpedagogicoia.adapters.out.resumoAudio.mapper.ResumoAudioMapper;
import br.com.olharpedagogicoia.adapters.out.resumoAudio.repository.ResumoAudioRepository;
import br.com.olharpedagogicoia.application.dto.ResumoAudioDTO;
import br.com.olharpedagogicoia.application.stub.ResumoAudioStub;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AtualizarResumoAudioRepositoryAdapterTest {

    @Mock
    private ResumoAudioRepository resumoAudioRepository;

    @Mock
    private ResumoAudioMapper resumoAudioMapper;

    @InjectMocks
    private AtualizarResumoAudioRepositoryAdapter atualizarResumoAudioRepositoryAdapter;

    @Test
    void deveAtualizarResumoAudioComSucesso() {

        final ResumoAudioDTO resumoAudioDTO = ResumoAudioStub.getResumoAudioCompleta();
        final ResumoAudioEntity resumoAudioEntity = new ResumoAudioEntity();

        when(resumoAudioMapper.deResumoAudioDTOParaResumoAudioEntity(resumoAudioDTO))
                .thenReturn(resumoAudioEntity);

        when(resumoAudioRepository.save(resumoAudioEntity))
                .thenReturn(resumoAudioEntity);

        when(resumoAudioMapper.deResumoAudioEntityParaResumoAudioDTO(resumoAudioEntity))
                .thenReturn(resumoAudioDTO);

        final ResumoAudioDTO resposta =
                atualizarResumoAudioRepositoryAdapter.atualizar(resumoAudioDTO);

        assertNotNull(resposta);
        assertEquals(resumoAudioDTO, resposta);

        verify(resumoAudioMapper).deResumoAudioDTOParaResumoAudioEntity(resumoAudioDTO);
        verify(resumoAudioRepository).save(resumoAudioEntity);
        verify(resumoAudioMapper).deResumoAudioEntityParaResumoAudioDTO(resumoAudioEntity);
    }
}