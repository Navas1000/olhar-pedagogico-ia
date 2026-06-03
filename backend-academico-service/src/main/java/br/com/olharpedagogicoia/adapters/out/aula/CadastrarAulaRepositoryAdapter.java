package br.com.olharpedagogicoia.adapters.out.aula;

import br.com.olharpedagogicoia.adapters.out.aula.entity.AulaEntity;
import br.com.olharpedagogicoia.adapters.out.aula.mapper.AulaMapper;
import br.com.olharpedagogicoia.adapters.out.aula.repository.AulaRepository;
import br.com.olharpedagogicoia.application.dto.AulaDTO;
import br.com.olharpedagogicoia.application.port.out.CadastrarAulaPortOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CadastrarAulaRepositoryAdapter implements CadastrarAulaPortOut {

    private final AulaRepository aulaRepository;
    private final AulaMapper aulaMapper;

    @Override
    public AulaDTO cadastrar(final AulaDTO aulaDTO) {

        final AulaEntity aulaEntity =
                aulaMapper.deAulaDTOParaAulaEntity(aulaDTO);

        final AulaEntity aulaSalva =
                aulaRepository.save(aulaEntity);

        return aulaMapper.deAulaEntityParaAulaDTO(aulaSalva);
    }
}