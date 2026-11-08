package cl.eternaluz.repository;

import cl.eternaluz.model.ServicioFunerario;

import java.util.List;

public class ServicioRepository {

    // Atributo
    private ServicioDAO servicioDAO;

    // Constructor
    public ServicioRepository(ServicioDAO servicioDAO) {
        this.servicioDAO = servicioDAO;
    }

    // Guardar servicio
    public void guardarServicio(ServicioFunerario servicio) {
        servicioDAO.guardar(servicio);
    }

    // Obtener todos los servicios
    public List<ServicioFunerario> obtenerServicios() {
        return servicioDAO.listar();
    }

    // Eliminar servicio
    public void eliminarServicio(String codigoServicio) {
        servicioDAO.eliminar(codigoServicio);
    }


    // Buscar servicio por codigo
    public ServicioFunerario buscarServicio(String codigoServicio) {

        for (ServicioFunerario servicio : servicioDAO.listar()) {

            if (servicio.getCodigoServicio().equals(codigoServicio)) {
                return servicio;
            }
        }

        return null;
    }

}
