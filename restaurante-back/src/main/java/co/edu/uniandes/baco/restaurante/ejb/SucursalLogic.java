/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.baco.restaurante.ejb;

import co.edu.uniandes.baco.restaurante.entities.RestauranteEntity;
import co.edu.uniandes.baco.restaurante.entities.SucursalEntity;
import co.edu.uniandes.baco.restaurante.exceptions.BusinessLogicException;
import co.edu.uniandes.baco.restaurante.persistence.SucursalPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @restaurante ISIS2603
 */
@Stateless
public class SucursalLogic {

    private static final Logger LOGGER = Logger.getLogger(SucursalLogic.class.getName());

    @Inject
    private SucursalPersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.

    /**
     *
     * @param entity
     * @return
     * @throws BusinessLogicException
     */
    public SucursalEntity createSucursal(SucursalEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de Sucursal");
        // Invoca la persistencia para crear la Sucursal
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de Sucursal");
        return entity;
    }

    /**
     * 
     * Obtener todas las Sucursales existentes en la base de datos.
     *
     * @return una lista de Sucursales.
     */
    public List<SucursalEntity> getSucursals() {
        LOGGER.info("Inicia proceso de consultar todas las Sucursales");
        // Note que, por medio de la inyección de dependencias se llama al método "findAll()" que se encuentra en la persistencia.
        List<SucursalEntity> sucursals = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todas las Sucursales");
        return sucursals;
    }
    /**
     * Actualiza la información de una instancia de Sucursal.
     *
     * @param entity Instancia de SucursalEntity con los nuevos datos.
     * @return Instancia de SucursalEntity con los datos actualizados.
     * @generated
     */
    public SucursalEntity updateSucursal(SucursalEntity entity) {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar un autor ");
        return persistence.update(entity);
    }

    /**
     * Elimina una instancia de Sucursal de la base de datos.
     *
     * @param id Identificador de la instancia a eliminar.
     * @generated
     */
    public void deleteSucursal(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar un autor ");
        persistence.delete(id);
    }
    public SucursalEntity getSucursal(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar un autor con id = {0}", id);
        return persistence.find(id);
    }
    public RestauranteEntity getRestaurante(Long sucursalId, Long restaurantesId) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar un autor del libro con id = {0}", sucursalId);
        RestauranteEntity franquicia = getSucursal(sucursalId).getRestaurante();
        RestauranteEntity restaurantesEntity = new RestauranteEntity();
        restaurantesEntity.setId(restaurantesId);
        return franquicia;
    }
}