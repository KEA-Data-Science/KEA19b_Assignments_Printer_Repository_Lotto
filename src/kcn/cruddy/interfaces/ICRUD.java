package kcn.cruddy.interfaces;

/**
 * All defined methods return a boolean, which asserts action success on true.
 * */
public interface ICRUD<T extends IHaveID>
{
    boolean create(T object);
    T read(int id);
    T update(T object);
    boolean delete(int id);

}
