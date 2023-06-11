package co.edu.uniquindio.proyecto.controladores;

import co.edu.uniquindio.proyecto.dto.MensajeDTO;
import co.edu.uniquindio.proyecto.servicios.interfaces.CloudinaryServicio;
import jakarta.mail.Multipart;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Map;

@RestController
@RequestMapping("/api/imagenes")
@AllArgsConstructor
public class CloudinaryControlador {

    private final CloudinaryServicio cloudinaryServicio;

    @PostMapping("/subirImagen")
    public ResponseEntity<MensajeDTO> subirImagen(@RequestParam("file") MultipartFile file)
            throws Exception{
        File imagen = cloudinaryServicio.convertir(file);
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO( HttpStatus.OK,
                false, cloudinaryServicio.subirImagen(imagen, "proyecto")));
    }

    @DeleteMapping("/eliminarImagen")
    public ResponseEntity<MensajeDTO> eliminarImagecodigon(@RequestBody String idImagen)
            throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK,
                false, cloudinaryServicio.eliminarImagen(idImagen)));
    }
}