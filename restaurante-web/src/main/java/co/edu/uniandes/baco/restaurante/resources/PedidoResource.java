/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.baco.restaurante.resources;


import co.edu.uniandes.baco.restaurante.dtos.PedidoDetailDTO;
import co.edu.uniandes.baco.restaurante.ejb.PedidoLogic;
import co.edu.uniandes.baco.restaurante.entities.PedidoEntity;
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
@Path("pedidos")
@Produces("application/json")
@Consumes("application/json")
@Stateless
public class PedidoResource {
     
    @Inject
    PedidoLogic PedidoLogic; // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.

    private static final Logger LOGGER = Logger.getLogger(PedidoResource.class.getName());

    /**
     * POST http://localhost:8080/restaurante-web/api/pedidos
     *
     * @param Pedido correponde a la representación java del objeto json
     * enviado en el llamado.
     * @return Devuelve el objeto json de entrada que contiene el id creado por
     * la base de datos y el tipo del objeto java. Ejemplo: { "type":
     * "PedidoDetailDTO", "id": 1, atributo1 : "valor" }
     * @throws BusinessLogicException
     */
    @POST 
    public PedidoDetailDTO  createPedido(PedidoDetailDTO Pedido) throws BusinessLogicException {
        // Convierte el DTO (json) en un objeto Entity para ser manejado por la lógica.
        PedidoEntity PedidoEntity = Pedido.toEntity();
        // Invoca la lógica para crear la Pedido nueva
        PedidoEntity nuevoPedido;
        nuevoPedido = PedidoLogic.createPedido(PedidoEntity);
        // Como debe retornar un DTO (json) se invoca el constructor del DTO con argumento el entity nuevo
        return new PedidoDetailDTO(nuevoPedido);
    }

    /**
     * GET para todas las Pedidoes.
     * http://localhost:8080/restaurante-web/api/pedidos
     *
     * @return la lista de todas las Pedidoes en objetos json DTO.
     * @throws BusinessLogicException
     */
    @GET 
    public List<PedidoDetailDTO> getPedidos() throws BusinessLogicException {
        return listEntity2DetailDTO(PedidoLogic.getPedidos());
    }
@GET
    @Path("{id: \\d+}")
    public PedidoDetailDTO getPedido(@PathParam("id") Long id) throws BusinessLogicException {
        PedidoEntity entity = PedidoLogic.getPedido(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /Pedido/" + id + " no existe.", 404);
        }
        return new PedidoDetailDTO(entity);
    }
   
    /**
     * PUT http://localhost:8080/restaurante-web/api/pedidos/1 Ejemplo
     * json { "id": 1, "atirbuto1": "Valor nuevo" }
     *
     * @param id corresponde a la Pedido a actualizar.
     * @param restaurante corresponde  al objeto con los cambios que se van a
     * realizar.
     * @return La Pedido actualizada.
     * @throws BusinessLogicException
     *
     * En caso de no existir el id de la Pedido a actualizar se retorna un
     * 404 con el mensaje.
     */
    @PUT 
    @Path("{id: \\d+}")
    public PedidoDetailDTO updatePedido(@PathParam("id") Long id, PedidoDetailDTO pedido) throws BusinessLogicException, UnsupportedOperationException {
          pedido.setId(id);
        PedidoEntity entity = PedidoLogic.getPedido(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /pedidos/" + id + " no existe.", 404);
        }
        return new PedidoDetailDTO(PedidoLogic.updatePedido(id, entity)); 
      
    }

    /**
     * DELETE http://localhost:8080/restaurante-web/api/pedidos/{id}
     *
     * @param id corresponde a la Pedido a borrar.
     * @throws BusinessLogicException
     *
     * En caso de no existir el id de la Pedido a actualizar se retorna un
     * 404 con el mensaje.
     *
     */
    @DELETE 
    @Path("{id: \\d+}")
    public void deletePedido(@PathParam("id") Long id) throws BusinessLogicException {
         PedidoEntity entity = PedidoLogic.getPedido(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /Pedido/" + id + " no existe.", 404);
        }
        PedidoLogic.deletePedido(id);
    }

    /**
     *
     * lista de entidades a DTO.
     *
     * Este método convierte una lista de objetos PedidoEntity a una lista de
     * objetos PedidoDetailDTO (json)
     *
     * @param entityList corresponde a la lista de Pedidoes de tipo Entity
     * que vamos a convertir a DTO.
     * @return la lista de Pedidoes en forma DTO (json)
     */
    private List<PedidoDetailDTO> listEntity2DetailDTO(List<PedidoEntity> entityList) {
        List<PedidoDetailDTO> list = new ArrayList<>();
        for (PedidoEntity entity : entityList) {
            list.add(new PedidoDetailDTO(entity));
        }
        return list;
    }
}
