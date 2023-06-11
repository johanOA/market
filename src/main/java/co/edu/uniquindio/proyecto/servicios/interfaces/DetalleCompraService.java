package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.*;
import co.edu.uniquindio.proyecto.modelo.entidades.Compra;
import co.edu.uniquindio.proyecto.modelo.entidades.DetalleCompra;
import co.edu.uniquindio.proyecto.modelo.entidades.Producto;

import java.util.List;

public interface DetalleCompraService {
    List<DetalleCompraDTO> listarPorCodigoProducto(Integer codigo);
    List<DetalleCompraDTO> listarPorCompra(CompraGetDTO compraDTO);

    List<Integer> obtenerDetallesCodigo(List<DetalleCompra> compras);

    DetalleCompraGetDTO obtenerDetalleCompra(int codigoDetalleCompra) throws Exception;

    List<ProductoGetDTO> getProductosCompradosPorUsuario(int idUsuario);
}
