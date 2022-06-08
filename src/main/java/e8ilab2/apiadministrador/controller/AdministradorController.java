package e8ilab2.apiadministrador.controller;

import e8ilab2.apiadministrador.dao.AdministradorDAO;
import e8ilab2.apiadministrador.model.Administrador;
import e8ilab2.apiadministrador.security.Encrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("*")
public class AdministradorController {

    @Autowired
    private AdministradorDAO adminDao;

    @Autowired
    private Encrypt encrypt;


    @PostMapping("/admin")
    public ResponseEntity<?> cadastrarAdministrador(@RequestBody Administrador administrador) throws Exception {
        Administrador administradorNew = new Administrador(administrador.getNome(), administrador.getEmail(), encrypt.encrypt(administrador.getSenha()));
        adminDao.save(administradorNew);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/validar")
    public ResponseEntity<?> validaToken() {
        return ResponseEntity.status(204).build();
    }


}