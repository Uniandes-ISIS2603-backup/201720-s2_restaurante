/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.baco.restaurante.resources;

import co.edu.uniandes.baco.restaurante.dtos.ReservaDetailDTO;
import co.edu.uniandes.baco.restaurante.ejb.ReservaLogic;
import co.edu.uniandes.baco.restaurante.entities.ReservaEntity;
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
@Path("reservas")
@Produces("application/json")
@Consumes("application/json")
@Stateless
public class ReservaResource {
    
    @Inject ReservaLogic reservaLogic; // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.


    /**
     * POST http://localhost:8080/restaurante-web/api/reservas
     *
     * @param reserva correponde a la representación java del objeto json
     * enviado en el llamado.
     * @return Devuelve el objeto json de entrada que contiene el id creado por
     * la base de datos y el tipo del objeto java. Ejemplo: { "type":
     * "ReservaDetailDTO", "id": 1, atributo1 : "valor" }
     * @throws BusinessLogicException
     */
    @POST 
    public ReservaDetailDTO  createReserva(ReservaDetailDTO reserva) throws BusinessLogicException {
        // Convierte el DTO (json) en un objeto Entity para ser manejado por la lógica.
        ReservaEntity reservaEntity = reserva.toEntity();
        // Invoca la lógica para crear la Reserva nueva
        ReservaEntity nuevoReserva;
        nuevoReserva = reservaLogic.createReserva(reservaEntity);
        // Como debe retornar un DTO (json) se invoca el constructor del DTO con argumento el entity nuevo
        return new ReservaDetailDTO(nuevoReserva);
    }

    /**
     * GET para todas las Reservaes.
     * http://localhost:8080/restaurante-web/api/reservas
     *
     * @return la lista de todas las Reservaes en objetos json DTO.
     * @throws BusinessLogicException
     */
    @GET 
    public List<ReservaDetailDTO> getReservas() throws BusinessLogicException {
        return listEntity2DetailDTO(reservaLogic.getReservas());
    }
@GET
    @Path("{id: \\d+}")
    public ReservaDetailDTO getReserva(@PathParam("id") Long id) throws BusinessLogicException {
        ReservaEntity entity = reservaLogic.getReserva(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /Reserva/" + id + " no existe.", 404);
        }
        return new ReservaDetailDTO(entity);
    }
   
    /**
     * PUT http://localhost:8080/restaurante-web/api/reservas/1 Ejemplo
     * json { "id": 1, "atirbuto1": "Valor nuevo" }
     *
     * @param id corresponde a la Reserva a actualizar.
     * @param reserva corresponde  al objeto con los cambios que se van a
     * realizar.
     * @return La Reserva actualizada.
     * @throws BusinessLogicException
     *
     * En caso de no existir el id de la Reserva a actualizar se retorna un
     * 404 con el mensaje.
     */
    @PUT 
    @Path("{id: \\d+}")
    public ReservaDetailDTO updateReserva(@PathParam("id") Long id, ReservaDetailDTO reserva) throws BusinessLogicException{
        reserva.setId(id);
        ReservaEntity entity = reserva.toEntity();
        if (entity == null) {
            throw new WebApplicationException("El recurso /reservas/" + id + " no está en la db.", 404);
        }
        return new ReservaDetailDTO(reservaLogic.updateReserva(entity)); 
        
    }

    /**
     * DELETE http://localhost:8080/restaurante-web/api/reservas/{id}
     *
     * @param id corresponde a la Reserva a borrar.
     * @throws BusinessLogicException
     *
     * En caso de no existir el id de la Reserva a actualizar se retorna un
     * 404 con el mensaje.
     *
     */
    @DELETE 
    @Path("{id: \\d+}")
    public void deleteReserva(@PathParam("id") Long id) throws BusinessLogicException {
         ReservaEntity entity = reservaLogic.getReserva(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /reservas/" + id + " no ha sido creado.", 404);
        }
        reservaLogic.deleteReserva(id);
    }

    /**
     *
     * lista de entidades a DTO.
     *
     * Este método convierte una lista de objetos ReservaEntity a una lista de
     * objetos ReservaDetailDTO (json)
     *
     * @param entityList corresponde a la lista de Reservaes de tipo Entity
     * que vamos a convertir a DTO.
     * @return la lista de Reservaes en forma DTO (json)
     */
    private List<ReservaDetailDTO> listEntity2DetailDTO(List<ReservaEntity> entityList) {
        List<ReservaDetailDTO> list = new ArrayList<>();
        for (ReservaEntity entity : entityList) {
            list.add(new ReservaDetailDTO(entity));
        }
        return list;
    }
}
