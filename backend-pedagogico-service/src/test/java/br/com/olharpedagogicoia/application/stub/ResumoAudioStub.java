package br.com.olharpedagogicoia.application.stub;

import br.com.olharpedagogicoia.application.dto.ResumoAudioDTO;
import br.com.olharpedagogicoia.application.util.RecursoUtil;

public class ResumoAudioStub {

    public static ResumoAudioDTO getResumoAudioCompleta() {
        return RecursoUtil.getObject(
                "resumoAudio/resumoAudioCompleta.json",
                ResumoAudioDTO.class
        );
    }

    public static ResumoAudioDTO getResumoAudioCadastrar() {
        return RecursoUtil.getObject(
                "resumoAudio/resumoAudioCadastrar.json",
                ResumoAudioDTO.class
        );
    }

    public static ResumoAudioDTO getResumoAudioAlterada() {
        return RecursoUtil.getObject(
                "resumoAudio/resumoAudioAlterada.json",
                ResumoAudioDTO.class
        );
    }
}