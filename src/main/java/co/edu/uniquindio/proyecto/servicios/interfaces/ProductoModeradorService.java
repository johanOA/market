package co.edu.uniquindio.proyecto.servicios.interfaces;

import co.edu.uniquindio.proyecto.dto.ModeradorGetDTO;
import co.edu.uniquindio.proyecto.dto.ProductoGetDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductoModeradorService {
    List<ProductoGetDTO> listarProductosPorModerador(ModeradorGetDTO moderadorGetDTO);
}
