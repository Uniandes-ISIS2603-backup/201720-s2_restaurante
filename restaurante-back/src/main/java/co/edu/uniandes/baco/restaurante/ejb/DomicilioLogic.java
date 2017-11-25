/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.baco.restaurante.ejb;
import co.edu.uniandes.baco.restaurante.entities.DomicilioEntity;
import co.edu.uniandes.baco.restaurante.exceptions.BusinessLogicException;
import co.edu.uniandes.baco.restaurante.persistence.DomicilioPersistence;
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
public class DomicilioLogic {

    private static final Logger LOGGER = Logger.getLogger(DomicilioLogic.class.getName());

    @Inject private DomicilioPersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.

    /**
     *
     * @param entity
     * @return
     * @throws BusinessLogicException
     */
    public DomicilioEntity createDomicilio(DomicilioEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de domicilio");
        // Verifica la regla de negocio que dice que no puede haber dos domicilios con el mismo nombre
        if (persistence.find(entity.getId()) != null) {
            throw new BusinessLogicException("Ya existe una Domicilio con el id \"" + entity.getId() + "\"");
        }
        // Invoca la persistencia para crear la domicilio
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de domicilio");
        return entity;
    }

    /**
     * 
     * Obtener todas las domicilios existentes en la base de datos.
     *
     * @return una lista de domicilios.
     */
    public List<DomicilioEntity> getDomicilios() {
        LOGGER.info("Inicia proceso de consultar todas las domicilios");
        // Note que, por medio de la inyección de dependencias se llama al método "findAll()" que se encuentra en la persistencia.
        List<DomicilioEntity> domicilios = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todas las domicilios");
        return domicilios;
    }


    public DomicilioEntity getDomicilio(Long id) {
        DomicilioEntity domicilio = persistence.find(id);
        if (domicilio == null) {
            LOGGER.log(Level.SEVERE, "La domicilio con el id {0} no existe", id);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar domicilio con id={0}", id);
        return domicilio;
    }

    /**
     *
     * Actualizar una domicilio.
     *
     * @param id: id de la domicilio para buscarla en la base de datos.
     * @param entity: domicilio con los cambios para ser actualizada, por
     * ejemplo el nombre.
     * @return la domicilio con los cambios actualizados en la base de datos.
     */
    public DomicilioEntity updateDomicilio(Long id, DomicilioEntity entity) {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar domicilio con id={0}", id);
        // Note que, por medio de la inyección de dependencias se llama al método "update(entity)" que se encuentra en la persistencia.
        DomicilioEntity newEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar domicilio con id={0}", entity.getId());
        return newEntity;
    }

    /**
     * Borrar un domicilio
     *
     * @param id: id de la domicilio a borrar
     */
    public void deleteDomicilio(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar domicilio con id={0}", id);
        // Note que, por medio de la inyección de dependencias se llama al método "delete(id)" que se encuentra en la persistencia.
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Termina proceso de borrar domicilio con id={0}", id);
    }

}

