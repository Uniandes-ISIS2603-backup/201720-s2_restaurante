/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.baco.restaurante.ejb;

import co.edu.uniandes.baco.restaurante.entities.ClienteEntity;
import co.edu.uniandes.baco.restaurante.exceptions.BusinessLogicException;
import co.edu.uniandes.baco.restaurante.persistence.ClientePersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author s.heim
 */
@Stateless
public class ClienteLogic {

    @Inject private ClientePersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.

    /**
     *
     * @param entity
     * @return
     * @throws BusinessLogicException
     */
    public ClienteEntity createCliente(ClienteEntity entity) throws BusinessLogicException {
        // Invoca la persistencia para crear el cliente
        persistence.create(entity);
        return entity;
    }

    /**
     *
     * Obtener todas los clientes existentes en la base de datos.
     *
     * @return una lista de clientes.
     */
    public List<ClienteEntity> getClientes() {
        // Note que, por medio de la inyección de dependencias se llama al método "findAll()" que se encuentra en la persistencia.
        List<ClienteEntity> clientes = persistence.findAll();
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
        // Note que, por medio de la inyección de dependencias se llama al método "find(id)" que se encuentra en la persistencia.
        ClienteEntity cliente = persistence.find(id);
        return cliente;
    }

    /**
     *
     * Actualizar una cliente.
     *
     * @param id: id del cliente para buscarla en la base de datos.
     * @param entity: clinete con los cambios para ser actualizada, por ejemplo
     * el nombre.
     * @return el cliente con los cambios actualizados en la base de datos.
     */
    public ClienteEntity updateCliente(Long id, ClienteEntity entity) {
        // Note que, por medio de la inyección de dependencias se llama al método "update(entity)" que se encuentra en la persistencia.
        ClienteEntity newEntity = persistence.update(entity);
        return newEntity;
    }

    /**
     * Borrar un cliente
     *
     * @param id: id de la cliente a borrar
     */
    public void deleteCliente(Long id) {
        persistence.delete(id);
    }
}
