package co.edu.uniquindio.proyecto.modelo.entidades;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

public enum Categoria {

    TECNOLOGIA,
    DEPORTE,
    HOGAR,
    HERRAMIENTAS,
    AUTOMOVILES,
    INSTRUMENTOS,
    LIBROS,
    RELOJES,
    SALUD

}
