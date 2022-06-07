package e8ilab2.apiadministrador.security;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
@Component
@Primary
public class Encrypt {
    public static String encrypt(String original) throws Exception {

        String strMinhaChave = System.getenv("PRIVATE_KEY");

        Key minhaChave = new SecretKeySpec(strMinhaChave.getBytes(), "AES");

        Cipher cipher = Cipher.getInstance("AES");

        cipher.init(Cipher.ENCRYPT_MODE, minhaChave);

        cipher.update(original.getBytes());

        String originalCripto = new String(cipher.doFinal(), "UTF-8");

        byte[] passwordEncrypt = originalCripto.getBytes();

        StringBuilder cryptoHex = new StringBuilder();

        for (byte b : passwordEncrypt) {
            cryptoHex.append(Integer.toHexString(b));
        }

        return cryptoHex.toString();
    }
}
