package co.edu.uniquindio.proyecto.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
public class UsuarioGetDTO {

    //@GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrementable codigo
    private int codigo;

    private String nombre;

    private String email;

    private String direccion;

    private List<String> telefono;

}
