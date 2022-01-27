package hibernate;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import hibernate.entities.Aficion;
import hibernate.entities.Pais;
import hibernate.entities.Persona;
public class Main {
	
	private static Session obtenerSesion() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		return sf.openSession();
	}
	private static void guardarPersona(Persona persona) {
		
		Session s = obtenerSesion();
		
		Transaction t = s.beginTransaction();
		s.save(persona);
		t.commit();
		
		System.out.println(persona + " ha sido guardada");
	}
	
	
	private static void guardarPais(Pais p) {
		Session s = obtenerSesion();
		Transaction t = s.beginTransaction();
		s.save(p);
		t.commit();
		
		System.out.println(p + " ha sido guardado");
	}
	
	private static void guardarAficion(Aficion a) {
		Session s = obtenerSesion();
		Transaction t = s.beginTransaction();
		s.save(a);
		t.commit();
		
		System.out.println(a + " ha sido guardado");
	}


	private static void actualizarPersona(Persona p) {
		Session s = obtenerSesion();
		Transaction t = s.beginTransaction();
		s.merge(p);
		t.commit();
		
		System.out.println(p + " ha sido actualizada");
	}
	
	private static void borrarPersona(Persona p) {
		Session s = obtenerSesion();
		Transaction t = s.beginTransaction();
		s.delete(p);
		t.commit();
		
		System.out.println(p + " ha sido actualizada");
	}
	private static void crearYGuardarPersona(String nombre, String nif, Pais pais) {
		Persona persona = new Persona(nombre, nif, pais);
		guardarPersona(persona);
		System.out.println(persona + " ha sido guardada");
	}
	
	private static Persona recuperarPersonaPorId(Long id) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();	
		return session.get(Persona.class, id);
		
	}
	
	private static Pais recuperarPaisPorId(Long id) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();	
		return session.get(Pais.class, id);
		
	}
	
	private static List<Persona> recuperarTodasLasPersonas(){
		Session session = obtenerSesion();
		return session.createQuery("from Persona").list();
		
	}
	
	private static List<Persona> recuperarPersonasPorNombre(String nombre){
		Session session = obtenerSesion();
		return session.createQuery("from Persona where nombre= :x").setParameter("x", nombre).list();
				
		
	}
	

	
public static void main(String args[]) {
	
	//crearYGuardarPersona("Pepe", "4684367H");
	
	//String listaPersonas = "";
	//for(long id=1; id<5; id++) {
		//listaPersonas += (recuperarPersonaPorId(2L)) +"\n";

	//}
	//System.out.println(listaPersonas);
	
	//List<Persona> personas = recuperarPersonasPorNombre("Pepe");
	
	//for(Persona p : personas) {
		//System.out.println(p);
	//}
	
	
//	Persona p = recuperarPersonaPorId(1L);
//	System.out.println(p);
//	System.out.println("=====ACTUALIZADO A... =====");
//	p.setNombre("Jose");
//	actualizarPersona(p);
//	System.out.println(p);
	
//	Persona p = recuperarPersonaPorId(1L);
//	System.out.println(p + " borrada");
//	borrarPersona(p);
	
	
//	Pais pais = new Pais("Francia");
//	guardarPais(pais);
	
//	Pais pais = recuperarPaisPorId(2L);
//	crearYGuardarPersona("Fransuá", "12345T", pais);

	Pais pais = recuperarPaisPorId(2L);
	for(Persona p : pais.getPersonasNacidas()) {
		System.out.println(p);
	}
	
	
	
}
}
