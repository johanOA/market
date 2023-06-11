package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.ModeradorGetDTO;
import co.edu.uniquindio.proyecto.dto.ProductoGetDTO;
import co.edu.uniquindio.proyecto.mappers.ProductoMapper;
import co.edu.uniquindio.proyecto.modelo.entidades.Moderador;
import co.edu.uniquindio.proyecto.modelo.entidades.Producto;
import co.edu.uniquindio.proyecto.repositorios.ProductoModeradorRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.ProductoModeradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoModeradorServiceImpl implements ProductoModeradorService {
    @Autowired
    private ProductoModeradorRepo productoModeradorRepo;

    @Autowired
    private ProductoMapper productoMapper;

    @Override
    public List<ProductoGetDTO> listarProductosPorModerador(ModeradorGetDTO moderadorDTO) {
        Moderador moderador = new Moderador();
        moderador.setCodigo(moderadorDTO.getCodigo());

        List<Producto> productos = productoModeradorRepo.listarProductosPorModerador(moderador);

        return productoMapper.mapToDtoList(productos);
    }
}
