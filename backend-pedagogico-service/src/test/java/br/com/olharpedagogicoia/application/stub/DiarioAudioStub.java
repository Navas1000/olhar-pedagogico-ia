package br.com.olharpedagogicoia.application.stub;

import br.com.olharpedagogicoia.application.dto.DiarioAudioDTO;
import br.com.olharpedagogicoia.application.util.RecursoUtil;

public class DiarioAudioStub {

    public static DiarioAudioDTO getDiarioAudioCompleta() {
        return RecursoUtil.getObject(
                "diarioAudio/diarioAudioCompleta.json",
                DiarioAudioDTO.class
        );
    }

    public static DiarioAudioDTO getDiarioAudioCadastrar() {
        return RecursoUtil.getObject(
                "diarioAudio/diarioAudioCadastrar.json",
                DiarioAudioDTO.class
        );
    }

    public static DiarioAudioDTO getDiarioAudioAlterada() {
        return RecursoUtil.getObject(
                "diarioAudio/diarioAudioAlterada.json",
                DiarioAudioDTO.class
        );
    }
}