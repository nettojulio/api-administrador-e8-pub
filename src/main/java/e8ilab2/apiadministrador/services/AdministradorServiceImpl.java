package e8ilab2.apiadministrador.services;

import e8ilab2.apiadministrador.dao.AdministradorDAO;
import e8ilab2.apiadministrador.model.Administrador;
import e8ilab2.apiadministrador.security.Encrypt;
import e8ilab2.apiadministrador.security.Token;
import e8ilab2.apiadministrador.security.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class AdministradorServiceImpl implements IAdministradorService{

    @Autowired
    private AdministradorDAO adminDao;
    @Override
    public Token gerarTokenAdministrador(Administrador dadosLogin) {
        try {
            Administrador user = adminDao.findByEmail(dadosLogin.getEmail());

            if (user != null) {

                String senhaLogin = Encrypt.encrypt(dadosLogin.getSenha());

                if (user.getSenha().equals(senhaLogin)) {
                    return new Token(TokenUtils.createToken(user));
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

}

