package cl.martini.bodark.postulantes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "polygon")
@Getter
@Setter
public class Polygon {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@Column(name = "latitude")
	String latitude;

	@Column(name = "longitude")
	String longitude;
	
	@Column(name = "polygonId")
	Long polygonId;
	

}
