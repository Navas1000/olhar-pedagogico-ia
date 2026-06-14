package br.com.olharpedagogicoia.adapters.out.transcricao;

import br.com.olharpedagogicoia.adapters.out.transcricao.entity.TranscricaoEntity;
import br.com.olharpedagogicoia.adapters.out.transcricao.mapper.TranscricaoMapper;
import br.com.olharpedagogicoia.adapters.out.transcricao.repository.TranscricaoRepository;
import br.com.olharpedagogicoia.application.dto.TranscricaoDTO;
import br.com.olharpedagogicoia.application.exceptions.TranscricaoNaoEncontradaException;
import br.com.olharpedagogicoia.application.stub.TranscricaoStub;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ConsultarTranscricaoRepositoryAdapterTest {

    @Mock
    private TranscricaoRepository transcricaoRepository;

    @Mock
    private TranscricaoMapper transcricaoMapper;

    @InjectMocks
    private ConsultarTranscricaoRepositoryAdapter consultarTranscricaoRepositoryAdapter;

    @Test
    void deveConsultarTranscricaoComSucesso() throws TranscricaoNaoEncontradaException {

        final Integer idTranscricao = 1;
        final TranscricaoDTO transcricaoDTO = TranscricaoStub.getTranscricaoCompleta();
        final TranscricaoEntity transcricaoEntity = new TranscricaoEntity();

        when(transcricaoRepository.findById(idTranscricao))
                .thenReturn(Optional.of(transcricaoEntity));

        when(transcricaoMapper.deTranscricaoEntityParaTranscricaoDTO(transcricaoEntity))
                .thenReturn(transcricaoDTO);

        final TranscricaoDTO resposta =
                consultarTranscricaoRepositoryAdapter.consultar(idTranscricao);

        assertNotNull(resposta);
        assertEquals(transcricaoDTO, resposta);

        verify(transcricaoRepository).findById(idTranscricao);
        verify(transcricaoMapper).deTranscricaoEntityParaTranscricaoDTO(transcricaoEntity);
    }

    @Test
    void deveLancarExcecaoQuandoTranscricaoNaoForEncontrada() {

        final Integer idTranscricao = 1;

        when(transcricaoRepository.findById(idTranscricao))
                .thenReturn(Optional.empty());

        assertThrows(
                TranscricaoNaoEncontradaException.class,
                () -> consultarTranscricaoRepositoryAdapter.consultar(idTranscricao)
        );

        verify(transcricaoRepository).findById(idTranscricao);
        verifyNoInteractions(transcricaoMapper);
    }
}