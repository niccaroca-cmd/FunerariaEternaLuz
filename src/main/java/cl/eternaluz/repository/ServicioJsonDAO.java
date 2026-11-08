package cl.eternaluz.repository;

import cl.eternaluz.model.ServicioFunerario;
import cl.eternaluz.model.ServicioSepultura;
import cl.eternaluz.model.ServicioCremacion;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ServicioJsonDAO implements ServicioDAO {

    // Archivo donde se guardaran los servicios
    private final Path archivo = Path.of("servicios.json");

    // Gson
    private final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    // Lista de servicios
    private List<ServicioFunerario> servicios;

    // Constructor
    public ServicioJsonDAO() {
        servicios = new ArrayList<>();
        cargar();
    }

    // Guardar un servicio
    @Override
    public void guardar(ServicioFunerario servicio) {
        servicios.add(servicio);
        guardarArchivo();
    }

    // Listar servicios
    @Override
    public List<ServicioFunerario> listar() {
        return servicios;
    }

    // Eliminar un servicio
    @Override
    public void eliminar(String codigoServicio) {

        servicios.removeIf(servicio ->
                servicio.getCodigoServicio().equals(codigoServicio));

        guardarArchivo();
    }

    // Guardar los servicios en JSON
    private void guardarArchivo() {

        JsonArray jsonArray = new JsonArray();

        for (ServicioFunerario servicio : servicios) {

            JsonObject objeto = gson.toJsonTree(servicio)
                    .getAsJsonObject();

            if (servicio instanceof ServicioSepultura) {
                objeto.addProperty("tipo", "sepultura");

            } else if (servicio instanceof ServicioCremacion) {
                objeto.addProperty("tipo", "cremacion");
            }

            jsonArray.add(objeto);
        }

        try {
            Files.writeString(
                    archivo,
                    gson.toJson(jsonArray),
                    StandardCharsets.UTF_8
            );

        } catch (IOException e) {
            throw new RuntimeException("Error al guardar los servicios", e);
        }
    }

    // Cargar los servicios desde JSON
    private void cargar() {

        if (!Files.exists(archivo)) {
            return;
        }

        try {
            String contenido = Files.readString(
                    archivo,
                    StandardCharsets.UTF_8
            );

            JsonArray jsonArray = JsonParser
                    .parseString(contenido)
                    .getAsJsonArray();

            for (int i = 0; i < jsonArray.size(); i++) {

                JsonObject objeto = jsonArray.get(i).getAsJsonObject();

                String tipo = objeto.get("tipo").getAsString();

                objeto.remove("tipo");

                if (tipo.equals("sepultura")) {

                    servicios.add(gson.fromJson(
                            objeto,
                            ServicioSepultura.class
                    ));

                } else if (tipo.equals("cremacion")) {

                    servicios.add(gson.fromJson(
                            objeto,
                            ServicioCremacion.class
                    ));
                }
            }

        } catch (IOException e) {
            throw new RuntimeException("Error al cargar los servicios", e);
        }
    }
}
