package Lab8;

import Lab6.annotation.Column;
import Lab8.classes.Product;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ExamplePersistEntity {
    private Connection connection;
    private Properties properties;

    public ExamplePersistEntity(Properties properties) {
        this.properties = properties;
        getConnection();
    }

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.setProperty("url", "jdbc:postgresql://localhost:5432/oodb");
        properties.setProperty("username", "postgres");
        properties.setProperty("password", "root");

        ExamplePersistEntity epe = new ExamplePersistEntity(properties);
        Product product = new Product();
        product.setName("Toy");
        epe.persist(product);
        epe.close();
    }

    public void persist(Object var1) {
        int p = var1.getClass().getName().lastIndexOf('.');
        int l = var1.getClass().getName().length();
        String tableName = var1.getClass().getName().substring(p + 1, l).toLowerCase();

        System.out.println(tableName);

        Field[] fields = var1.getClass().getDeclaredFields();
        for (Field field : fields) {
            Annotation[] annotations = field.getAnnotations();
            for (Annotation a : annotations) {
                if (a.annotationType().equals(Column.class)) {
                    try {
                        Method method = var1.getClass().getMethod(
                                "get" + field.getName().substring(0, 1).toUpperCase() +
                                        field.getName().substring(1), null
                        );
                        System.out.println(method.getName());

                        String value = method.invoke(var1, null).toString();
                        System.out.println(value);
                    } catch (NoSuchMethodException | InvocationTargetException | IllegalArgumentException | IllegalAccessException | SecurityException e) {
                        e.printStackTrace();
                    }
                    System.out.println(field.getName());
                }
            }
        }
    }

    public Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            try {
                connection = DriverManager.getConnection(properties.getProperty("url"),
                        properties.getProperty("username"), properties.getProperty("password"));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public void close(){
        closeConnection();
    }

    private void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
