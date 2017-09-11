/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.baco.restaurante.persistence;

import co.edu.uniandes.baco.restaurante.entities.TarjetaPuntosEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author af.bejarano
 */
@Stateless
public class TarjetaPuntosPersistence {
     @PersistenceContext(unitName = "restaurantePU")
    protected EntityManager em;
    /**
     *
     * @param entity objeto TarjetaPuntos que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public TarjetaPuntosEntity create(TarjetaPuntosEntity entity) {
        /* Note que hacemos uso de un método propio de EntityManager para persistir la TarjetaPuntos en la base de datos.
        Es similar a "INSERT INTO table_codigo (column1, column2, column3, ...) VALUES (value1, value2, value3, ...);" en SQL.
         */
        em.persist(entity);
        return entity;
    }
    /**
     * Actualiza un Domicilio.
     *
     * @param entity: la TarjetaPuntos que viene con los nuevos cambios. Por ejemplo
     * el codigo pudo cambiar. En ese caso, se haria uso del método update.
     * @return un TarjetaPuntos con los cambios aplicados.
     */
    public TarjetaPuntosEntity update(TarjetaPuntosEntity entity) {
        /* Note que hacemos uso de un método propio del EntityManager llamado merge() que recibe como argumento
        la TarjetaPuntos con los cambios, esto es similar a 
        "UPDATE table_codigo SET column1 = value1, column2 = value2, ... WHERE condition;" en SQL.
         */
        return em.merge(entity);
    }
    /**
     *
     * Borra un TarjetaPuntos de la base de datos recibiendo como argumento el id
     * de la TarjetaPuntos
     *
     * @param id: id correspondiente a la TarjetaPuntos a borrar.
     */
    public void delete(Long id) {
        // Se hace uso de mismo método que esta explicado en public TarjetaPuntos find(Long id) para obtener la TarjetaPuntos a borrar.
        TarjetaPuntosEntity entity = em.find(TarjetaPuntosEntity.class, id);
        /* Note que una vez obtenido el objeto desde la base de datos llamado "entity", volvemos hacer uso de un método propio del
         EntityManager para eliminar de la base de datos el objeto que encontramos y queremos borrar.
         Es similar a "delete from TarjetaPuntosEntity where id=id;" - "DELETE FROM table_codigo WHERE condition;" en SQL.*/
        em.remove(entity);
    }

    /**
     * Busca si hay algun TarjetaPuntos con el id que se envía de argumento
     *
     * @param id: id correspondiente a la Domicilio buscada.
     * @return un TarjetaPuntos.
     */
    public TarjetaPuntosEntity find(Long id) {
        /* Note que se hace uso del metodo "find" propio del EntityManager, el cual recibe como argumento 
        el tipo de la clase y el objeto que nos hara el filtro en la base de datos en este caso el "id"
        Suponga que es algo similar a "select * from TarjetaPuntosEntity where id=id;" - "SELECT * FROM table_codigo WHERE condition;" en SQL.
         */
        return em.find(TarjetaPuntosEntity.class, id);
    }

    /**
     * Devuelve todos los TarjetaPuntos de la base de datos.
     *
     * @return una lista con todos los TarjetaPuntos que encuentre en la base de
     * datos, "select u from TarjetaPuntosEntity u" es como un "select * from
     * TarjetaPuntosEntity;" - "SELECT * FROM table_codigo" en SQL.
     */
    public List<TarjetaPuntosEntity> findAll() {
        // Se crea un query para buscar todas las TarjetaPuntos en la base de datos.
        TypedQuery query = em.createQuery("select u from TarjetaPuntosEntity u", TarjetaPuntosEntity.class);
        // Note que en el query se hace uso del método getResultList() que obtiene una lista de TarjetaPuntos.
        return query.getResultList();
    }
}
