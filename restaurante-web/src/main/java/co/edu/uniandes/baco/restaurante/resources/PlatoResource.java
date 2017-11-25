/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.baco.restaurante.resources;

import co.edu.uniandes.baco.restaurante.dtos.PlatoDetailDTO;
import co.edu.uniandes.baco.restaurante.ejb.PlatoLogic;
import co.edu.uniandes.baco.restaurante.entities.PlatoEntity;
import co.edu.uniandes.baco.restaurante.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
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
@Path("platos")
@Produces("application/json")
@Consumes("application/json")
@Stateless
public class PlatoResource {
    @Inject PlatoLogic platoLogic; // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.


    /**
     * POST http://localhost:8080/restaurante-web/api/platos
     *
     * @param plato correponde a la representación java del objeto json
     * enviado en el llamado.
     * @return Devuelve el objeto json de entrada que contiene el id creado por
     * la base de datos y el tipo del objeto java. Ejemplo: { "type":
     * "PlatoDetailDTO", "id": 1, atributo1 : "valor" }
     * @throws BusinessLogicException
     */
    @POST 
    public PlatoDetailDTO  createCliente(PlatoDetailDTO plato) throws BusinessLogicException {
        // Convierte el DTO (json) en un objeto Entity para ser manejado por la lógica.
        PlatoEntity platoEntity = plato.toEntity();
        // Invoca la lógica para crear la Plato nueva
        PlatoEntity nuevoPlato;
        nuevoPlato = platoLogic.createPlato(platoEntity);
        // Como debe retornar un DTO (json) se invoca el constructor del DTO con argumento el entity nuevo
        return new PlatoDetailDTO(nuevoPlato);
    }

    /**
     * GET para todas las Platoes.
     * http://localhost:8080/restaurante-web/api/platos
     *
     * @return la lista de todas las Platoes en objetos json DTO.
     * @throws BusinessLogicException
     */
    @GET 
    public List<PlatoDetailDTO> getPlatos() throws BusinessLogicException {
        return listEntity2DetailDTO(platoLogic.getPlatos());
    }
@GET
    @Path("{id: \\d+}")
    public PlatoDetailDTO getPlato(@PathParam("id") Long id) throws BusinessLogicException {
        PlatoEntity entity = platoLogic.gePlato(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /Platoes/" + id + " no existe.", 404);
        }
        return new PlatoDetailDTO(entity);
    }

   
    /**
     * PUT http://localhost:8080/restaurante-web/api/Platoes/1 Ejemplo
     * json { "id": 1, "atirbuto1": "Valor nuevo" }
     *
     * @param id corresponde a la Plato a actualizar.
     * @param suc corresponde  al objeto con los cambios que se van a
     * realizar.
     * @return La Plato actualizada.
     * @throws BusinessLogicException
     *
     * En caso de no existir el id de la Plato a actualizar se retorna un
     * 404 con el mensaje.
     */
    @PUT
    @Path("{id: \\d+}")
    public PlatoDetailDTO updatePlato(@PathParam("id") Long id, PlatoDetailDTO suc) throws BusinessLogicException {
        suc.setId(id);
        PlatoEntity entity = platoLogic.gePlato(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /Plato/" + id + " no está en la db.", 404);
        }
        return new PlatoDetailDTO(platoLogic.updatePlato(id, suc.toEntity()));
    }


    /**
     * DELETE http://localhost:8080/restaurante-web/api/platos/{id}
     *
     * @param id corresponde a la Plato a borrar.
     * @throws BusinessLogicException
     *
     * En caso de no existir el id de la Plato a actualizar se retorna un
     * 404 con el mensaje.
     *
     */
    @DELETE 
    @Path("{id: \\d+}")
    public void deletePlato(@PathParam("id") Long id) throws BusinessLogicException {
          PlatoEntity entity = platoLogic.gePlato(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /Plato/" + id + " no ha sido creado", 404);
        }
        platoLogic.deletePlato(id);
    }

    /**
     *
     * lista de entidades a DTO.
     *
     * Este método convierte una lista de objetos PlatoEntity a una lista de
     * objetos PlatoDetailDTO (json)
     *
     * @param entityList corresponde a la lista de Platoes de tipo Entity
     * que vamos a convertir a DTO.
     * @return la lista de Platoes en forma DTO (json)
     */
    private List<PlatoDetailDTO> listEntity2DetailDTO(List<PlatoEntity> entityList) {
        List<PlatoDetailDTO> list = new ArrayList<>();
        for (PlatoEntity entity : entityList) {
            list.add(new PlatoDetailDTO(entity));
        }
        return list;
    }
}
