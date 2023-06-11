package co.edu.uniquindio.proyecto.modelo.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Producto implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrementable codigo
    private int codigo;

    private Estado estado; //preguntar

    private LocalDateTime fechaLimite;

    private LocalDateTime fechaCreacion;

    private String nombre;

    private String descripcion;

    private int unidades;

    private float precio;

    private Integer calificacion;

    @ElementCollection
    private List<String> imagenes;

    @ElementCollection
    private List<Categoria> categorias;

    @OneToMany (mappedBy = "producto")
    private List<Comentario> comentarios;

    @OneToMany(mappedBy = "producto")
    private List<ProductoModerador> productoModeradors;

    @OneToMany(mappedBy = "producto")
    private List<Favorito> favoritos;

    @ManyToOne
    private Usuario usuario;

    @OneToMany(mappedBy = "producto")
    private List<DetalleCompra> detalleCompras;

}
