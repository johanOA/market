package co.edu.uniquindio.proyecto.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class ModeradorGetDTO {
    private Integer codigo;
    private String nombre;
    private String email;
    private String password;
}
