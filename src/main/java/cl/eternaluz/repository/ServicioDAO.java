package cl.eternaluz.repository;

import cl.eternaluz.model.ServicioFunerario;
import java.util.List;

public interface ServicioDAO {

    // Guardar un servicio
    void guardar(ServicioFunerario servicio);

    // Listar servicios
    List<ServicioFunerario> listar();

    // Eliminar un servicio
    void eliminar(String codigoServicio);
}

