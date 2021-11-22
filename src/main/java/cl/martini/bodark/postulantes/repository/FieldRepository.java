package cl.martini.bodark.postulantes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.martini.bodark.postulantes.model.Field;

public interface FieldRepository extends JpaRepository<Field, Long> {

}
