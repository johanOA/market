package co.edu.uniquindio.proyecto.modelo.entidades;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Compra implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @DateTimeFormat //preguntar
    private LocalDateTime fecha_creacion;

    private Double valor_total;

    @Column(nullable = false)
    private MetodoPago metodo_pago;

    @ManyToOne
    private Usuario usuario;

    @OneToMany(mappedBy = "compra")
    private List<DetalleCompra> detalleCompras;

    /*
    @Builder
    public Compra(LocalDateTime fecha_creacion, Float valor_total, MetodoPago metodo_pago,
                  Usuario usuario, List<DetalleCompra> detalleCompras) {
        this.fecha_creacion = LocalDateTime.now();
        this.valor_total = valor_total;
        this.metodo_pago = metodo_pago;
        this.usuario = usuario;
        this.detalleCompras = detalleCompras;
    }

     */
}
