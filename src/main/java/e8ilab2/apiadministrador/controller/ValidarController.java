package e8ilab2.apiadministrador.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class ValidarController {
    @GetMapping("/validar")
    public ResponseEntity<?> validaToken() {
        return ResponseEntity.status(204).build();
    }
}
