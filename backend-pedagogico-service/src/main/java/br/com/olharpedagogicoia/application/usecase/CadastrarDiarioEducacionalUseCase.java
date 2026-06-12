package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.DiarioEducacionalDTO;
import br.com.olharpedagogicoia.application.port.in.CadastrarDiarioEducacionalPortIn;
import br.com.olharpedagogicoia.application.port.out.CadastrarDiarioEducacionalPortOut;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
@AllArgsConstructor
public class CadastrarDiarioEducacionalUseCase implements CadastrarDiarioEducacionalPortIn {

    final CadastrarDiarioEducacionalPortOut cadastrarDiarioEducacionalPortOut;

    @Override
    public DiarioEducacionalDTO cadastrar(final DiarioEducacionalDTO diarioEducacionalDTO) {

        diarioEducacionalDTO.setDataCriacao(LocalDateTime.now());

        final DiarioEducacionalDTO diarioEducacionalCadastrado =
                cadastrarDiarioEducacionalPortOut.cadastrar(diarioEducacionalDTO);

        log.info("Diário educacional cadastrado com sucesso: {}", diarioEducacionalCadastrado);

        return diarioEducacionalCadastrado;
    }
}