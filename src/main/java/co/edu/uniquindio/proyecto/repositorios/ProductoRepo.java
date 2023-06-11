package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.modelo.entidades.Categoria;
import co.edu.uniquindio.proyecto.modelo.entidades.Estado;
import co.edu.uniquindio.proyecto.modelo.entidades.Producto;
import co.edu.uniquindio.proyecto.modelo.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepo extends JpaRepository<Producto, Integer> {

    @Query("select p from Producto p where p.usuario.codigo = :codigoUsuario")
    List<Producto> listarProductosUsuario(int codigoUsuario);

    @Query("select p from Producto p where p.nombre like concat( '%', :nombre, '%' ) and p.estado = co.edu.uniquindio.proyecto.modelo.entidades.Estado.APROBADO")
    List<Producto> listarProductosNombre(String nombre);


    @Query("select p from Producto p where p.estado = :estado and p.estado = co.edu.uniquindio.proyecto.modelo.entidades.Estado.APROBADO")
    List<Producto> listarProductosPorEstado(Estado estado);

    @Query("select p from Producto p where :categoria member of p.categorias")
    List<Producto> listarProductosCategoria(Categoria categoria);

    @Query("select p from Producto p join p.favoritos u where u.codigo = :codigoUsuario")
    List<Producto> listarProductosFavoritos(int codigoUsuario);

    @Query("select p from Producto p where p.precio > :precioMinimo and p.precio < :precioMaximo")
    List<Producto> listarProductosPrecio(float precioMinimo, float precioMaximo);

    @Query("SELECT p FROM Producto p JOIN p.categorias c WHERE c = :categoria ORDER BY p.precio DESC")
    Producto obtenerProductoMasCaroPorCategoria(@Param("categoria") Categoria categoria);

    @Query("SELECT p FROM Producto p JOIN p.categorias c WHERE c = :categoria ORDER BY p.precio ASC")
    Producto obtenerProductoMasBaratoPorCategoria(@Param("categoria") Categoria categoria);


}
