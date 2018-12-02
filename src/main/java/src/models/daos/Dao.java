package src.models.daos;

/**
 * 
 * @author Andrécio Costa / Dante Alighieri
 *
 */

import java.sql.SQLException;

public interface Dao<T> {
    void save(T t)  throws SQLException;
     
    void update(T t, String[] params) throws SQLException;
     
    void delete(T t) throws SQLException;
}

