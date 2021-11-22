package cl.martini.bodark.postulantes.service.impl;

import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import cl.martini.bodark.postulantes.model.Field;
import cl.martini.bodark.postulantes.model.Polygon;
import cl.martini.bodark.postulantes.model.RequestArea;
import cl.martini.bodark.postulantes.model.ResponseArea;
import cl.martini.bodark.postulantes.repository.FieldRepository;
import cl.martini.bodark.postulantes.service.AreaService;

@Service
public class AreaServiceImpl implements AreaService {

	@Autowired
	FieldRepository fieldRepository;

	@Override
	public ResponseEntity<?> isValidArea(RequestArea requestArea) {
		System.out.println("Longitud: " + requestArea.getLongitud());
		System.out.println("Latitud: " + requestArea.getLatitud());

		List<Field> fields = fieldRepository.findAll();

		List<Field> listField = new ArrayList<Field>();

		if (!fields.isEmpty()) {
			for (Field field : fields) {
				List<Polygon> polygon = field.getPolygon();
				if (!polygon.isEmpty()) {
					Path2D path = new Path2D.Double();
					int count = 0;
					for (Polygon poly : polygon) {
						if (count == 0) {
							path.moveTo(Double.parseDouble(poly.getLatitude()),
									Double.parseDouble(poly.getLongitude()));
							count++;
						} else {
							path.lineTo(Double.parseDouble(poly.getLatitude()),
									Double.parseDouble(poly.getLongitude()));
						}

					}
					path.closePath();
					if (path.contains(Double.parseDouble(requestArea.getLatitud()),
							Double.parseDouble(requestArea.getLongitud()))) {
						listField.add(field);
					}
				}
			}
		}
		if (!listField.isEmpty()) {
			for (Field field : listField) {
				if (field.isFieldActive()) {
					return ResponseEntity.ok(new ResponseArea(true, field.getName(), "200"));
				} else {
					return ResponseEntity.ok(new ResponseArea(false, field.getName(), "200"));
				}
			}

		}
		return ResponseEntity.ok(new ResponseArea(false, "No estas en ninguna cancha válida", "401"));

	}

}
