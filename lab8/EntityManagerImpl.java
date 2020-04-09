package Lab8;


import Lab8.annotation.Entity;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class EntityManagerImpl implements EntityManager {
    @Override
    public void persist(Object var1) throws Exception {
        // 1. Проверяем наличие аннотации @Entity
        Annotation entity = var1.getClass().getAnnotation(Entity.class);
        // Если аннотации @Entity нет, то прекращаем работу, генерируя исключение
        if (entity == null)
            throw new Exception("Class " + var1.getClass().getCanonicalName() + " is not Entity!");

        // 1. Получаем имя таблицы
        String tableName = var1.getClass().getSimpleName().toLowerCase();

        // Получаем список членов класса
        Field[] fields = var1.getClass().getDeclaredFields();
        for (Field field : fields) {

        }
    }

    @Override
    public <T> T merge(T var1) {
        return null;
    }

    @Override
    public void remove(Object var1) {

    }

    @Override
    public <T> T find(Class<T> var1, Object var2) {
        return null;
    }

    @Override
    public void refresh(Object var1) {

    }
}
