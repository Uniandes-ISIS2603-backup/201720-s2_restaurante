/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.baco.restaurante.persistence;

import co.edu.uniandes.baco.restaurante.entities.PlatoEntity;
import co.edu.uniandes.baco.restaurante.entities.PlatoEntity;
import co.edu.uniandes.baco.restaurante.entities.SucursalEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author df.penap
 */
@Stateless
public class PlatoPersistence {

      private static final Logger LOGGER = Logger.getLogger(ClientePersistence.class.getName());

    @PersistenceContext(unitName = "restaurantePU")
    protected EntityManager em;

    /**
     *
     * @param entity objeto Cliente que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public PlatoEntity create(PlatoEntity entity) {
        LOGGER.info("Creando un plato nuevo");
        /* Note que hacemos uso de un método propio de EntityManager para persistir el Cliente en la base de datos.
        Es similar a "INSERT INTO table_codigo (column1, column2, column3, ...) VALUES (value1, value2, value3, ...);" en SQL.
         */
        em.persist(entity);
        LOGGER.info("Creando un cliente nuevo");
        return entity;
    }

    /**
     * Actualiza un cliente.
     *
     * @param entity: el cliente que viene con los nuevos cambios. Por ejemplo
     * el codigo pudo cambiar. En ese caso, se haria uso del método update.
     * @return un cliente con los cambios aplicados.
     */
    public PlatoEntity update(PlatoEntity entity) {
        LOGGER.log(Level.INFO, "Actualizando Plato con id={0}", entity.getId());
        /* Note que hacemos uso de un método propio del EntityManager llamado merge() que recibe como argumento
        el cliente con los cambios, esto es similar a 
        "UPDATE table_codigo SET column1 = value1, column2 = value2, ... WHERE condition;" en SQL.
         */
        return em.merge(entity);
    }

    /**
     *
     * Borra un cliente de la base de datos recibiendo como argumento el id
     * del cliente
     *
     * @param id: id correspondiente al cliente a borrar.
     */
    public void delete(Long id) {
        LOGGER.log(Level.INFO, "Borrando plato con id={0}", id);
        // Se hace uso de mismo método que esta explicado en public ClienteEntity find(Long id) para obtener el cliente a borrar.
        PlatoEntity entity = em.find(PlatoEntity.class, id);
        /* Note que una vez obtenido el objeto desde la base de datos llamado "entity", volvemos hacer uso de un método propio del
         EntityManager para eliminar de la base de datos el objeto que encontramos y queremos borrar.
         Es similar a "delete from ClienteEntity where id=id;" - "DELETE FROM table_codigo WHERE condition;" en SQL.*/
        em.remove(entity);
    }

    /**
     * Busca si hay algun cliente con el id que se envía de argumento
     *
     * @param id: id correspondiente al cliente buscado.
     * @return un cliente.
     */
    public PlatoEntity find(Long id) {
        LOGGER.log(Level.INFO, "Consultando Cliente con id={0}", id);
        /* Note que se hace uso del metodo "find" propio del EntityManager, el cual recibe como argumento 
        el tipo de la clase y el objeto que nos hara el filtro en la base de datos en este caso el "id"
        Suponga que es algo similar a "select * from Cliente where id=id;" - "SELECT * FROM table_codigo WHERE condition;" en SQL.
         */
        return em.find(PlatoEntity.class, id);
    }

    /**
     * Devuelve todos los clientes de la base de datos.
     *
     * @return una lista con todas los clientes que encuentre en la base de
     * datos, "select u from ClienteEntity u" es como un "select * from
     * ClienteEntity;" - "SELECT * FROM table_codigo" en SQL.
     */
    public List<PlatoEntity> findAll() {
        LOGGER.info("Consultando todos los platos");
        // Se crea un query para buscar todos los platos en la base de datos.
        TypedQuery query = em.createQuery("select u from PlatoEntity u", PlatoEntity.class);
        // Note que en el query se hace uso del método getResultList() que obtiene una lista de platos.
        return query.getResultList();
    }
}