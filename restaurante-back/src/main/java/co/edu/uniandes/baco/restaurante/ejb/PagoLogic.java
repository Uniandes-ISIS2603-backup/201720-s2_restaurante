/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.baco.restaurante.ejb;

import co.edu.uniandes.baco.restaurante.entities.PagoEntity;
import co.edu.uniandes.baco.restaurante.exceptions.BusinessLogicException;
import co.edu.uniandes.baco.restaurante.persistence.PagoPersistence;
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
public class PagoLogic {
    
private static final Logger LOGGER = Logger.getLogger(PagoLogic.class.getName());

    @Inject private PagoPersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.

    /**
     *
     * @param entity
     * @return
     * @throws BusinessLogicException
     */
    public PagoEntity createPago(PagoEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de Pago");
        // Invoca la persistencia para crear el Pago
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de Pago");
        return entity;
    }

    /**
     * 
     * Obtener todas los Pagos existentes en la base de datos.
     *
     * @return una lista de Pagos.
     */
    public List<PagoEntity> getPagos() {
        LOGGER.info("Inicia proceso de consultar todas las Pagos");
        // Note que, por medio de la inyección de dependencias se llama al método "findAll()" que se encuentra en la persistencia.
        List<PagoEntity> pagos = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todas las Pagos");
        return pagos;
    }

    /**
     *
     * Obtener un Pago por medio de su id.
     * 
     * @param id: id del Pago para ser buscada.
     * @return el Pago solicitado por medio de su id.
     */
    public PagoEntity gePago(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar Pago con id={0}", id);
        // Note que, por medio de la inyección de dependencias se llama al método "find(id)" que se encuentra en la persistencia.
        PagoEntity pago = persistence.find(id);
        if ( pago == null) {
            LOGGER.log(Level.SEVERE, "El Pago con el id {0} no existe", id);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar Pago con id={0}", id);
        return pago ;
    }

    /**
     *
     * Actualizar una Pago.
     *
     * @param id: id del Pago para buscarla en la base de datos.
     * @param entity: clinete con los cambios para ser actualizada, por
     * ejemplo el nombre.
     * @return el Pago con los cambios actualizados en la base de datos.
     */
    public PagoEntity updatePago(Long id, PagoEntity entity) {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar Pago con id={0}", id);
        // Note que, por medio de la inyección de dependencias se llama al método "update(entity)" que se encuentra en la persistencia.
        PagoEntity newEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar Pago con id={0}", entity.getId());
        return newEntity;
    }

    /**
     * Borrar un Pago
     *
     * @param id: id de la Pago a borrar
     */
    public void deletePago(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar Pago con id={0}", id);
        // Note que, por medio de la inyección de dependencias se llama al método "delete(id)" que se encuentra en la persistencia.
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Termina proceso de borrar Pago con id={0}", id);
    }
}
