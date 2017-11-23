/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.baco.restaurante.ejb;

import co.edu.uniandes.baco.restaurante.entities.BaseEntity;
import co.edu.uniandes.baco.restaurante.entities.ClienteEntity;
import co.edu.uniandes.baco.restaurante.exceptions.BusinessLogicException;
import co.edu.uniandes.baco.restaurante.persistence.ClientePersistence;
import javax.ejb.Stateless;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author s.heim
 */
@Stateless
public class ClienteLogic 
{
       private static final Logger LOGGER = Logger.getLogger(ClienteLogic.class.getName());

    @Inject
    private ClientePersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.

    /**
     *
     * @param entity
     * @return
     * @throws BusinessLogicException
     */
    public ClienteEntity createCliente(ClienteEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de cliente");
        // Verifica la regla de negocio que dice que no puede haber dos clientes con el mismo nombre
//        if (getCliente(entity.getId()) != null) {
//            throw new BusinessLogicException("Ya existe este Cliente \"" + entity.getId() + "\"");
//        }
        // Invoca la persistencia para crear el cliente
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de cliente");
        return entity;
    }

    /**
     * 
     * Obtener todas los clientes existentes en la base de datos.
     *
     * @return una lista de clientes.
     */
    public List<ClienteEntity> getClientes() {
        LOGGER.info("Inicia proceso de consultar todas las clientes");
        // Note que, por medio de la inyección de dependencias se llama al método "findAll()" que se encuentra en la persistencia.
        List<ClienteEntity> clientes = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todas las clientes");
        return clientes;
    }

    /**
     *
     * Obtener un cliente por medio de su id.
     * 
     * @param id: id del cliente para ser buscada.
     * @return el cliente solicitado por medio de su id.
     */
    public ClienteEntity getCliente(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar cliente con id={0}", id);
        // Note que, por medio de la inyección de dependencias se llama al método "find(id)" que se encuentra en la persistencia.
        ClienteEntity cliente = persistence.find(id);
//        if ( cliente == null) 
//        {
//            LOGGER.log(Level.SEVERE, "El cliente con el id {0} no existe", id);
//        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar cliente con id={0}", id);
        return cliente ;
    }

    /**
     *
     * Actualizar una cliente.
     *
     * @param id: id del cliente para buscarla en la base de datos.
     * @param entity: clinete con los cambios para ser actualizada, por
     * ejemplo el nombre.
     * @return el cliente con los cambios actualizados en la base de datos.
     */
    public ClienteEntity updateCliente(Long id, ClienteEntity entity) {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar cliente con id={0}", id);
        // Note que, por medio de la inyección de dependencias se llama al método "update(entity)" que se encuentra en la persistencia.
        ClienteEntity newEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar cliente con id={0}", entity.getId());
        return newEntity;
    }

    /**
     * Borrar un cliente
     *
     * @param id: id de la cliente a borrar
     */
    public void deleteCliente(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar cliente con id={0}", id);
        // Note que, por medio de la inyección de dependencias se llama al método "delete(id)" que se encuentra en la persistencia.
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Termina proceso de borrar cliente con id={0}", id);
    }
}