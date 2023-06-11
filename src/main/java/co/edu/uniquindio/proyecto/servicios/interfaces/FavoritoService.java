package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.*;
import co.edu.uniquindio.proyecto.modelo.entidades.Producto;
import co.edu.uniquindio.proyecto.modelo.entidades.Usuario;

import java.util.List;

public interface FavoritoService {

    List<FavoritoDTO> listarFavoritosPorUser(UsuarioGetDTO usuario);

    FavoritoDTO listarFavoritosPorProductAndUser(ProductoGetDTO producto, UsuarioGetDTO usuario);

    void agregarFavorito(FavoritoDTO favoritoDTO);

    void eliminarFavorito(FavoritoGetDTO favoritoGetDTO);

}
