package co.edu.uniquindio.proyecto.dto;

import co.edu.uniquindio.proyecto.modelo.entidades.DetalleCompra;
import co.edu.uniquindio.proyecto.modelo.entidades.MetodoPago;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class CompraGetDTO {

    private Integer codigo;

    private LocalDateTime fecha;

    private Double valorTotal;

    private int codigoUsuario;

    private MetodoPago metodoPago;

    private List<DetalleCompra> detalleCompras;

}
