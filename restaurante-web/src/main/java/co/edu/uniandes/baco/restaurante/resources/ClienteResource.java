/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.baco.restaurante.resources;

import co.edu.uniandes.baco.restaurante.dtos.ClienteDetailDTO;
import co.edu.uniandes.baco.restaurante.ejb.ClienteLogic;
import co.edu.uniandes.baco.restaurante.entities.ClienteEntity;
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
@Path("clientes")
@Produces("application/json")
@Consumes("application/json")
@Stateless
public class ClienteResource {
    
    @Inject ClienteLogic clienteLogic; // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.


    /**
     * POST http://localhost:8080/restaurante-web/api/clientes
     *
     * @param Cliente correponde a la representación java del objeto json
     * enviado en el llamado.
     * @return Devuelve el objeto json de entrada que contiene el id creado por
     * la base de datos y el tipo del objeto java. Ejemplo: { "type":
     * "ClienteDetailDTO", "id": 1, atributo1 : "valor" }
     * @throws BusinessLogicException
     */
    @POST 
    public ClienteDetailDTO  createCliente(ClienteDetailDTO cliente) throws BusinessLogicException {
        // Convierte el DTO (json) en un objeto Entity para ser manejado por la lógica.
        ClienteEntity ClienteEntity = cliente.toEntity();
        // Invoca la lógica para crear la Cliente nueva
        ClienteEntity nuevoCliente;
        nuevoCliente = clienteLogic.createCliente(ClienteEntity);
        // Como debe retornar un DTO (json) se invoca el constructor del DTO con argumento el entity nuevo
        return new ClienteDetailDTO(nuevoCliente);
    }

    /**
     * GET para todas las Clientees.
     * http://localhost:8080/restaurante-web/api/clientes
     *
     * @return la lista de todas las Clientees en objetos json DTO.
     * @throws BusinessLogicException
     */
    @GET 
    public List<ClienteDetailDTO> getClientes() throws BusinessLogicException {
        return listEntity2DetailDTO(clienteLogic.getClientes());
    }
@GET
    @Path("{id: \\d+}")
    public ClienteDetailDTO getCliente(@PathParam("id") Long id) throws BusinessLogicException {
        ClienteEntity entity = clienteLogic.getCliente(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /Cliente/" + id + " no existe.", 404);
        }
        return new ClienteDetailDTO(entity);
    }
   
    /**
     * PUT http://localhost:8080/restaurante-web/api/clientes/1 Ejemplo
     * json { "id": 1, "atirbuto1": "Valor nuevo" }
     *
     * @param id corresponde a la Cliente a actualizar.
     * @param cliente corresponde  al objeto con los cambios que se van a
     * realizar.
     * @return La Cliente actualizada.
     * @throws BusinessLogicException
     *
     * En caso de no existir el id de la Cliente a actualizar se retorna un
     * 404 con el mensaje.
     */
    @PUT 
    @Path("{id: \\d+}")
    public ClienteDetailDTO updateCliente(@PathParam("id") Long id, ClienteDetailDTO cliente) throws BusinessLogicException {
        cliente.setId(id);
        ClienteEntity entity = cliente.toEntity();
        if (entity == null) {
            throw new WebApplicationException("El recurso /clientes/" + id + " no es existente.", 404);
        }
        return new ClienteDetailDTO(clienteLogic.updateCliente(id, entity)); 
        
    }

    /**
     * DELETE http://localhost:8080/restaurante-web/api/clientes/{id}
     *
     * @param id corresponde a la Cliente a borrar.
     * @throws BusinessLogicException
     *
     * En caso de no existir el id de la Cliente a actualizar se retorna un
     * 404 con el mensaje.
     *
     */
    @DELETE 
    @Path("{id: \\d+}")
    public void deleteCliente(@PathParam("id") Long id) throws BusinessLogicException {
         ClienteEntity entity = clienteLogic.getCliente(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /clientes/" + id + " no se encuentra en la db.", 404);
        }
        clienteLogic.deleteCliente(id);
    }

    /**
     *
     * lista de entidades a DTO.
     *
     * Este método convierte una lista de objetos ClienteEntity a una lista de
     * objetos ClienteDetailDTO (json)
     *
     * @param entityList corresponde a la lista de Clientees de tipo Entity
     * que vamos a convertir a DTO.
     * @return la lista de Clientees en forma DTO (json)
     */
    private List<ClienteDetailDTO> listEntity2DetailDTO(List<ClienteEntity> entityList) {
        List<ClienteDetailDTO> list = new ArrayList<>();
        for (ClienteEntity entity : entityList) {
            list.add(new ClienteDetailDTO(entity));
        }
        return list;
    }
}
