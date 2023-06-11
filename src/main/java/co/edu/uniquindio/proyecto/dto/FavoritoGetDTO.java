package co.edu.uniquindio.proyecto.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FavoritoGetDTO {

    private int codigo;
    private ProductoGetDTO productoId;
    private UsuarioGetDTO usuarioId;
}
