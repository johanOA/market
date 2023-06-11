package co.edu.uniquindio.proyecto.controladores;

import co.edu.uniquindio.proyecto.dto.FavoritoDTO;
import co.edu.uniquindio.proyecto.dto.FavoritoGetDTO;
import co.edu.uniquindio.proyecto.dto.MensajeDTO;
import co.edu.uniquindio.proyecto.dto.UsuarioGetDTO;
import co.edu.uniquindio.proyecto.exceptions.NotFoundException;
import co.edu.uniquindio.proyecto.modelo.entidades.Favorito;
import co.edu.uniquindio.proyecto.modelo.entidades.Usuario;
import co.edu.uniquindio.proyecto.servicios.interfaces.FavoritoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/favoritos")
@AllArgsConstructor
public class FavoritoController {

    private final FavoritoService favoritoService;
    @GetMapping("/{usuarioId}")
    public ResponseEntity<MensajeDTO> listarFavoritosPorUsuario(@PathVariable Integer usuarioId) {
        UsuarioGetDTO usuarioDTO = new UsuarioGetDTO();
        usuarioDTO.setCodigo(usuarioId);

        return ResponseEntity.ok( new MensajeDTO<>(HttpStatus.OK, false, favoritoService.listarFavoritosPorUser(usuarioDTO)) );
    }

    @PostMapping("/agregarFavorito")
    public ResponseEntity<MensajeDTO> agregarFavorito(@RequestBody FavoritoDTO favoritoDto) {
        try {
            favoritoService.agregarFavorito(favoritoDto);
            return ResponseEntity.ok( new MensajeDTO<>(HttpStatus.OK, false,"Favorito agregado correctamente" ));
        } catch (NotFoundException e) {
            return ResponseEntity.badRequest().body( new MensajeDTO<>(HttpStatus.BAD_REQUEST, true,e.getMessage() ) );
        }
    }

    @DeleteMapping("/eliminarFavorito")
    public ResponseEntity<MensajeDTO> eliminarFavorito(@RequestBody FavoritoGetDTO favoritoDTO) {
        favoritoService.eliminarFavorito(favoritoDTO);
        return ResponseEntity.ok( new MensajeDTO<>(HttpStatus.OK, false,"Favorito eliminado correctamente" ));
    }
}
