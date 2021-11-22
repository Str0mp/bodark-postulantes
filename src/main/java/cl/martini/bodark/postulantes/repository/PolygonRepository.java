package cl.martini.bodark.postulantes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.martini.bodark.postulantes.model.Polygon;

public interface PolygonRepository extends JpaRepository<Polygon, Long> {

}
