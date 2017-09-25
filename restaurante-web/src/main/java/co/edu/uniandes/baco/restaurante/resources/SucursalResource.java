/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.baco.restaurante.resources;

import co.edu.uniandes.baco.restaurante.dtos.SucursalDetailDTO;
import co.edu.uniandes.baco.restaurante.ejb.SucursalLogic;
import co.edu.uniandes.baco.restaurante.entities.SucursalEntity;
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
@Path("sucursales")
@Produces("application/json")
@Consumes("application/json")
@Stateless
public class SucursalResource {
    @Inject
    SucursalLogic SucursalLogic; // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.

    private static final Logger LOGGER = Logger.getLogger(SucursalResource.class.getName());

    /**
     * POST http://localhost:8080/restaurante-web/api/sucursales
     *
     * @param Sucursal correponde a la representación java del objeto json
     * enviado en el llamado.
     * @return Devuelve el objeto json de entrada que contiene el id creado por
     * la base de datos y el tipo del objeto java. Ejemplo: { "type":
     * "SucursalDetailDTO", "id": 1, atributo1 : "valor" }
     * @throws BusinessLogicException
     */
    @POST 
    public SucursalDetailDTO  createCliente(SucursalDetailDTO Sucursal) throws BusinessLogicException {
        // Convierte el DTO (json) en un objeto Entity para ser manejado por la lógica.
        SucursalEntity SucursalEntity = Sucursal.toEntity();
        // Invoca la lógica para crear la Sucursal nueva
        SucursalEntity nuevoSucursal;
        nuevoSucursal = SucursalLogic.createSucursal(SucursalEntity);
        // Como debe retornar un DTO (json) se invoca el constructor del DTO con argumento el entity nuevo
        return new SucursalDetailDTO(nuevoSucursal);
    }

    /**
     * GET para todas las Sucursales.
     * http://localhost:8080/restaurante-web/api/sucursales
     *
     * @return la lista de todas las Sucursales en objetos json DTO.
     * @throws BusinessLogicException
     */
    @GET 
    public List<SucursalDetailDTO> getSucursals() throws BusinessLogicException {
        return listEntity2DetailDTO(SucursalLogic.getSucursals());
    }

   
    /**
     * PUT http://localhost:8080/restaurante-web/api/sucursales/1 Ejemplo
     * json { "id": 1, "atirbuto1": "Valor nuevo" }
     *
     * @param id corresponde a la Sucursal a actualizar.
     * @param restaurante corresponde  al objeto con los cambios que se van a
     * realizar.
     * @return La Sucursal actualizada.
     * @throws BusinessLogicException
     *
     * En caso de no existir el id de la Sucursal a actualizar se retorna un
     * 404 con el mensaje.
     */
    @PUT 
    @Path("{id: \\d+}")
    public SucursalDetailDTO updateSucursal(@PathParam("id") Long id, SucursalDetailDTO restaurante) throws BusinessLogicException, UnsupportedOperationException {
          throw new UnsupportedOperationException("Este servicio  no está implementado");
      
    }

    /**
     * DELETE http://localhost:8080/restaurante-web/api/sucursales/{id}
     *
     * @param id corresponde a la Sucursal a borrar.
     * @throws BusinessLogicException
     *
     * En caso de no existir el id de la Sucursal a actualizar se retorna un
     * 404 con el mensaje.
     *
     */
    @DELETE 
    @Path("{id: \\d+}")
    public void deleteSucursal(@PathParam("id") Long id) throws BusinessLogicException {
         throw new UnsupportedOperationException("Este servicio no está implementado");
    }

    /**
     *
     * lista de entidades a DTO.
     *
     * Este método convierte una lista de objetos SucursalEntity a una lista de
     * objetos SucursalDetailDTO (json)
     *
     * @param entityList corresponde a la lista de Sucursales de tipo Entity
     * que vamos a convertir a DTO.
     * @return la lista de Sucursales en forma DTO (json)
     */
    private List<SucursalDetailDTO> listEntity2DetailDTO(List<SucursalEntity> entityList) {
        List<SucursalDetailDTO> list = new ArrayList<>();
        for (SucursalEntity entity : entityList) {
            list.add(new SucursalDetailDTO(entity));
        }
        return list;
    }
}
