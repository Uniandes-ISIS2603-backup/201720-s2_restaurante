package co.edu.uniandes.baco.restaurante.ejb;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import co.edu.uniandes.baco.restaurante.entities.PedidoEntity;
import co.edu.uniandes.baco.restaurante.exceptions.BusinessLogicException;
import co.edu.uniandes.baco.restaurante.persistence.PedidoPersistence;
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
public class PedidoLogic 
{
       private static final Logger LOGGER = Logger.getLogger(PedidoLogic.class.getName());

    @Inject
    private PedidoPersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.

    /**
     *
     * @param entity
     * @return
     * @throws BusinessLogicException
     */
    public PedidoEntity createpedido(PedidoEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de pedido");
        // Verifica la regla de negocio que dice que no puede haber dos clientes con el mismo nombre
//        if (persistence.findByName(entity.getName()) != null) {
//            throw new BusinessLogicException("Ya existe un Cliente con el nombre \"" + entity.getName() + "\"");
//        }
        // Invoca la persistencia para crear el pedido
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de pedido");
        return entity;
    }

    /**
     * 
     * Obtener todas los pedidos existentes en la base de datos.
     *
     * @return una lista de pedidos.
     */
    public List<PedidoEntity> getpedido() {
        LOGGER.info("Inicia proceso de consultar todas las pedido");
        // Note que, por medio de la inyección de dependencias se llama al método "findAll()" que se encuentra en la persistencia.
        List<PedidoEntity> pedidos = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todas las pedido");
        return pedidos;
    }

    /**
     *
     * Obtener un pedido por medio de su id.
     * 
     * @param id: id del pedido para ser buscada.
     * @return el pedido solicitado por medio de su id.
     */
    public PedidoEntity gepedido(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar pedido con id={0}", id);
        // Note que, por medio de la inyección de dependencias se llama al método "find(id)" que se encuentra en la persistencia.
        PedidoEntity pedido = persistence.find(id);
        if ( pedido == null) {
            LOGGER.log(Level.SEVERE, "El pedido con el id {0} no existe", id);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar pedido con id={0}", id);
        return pedido ;
    }

    /**
     *
     * Actualizar un pedido.
     *
     * @param id: id de la pedido para buscarla en la base de datos.
     * @param entity: pedido con los cambios para ser actualizada, por
     * ejemplo el nombre.
     * @return el pedido con los cambios actualizados en la base de datos.
     */
    public PedidoEntity updatepedido(Long id, PedidoEntity entity) {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar pedido con id={0}", id);
        // Note que, por medio de la inyección de dependencias se llama al método "update(entity)" que se encuentra en la persistencia.
        PedidoEntity newEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar pedido con id={0}", entity.getId());
        return newEntity;
    }

    /**
     * Borrar un pedido
     *
     * @param id: id del pedido a borrar
     */
    public void deletePedido(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar pedido con id={0}", id);
        // Note que, por medio de la inyección de dependencias se llama al método "delete(id)" que se encuentra en la persistencia.
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Termina proceso de borrar pedido con id={0}", id);
    }
}