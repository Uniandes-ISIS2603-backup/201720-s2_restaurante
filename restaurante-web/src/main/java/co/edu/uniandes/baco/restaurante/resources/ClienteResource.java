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

/**
 *
 * @author s.heim
 */
@Path("clientes")
@Produces("application/json")
@Consumes("application/json")
@Stateless
public class ClienteResource {
    
    @Inject
    ClienteLogic ClienteLogic; // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.

    private static final Logger LOGGER = Logger.getLogger(ClienteResource.class.getName());

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
    public ClienteDetailDTO  createCliente(ClienteDetailDTO Cliente) throws BusinessLogicException {
        // Convierte el DTO (json) en un objeto Entity para ser manejado por la lógica.
        ClienteEntity ClienteEntity = Cliente.toEntity();
        // Invoca la lógica para crear la Cliente nueva
        ClienteEntity nuevoCliente;
        nuevoCliente = ClienteLogic.createCliente(ClienteEntity);
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
        return listEntity2DetailDTO(ClienteLogic.getClientes());
    }

   
    /**
     * PUT http://localhost:8080/restaurante-web/api/clientes/1 Ejemplo
     * json { "id": 1, "atirbuto1": "Valor nuevo" }
     *
     * @param id corresponde a la Cliente a actualizar.
     * @param restaurante corresponde  al objeto con los cambios que se van a
     * realizar.
     * @return La Cliente actualizada.
     * @throws BusinessLogicException
     *
     * En caso de no existir el id de la Cliente a actualizar se retorna un
     * 404 con el mensaje.
     */
    @PUT 
    @Path("{id: \\d+}")
    public ClienteDetailDTO updateCliente(@PathParam("id") Long id, ClienteDetailDTO restaurante) throws BusinessLogicException, UnsupportedOperationException {
          throw new UnsupportedOperationException("Este servicio  no está implementado");
      
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
         throw new UnsupportedOperationException("Este servicio no está implementado");
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
