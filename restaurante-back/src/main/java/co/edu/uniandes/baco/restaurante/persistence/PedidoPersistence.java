/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.baco.restaurante.persistence;

import co.edu.uniandes.baco.restaurante.entities.PedidoEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author s.heim
 */
public class PedidoPersistence 
{
  private static final Logger LOGGER = Logger.getLogger(PedidoPersistence.class.getName());

    @PersistenceContext(unitName = "pedidoPU")
    protected EntityManager em;

    /**
     *
     * @param entity objeto Pedido que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public PedidoEntity create(PedidoEntity entity) {
        LOGGER.info("Creando un pedido nuevo");
        /* Note que hacemos uso de un método propio de EntityManager para persistir el pedido en la base de datos.
        Es similar a "INSERT INTO table_codigo (column1, column2, column3, ...) VALUES (value1, value2, value3, ...);" en SQL.
         */
        em.persist(entity);
        LOGGER.info("Creando un pedido nuevo");
        return entity;
    }

    /**
     * Actualiza un pedido.
     *
     * @param entity: el pedido que viene con los nuevos cambios. Por ejemplo
     * el codigo pudo cambiar. En ese caso, se haria uso del método update.
     * @return un pedido con los cambios aplicados.
     */
    public PedidoEntity update(PedidoEntity entity) {
        LOGGER.log(Level.INFO, "Actualizando Pedido con id={0}", entity.getId());
        /* Note que hacemos uso de un método propio del EntityManager llamado merge() que recibe como argumento
        el pedido con los cambios, esto es similar a 
        "UPDATE table_codigo SET column1 = value1, column2 = value2, ... WHERE condition;" en SQL.
         */
        return em.merge(entity);
    }

    /**
     *
     * Borra un pedido de la base de datos recibiendo como argumento el id
     * del pedido
     *
     * @param id: id correspondiente al pedido a borrar.
     */
    public void delete(Long id) {
        LOGGER.log(Level.INFO, "Borrando Pedido con id={0}", id);
        // Se hace uso de mismo método que esta explicado en public PedidoEntity find(Long id) para obtener el pedido a borrar.
        PedidoEntity entity = em.find(PedidoEntity.class, id);
        /* Note que una vez obtenido el objeto desde la base de datos llamado "entity", volvemos hacer uso de un método propio del
         EntityManager para eliminar de la base de datos el objeto que encontramos y queremos borrar.
         Es similar a "delete from PedidoEntity where id=id;" - "DELETE FROM table_codigo WHERE condition;" en SQL.*/
        em.remove(entity);
    }

    /**
     * Busca si hay algun pedido con el id que se envía de argumento
     *
     * @param id: id correspondiente al pedido buscado.
     * @return un pedido.
     */
    public PedidoEntity find(Long id) {
        LOGGER.log(Level.INFO, "Consultando Pedido con id={0}", id);
        /* Note que se hace uso del metodo "find" propio del EntityManager, el cual recibe como argumento 
        el tipo de la clase y el objeto que nos hara el filtro en la base de datos en este caso el "id"
        Suponga que es algo similar a "select * from PedidoEntity where id=id;" - "SELECT * FROM table_codigo WHERE condition;" en SQL.
         */
        return em.find(PedidoEntity.class, id);
    }

    /**
     * Devuelve todos los pedidos de la base de datos.
     *
     * @return una lista con todas los pedidos que encuentre en la base de
     * datos, "select u from PedidoEntity u" es como un "select * from
     * PedidoEntity;" - "SELECT * FROM table_codigo" en SQL.
     */
    public List<PedidoEntity> findAll() {
        LOGGER.info("Consultando todos los pedidos");
        // Se crea un query para buscar todos los pedidos en la base de datos.
        TypedQuery query = em.createQuery("select u from PedidoEntity u", PedidoEntity.class);
        // Note que en el query se hace uso del método getResultList() que obtiene una lista de pedidos.
        return query.getResultList();
    }    
}
