package e8ilab2.apiadministrador.controller;

import e8ilab2.apiadministrador.model.Administrador;
import e8ilab2.apiadministrador.security.Token;
import e8ilab2.apiadministrador.services.AdministradorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class LoginController {
    @Autowired
    private AdministradorServiceImpl service;

    @PostMapping("/login")
    public ResponseEntity<?> realizarLogin(@RequestBody Administrador dadosLogin) {
        Token token = service.gerarTokenAdministrador(dadosLogin);

        if (token != null) {
            return ResponseEntity.ok(token);
        }

        return ResponseEntity.status(401).body("Acesso Negado");
    }
}