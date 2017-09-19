/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.baco.restaurante.ejb;

import co.edu.uniandes.baco.restaurante.entities.PlatoEntity;
import co.edu.uniandes.baco.restaurante.exceptions.BusinessLogicException;
import co.edu.uniandes.baco.restaurante.persistence.PlatoPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author df.penap
 */
@Stateless
public class PlatoLogic {
      private static final Logger LOGGER = Logger.getLogger(PlatoLogic.class.getName());

    @Inject
    private PlatoPersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.

    /**
     *
     * @param entity
     * @return
     * @throws BusinessLogicException
     */
    public PlatoEntity createPlato(PlatoEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de Plato");
        // Verifica la regla de negocio que dice que no puede haber dos Platos con el mismo nombre
//        if (persistence.findByName(entity.getName()) != null) {
//            throw new BusinessLogicException("Ya existe un Plato con el nombre \"" + entity.getName() + "\"");
//        }
        // Invoca la persistencia para crear el Plato
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de Plato");
        return entity;
    }

    /**
     * 
     * Obtener todas los Platos existentes en la base de datos.
     *
     * @return una lista de Platos.
     */
    public List<PlatoEntity> getPlatos() {
        LOGGER.info("Inicia proceso de consultar todas las Platos");
        // Note que, por medio de la inyección de dependencias se llama al método "findAll()" que se encuentra en la persistencia.
        List<PlatoEntity> Platos = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todas las Platos");
        return Platos;
    }

    /**
     *
     * Obtener un Plato por medio de su id.
     * 
     * @param id: id del Plato para ser buscada.
     * @return el Plato solicitado por medio de su id.
     */
    public PlatoEntity gePlato(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar Plato con id={0}", id);
        // Note que, por medio de la inyección de dependencias se llama al método "find(id)" que se encuentra en la persistencia.
        PlatoEntity Plato = persistence.find(id);
        if ( Plato == null) {
            LOGGER.log(Level.SEVERE, "El Plato con el id {0} no existe", id);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar Plato con id={0}", id);
        return Plato ;
    }

    /**
     *
     * Actualizar una Plato.
     *
     * @param id: id del Plato para buscarla en la base de datos.
     * @param entity: clinete con los cambios para ser actualizada, por
     * ejemplo el nombre.
     * @return el Plato con los cambios actualizados en la base de datos.
     */
    public PlatoEntity updatePlato(Long id, PlatoEntity entity) {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar Plato con id={0}", id);
        // Note que, por medio de la inyección de dependencias se llama al método "update(entity)" que se encuentra en la persistencia.
        PlatoEntity newEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar Plato con id={0}", entity.getId());
        return newEntity;
    }

    /**
     * Borrar un Plato
     *
     * @param id: id de la Plato a borrar
     */
    public void deletePlato(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar Plato con id={0}", id);
        // Note que, por medio de la inyección de dependencias se llama al método "delete(id)" que se encuentra en la persistencia.
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Termina proceso de borrar Plato con id={0}", id);
    }
}
