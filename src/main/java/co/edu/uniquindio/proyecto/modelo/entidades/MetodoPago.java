package co.edu.uniquindio.proyecto.modelo.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

public enum MetodoPago {

    TARJETA_CREDITO,
    TARJETA_DEBITO,
    PSE,
    EFECTIVO

}
