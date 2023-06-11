package co.edu.uniquindio.proyecto.controladores;

import co.edu.uniquindio.proyecto.dto.MensajeDTO;
import co.edu.uniquindio.proyecto.dto.ModeradorGetDTO;
import co.edu.uniquindio.proyecto.dto.ProductoGetDTO;
import co.edu.uniquindio.proyecto.servicios.interfaces.ProductoModeradorService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/productoModerador")
@AllArgsConstructor
public class ProductoModeradorController {
    private final ProductoModeradorService productoModeradorService;

    @GetMapping("/moderador/{moderadorId}")
    public ResponseEntity<MensajeDTO> listarProductosPorModerador(@PathVariable Integer moderadorId) {
        ModeradorGetDTO moderadorDTO = new ModeradorGetDTO();
        moderadorDTO.setCodigo(moderadorId);

        return ResponseEntity.ok( new MensajeDTO<>(HttpStatus.OK, false, productoModeradorService.listarProductosPorModerador(moderadorDTO)));
    }
}
