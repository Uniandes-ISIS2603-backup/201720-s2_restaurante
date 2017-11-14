/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.baco.restaurante.ejb;

import co.edu.uniandes.baco.restaurante.entities.ClienteEntity;
import co.edu.uniandes.baco.restaurante.entities.MesaEntity;
import co.edu.uniandes.baco.restaurante.entities.ReservaEntity;
import co.edu.uniandes.baco.restaurante.entities.RestauranteEntity;
import co.edu.uniandes.baco.restaurante.exceptions.BusinessLogicException;
import co.edu.uniandes.baco.restaurante.persistence.ReservaPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;

/**
 *
 * @author jf.sanchezg
 */
public class ReservaLogic {
    private static final Logger LOGGER = Logger.getLogger(ReservaLogic.class.getName());

    @Inject
    private ReservaPersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.

    /**
     *
     * @param entity
     * @return
     * @throws BusinessLogicException
     */
    public ReservaEntity createReserva(ReservaEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de Reserva");
        // Invoca la persistencia para crear la Reserva
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de Reserva");
        return entity;
    }

    /**
     * 
     * Obtener todas las Reservaes existentes en la base de datos.
     *
     * @return una lista de Reservaes.
     */
    public List<ReservaEntity> getReservas() {
        LOGGER.info("Inicia proceso de consultar todas las Reservas");
        // Note que, por medio de la inyección de dependencias se llama al método "findAll()" que se encuentra en la persistencia.
        List<ReservaEntity> Reservas = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todas las Reservaes");
        return Reservas;
    }
    /**
     * Actualiza la información de una instancia de Reserva.
     *
     * @param entity Instancia de ReservaEntity con los nuevos datos.
     * @return Instancia de ReservaEntity con los datos actualizados.
     * @generated
     */
    public ReservaEntity updateReserva(ReservaEntity entity) {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar una Reserva");
        ReservaEntity newEntity = persistence.update(entity);
        return newEntity;
    }

    /**
     * Elimina una instancia de Reserva de la base de datos.
     *
     * @param id Identificador de la instancia a eliminar.
     * @generated
     */
    public void deleteReserva(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar un autor ");
        persistence.delete(id);
    }
    public ReservaEntity getReserva(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar una Reserva con id = {0}", id);
        return persistence.find(id);
    }
    /**
     * Obtiene una instancia de RestauranteEntity asociada a una instancia de Reserva
     *
     * @param ReservaId Identificador de la instancia de Reserva
     * @param RestaurantesId Identificador de la instancia de Restaurante
     * @return
     * @generated
     */
    public RestauranteEntity getRestaurante(Long ReservaId, Long RestauranteId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar un libro con id = {0}", RestauranteId);
        RestauranteEntity rta = getReserva(ReservaId).getRestaurante();
        if(rta.getId()==RestauranteId)
            throw new BusinessLogicException("El identificador de la Restaurante asociada a esta Reserva no coinside con el solicitado.");
        return rta;
    }
    
    /**
     * Obtiene una instancia de ClienteEntity asociada a una instancia de Reserva
     *
     * @param ReservaId Identificador de la instancia de Reserva
     * @param ClientesId Identificador de la instancia de Cliente
     * @return
     * @generated
     */
    public ClienteEntity getCliente(Long ReservaId, Long ClienteId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar un libro con id = {0}", ClienteId);
        ClienteEntity rta = getReserva(ReservaId).getCliente();
        if(rta.getId()==ClienteId)
            throw new BusinessLogicException("El identificador de la Cliente asociada a esta Reserva no coinside con el solicitado.");
        return rta;
    }
    
    /**
     * Obtiene una instancia de MesaEntity asociada a una instancia de Reserva
     *
     * @param ReservaId Identificador de la instancia de Reserva
     * @param MesasId Identificador de la instancia de Mesa
     * @return
     * @generated
     */
    public MesaEntity getMesa(Long ReservaId, Long MesaId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar un libro con id = {0}", MesaId);
        MesaEntity rta = getReserva(ReservaId).getMesa();
        if(rta.getId()==MesaId)
            throw new BusinessLogicException("El identificador de la Mesa asociada a esta Reserva no coinside con el solicitado.");
        return rta;
    }
    
    
}
