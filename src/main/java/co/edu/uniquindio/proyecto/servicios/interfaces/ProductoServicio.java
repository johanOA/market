package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.dto.ProductoGetDTO;
import co.edu.uniquindio.proyecto.modelo.entidades.Categoria;
import co.edu.uniquindio.proyecto.modelo.entidades.Estado;
import co.edu.uniquindio.proyecto.modelo.entidades.Producto;

import java.util.List;

public interface ProductoServicio {


    int crearProducto(ProductoDTO productoDTO)  throws Exception;

    int actualizarProducto(int codigoProducto, ProductoGetDTO productoGetDTO)  throws Exception;

    int actualizarUnidades(int codigoProducto, int unidades) throws Exception;

    int actualizarEstado(int codigoProducto, Estado estado) throws Exception;

    int eliminarProducto(int codigoProducto) throws Exception;

    void  crearFavorito(int codigoUsuario, int codigoProducto) throws Exception;

    void  eliminarFavorito(int codigoUsuario, int codigoProducto) throws Exception;

    Producto obtener(int codigo) throws Exception;

    ProductoGetDTO obtenerProducto(int codigoProducto) throws Exception;

    List<ProductoGetDTO> listarProductosUsuario(int codigoUsuario);

    List<ProductoGetDTO> listarProductosCategoria(Categoria categoria);

    List<ProductoGetDTO> listarProductosPorEstado(Estado estado);

    List<ProductoGetDTO> listarProductosFavoritos(int codigoUsuario);

    List<ProductoGetDTO> listarProductosNombre(String nombre);

    List<ProductoGetDTO> listarProductosPrecio(float precioMinimo, float precioMaximo);

}
