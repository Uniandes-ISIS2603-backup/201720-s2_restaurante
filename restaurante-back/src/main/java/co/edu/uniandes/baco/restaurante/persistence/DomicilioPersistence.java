/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.baco.restaurante.persistence;

import co.edu.uniandes.baco.restaurante.entities.DomicilioEntity;
import co.edu.uniandes.baco.restaurante.entities.RestauranteEntity;
import java.util.List;
import java.util.logging.Level;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author af.bejarano
 */
@Stateless
public class DomicilioPersistence {
    
    @PersistenceContext(unitName = "restaurantePU")
    protected EntityManager em;
    /**
     *
     * @param entity objeto Domicilio que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public DomicilioEntity create(DomicilioEntity entity) {
        /* Note que hacemos uso de un método propio de EntityManager para persistir la Domicilio en la base de datos.
        Es similar a "INSERT INTO table_codigo (column1, column2, column3, ...) VALUES (value1, value2, value3, ...);" en SQL.
         */
        em.persist(entity);
        return entity;
    }
    /**
     * Actualiza un Domicilio.
     *
     * @param entity: la Domicilio que viene con los nuevos cambios. Por ejemplo
     * el codigo pudo cambiar. En ese caso, se haria uso del método update.
     * @return un Domicilio con los cambios aplicados.
     */
    public DomicilioEntity update(DomicilioEntity entity) {
        /* Note que hacemos uso de un método propio del EntityManager llamado merge() que recibe como argumento
        la Domicilio con los cambios, esto es similar a 
        "UPDATE table_codigo SET column1 = value1, column2 = value2, ... WHERE condition;" en SQL.
         */
        return em.merge(entity);
    }
    /**
     *
     * Borra un Domicilio de la base de datos recibiendo como argumento el id
     * de la Domicilio
     *
     * @param id: id correspondiente a la Domicilio a borrar.
     */
    public void delete(Long id) {
        // Se hace uso de mismo método que esta explicado en public DomicilioEntity find(Long id) para obtener la Domicilio a borrar.
        DomicilioEntity entity = em.find(DomicilioEntity.class, id);
        /* Note que una vez obtenido el objeto desde la base de datos llamado "entity", volvemos hacer uso de un método propio del
         EntityManager para eliminar de la base de datos el objeto que encontramos y queremos borrar.
         Es similar a "delete from DomicilioEntity where id=id;" - "DELETE FROM table_codigo WHERE condition;" en SQL.*/
        em.remove(entity);
    }

    /**
     * Busca si hay algun Domicilio con el id que se envía de argumento
     *
     * @param id: id correspondiente a la Domicilio buscada.
     * @return un Domicilio.
     */
    public DomicilioEntity find(Long id) {
        /* Note que se hace uso del metodo "find" propio del EntityManager, el cual recibe como argumento 
        el tipo de la clase y el objeto que nos hara el filtro en la base de datos en este caso el "id"
        Suponga que es algo similar a "select * from DomicilioEntity where id=id;" - "SELECT * FROM table_codigo WHERE condition;" en SQL.
         */
        return em.find(DomicilioEntity.class, id);
    }

    /**
     * Devuelve todos los Domicilios de la base de datos.
     *
     * @return una lista con todos los Domicilio que encuentre en la base de
     * datos, "select u from DomicilioEntity u" es como un "select * from
     * DomicilioEntity;" - "SELECT * FROM table_codigo" en SQL.
     */
    public List<DomicilioEntity> findAll() {
        // Se crea un query para buscar todas las Domicilios en la base de datos.
        TypedQuery query = em.createQuery("select u from DomicilioEntity u", DomicilioEntity.class);
        // Note que en el query se hace uso del método getResultList() que obtiene una lista de Domicilios.
        return query.getResultList();
    }
}
