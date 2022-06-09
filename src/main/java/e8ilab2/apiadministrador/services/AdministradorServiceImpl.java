package e8ilab2.apiadministrador.services;

import e8ilab2.apiadministrador.dao.AdministradorDAO;
import e8ilab2.apiadministrador.model.Administrador;
import e8ilab2.apiadministrador.security.Token;
import e8ilab2.apiadministrador.security.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@Primary
public class AdministradorServiceImpl implements IAdministradorService {

    @Autowired
    private AdministradorDAO adminDao;

    private final PasswordEncoder encoder;

    public AdministradorServiceImpl(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @Override
    public Token gerarTokenAdministrador(Administrador dadosLogin) {
        try {
            Administrador user = adminDao.findByEmail(dadosLogin.getEmail());

            if (user != null) {

                if (encoder.matches(dadosLogin.getSenha(), user.getSenha())) {
                    return new Token(TokenUtils.createToken(user));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

}

