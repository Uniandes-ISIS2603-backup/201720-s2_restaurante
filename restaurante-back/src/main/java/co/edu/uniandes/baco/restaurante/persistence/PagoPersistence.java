/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.baco.restaurante.persistence;

import co.edu.uniandes.baco.restaurante.entities.PagoEntity;
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
public class PagoPersistence {

    private static final Logger LOGGER = Logger.getLogger(PagoPersistence.class.getName());

    @PersistenceContext(unitName = "restaurantePU")
    protected EntityManager em;

    /**
     *
     * @param entity objeto Pago que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public PagoEntity create(PagoEntity entity) {
        LOGGER.info("Creando un Pago nuevo");
        /* Note que hacemos uso de un método propio de EntityManager para persistir el Pago en la base de datos.
        Es similar a "INSERT INTO table_codigo (column1, column2, column3, ...) VALUES (value1, value2, value3, ...);" en SQL.
         */
        em.persist(entity);
        LOGGER.info("Creando un Pago nuevo");
        return entity;
    }

    /**
     * Actualiza un Pago.
     *
     * @param entity: el Pago que viene con los nuevos cambios. Por ejemplo
     * el codigo pudo cambiar. En ese caso, se haria uso del método update.
     * @return un Pago con los cambios aplicados.
     */
    public PagoEntity update(PagoEntity entity) {
        LOGGER.log(Level.INFO, "Actualizando Pago con id={0}", entity.getId());
        /* Note que hacemos uso de un método propio del EntityManager llamado merge() que recibe como argumento
        el Pago con los cambios, esto es similar a 
        "UPDATE table_codigo SET column1 = value1, column2 = value2, ... WHERE condition;" en SQL.
         */
        return em.merge(entity);
    }

    /**
     *
     * Borra un Pago de la base de datos recibiendo como argumento el id
     * del Pago
     *
     * @param id: id correspondiente al Pago a borrar.
     */
    public void delete(Long id) {
        LOGGER.log(Level.INFO, "Borrando Pago con id={0}", id);
        // Se hace uso de mismo método que esta explicado en public PagoEntity find(Long id) para obtener el Pago a borrar.
        PagoEntity entity = em.find(PagoEntity.class, id);
        /* Note que una vez obtenido el objeto desde la base de datos llamado "entity", volvemos hacer uso de un método propio del
         EntityManager para eliminar de la base de datos el objeto que encontramos y queremos borrar.
         Es similar a "delete from PagoEntity where id=id;" - "DELETE FROM table_codigo WHERE condition;" en SQL.*/
        em.remove(entity);
    }

    /**
     * Busca si hay algun Pago con el id que se envía de argumento
     *
     * @param id: id correspondiente al Pago buscado.
     * @return un Pago.
     */
    public PagoEntity find(Long id) {
        LOGGER.log(Level.INFO, "Consultando Pago con id={0}", id);
        /* Note que se hace uso del metodo "find" propio del EntityManager, el cual recibe como argumento 
        el tipo de la clase y el objeto que nos hara el filtro en la base de datos en este caso el "id"
        Suponga que es algo similar a "select * from PagoEntity where id=id;" - "SELECT * FROM table_codigo WHERE condition;" en SQL.
         */
        return em.find(PagoEntity.class, id);
    }

    /**
     * Devuelve todos los Pagos de la base de datos.
     *
     * @return una lista con todas los Pagos que encuentre en la base de
     * datos, "select u from PagoEntity u" es como un "select * from
     * PagoEntity;" - "SELECT * FROM table_codigo" en SQL.
     */
    public List<PagoEntity> findAll() {
        LOGGER.info("Consultando todos los Pagos");
        // Se crea un query para buscar todos los Pagos en la base de datos.
        TypedQuery query = em.createQuery("select u from PagoEntity u", PagoEntity.class);
        // Note que en el query se hace uso del método getResultList() que obtiene una lista de Pagos.
        return query.getResultList();
    }    
}
