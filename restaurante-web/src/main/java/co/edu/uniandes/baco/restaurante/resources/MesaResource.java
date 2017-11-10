/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.baco.restaurante.resources;

import co.edu.uniandes.baco.restaurante.dtos.MesaDetailDTO;
import co.edu.uniandes.baco.restaurante.ejb.MesaLogic;
import co.edu.uniandes.baco.restaurante.entities.MesaEntity;
import co.edu.uniandes.baco.restaurante.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author s.heim
 */
@Path("mesas")
@Produces("application/json")
@Consumes("application/json")
@Stateless
public class MesaResource {
    @Inject
    MesaLogic MesaLogic; // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.

    private static final Logger LOGGER = Logger.getLogger(MesaResource.class.getName());

    /**
     * POST http://localhost:8080/restaurante-web/api/mesas
     *
     * @param Mesa correponde a la representación java del objeto json
     * enviado en el llamado.
     * @return Devuelve el objeto json de entrada que contiene el id creado por
     * la base de datos y el tipo del objeto java. Ejemplo: { "type":
     * "MesaDetailDTO", "id": 1, atributo1 : "valor" }
     * @throws BusinessLogicException
     */
    @POST 
    public MesaDetailDTO  createCliente(MesaDetailDTO Mesa) throws BusinessLogicException {
        // Convierte el DTO (json) en un objeto Entity para ser manejado por la lógica.
        MesaEntity MesaEntity = Mesa.toEntity();
        // Invoca la lógica para crear la Mesa nueva
        MesaEntity nuevoMesa;
        nuevoMesa = MesaLogic.createMesa(MesaEntity);
        // Como debe retornar un DTO (json) se invoca el constructor del DTO con argumento el entity nuevo
        return new MesaDetailDTO(nuevoMesa);
    }

    /**
     * GET para todas las Mesaes.
     * http://localhost:8080/restaurante-web/api/mesas
     *
     * @return la lista de todas las Mesaes en objetos json DTO.
     * @throws BusinessLogicException
     */
    @GET 
    public List<MesaDetailDTO> getMesas() throws BusinessLogicException {
        return listEntity2DetailDTO(MesaLogic.getMesas());
    }
@GET
    @Path("{id: \\d+}")
    public MesaDetailDTO getMesa(@PathParam("id") Long id) throws BusinessLogicException {
        MesaEntity entity = MesaLogic.getMesa(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /Mesa/" + id + " no existe.", 404);
        }
        return new MesaDetailDTO(entity);
    }
   
    /**
     * PUT http://localhost:8080/restaurante-web/api/mesas/1 Ejemplo
     * json { "id": 1, "atirbuto1": "Valor nuevo" }
     *
     * @param id corresponde a la Mesa a actualizar.
     * @param restaurante corresponde  al objeto con los cambios que se van a
     * realizar.
     * @return La Mesa actualizada.
     * @throws BusinessLogicException
     *
     * En caso de no existir el id de la Mesa a actualizar se retorna un
     * 404 con el mensaje.
     */
    @PUT 
    @Path("{id: \\d+}")
    public MesaDetailDTO updateMesa(@PathParam("id") Long id, MesaDetailDTO mesa) throws BusinessLogicException, UnsupportedOperationException {
          mesa.setId(id);
        MesaEntity entity = MesaLogic.getMesa(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /Mesaes/" + id + " no existe.", 404);
        }
        return new MesaDetailDTO(MesaLogic.updateMesa( mesa.toEntity()));
      
    }

    /**
     * DELETE http://localhost:8080/restaurante-web/api/mesas/{id}
     *
     * @param id corresponde a la Mesa a borrar.
     * @throws BusinessLogicException
     *
     * En caso de no existir el id de la Mesa a actualizar se retorna un
     * 404 con el mensaje.
     *
     */
    @DELETE 
    @Path("{id: \\d+}")
    public void deleteMesa(@PathParam("id") Long id) throws BusinessLogicException {
         throw new UnsupportedOperationException("Este servicio no está implementado");
    }

    /**
     *
     * lista de entidades a DTO.
     *
     * Este método convierte una lista de objetos MesaEntity a una lista de
     * objetos MesaDetailDTO (json)
     *
     * @param entityList corresponde a la lista de Mesaes de tipo Entity
     * que vamos a convertir a DTO.
     * @return la lista de Mesaes en forma DTO (json)
     */
    private List<MesaDetailDTO> listEntity2DetailDTO(List<MesaEntity> entityList) {
        List<MesaDetailDTO> list = new ArrayList<>();
        for (MesaEntity entity : entityList) {
            list.add(new MesaDetailDTO(entity));
        }
        return list;
    }
}
