package com.robotech.web.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.robotech.web.models.Usuario;

public interface IUsuarioDao extends JpaRepository<Usuario, Integer>{
	
	public Usuario findUsuarioByCorreo(String correo);
	
	Optional<Usuario> findByResetToken(String resetToken);
	
	List<Usuario> findByTipoUsuarioId(Integer tipousu);
	
	Optional<Usuario> findByCorreo(String correo);
	
	@Query(value = "SELECT * FROM usuario WHERE tipo_usuario_id = ?1 ORDER BY id DESC LIMIT 1", nativeQuery = true)
	Usuario findFirstByTipoUsuarioIdOrderByDesc(Integer tipoUsuarioId);
	
	 boolean existsByCorreo(String correo);
	 boolean existsByUsername(String username);
}
