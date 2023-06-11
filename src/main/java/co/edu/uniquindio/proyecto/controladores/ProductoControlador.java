package co.edu.uniquindio.proyecto.controladores;

import co.edu.uniquindio.proyecto.dto.MensajeDTO;
import co.edu.uniquindio.proyecto.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.dto.ProductoGetDTO;
import co.edu.uniquindio.proyecto.modelo.entidades.Producto;
import co.edu.uniquindio.proyecto.servicios.interfaces.DetalleCompraService;
import co.edu.uniquindio.proyecto.servicios.interfaces.ProductoServicio;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/producto")
@AllArgsConstructor
public class ProductoControlador {
    private final ProductoServicio productoServicio;
    private final DetalleCompraService detalleCompraService;

    @PostMapping("/crear")
    ResponseEntity<MensajeDTO> crearProducto(@RequestBody ProductoDTO productoDTO) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, productoServicio.crearProducto(productoDTO)));
    }

    @PutMapping("/actualizarProductos/{codigoProducto}")
    ResponseEntity<MensajeDTO> actualizarProducto(@PathVariable int codigoProducto, @RequestBody ProductoGetDTO productoGetDTO) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, productoServicio.actualizarProducto(codigoProducto,productoGetDTO)));
    }
    @GetMapping("/obtenerProducto/{codigoProducto}")
    public ResponseEntity<MensajeDTO> obtenerProducto(@PathVariable int codigoProducto) throws Exception{
        return ResponseEntity.status(200).body( new MensajeDTO(HttpStatus.OK, false, productoServicio.obtenerProducto(codigoProducto)) );
    }

    @GetMapping("/compradosPorUsuario/{idUsuario}")
    public ResponseEntity<MensajeDTO> getProductosCompradosPorUsuario(@PathVariable int idUsuario) {
        List<ProductoGetDTO> productos = detalleCompraService.getProductosCompradosPorUsuario(idUsuario);
        return ResponseEntity.status(200).body( new MensajeDTO(HttpStatus.OK, false, productos) );
    }


}