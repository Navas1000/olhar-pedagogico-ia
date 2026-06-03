package br.com.olharpedagogicoia.adapters.out.aula;

import br.com.olharpedagogicoia.adapters.out.aula.entity.AulaEntity;
import br.com.olharpedagogicoia.adapters.out.aula.mapper.AulaMapper;
import br.com.olharpedagogicoia.adapters.out.aula.repository.AulaRepository;
import br.com.olharpedagogicoia.application.dto.AulaDTO;
import br.com.olharpedagogicoia.application.exceptions.AulaNaoEncontradaException;
import br.com.olharpedagogicoia.application.stub.AulaStub;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ConsultarAulaRepositoryAdapterTest {

    @Mock
    private AulaRepository aulaRepository;

    @Mock
    private AulaMapper aulaMapper;

    @InjectMocks
    private ConsultarAulaRepositoryAdapter consultarAulaRepositoryAdapter;

    @Test
    void deveConsultarAulaComSucesso() throws AulaNaoEncontradaException {

        final Integer idAula = 1;
        final AulaDTO aulaDTO = AulaStub.getAulaCompleta();
        final AulaEntity aulaEntity = new AulaEntity();

        when(aulaRepository.findById(idAula)).thenReturn(Optional.of(aulaEntity));
        when(aulaMapper.deAulaEntityParaAulaDTO(aulaEntity)).thenReturn(aulaDTO);

        final AulaDTO resposta = consultarAulaRepositoryAdapter.consultar(idAula);

        assertNotNull(resposta);
        assertEquals(aulaDTO, resposta);

        verify(aulaRepository).findById(idAula);
        verify(aulaMapper).deAulaEntityParaAulaDTO(aulaEntity);
    }

    @Test
    void deveLancarExcecaoQuandoAulaNaoForEncontrada() {

        final Integer idAula = 1;

        when(aulaRepository.findById(idAula)).thenReturn(Optional.empty());

        assertThrows(
                AulaNaoEncontradaException.class,
                () -> consultarAulaRepositoryAdapter.consultar(idAula)
        );

        verify(aulaRepository).findById(idAula);
        verifyNoInteractions(aulaMapper);
    }
}