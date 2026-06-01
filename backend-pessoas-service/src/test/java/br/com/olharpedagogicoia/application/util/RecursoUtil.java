package br.com.olharpedagogicoia.application.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

@Slf4j
public class RecursoUtil {

    static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> T getObject(final String pathOrContentJsonFile, final Class<T> responseClass) {
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        try {
            return getResource(pathOrContentJsonFile, responseClass);
        } catch (final Exception excecao) {
            log.error(excecao.getMessage(), excecao);
            throw new RuntimeException(excecao.getMessage(), excecao);
        }
    }

    public static <T> T getResource(final String arquivo, final Class<T> classeResposta) {
        String texto = null;

        try (final InputStream inputStream = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream(arquivo)) {

            if (inputStream != null) {
                texto = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))
                        .lines()
                        .collect(Collectors.joining("\n"));

                return objectMapper.readValue(texto, classeResposta);
            }

            throw new RuntimeException("Não foi possível criar InputStream");

        } catch (final Exception excecao) {
            log.error(excecao.getMessage(), excecao);
            throw new RuntimeException(excecao.getMessage(), excecao);
        }
    }
}