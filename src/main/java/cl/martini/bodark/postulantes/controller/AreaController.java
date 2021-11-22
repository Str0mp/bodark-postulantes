package cl.martini.bodark.postulantes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cl.martini.bodark.postulantes.model.RequestArea;
import cl.martini.bodark.postulantes.service.AreaService;

@RestController
public class AreaController {
	
	@Autowired
	AreaService areaService;
	
	@GetMapping("/isValidArea")
	ResponseEntity<?> isValidArea(@RequestBody  RequestArea requestArea){		
		return areaService.isValidArea(requestArea);
	}

}
