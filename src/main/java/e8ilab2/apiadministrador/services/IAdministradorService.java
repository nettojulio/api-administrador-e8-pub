package e8ilab2.apiadministrador.services;

import e8ilab2.apiadministrador.model.Administrador;
import e8ilab2.apiadministrador.security.Token;

public interface IAdministradorService {
    public Token gerarTokenAdministrador(Administrador dadosLogin);
}
