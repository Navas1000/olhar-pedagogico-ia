package br.com.olharpedagogicoia.application.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class FuncionarioSenhaUtil {

    private static final int TAMANHO_DO_PREFIXO_DO_SHA = 20;

    public static String gerarSenhaCriptografada(final String senha, final String salt) {

        final String hashSha256 = gerarSha256(senha + salt);

             return hashSha256.substring(0, TAMANHO_DO_PREFIXO_DO_SHA);
    }

    private static String gerarSha256(final String valor) {

        try {
            final MessageDigest digest = MessageDigest.getInstance("SHA-256");
            final byte[] hash = digest.digest(valor.getBytes(StandardCharsets.UTF_8));

            final StringBuilder hexadecimal = new StringBuilder();

            for (byte b : hash)
                hexadecimal.append(String.format("%02x", b));

            return hexadecimal.toString();

        } catch (NoSuchAlgorithmException excecao) {
            throw new RuntimeException("Erro ao gerar SHA-256 da senha do funcionário", excecao);
        }
    }
}