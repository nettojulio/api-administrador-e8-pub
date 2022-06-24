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
        if (administrador.getNome().length() == 0 || administrador.getSenha().length() == 0 || administrador.getEmail().length() == 0){
            return ResponseEntity.status(400).body("Não foi possível cadastrar o administrador");
        }

        administrador.setSenha(encoder.encode(administrador.getSenha()));
        Administrador administradorNew = new Administrador(administrador.getNome(), administrador.getEmail(), administrador.getSenha());
        adminDao.save(administradorNew);

        if (administradorNew != null) {
            return ResponseEntity.status(201).body(administradorNew);
        }

        return ResponseEntity.status(400).body("Não foi possível concluir o cadastro!");

    }
}