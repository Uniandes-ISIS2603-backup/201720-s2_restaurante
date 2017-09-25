/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.baco.restaurante.ejb;
import co.edu.uniandes.baco.restaurante.entities.TarjetaPuntosEntity;
import co.edu.uniandes.baco.restaurante.exceptions.BusinessLogicException;
import co.edu.uniandes.baco.restaurante.persistence.TarjetaPuntosPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author af.bejarano
 */
@Stateless
public class TarjetaPuntosLogic {

    private static final Logger LOGGER = Logger.getLogger(TarjetaPuntosLogic.class.getName());

    @Inject
    private TarjetaPuntosPersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.

    /**
     *
     * @param entity
     * @return
     * @throws BusinessLogicException
     */
    public TarjetaPuntosEntity createTarjetaPuntos(TarjetaPuntosEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de tarjetaPuntos");
        // Verifica la regla de negocio que dice que no puede haber dos tarjetaPuntoss con el mismo nombre
        if (persistence.find(entity.getId()) != null) {
            throw new BusinessLogicException("Ya existe una TarjetaPuntos con el ID \"" + entity.getId() + "\"");
        }
        // Invoca la persistencia para crear la tarjetaPuntos
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de tarjetaPuntos");
        return entity;
    }

    /**
     * 
     * Obtener todas las tarjetaPuntoss existentes en la base de datos.
     *
     * @return una lista de tarjetaPuntoss.
     */
    public List<TarjetaPuntosEntity> getTarjetaPuntoss() {
        LOGGER.info("Inicia proceso de consultar todas las tarjetaPuntoss");
        // Note que, por medio de la inyección de dependencias se llama al método "findAll()" que se encuentra en la persistencia.
        List<TarjetaPuntosEntity> tarjetaPuntoss = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todas las tarjetaPuntoss");
        return tarjetaPuntoss;
    }


    public TarjetaPuntosEntity getTarjetaPuntos(Long id) {
        TarjetaPuntosEntity tarjetaPuntos = persistence.find(id);
        if (tarjetaPuntos == null) {
            LOGGER.log(Level.SEVERE, "La tarjetaPuntos con el id {0} no existe", id);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar tarjetaPuntos con id={0}", id);
        return tarjetaPuntos;
    }

    /**
     *
     * Actualizar una tarjetaPuntos.
     *
     * @param id: id de la tarjetaPuntos para buscarla en la base de datos.
     * @param entity: tarjetaPuntos con los cambios para ser actualizada, por
     * ejemplo el nombre.
     * @return la tarjetaPuntos con los cambios actualizados en la base de datos.
     */
    public TarjetaPuntosEntity updateTarjetaPuntos(Long id, TarjetaPuntosEntity entity) {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar tarjetaPuntos con id={0}", id);
        // Note que, por medio de la inyección de dependencias se llama al método "update(entity)" que se encuentra en la persistencia.
        TarjetaPuntosEntity newEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar tarjetaPuntos con id={0}", entity.getId());
        return newEntity;
    }

    /**
     * Borrar un tarjetaPuntos
     *
     * @param id: id de la tarjetaPuntos a borrar
     */
    public void deleteTarjetaPuntos(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar tarjetaPuntos con id={0}", id);
        // Note que, por medio de la inyección de dependencias se llama al método "delete(id)" que se encuentra en la persistencia.
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Termina proceso de borrar tarjetaPuntos con id={0}", id);
    }

}

