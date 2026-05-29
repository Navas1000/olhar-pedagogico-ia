package br.com.olharpedagogicoia.application.exceptions;

public class PessoaNaoEncontradaException extends Exception {

    public PessoaNaoEncontradaException(String mensagem) {
        super(mensagem);
    }
}