package src.models.daos;

public interface Dao<T> {
    void save(T t);
     
    void update(T t, String[] params);
     
    void delete(T t);
}

