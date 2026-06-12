package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.ResumoEducacionalDTO;
import br.com.olharpedagogicoia.application.port.in.CadastrarResumoEducacionalPortIn;
import br.com.olharpedagogicoia.application.port.out.CadastrarResumoEducacionalPortOut;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
@AllArgsConstructor
public class CadastrarResumoEducacionalUseCase implements CadastrarResumoEducacionalPortIn {

    final CadastrarResumoEducacionalPortOut cadastrarResumoEducacionalPortOut;

    @Override
    public ResumoEducacionalDTO cadastrar(final ResumoEducacionalDTO resumoEducacionalDTO) {

        resumoEducacionalDTO.setDataCriacao(LocalDateTime.now());

        final ResumoEducacionalDTO resumoEducacionalCadastrado =
                cadastrarResumoEducacionalPortOut.cadastrar(resumoEducacionalDTO);

        log.info("Resumo educacional cadastrado com sucesso: {}", resumoEducacionalCadastrado);

        return resumoEducacionalCadastrado;
    }
}