package co.edu.uniquindio.proyecto.mappers;

import co.edu.uniquindio.proyecto.dto.ProductoGetDTO;
import co.edu.uniquindio.proyecto.modelo.entidades.Producto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductoMapper {
    public static ProductoGetDTO toDto(Producto producto) {
        ProductoGetDTO productoGetDTO = new ProductoGetDTO();
        productoGetDTO.setCodigo(producto.getCodigo());
        productoGetDTO.setEstado(producto.getEstado());
        productoGetDTO.setFechaLimite(producto.getFechaLimite());
        productoGetDTO.setNombre(producto.getNombre());
        productoGetDTO.setDescripcion(producto.getDescripcion());
        productoGetDTO.setUnidades(producto.getUnidades());
        productoGetDTO.setPrecio(producto.getPrecio());
        productoGetDTO.setImagenes(producto.getImagenes());
        productoGetDTO.setCategorias(producto.getCategorias());
        return productoGetDTO;

    }
    public Producto toEntity(ProductoGetDTO productoGetDTO) {
        Producto producto = new Producto();
        producto.setCodigo(productoGetDTO.getCodigo());
        producto.setEstado(productoGetDTO.getEstado());
        producto.setFechaLimite(productoGetDTO.getFechaLimite());
        producto.setNombre(productoGetDTO.getNombre());
        producto.setDescripcion(productoGetDTO.getDescripcion());
        producto.setUnidades(productoGetDTO.getUnidades());
        producto.setPrecio(productoGetDTO.getPrecio());
        producto.setImagenes(productoGetDTO.getImagenes());
        producto.setCategorias(productoGetDTO.getCategorias());
        return producto;
    }

    public static List<ProductoGetDTO> mapToDtoList(List<Producto> productos) {
        return productos.stream()
                .map(ProductoMapper::toDto)
                .collect(Collectors.toList());
    }
    public ProductoGetDTO toGetDTO(Producto producto) {
        ProductoGetDTO dto = new ProductoGetDTO();
        dto.setCodigo(producto.getCodigo());
        dto.setEstado(producto.getEstado());
        dto.setFechaLimite(producto.getFechaLimite());
        dto.setNombre(producto.getNombre());
        dto.setDescripcion(producto.getDescripcion());
        dto.setUnidades(producto.getUnidades());
        dto.setPrecio(producto.getPrecio());
        dto.setCalificacion(producto.getCalificacion());
        dto.setImagenes(producto.getImagenes());
        dto.setCategorias(producto.getCategorias());
        return dto;
    }

    public List<ProductoGetDTO> toGetDTOList(List<Producto> productos) {
        return productos.stream()
                .map(this::toGetDTO)
                .collect(Collectors.toList());
    }
}
