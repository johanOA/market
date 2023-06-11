package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.modelo.entidades.Usuario;
import co.edu.uniquindio.proyecto.modelo.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario, Integer> {

    @Query(value = "SELECT * FROM Usuario WHERE email = :correo", nativeQuery = true)
    Usuario buscarUsuario(@Param("correo") String correo);

    @Query("SELECT u FROM Usuario u JOIN u.comentarios c JOIN c.producto p WHERE p.nombre = :nombreProducto")
    List<Usuario> buscarPorComentarioEnProducto(@Param("nombreProducto") String nombreProducto);

    @Query("SELECT u FROM Usuario u WHERE u.email = :correo")
    Usuario buscarPorCorreo(@Param("correo") String correo);

    Optional<Usuario> findByEmail(String email);

}
