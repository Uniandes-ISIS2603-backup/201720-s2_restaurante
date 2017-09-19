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

    @PersistenceContext(unitName = "restaurantePU")
    protected EntityManager em;
    /**
     *
     * @param entity objeto Plato que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public PlatoEntity create(PlatoEntity entity) {
        /* Note que hacemos uso de un método propio de EntityManager para persistir la Plato en la base de datos.
        Es similar a "INSERT INTO table_codigo (column1, column2, column3, ...) VALUES (value1, value2, value3, ...);" en SQL.
         */
        em.persist(entity);
        return entity;
    }
    /**
     * Actualiza un Plato.
     *
     * @param entity: la Plato que viene con los nuevos cambios. Por ejemplo
     * el codigo pudo cambiar. En ese caso, se haria uso del método update.
     * @return un Plato con los cambios aplicados.
     */
    public PlatoEntity update(PlatoEntity entity) {
        /* Note que hacemos uso de un método propio del EntityManager llamado merge() que recibe como argumento
        la Plato con los cambios, esto es similar a 
        "UPDATE table_codigo SET column1 = value1, column2 = value2, ... WHERE condition;" en SQL.
         */
        return em.merge(entity);
    }
    /**
     *
     * Borra un Plato de la base de datos recibiendo como argumento el id
     * de la Plato
     *
     * @param id: id correspondiente a la Plato a borrar.
     */
    public void delete(Long id) {
        // Se hace uso de mismo método que esta explicado en public PlatoEntity find(Long id) para obtener la Plato a borrar.
        PlatoEntity entity = em.find(PlatoEntity.class, id);
        /* Note que una vez obtenido el objeto desde la base de datos llamado "entity", volvemos hacer uso de un método propio del
         EntityManager para eliminar de la base de datos el objeto que encontramos y queremos borrar.
         Es similar a "delete from PlatoEntity where id=id;" - "DELETE FROM table_codigo WHERE condition;" en SQL.*/
        em.remove(entity);
    }

    /**
     * Busca si hay algun Plato con el id que se envía de argumento
     *
     * @param id: id correspondiente a la Plato buscada.
     * @return un Plato.
     */
    public PlatoEntity find(Long id) {
        /* Note que se hace uso del metodo "find" propio del EntityManager, el cual recibe como argumento 
        el tipo de la clase y el objeto que nos hara el filtro en la base de datos en este caso el "id"
        Suponga que es algo similar a "select * from PlatoEntity where id=id;" - "SELECT * FROM table_codigo WHERE condition;" en SQL.
         */
        return em.find(PlatoEntity.class, id);
    }

    /**
     * Devuelve todos los Platos de la base de datos.
     *
     * @return una lista con todos los Plato que encuentre en la base de
     * datos, "select u from PlatoEntity u" es como un "select * from
     * PlatoEntity;" - "SELECT * FROM table_codigo" en SQL.
     */
    public List<PlatoEntity> findAll() {
        // Se crea un query para buscar todas las Platos en la base de datos.
        TypedQuery query = em.createQuery("select u from PlatoEntity u", PlatoEntity.class);
        // Note que en el query se hace uso del método getResultList() que obtiene una lista de Platos.
        return query.getResultList();
    }
}
