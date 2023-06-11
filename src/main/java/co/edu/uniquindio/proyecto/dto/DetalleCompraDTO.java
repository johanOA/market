package co.edu.uniquindio.proyecto.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class DetalleCompraDTO {

    @PositiveOrZero
    private int unidades;
    @Positive
    @NotNull
    private float precio;
    private int codigoProducto;

}
