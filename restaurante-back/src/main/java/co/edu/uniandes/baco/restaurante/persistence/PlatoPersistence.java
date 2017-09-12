/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.baco.restaurante.persistence;

import co.edu.uniandes.baco.restaurante.entities.PagoEntity;
import co.edu.uniandes.baco.restaurante.entities.PlatoEntity;
import co.edu.uniandes.baco.restaurante.entities.SucursalEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author df.penap
 */

public class PlatoPersistence {
private static final Logger LOGGER = Logger.getLogger(SucursalPersistence.class.getName());

    @PersistenceContext(unitName = "restaurantePU")
    protected EntityManager em;
    PlatoEntity create(PlatoEntity entity) {
        LOGGER.info("Creando un plato nuevo");
        /* Note que hacemos uso de un método propio de EntityManager para persistir la Sucursal en la base de datos.
        Es similar a "INSERT INTO table_codigo (column1, column2, column3, ...) VALUES (value1, value2, value3, ...);" en SQL.
         */
        em.persist(entity);
        LOGGER.info("Creando un plato nuevo");
        return entity;
    }

    List<PlatoEntity> findAll() {
        LOGGER.info("Consultando los platos");
       
        TypedQuery query = em.createQuery("select u from PlatoEntity u", SucursalEntity.class);
       
        return query.getResultList();
    }
    PlatoEntity find(Long id) {
        LOGGER.log(Level.INFO, "Consultando Plato con id={0}", id);
      
        return em.find(PlatoEntity.class, id);
    }

    PlatoEntity update(PlatoEntity entity) {
        LOGGER.log(Level.INFO, "Actualizando Plato con id={0}", entity.getId());
       
        return em.merge(entity);
    }

    void delete(Long id) {
        LOGGER.log(Level.INFO, "Borrando plato con id={0}", id);
        
        PlatoEntity entity = em.find(PlatoEntity.class, id);
        
        em.remove(entity);
    }
}
