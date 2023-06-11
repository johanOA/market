package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.dto.ProductoGetDTO;
import co.edu.uniquindio.proyecto.modelo.entidades.*;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.ProductoServicio;
import co.edu.uniquindio.proyecto.servicios.interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductoServicioImpl implements ProductoServicio {

    private final ProductoRepo productoRepo;
    private final UsuarioServicio usuarioServicio;

    @Override
    public int crearProducto(ProductoDTO productoDTO) throws Exception {

        Producto producto = new Producto();
        producto.setNombre( productoDTO.getNombre() );
        producto.setDescripcion( productoDTO.getDescripcion() );
        producto.setUnidades( productoDTO.getUnidades() );
        producto.setPrecio( productoDTO.getPrecio() );
        producto.setCalificacion( productoDTO.getCalificacion());
        producto.setUsuario( usuarioServicio.obtener( productoDTO.getCodigoVendedor() ) );
        producto.setImagenes( productoDTO.getImagenes() );
        producto.setCategorias( productoDTO.getCategorias() );
        producto.setEstado( Estado.SIN_REVISAR );
        producto.setFechaCreacion( LocalDateTime.now() );
        producto.setFechaLimite( LocalDateTime.now().plusDays(60) );

        return productoRepo.save( producto ).getCodigo();
    }

    @Override
    public int actualizarProducto(int codigoProducto, ProductoGetDTO productoDTO)  throws Exception
    {
        validarExiste(codigoProducto);

        Producto producto = convertir(productoDTO);
        producto.setCodigo(codigoProducto);

        return productoRepo.save( producto ).getCodigo();
    }

    @Override
    public int actualizarUnidades(int codigoProducto, int unidades)  throws Exception
    {
        validarExiste(codigoProducto);

        if (unidades<0)
        {
            throw new Exception("Las unidades no pueden ser menores a 0");
        }

        Producto producto = obtener(codigoProducto);
        producto.setUnidades(unidades);

        return productoRepo.save(producto).getCodigo();
    }

    @Override
    public int actualizarEstado(int codigoProducto, Estado estado)  throws Exception
    {
        validarExiste(codigoProducto);

        if (estado==null)
        {
            throw new Exception("La disponibilidad no puede ser nula");
        }

        Producto producto = obtener(codigoProducto);
        producto.setEstado(estado);

        return productoRepo.save(producto).getCodigo();
    }

    @Override
    public int eliminarProducto(int codigoProducto)  throws Exception
    {
        validarExiste(codigoProducto);

        productoRepo.deleteById(codigoProducto);

        return codigoProducto;
    }

    @Override
    public void crearFavorito(int codigoUsuario, int codigoProducto) throws Exception
    {
        Usuario usuario = usuarioServicio.obtener(codigoUsuario);
        Producto producto = obtener(codigoProducto);

        usuario.getFavoritos().add( new Favorito(producto, usuario));

    }



    @Override
    public void eliminarFavorito(int codigoUsuario, int codigoProducto) throws Exception
    {
        Usuario usuario = usuarioServicio.obtener(codigoUsuario);
        Producto producto = obtener(codigoProducto);

        usuario.getFavoritos().remove(producto);

    }

    @Override
    public Producto obtener(int codigoProducto) throws Exception
    {
        Optional<Producto> producto = productoRepo.findById(codigoProducto);

        if(producto.isEmpty() )
        {

            throw new Exception("El código "+codigoProducto+" no está asociado a ningún producto");
        }

        return producto.get();
    }

    @Override
    public ProductoGetDTO obtenerProducto(int codigoProducto)  throws Exception
    {
        return convertir( obtener(codigoProducto) );
    }

    @Override
    public List<ProductoGetDTO> listarProductosUsuario(int codigoUsuario)
    {
        List<Producto> lista = productoRepo.listarProductosUsuario(codigoUsuario);
        List<ProductoGetDTO> respuesta = new ArrayList<>();

        for(Producto p : lista)
        {
            respuesta.add( convertir(p) );
        }

        return respuesta;
    }

    private ProductoGetDTO convertir(Producto producto){

        ProductoGetDTO productoGetDTO = new ProductoGetDTO(
                producto.getCodigo(),
                producto.getEstado(),
                producto.getFechaLimite(),
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getUnidades(),
                producto.getUsuario().getCodigo(),
                producto.getPrecio(),
                producto.getCalificacion(),
                producto.getImagenes(),
                producto.getCategorias()
        );

        return productoGetDTO;
    }

    private Producto convertir(ProductoGetDTO productoDTO) throws Exception
    {

        Producto producto = new Producto();
        producto.setNombre( productoDTO.getNombre() );
        producto.setDescripcion( productoDTO.getDescripcion() );
        producto.setUnidades( productoDTO.getUnidades() );
        producto.setPrecio( productoDTO.getPrecio() );
        producto.setImagenes( productoDTO.getImagenes() );
        producto.setCategorias( productoDTO.getCategorias());
        producto.setUsuario( usuarioServicio.obtener( productoDTO.getCodigoUsuario() ) );
        producto.setFechaLimite( productoDTO.getFechaLimite() );
        producto.setEstado( productoDTO.getEstado() );

        return producto;
    }

    @Override
    public List<ProductoGetDTO> listarProductosCategoria(Categoria categoria)
    {
        //usar member of para lista de element collections (son varios)
        List<Producto> lista = productoRepo.listarProductosCategoria(categoria);
        List<ProductoGetDTO> respuesta = new ArrayList<>();

        for(Producto p : lista)
        {
            respuesta.add( convertir(p) );
        }

        return respuesta;
    }

    @Override
    public List<ProductoGetDTO> listarProductosPorEstado(Estado estado)
    {
        // este es una lista de enum pero estamos mirando por uno solo no todos los datos de la lista (uno solo)
        List<Producto> lista = productoRepo.listarProductosPorEstado(estado);
        List<ProductoGetDTO> respuesta = new ArrayList<>();

        for(Producto p : lista)
        {
            respuesta.add( convertir(p) );
        }

        return respuesta;
    }

    @Override
    public List<ProductoGetDTO> listarProductosFavoritos(int codigoUsuario)
    {
        List<Producto> lista = productoRepo.listarProductosFavoritos(codigoUsuario);
        List<ProductoGetDTO> respuesta = new ArrayList<>();

        for(Producto p : lista)
        {
            respuesta.add( convertir(p) );
        }

        return respuesta;
    }

    @Override
    public List<ProductoGetDTO> listarProductosNombre(String nombre) {

        List<Producto> lista = productoRepo.listarProductosNombre(nombre);
        List<ProductoGetDTO> respuesta = new ArrayList<>();

        for(Producto p : lista){
            respuesta.add( convertir(p) );
        }

        return respuesta;
    }

    private void validarExiste(int codigoProducto) throws Exception
    {
        boolean existe = productoRepo.existsById(codigoProducto);

        if(!existe){
            throw new Exception("El código" +codigoProducto+ "No existe");
        }

    }

    @Override
    public List<ProductoGetDTO> listarProductosPrecio(float precioMinimo, float precioMaximo)
    {
        List<Producto> lista = productoRepo.listarProductosPrecio(precioMinimo, precioMaximo);
        List<ProductoGetDTO> respuesta = new ArrayList<>();

        for(Producto p : lista)
        {
            respuesta.add( convertir(p) );
        }

        return respuesta;
    }
}
