package dev.ipartek.formacion.posting.entidades;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "denuncias")
public class Denuncia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "razon", length = 255, nullable = false)
	private String razon;
	
	public Denuncia() {
	}

	public Denuncia(Long id, String razon) {
		super();
		this.id = id;
		this.razon = razon;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRazon() {
		return razon;
	}

	public void setRazon(String razon) {
		this.razon = razon;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, razon);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Denuncia other = (Denuncia) obj;
		return Objects.equals(id, other.id) && Objects.equals(razon, other.razon);
	}

	@Override
	public String toString() {
		return "Denuncia [id=" + id + ", razon=" + razon + "]";
	}

	

}
