package co.edu.uniquindio.proyecto.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class ComentarioDTO { //DTO --> Datos de trnsferencia simples

    @NotNull
    @Length(max = 100, message = "El comentario  debe tener máximo 100 caracteres")
    private String mensaje;

    private int codigoUsuario;

    private int codigoProducto;

    private LocalDateTime localDateTime;

}
