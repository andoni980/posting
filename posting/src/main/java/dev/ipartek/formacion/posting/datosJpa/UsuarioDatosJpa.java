package dev.ipartek.formacion.posting.datosJpa;

import static dev.ipartek.formacion.posting.datosJpa.AccesoDatosJpa.enTransaccion;

import dev.ipartek.formacion.posting.entidades.Usuario;

public class UsuarioDatosJpa {

	public static void insertar(Usuario usuario) {
		enTransaccion(em -> {
			em.persist(usuario);
			return null;
		});
	}
	
	public static Usuario buscarPorNickName(String nickName) {
		return enTransaccion(em -> {
			var usuarios = em
					.createQuery("select u from Usuario u join fetch u.rol where u.nickName = :nickName", Usuario.class)
					.setParameter("nickName", nickName).getResultList();
			
			if(usuarios.size() == 1) {
				return usuarios.get(0);
			}else {
				return null;
			}
		});
	}
}
