/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.baco.restaurante.persistence;

import co.edu.uniandes.baco.restaurante.entities.ReservaEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author jf.sanchezg
 */
@Stateless
public class ReservaPersistence {
    private static final Logger LOGGER = Logger.getLogger(ReservaPersistence.class.getName());

    @PersistenceContext(unitName = "reservaPU")
    protected EntityManager em;

    /**
     *
     * @param entity objeto Reserva que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public ReservaEntity create(ReservaEntity entity) {
        LOGGER.info("Creando una Reserva nueva");
        /* Note que hacemos uso de un método propio de EntityManager para persistir la Reserva en la base de datos.
        Es similar a "INSERT INTO table_codigo (column1, column2, column3, ...) VALUES (value1, value2, value3, ...);" en SQL.
         */
        em.persist(entity);
        LOGGER.info("Creando un Reserva nueva");
        return entity;
    }

    /**
     * Actualiza una Reserva.
     *
     * @param entity: la Reserva que viene con los nuevos cambios. Por ejemplo
     * el codigo pudo cambiar. En ese caso, se haria uso del método update.
     * @return una Reserva con los cambios aplicados.
     */
    public ReservaEntity update(ReservaEntity entity) {
        LOGGER.log(Level.INFO, "Actualizando Reserva con id={0}", entity.getId());
        /* Note que hacemos uso de un método propio del EntityManager llamado merge() que recibe como argumento
        la Reserva con los cambios, esto es similar a 
        "UPDATE table_codigo SET column1 = value1, column2 = value2, ... WHERE condition;" en SQL.
         */
        return em.merge(entity);
    }

    /**
     *
     * Borra una Reserva de la base de datos recibiendo como argumento el id
     * de la Reserva
     *
     * @param id: id correspondiente a la Reserva a borrar.
     */
    public void delete(Long id) {
        LOGGER.log(Level.INFO, "Borrando Reserva con id={0}", id);
        // Se hace uso de mismo método que esta explicado en public ReservaEntity find(Long id) para obtener la Reserva a borrar.
        ReservaEntity entity = em.find(ReservaEntity.class, id);
        /* Note que una vez obtenido el objeto desde la base de datos llamado "entity", volvemos hacer uso de un método propio del
         EntityManager para eliminar de la base de datos el objeto que encontramos y queremos borrar.
         Es similar a "delete from ReservaEntity where id=id;" - "DELETE FROM table_codigo WHERE condition;" en SQL.*/
        em.remove(entity);
    }

    /**
     * Busca si hay a Reserva con el id que se envía de argumento
     *
     * @param id: id correspondiente a la Reserva buscada.
     * @return una Reserva.
     */
    public ReservaEntity find(Long id) {
        LOGGER.log(Level.INFO, "Consultando Reserva con id={0}", id);
        /* Note que se hace uso del metodo "find" propio del EntityManager, el cual recibe como argumento 
        el tipo de la clase y el objeto que nos hara el filtro en la base de datos en este caso el "id"
        Suponga que es algo similar a "select * from ReservaEntity where id=id;" - "SELECT * FROM table_codigo WHERE condition;" en SQL.
         */
        return em.find(ReservaEntity.class, id);
    }

    /**
     * Devuelve todas las Reservas de la base de datos.
     *
     * @return una lista con todas las Reservas que encuentre en la base de
     * datos, "select u from ReservaEntity u" es como un "select * from
     * ReservaEntity;" - "SELECT * FROM table_codigo" en SQL.
     */
    public List<ReservaEntity> findAll() {
        LOGGER.info("Consultando todas las Reservas");
        // Se crea un query para buscar todas las Reservas en la base de datos.
        TypedQuery query = em.createQuery("select u from ReservaEntity u", ReservaEntity.class);
        // Note que en el query se hace uso del método getResultList() que obtiene una lista de Reservas.
        return query.getResultList();
    }
}
