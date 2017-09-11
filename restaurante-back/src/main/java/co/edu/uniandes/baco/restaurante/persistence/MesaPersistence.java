package co.edu.uniandes.baco.restaurante.persistence;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




import co.edu.uniandes.baco.restaurante.entities.MesaEntity;
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
public class MesaPersistence {
    
    private static final Logger LOGGER = Logger.getLogger(MesaPersistence.class.getName());

    @PersistenceContext(unitName = "mesaPU")
    protected EntityManager em;

    /**
     *
     * @param entity objeto Mesa que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public MesaEntity create(MesaEntity entity) {
        LOGGER.info("Creando una mesa nueva");
        /* Note que hacemos uso de un método propio de EntityManager para persistir la Mesa en la base de datos.
        Es similar a "INSERT INTO table_codigo (column1, column2, column3, ...) VALUES (value1, value2, value3, ...);" en SQL.
         */
        em.persist(entity);
        LOGGER.info("Creando un Mesa nueva");
        return entity;
    }

    /**
     * Actualiza una mesa.
     *
     * @param entity: la Mesa que viene con los nuevos cambios. Por ejemplo
     * el codigo pudo cambiar. En ese caso, se haria uso del método update.
     * @return una Mesa con los cambios aplicados.
     */
    public MesaEntity update(MesaEntity entity) {
        LOGGER.log(Level.INFO, "Actualizando Mesa con id={0}", entity.getId());
        /* Note que hacemos uso de un método propio del EntityManager llamado merge() que recibe como argumento
        la Mesa con los cambios, esto es similar a 
        "UPDATE table_codigo SET column1 = value1, column2 = value2, ... WHERE condition;" en SQL.
         */
        return em.merge(entity);
    }

    /**
     *
     * Borra una mesa de la base de datos recibiendo como argumento el id
     * de la Mesa
     *
     * @param id: id correspondiente a la Mesa a borrar.
     */
    public void delete(Long id) {
        LOGGER.log(Level.INFO, "Borrando Mesa con id={0}", id);
        // Se hace uso de mismo método que esta explicado en public MesaEntity find(Long id) para obtener la Mesa a borrar.
        MesaEntity entity = em.find(MesaEntity.class, id);
        /* Note que una vez obtenido el objeto desde la base de datos llamado "entity", volvemos hacer uso de un método propio del
         EntityManager para eliminar de la base de datos el objeto que encontramos y queremos borrar.
         Es similar a "delete from MesaEntity where id=id;" - "DELETE FROM table_codigo WHERE condition;" en SQL.*/
        em.remove(entity);
    }

    /**
     * Busca si hay a Mesa con el id que se envía de argumento
     *
     * @param id: id correspondiente a la Mesa buscada.
     * @return una Mesa.
     */
    public MesaEntity find(Long id) {
        LOGGER.log(Level.INFO, "Consultando Mesa con id={0}", id);
        /* Note que se hace uso del metodo "find" propio del EntityManager, el cual recibe como argumento 
        el tipo de la clase y el objeto que nos hara el filtro en la base de datos en este caso el "id"
        Suponga que es algo similar a "select * from MesaEntity where id=id;" - "SELECT * FROM table_codigo WHERE condition;" en SQL.
         */
        return em.find(MesaEntity.class, id);
    }

    /**
     * Devuelve todas las Mesas de la base de datos.
     *
     * @return una lista con todas las Mesas que encuentre en la base de
     * datos, "select u from MesaEntity u" es como un "select * from
     * MesaEntity;" - "SELECT * FROM table_codigo" en SQL.
     */
    public List<MesaEntity> findAll() {
        LOGGER.info("Consultando todas las Mesas");
        // Se crea un query para buscar todas las Mesas en la base de datos.
        TypedQuery query = em.createQuery("select u from MesaEntity u", MesaEntity.class);
        // Note que en el query se hace uso del método getResultList() que obtiene una lista de Mesas.
        return query.getResultList();
    }
}
