package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.modelo.entidades.Moderador;

public interface ModeradorServicio {

    void aprobarProducto(int codigoProducto) throws Exception;

    void rechazarProducto(int codigoProducto) throws Exception;

    Moderador obtenerModerador(int codigoModerador) throws Exception;
}
