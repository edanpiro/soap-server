package pe.idat.servidorws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.idat.servidorws.entity.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
}