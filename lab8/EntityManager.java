package Lab8;

public interface EntityManager {
//    save object var1
    void persist(Object var1);
//    update data of object
    <T> T merge(T var1);
//    delete object
    void remove(Object var1);
//    get data
    <T> T find(Class<T> var1, Object var2);
    void refresh(Object var1);
}
