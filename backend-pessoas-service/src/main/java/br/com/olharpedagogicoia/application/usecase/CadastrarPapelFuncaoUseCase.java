package br.com.olharpedagogicoia.application.usecase;

import br.com.olharpedagogicoia.application.dto.PapelFuncaoDTO;
import br.com.olharpedagogicoia.application.port.in.CadastrarPapelFuncaoPortIn;
import br.com.olharpedagogicoia.application.port.out.CadastrarPapelFuncaoPortOut;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
@AllArgsConstructor
public class CadastrarPapelFuncaoUseCase implements CadastrarPapelFuncaoPortIn {

    final CadastrarPapelFuncaoPortOut cadastrarPapelFuncaoPortOut;

    @Override
    public PapelFuncaoDTO cadastrar(final PapelFuncaoDTO papelFuncaoDTO) {

        papelFuncaoDTO.setDataModificacao(LocalDateTime.now());
        papelFuncaoDTO.setDataCriacao(LocalDateTime.now());

        final PapelFuncaoDTO papelFuncaoCadastrado = cadastrarPapelFuncaoPortOut.cadastrar(papelFuncaoDTO);

        log.info("Papel Função cadastrado com sucesso: {}", papelFuncaoCadastrado);
        return papelFuncaoCadastrado;
    }
}