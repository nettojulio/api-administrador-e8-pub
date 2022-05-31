package e8ilab2.apiadministrador.dao;

import e8ilab2.apiadministrador.model.Administrador;
import org.springframework.data.repository.CrudRepository;

public interface AdministradorDAO extends CrudRepository<Administrador, Integer> {

    public Administrador findByEmail(String email);

    public Administrador save(Administrador administrador);
}
