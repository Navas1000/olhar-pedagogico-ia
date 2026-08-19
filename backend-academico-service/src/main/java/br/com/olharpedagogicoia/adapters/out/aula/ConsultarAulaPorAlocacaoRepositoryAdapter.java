package br.com.olharpedagogicoia.adapters.out.aula;

import br.com.olharpedagogicoia.adapters.out.aula.entity.AulaEntity;
import br.com.olharpedagogicoia.adapters.out.aula.mapper.AulaMapper;
import br.com.olharpedagogicoia.adapters.out.aula.repository.AulaRepository;
import br.com.olharpedagogicoia.application.dto.AulaDTO;
import br.com.olharpedagogicoia.application.port.out.ConsultarAulaPorAlocacaoPortOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ConsultarAulaPorAlocacaoRepositoryAdapter
        implements ConsultarAulaPorAlocacaoPortOut {

    private final AulaRepository aulaRepository;
    private final AulaMapper aulaMapper;

    @Override
    public List<AulaDTO> consultarPorAlocacao(final Integer idAlocacao) {

        final List<AulaEntity> aulas =
                aulaRepository.findByIdAlocacao(idAlocacao);

        return aulas.stream()
                .map(aulaMapper::deAulaEntityParaAulaDTO)
                .toList();
    }
}