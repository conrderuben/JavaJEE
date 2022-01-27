package hibernate.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Pais {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String nombre;
	
	@OneToMany(mappedBy = "paisNace")
	private Collection<Persona> personasNacidas;
	
	//========================
	
	public Pais() {
		this.nombre = "Invernalia";
		this.personasNacidas = new ArrayList<Persona>();
	}
	
	public Pais( String nombre) {
		this.nombre = nombre;
		this.personasNacidas = new ArrayList<Persona>();
	}
	
	//==========================
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	
	public Collection<Persona> getPersonasNacidas() {
		return personasNacidas;
	}

	public void setPersonasNacidas(Collection<Persona> personasNacidas) {
		this.personasNacidas = personasNacidas;
	}

	@Override
	public String toString() {
		return "Pais [id=" + id + ", nombre=" + nombre + "]";
	}

	
	
	
}
