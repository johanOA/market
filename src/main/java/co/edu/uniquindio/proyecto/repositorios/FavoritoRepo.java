package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.modelo.entidades.Favorito;
import co.edu.uniquindio.proyecto.modelo.entidades.Producto;
import co.edu.uniquindio.proyecto.modelo.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FavoritoRepo extends JpaRepository<Favorito, Integer> {
    @Query("SELECT f FROM Favorito f WHERE f.usuario.codigo = :codigoUsuario")
    List<Favorito> listarFavoritosPorUser(int codigoUsuario);

    @Query("SELECT f FROM Favorito f WHERE f.producto = :producto AND f.usuario = :usuario")
    Optional<Favorito> listarFavoritosPorProductAndUser(Producto producto, Usuario usuario);
}
