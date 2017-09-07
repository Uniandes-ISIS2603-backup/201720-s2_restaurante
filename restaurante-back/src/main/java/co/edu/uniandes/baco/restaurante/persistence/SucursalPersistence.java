/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.baco.restaurante.persistence;

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
 * @author jd.correa
 */
@Stateless
public class SucursalPersistence {
    private static final Logger LOGGER = Logger.getLogger(SucursalPersistence.class.getName());

    @PersistenceContext(unitName = "sucursalPU")
    protected EntityManager em;

    /**
     *
     * @param entity objeto Sucursal que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public SucursalEntity create(SucursalEntity entity) {
        LOGGER.info("Creando una sucursal nueva");
        /* Note que hacemos uso de un método propio de EntityManager para persistir la Sucursal en la base de datos.
        Es similar a "INSERT INTO table_codigo (column1, column2, column3, ...) VALUES (value1, value2, value3, ...);" en SQL.
         */
        em.persist(entity);
        LOGGER.info("Creando una sucursal nueva");
        return entity;
    }

    /**
     * Actualiza un restaurante.
     *
     * @param entity: la Sucursal que viene con los nuevos cambios. Por ejemplo
     * el codigo pudo cambiar. En ese caso, se haria uso del método update.
     * @return un Sucursal con los cambios aplicados.
     */
    public SucursalEntity update(SucursalEntity entity) {
        LOGGER.log(Level.INFO, "Actualizando Sucursal con id={0}", entity.getId());
        /* Note que hacemos uso de un método propio del EntityManager llamado merge() que recibe como argumento
        la Sucursal con los cambios, esto es similar a 
        "UPDATE table_codigo SET column1 = value1, column2 = value2, ... WHERE condition;" en SQL.
         */
        return em.merge(entity);
    }

    /**
     *
     * Borra un restaurante de la base de datos recibiendo como argumento el id
     * de la Sucursal
     *
     * @param id: id correspondiente a la Sucursal a borrar.
     */
    public void delete(Long id) {
        LOGGER.log(Level.INFO, "Borrando Sucursal con id={0}", id);
        // Se hace uso de mismo método que esta explicado en public SucursalEntity find(Long id) para obtener la Sucursal a borrar.
        SucursalEntity entity = em.find(SucursalEntity.class, id);
        /* Note que una vez obtenido el objeto desde la base de datos llamado "entity", volvemos hacer uso de un método propio del
         EntityManager para eliminar de la base de datos el objeto que encontramos y queremos borrar.
         Es similar a "delete from SucursalEntity where id=id;" - "DELETE FROM table_codigo WHERE condition;" en SQL.*/
        em.remove(entity);
    }

    /**
     * Busca si hay algun Sucursal con el id que se envía de argumento
     *
     * @param id: id correspondiente a la Sucursal buscada.
     * @return un Sucursal.
     */
    public SucursalEntity find(Long id) {
        LOGGER.log(Level.INFO, "Consultando Sucursal con id={0}", id);
        /* Note que se hace uso del metodo "find" propio del EntityManager, el cual recibe como argumento 
        el tipo de la clase y el objeto que nos hara el filtro en la base de datos en este caso el "id"
        Suponga que es algo similar a "select * from RestauranteEntity where id=id;" - "SELECT * FROM table_codigo WHERE condition;" en SQL.
         */
        return em.find(SucursalEntity.class, id);
    }

    /**
     * Devuelve todas las Sucursales de la base de datos.
     *
     * @return una lista con todas las Sucursales que encuentre en la base de
     * datos, "select u from SucursalEntity u" es como un "select * from
     * SucursalEntity;" - "SELECT * FROM table_codigo" en SQL.
     */
    public List<SucursalEntity> findAll() {
        LOGGER.info("Consultando todas las Sucursales");
        // Se crea un query para buscar todas las Sucursales en la base de datos.
        TypedQuery query = em.createQuery("select u from SucursalEntity u", SucursalEntity.class);
        // Note que en el query se hace uso del método getResultList() que obtiene una lista de Sucursales.
        return query.getResultList();
    }
}
