package cl.martini.bodark.postulantes.service;

import org.springframework.http.ResponseEntity;

import cl.martini.bodark.postulantes.model.RequestArea;

public interface AreaService {

	ResponseEntity<?> isValidArea(RequestArea requestArea);

}
