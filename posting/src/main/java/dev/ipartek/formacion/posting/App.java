package dev.ipartek.formacion.posting;

import dev.ipartek.formacion.posting.entidades.Rol;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class App 
{
    public static void main( String[] args ){
        
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev.ipartek.formacion.posting.entidades");
		
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction t = em.getTransaction();
		
		t.begin();
		em.persist(new Rol(null, "ADMIN"));
		t.commit();
    }
}
