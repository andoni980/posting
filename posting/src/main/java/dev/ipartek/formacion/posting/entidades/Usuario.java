package dev.ipartek.formacion.posting.entidades;

import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "nick_name", nullable = false, length = 50)
	private String nickName;

	@ManyToOne
	@JoinColumn(name = "rol_id", nullable = false, foreignKey = @ForeignKey(name = "FK_usuario_rol"))
	private Rol rol;

	@OneToMany(mappedBy = "usuario")
	private Set<Post> posts;
	
	@ManyToMany
	@JoinTable(name = "posts_favoritos",
		joinColumns = @JoinColumn(name = "usuario_id"),
		inverseJoinColumns = @JoinColumn(name = "post_id"),
		foreignKey = @ForeignKey(name = "FK_usuario_gusta_post"),
		inverseForeignKey = @ForeignKey(name = "FK_usuario_post_gusta"))
	private Set<Post> postsFavoritos;
	
	@ManyToMany
	@JoinTable(name = "posts_guardados",
		joinColumns = @JoinColumn(name = "usuario_id"),
		inverseJoinColumns = @JoinColumn(name = "post_id"),
		foreignKey = @ForeignKey(name = "FK_usuario_guarda_post"),
		inverseForeignKey = @ForeignKey(name = "FK_usuario_post_guarda"))
	private Set<Post> postsGuardados;

	public Usuario() {}

	public Usuario(Long id, String nickName, Rol rol, Set<Post> posts, Set<Post> postsFavoritos,
			Set<Post> postsGuardados) {
		super();
		this.id = id;
		this.nickName = nickName;
		this.rol = rol;
		this.posts = posts;
		this.postsFavoritos = postsFavoritos;
		this.postsGuardados = postsGuardados;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Set<Post> getPosts() {
		return posts;
	}

	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}

	public Set<Post> getPostsFavoritos() {
		return postsFavoritos;
	}

	public void setPostsFavoritos(Set<Post> postsFavoritos) {
		this.postsFavoritos = postsFavoritos;
	}

	public Set<Post> getPostsGuardados() {
		return postsGuardados;
	}

	public void setPostsGuardados(Set<Post> postsGuardados) {
		this.postsGuardados = postsGuardados;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nickName, posts, postsFavoritos, postsGuardados, rol);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id) && Objects.equals(nickName, other.nickName)
				&& Objects.equals(posts, other.posts) && Objects.equals(postsFavoritos, other.postsFavoritos)
				&& Objects.equals(postsGuardados, other.postsGuardados) && Objects.equals(rol, other.rol);
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nickName=" + nickName + ", rol=" + rol + "]";
	}

	
}
