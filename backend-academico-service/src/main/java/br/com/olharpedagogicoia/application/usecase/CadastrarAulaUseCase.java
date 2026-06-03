package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.AulaDTO;
import br.com.olharpedagogicoia.application.port.in.CadastrarAulaPortIn;
import br.com.olharpedagogicoia.application.port.out.CadastrarAulaPortOut;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
@AllArgsConstructor
public class CadastrarAulaUseCase implements CadastrarAulaPortIn {

    final CadastrarAulaPortOut cadastrarAulaPortOut;

    @Override
    public AulaDTO cadastrar(final AulaDTO aulaDTO) {

        aulaDTO.setDataCriacao(LocalDateTime.now());

        final AulaDTO aulaCadastrada = cadastrarAulaPortOut.cadastrar(aulaDTO);

        log.info("Aula cadastrada com sucesso: {}", aulaCadastrada);

        return aulaCadastrada;
    }
}