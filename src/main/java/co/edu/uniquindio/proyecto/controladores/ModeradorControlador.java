package co.edu.uniquindio.proyecto.controladores;

import co.edu.uniquindio.proyecto.dto.MensajeDTO;
import co.edu.uniquindio.proyecto.modelo.entidades.Producto;
import co.edu.uniquindio.proyecto.servicios.implementacion.ModeradorServicioImpl;
import co.edu.uniquindio.proyecto.servicios.interfaces.ModeradorServicio;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/moderador")
@AllArgsConstructor
public class ModeradorControlador {

    private final ModeradorServicioImpl moderadorServicioImpl;


    /*
    @PostMapping("/favoritos")
    public ResponseEntity<MensajeDTO> agregarFavorito(@RequestBody FavoritoDTO favoritoDto) {
        try {
            favoritoService.agregarFavorito(favoritoDto);
            return ResponseEntity.ok( new MensajeDTO<>(HttpStatus.OK, false,"Favorito agregado correctamente" ));
        } catch (NotFoundException e) {
            return ResponseEntity.badRequest().body( new MensajeDTO<>(HttpStatus.BAD_REQUEST, true,e.getMessage() ) );
        }
    }
    * */
    @PostMapping("/aprobarProducto/{codigoProducto}")
    public ResponseEntity<MensajeDTO> aprobarProducto(@PathVariable int codigoProducto) {
        try {
            moderadorServicioImpl.aprobarProducto(codigoProducto);
            return ResponseEntity.ok( new MensajeDTO<>(HttpStatus.OK, false, "Producto aprobado correctamente"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body( new MensajeDTO<>(HttpStatus.BAD_REQUEST, true, e.getMessage()));
        }
    }
    @PostMapping("/rechazarProducto/{codigoProducto}")
    public ResponseEntity<MensajeDTO> rechazarProducto(@PathVariable int codigoProducto) {
        try {
            moderadorServicioImpl.rechazarProducto(codigoProducto);
            return ResponseEntity.ok( new MensajeDTO<>(HttpStatus.OK, false, "Producto rechazado correctamente"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new MensajeDTO<>(HttpStatus.BAD_REQUEST, true,e.getMessage()));
        }
    }

}