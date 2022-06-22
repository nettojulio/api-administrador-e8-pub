package e8ilab2.apiadministrador.controller;

import e8ilab2.apiadministrador.dao.AdministradorDAO;
import e8ilab2.apiadministrador.model.Administrador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@CrossOrigin("*")
public class AdministradorController {

    @Autowired
    private AdministradorDAO adminDao;

    private final PasswordEncoder encoder;

    public AdministradorController(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @PostMapping("/admin")
    public ResponseEntity<?> cadastrarAdministrador(@RequestBody @Valid Administrador administrador) {
        administrador.setSenha(encoder.encode(administrador.getSenha()));
        Administrador administradorNew = new Administrador(administrador.getNome(), administrador.getEmail(), administrador.getSenha());
        adminDao.save(administradorNew);
        return ResponseEntity.status(201).build();
    }
}