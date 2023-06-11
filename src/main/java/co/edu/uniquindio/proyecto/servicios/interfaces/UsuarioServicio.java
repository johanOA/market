package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.UsuarioDTO;
import co.edu.uniquindio.proyecto.dto.UsuarioGetDTO;
import co.edu.uniquindio.proyecto.modelo.entidades.Usuario;
//import co.edu.uniquindio.proyecto.modelo.entidades.Usuario;


public interface UsuarioServicio {


    int crearUsuario(UsuarioDTO usuarioDTO)  throws Exception;

    int actualizarUsuario(int codigoUsuario, UsuarioDTO usuarioDTO) throws Exception;

    int eliminiarUsuario(int codigoUsuario) throws Exception;

    UsuarioGetDTO obtenerUsuario(int codigoUsuario) throws Exception;

    Usuario obtener(int codigoUsuario) throws Exception;

    boolean cambiarPassword(String correo, String passwordNueva) throws Exception;


}
