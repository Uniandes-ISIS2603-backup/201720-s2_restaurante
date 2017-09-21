/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.baco.restaurante.ejb;

import co.edu.uniandes.baco.restaurante.entities.MesaEntity;
import co.edu.uniandes.baco.restaurante.entities.ReservaEntity;
import co.edu.uniandes.baco.restaurante.entities.SucursalEntity;
import co.edu.uniandes.baco.restaurante.exceptions.BusinessLogicException;
import co.edu.uniandes.baco.restaurante.persistence.MesaPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author jf.sanchezg
 */
@Stateless
public class MesaLogic {
    private static final Logger LOGGER = Logger.getLogger(MesaLogic.class.getName());

    @Inject
    private MesaPersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.

    /**
     *
     * @param entity
     * @return
     * @throws BusinessLogicException
     */
    public MesaEntity createMesa(MesaEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de Mesa");
        // Invoca la persistencia para crear la Mesa
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de Mesa");
        return entity;
    }

    /**
     * 
     * Obtener todas las Mesaes existentes en la base de datos.
     *
     * @return una lista de Mesaes.
     */
    public List<MesaEntity> getMesas() {
        LOGGER.info("Inicia proceso de consultar todas las Mesas");
        // Note que, por medio de la inyección de dependencias se llama al método "findAll()" que se encuentra en la persistencia.
        List<MesaEntity> Mesas = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todas las Mesaes");
        return Mesas;
    }
    /**
     * Actualiza la información de una instancia de Mesa.
     *
     * @param entity Instancia de MesaEntity con los nuevos datos.
     * @return Instancia de MesaEntity con los datos actualizados.
     * @generated
     */
    public MesaEntity updateMesa(MesaEntity entity) {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar una Mesa");
        return persistence.update(entity);
    }

    /**
     * Elimina una instancia de Mesa de la base de datos.
     *
     * @param id Identificador de la instancia a eliminar.
     * @generated
     */
    public void deleteMesa(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar un autor ");
        persistence.delete(id);
    }
    public MesaEntity getMesa(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar una Mesa con id = {0}", id);
        return persistence.find(id);
    }
    /**
     * Obtiene una instancia de SucursalEntity asociada a una instancia de Mesa
     *
     * @param MesaId Identificador de la instancia de Mesa
     * @param sucursalsId Identificador de la instancia de Sucursal
     * @return
     * @generated
     */
    public SucursalEntity getSucursal(Long MesaId, Long sucursalId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar un libro con id = {0}", sucursalId);
        SucursalEntity rta = getMesa(MesaId).getSucursal();
        if(rta.getId()==sucursalId)
            throw new BusinessLogicException("El identificador de la sucursal asociada a esta mesa no coinside con el solicitado.");
        return rta;
    }
    
    /**
     * Obtiene una instancia de ReservaEntity asociada a una instancia de Mesa
     *
     * @param MesaId Identificador de la instancia de Mesa
     * @param ReservasId Identificador de la instancia de Reserva
     * @return
     * @generated
     */
    public ReservaEntity getReserva(Long MesaId, Long ReservaId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar un libro con id = {0}", ReservaId);
        ReservaEntity rta = getMesa(MesaId).getReserva();
        if(rta.getId()==ReservaId)
            throw new BusinessLogicException("El identificador de la reserva asociada a esta mesa no coinside con el solicitado.");
        return rta;
    }
    
}
