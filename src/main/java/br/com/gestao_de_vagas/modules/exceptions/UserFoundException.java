package br.com.gestao_de_vagas.modules.exceptions;

public class UserFoundException extends RuntimeException {
    public UserFoundException(){
        super("usuário já existe");
    }
}
