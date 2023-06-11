package co.edu.uniquindio.proyecto.modelo.entidades;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ProductoModerador implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Column(nullable = false, length = 100)
    private String motivo;

    @DateTimeFormat //preguntar
    private LocalDateTime fecha;

    @ManyToOne
    private Producto producto;

    @ManyToOne
    private Moderador moderador;

    private Estado estado;


    @Builder
    public ProductoModerador(String motivo, LocalDate fecha, Producto producto, Moderador moderador, Estado estado) {
        this.motivo = motivo;
        this.fecha = LocalDateTime.now();
        this.producto = producto;
        this.moderador = moderador;
        this.estado = estado;
    }
}
