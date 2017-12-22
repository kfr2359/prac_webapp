package DAO;

import java.io.Serializable;
import java.util.Collection;

public interface GenericDAO<T extends Serializable> {
    public void          add(T obj);
    public void          update(T obj);
    public void          delete(T obj);
    public T             getById(int id);
    public Collection<T> getAll();
}
