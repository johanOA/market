package co.edu.uniquindio.proyecto;

import co.edu.uniquindio.proyecto.dto.*;

import co.edu.uniquindio.proyecto.modelo.entidades.Categoria;

import co.edu.uniquindio.proyecto.servicios.interfaces.ComentarioServicio;
import co.edu.uniquindio.proyecto.servicios.interfaces.ProductoServicio;
import co.edu.uniquindio.proyecto.servicios.interfaces.UsuarioServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
public class ComentarioTest {
    @Autowired
    ComentarioServicio comentarioServicio;

    @Autowired
    UsuarioServicio usuarioServicio;

    @Autowired
    ProductoServicio productoServicio;
    @Test
    //@Sql("classpath:dataset.sql")
    public void crearComentarioTest() throws Exception {

        List<String> telefonos = new ArrayList<>();
        telefonos.add("3225247458");
        telefonos.add("3225874152");
        //Creamos un cliente
        UsuarioDTO usuarioDTO = new UsuarioDTO(
                "Pepito 1",
                "pepe1@email.com",
                "1234",
                "Calle 123",
                telefonos);

        //El servicio del usuario nos retorna el código con el que quedó en la base de datos
        int codigoVendedor = usuarioServicio.crearUsuario(usuarioDTO);

        //Creamos un producto
        List<Categoria> categoriaList = new ArrayList<>();
        categoriaList.add(Categoria.TECNOLOGIA);
        //Se crea la colección de imágenes para el producto.
        List<String> imagenes = new ArrayList<String>();
        imagenes.add("http://www.google.com/images/imagenasus.png");
        imagenes.add("http://www.google.com/images/imagenasus_original.png");

        //Se crea el producto y se usa el código dado por el servicio de registro de usuario para asignar el vendedor
        ProductoDTO productoDTO = new ProductoDTO(
                "Computador Asus 1",
                "Es el mejor computador portatil que el dinero pueda comprar",
                1,
                7000000,
                2,
                codigoVendedor,
                imagenes,
                categoriaList);
        //Se llama el servicio para crear el producto
        int codigoProducto = productoServicio.crearProducto(productoDTO);

        //Se espera que el servicio retorne el código del nuevo producto
        //  Assertions.assertNotEquals(0, codigoProducto);


        //Creamos un Comentario
        LocalDateTime fecha = LocalDateTime.now();
        ComentarioDTO comentarioDTO = new ComentarioDTO(
                "",
                codigoVendedor,
                codigoProducto,
                fecha
        );

        int codigoComentario = comentarioServicio.crearComentario(comentarioDTO);
        Assertions.assertNotEquals(0, codigoComentario);

    }

    @Test
    //@Sql("classpath:dataset.sql")
    public void eliminarComentarioTest() throws Exception{
        List<String> telefonos = new ArrayList<>();
        telefonos.add("3225247458");
        telefonos.add("3225874152");
        //Creamos un cliente
        UsuarioDTO usuarioDTO = new UsuarioDTO(
                "Pepito 1",
                "pepe1@email.com",
                "1234",
                "Calle 123",
                telefonos);

        //El servicio del usuario nos retorna el código con el que quedó en la base de datos
        int codigoVendedor = usuarioServicio.crearUsuario(usuarioDTO);

        //Creamos un producto
        List<Categoria> categoriaList = new ArrayList<>();
        categoriaList.add(Categoria.TECNOLOGIA);
        //Se crea la colección de imágenes para el producto.
        List<String> imagenes = new ArrayList<String>();
        imagenes.add("http://www.google.com/images/imagenasus.png");
        imagenes.add("http://www.google.com/images/imagenasus_original.png");

        //Se crea el producto y se usa el código dado por el servicio de registro de usuario para asignar el vendedor
        ProductoDTO productoDTO = new ProductoDTO(
                "Computador Asus 1",
                "Es el mejor computador portatil que el dinero pueda comprar",
                1,
                7000000,
                2,
                codigoVendedor,
                imagenes,
                categoriaList);
        //Se llama el servicio para crear el producto
        int codigoProducto = productoServicio.crearProducto(productoDTO);

        //Se espera que el servicio retorne el código del nuevo producto
        //  Assertions.assertNotEquals(0, codigoProducto);


        //Creamos un Comentario
        LocalDateTime fecha = LocalDateTime.now();
        ComentarioDTO comentarioDTO = new ComentarioDTO(
                "",
                codigoVendedor,
                codigoProducto,
                fecha
        );

        int codigoComentario = comentarioServicio.crearComentario(comentarioDTO);
        Assertions.assertNotEquals(0, codigoComentario);

        int codigoBorrado = comentarioServicio.eliminiarComentario(codigoComentario);
        Assertions.assertEquals(codigoBorrado,codigoComentario);
    }

    @Test
   // @Sql("classpath:dataset.sql")
    public void actualizarComentarioTest() throws Exception{

        List<String> telefonos = new ArrayList<>();
        telefonos.add("3225247458");
        telefonos.add("3225874152");

        //Creamos un cliente
        UsuarioDTO usuarioDTO = new UsuarioDTO(
                "Pepito 1",
                "pepe1@email.com",
                "1234",
                "Calle 123",
                telefonos);

        //El servicio del usuario nos retorna el código con el que quedó en la base de datos
        int codigoVendedor = usuarioServicio.crearUsuario(usuarioDTO);

        //Creamos un producto
        List<Categoria> categoriaList = new ArrayList<>();
        categoriaList.add(Categoria.TECNOLOGIA);
        //Se crea la colección de imágenes para el producto.
        List<String> imagenes = new ArrayList<String>();
        imagenes.add("http://www.google.com/images/imagenasus.png");
        imagenes.add("http://www.google.com/images/imagenasus_original.png");

        //Se crea el producto y se usa el código dado por el servicio de registro de usuario para asignar el vendedor
        ProductoDTO productoDTO = new ProductoDTO(
                "Computador Asus 1",
                "Es el mejor computador portatil que el dinero pueda comprar",
                1,
                7000000,
                2,
                codigoVendedor,
                imagenes,
                categoriaList);
        //Se llama el servicio para crear el producto
        int codigoProducto = productoServicio.crearProducto(productoDTO);

        //Se espera que el servicio retorne el código del nuevo producto
        //  Assertions.assertNotEquals(0, codigoProducto);


        //Creamos un Comentario
        LocalDateTime fecha = LocalDateTime.now();
        ComentarioDTO comentarioDTO = new ComentarioDTO(
                "",
                codigoVendedor,
                codigoProducto,
                fecha
        );

        int codigoComentario = comentarioServicio.crearComentario(comentarioDTO);
        // Assertions.assertNotEquals(0, codigoComentario);
        LocalDateTime fechaActulizado = LocalDateTime.now();


        ComentarioGetDTO comentarioGetDTO =  comentarioServicio.actualizarComentario(codigoComentario,
                new ComentarioDTO(
                        "saludos",
                        codigoVendedor,
                        codigoProducto,
                        fecha
                ));

        Assertions.assertNotEquals("", comentarioGetDTO.getMensaje());
    }

    @Test
  //  @Sql("classpath:dataset.sql")
    public void obtenerComentarioTest()throws Exception{
        List<String> telefonos = new ArrayList<>();
        telefonos.add("3225247458");
        telefonos.add("3225874152");
        //Creamos un cliente
        UsuarioDTO usuarioDTO = new UsuarioDTO(
                "Pepito 1",
                "pepe1@email.com",
                "1234",
                "Calle 123",
                telefonos);

        //El servicio del usuario nos retorna el código con el que quedó en la base de datos
        int codigoVendedor = usuarioServicio.crearUsuario(usuarioDTO);

        //Creamos un producto
        List<Categoria> categoriaList = new ArrayList<>();
        categoriaList.add(Categoria.TECNOLOGIA);
        //Se crea la colección de imágenes para el producto.
        List<String> imagenes = new ArrayList<String>();
        imagenes.add("http://www.google.com/images/imagenasus.png");
        imagenes.add("http://www.google.com/images/imagenasus_original.png");

        //Se crea el producto y se usa el código dado por el servicio de registro de usuario para asignar el vendedor
        ProductoDTO productoDTO = new ProductoDTO(
                "Computador Asus 1",
                "Es el mejor computador portatil que el dinero pueda comprar",
                1,
                7000000,
                2,
                codigoVendedor,
                imagenes,
                categoriaList);
        //Se llama el servicio para crear el producto
        int codigoProducto = productoServicio.crearProducto(productoDTO);

        //Se espera que el servicio retorne el código del nuevo producto
        //  Assertions.assertNotEquals(0, codigoProducto);


        //Creamos un Comentario
        LocalDateTime fecha = LocalDateTime.now();
        ComentarioDTO comentarioDTO = new ComentarioDTO(
                "Saludo",
                codigoVendedor,
                codigoProducto,
                fecha
        );

        int codigoComentario = comentarioServicio.crearComentario(comentarioDTO);

        //Se llama el servicio para obtener el usuario completo dado su código
        ComentarioGetDTO comentarioGetDTO = comentarioServicio.obtenerComentario( codigoComentario);

        //Comprobamos que la dirección que está en la base de datos coincide con la que esperamos
        Assertions.assertEquals("Saludo", comentarioGetDTO.getMensaje());
    }
}
