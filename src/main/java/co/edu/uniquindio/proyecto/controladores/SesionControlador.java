package co.edu.uniquindio.proyecto.controladores;

import co.edu.uniquindio.proyecto.dto.MensajeDTO;
import co.edu.uniquindio.proyecto.dto.SesionDTO;
import co.edu.uniquindio.proyecto.dto.TokenDTO;
import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.servicios.interfaces.SesionServicio;
import co.edu.uniquindio.proyecto.servicios.interfaces.UsuarioServicio;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class SesionControlador {

    private final SesionServicio sesionServicio;
    private final UsuarioServicio usuarioServicio;

    @PostMapping("/crear")
    public ResponseEntity<MensajeDTO> crearUsuario(@Valid @RequestBody UsuarioDTO usuarioDTO) throws Exception {
        return ResponseEntity.status(200).body(new MensajeDTO(HttpStatus.OK, false, "Usuario creado exitosamente! Código: " + usuarioServicio.crearUsuario(usuarioDTO)));
    }
    @PostMapping("/login")
    public ResponseEntity<MensajeDTO> login(@RequestBody SesionDTO sesionDTO){
        return ResponseEntity.status(200).body( new MensajeDTO(HttpStatus.OK, false, sesionServicio.login(sesionDTO)) );
    }




}