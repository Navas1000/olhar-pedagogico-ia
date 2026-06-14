package br.com.olharpedagogicoia.application.stub;

import br.com.olharpedagogicoia.application.dto.TranscricaoDTO;
import br.com.olharpedagogicoia.application.util.RecursoUtil;

public class TranscricaoStub {

    public static TranscricaoDTO getTranscricaoCompleta() {
        return RecursoUtil.getObject(
                "transcricao/transcricaoCompleta.json",
                TranscricaoDTO.class
        );
    }

    public static TranscricaoDTO getTranscricaoCadastrar() {
        return RecursoUtil.getObject(
                "transcricao/transcricaoCadastrar.json",
                TranscricaoDTO.class
        );
    }

    public static TranscricaoDTO getTranscricaoAlterada() {
        return RecursoUtil.getObject(
                "transcricao/transcricaoAlterada.json",
                TranscricaoDTO.class
        );
    }
}