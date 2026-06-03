package br.com.olharpedagogicoia.adapters.out.aula;

import br.com.olharpedagogicoia.adapters.out.aula.entity.AulaEntity;
import br.com.olharpedagogicoia.adapters.out.aula.mapper.AulaMapper;
import br.com.olharpedagogicoia.adapters.out.aula.repository.AulaRepository;
import br.com.olharpedagogicoia.application.dto.AulaDTO;
import br.com.olharpedagogicoia.application.exceptions.AulaNaoEncontradaException;
import br.com.olharpedagogicoia.application.exceptions.Constantes;
import br.com.olharpedagogicoia.application.port.out.ConsultarAulaPortOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ConsultarAulaRepositoryAdapter implements ConsultarAulaPortOut {

    private final AulaRepository aulaRepository;
    private final AulaMapper aulaMapper;

    @Override
    public AulaDTO consultar(final Integer id) throws AulaNaoEncontradaException {

        final Optional<AulaEntity> aulaOpcional = aulaRepository.findById(id);

        if (aulaOpcional.isPresent())
            return aulaMapper.deAulaEntityParaAulaDTO(aulaOpcional.get());

        throw new AulaNaoEncontradaException(Constantes.AULA_NAO_ENCONTRADA);
    }
}