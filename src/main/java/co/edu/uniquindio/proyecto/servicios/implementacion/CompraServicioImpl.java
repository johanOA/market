package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.CompraDTO;
import co.edu.uniquindio.proyecto.dto.CompraGetDTO;
import co.edu.uniquindio.proyecto.modelo.entidades.Compra;
import co.edu.uniquindio.proyecto.modelo.entidades.DetalleCompra;
import co.edu.uniquindio.proyecto.modelo.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.CompraRepo;
import co.edu.uniquindio.proyecto.repositorios.DetalleCompraRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.CompraServicio;
import co.edu.uniquindio.proyecto.servicios.interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CompraServicioImpl implements CompraServicio {

    private final CompraRepo compraRepo;

    private final UsuarioServicio usuarioServicio;

    private final DetalleCompraRepo detalleCompraRepo;


    @Override
    public int crearCompra(CompraDTO compraDTO) throws Exception {

        Compra compra = new Compra();
        compra.setFecha_creacion(LocalDateTime.now());
        compra.setValor_total(compra.getValor_total());
        compra.setMetodo_pago(compraDTO.getMetodoPago());
        compra.setUsuario(usuarioServicio.obtener(compraDTO.getCodigoUsuario()));
        compra.setDetalleCompras(compra.getDetalleCompras());

        return compraRepo.save(compra).getCodigo();
    }

    @Override
    public List<CompraGetDTO> listarCompras(int codigoUsuario) {

        List<Compra> lista = compraRepo.listarCompras(codigoUsuario);
        List<CompraGetDTO> respuesta = new ArrayList<>();

        for (Compra p : lista) {
            respuesta.add(convertir(p));
        }

        return respuesta;
    }

    private CompraGetDTO convertir(Compra compra) {

        CompraGetDTO compraGetDTO = new CompraGetDTO(
                compra.getCodigo(),
                compra.getFecha_creacion(),
                compra.getValor_total(),
                compra.getUsuario().getCodigo(),
                compra.getMetodo_pago(),
                compra.getDetalleCompras()

        );

        return compraGetDTO;

    }

    @Override
    public CompraGetDTO obtenerCompra(int codigoCompra) throws Exception {

        return convertir(obtener(codigoCompra));
    }

    @Override
    public Compra obtener(int codigoCompra) throws Exception {
        Optional<Compra> compra = compraRepo.findById(codigoCompra);

        if (compra.isEmpty()) {

            throw new Exception("El código " + codigoCompra + " no está asociado a ninguna compra");
        }

        return compra.get();
    }

    @Override
    public CompraGetDTO actualizarCompra(int codigoCompra, CompraDTO compraDTO) throws Exception {
        obtener(codigoCompra);

        Compra compra = convertirCompraDTOaCompra(compraDTO);
        compra.setCodigo(codigoCompra);

        return convertir(compraRepo.save(compra));

    }

    private Compra convertirCompraDTOaCompra(CompraDTO compraDTO) throws Exception {

        LocalDateTime fecha = LocalDateTime.now();
        Usuario usuario = usuarioServicio.obtener(compraDTO.getCodigoUsuario());
        Compra compra = new Compra();
        compra.setFecha_creacion(fecha);
        compra.setMetodo_pago(compraDTO.getMetodoPago());
        compra.setValor_total(compraDTO.getValorTotal());
        compra.setUsuario(usuario);
        compra.setDetalleCompras(compra.getDetalleCompras());

        for (DetalleCompra d : compra.getDetalleCompras()) {
            detalleCompraRepo.save(d);
        }
        return compra;
    }

    @Override
    public int eliminiarCompra(int codigoCompra) throws Exception {
        obtener(codigoCompra);
        compraRepo.deleteById(codigoCompra);
        return codigoCompra;
    }
}

