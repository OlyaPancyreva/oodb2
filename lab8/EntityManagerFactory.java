package Lab8;

import java.sql.Connection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Properties;

public class EntityManagerFactory {
    private Connection connection;
    private Properties properties;
    private HashMap<String, HashSet<String>> tables = new HashMap<>();

    public EntityManagerFactory(Properties properties) {
        this.properties = properties;
    }
//    create, initialize class
    public EntityManager createEntityManager(){
        return null;
    }
//    create connection
    private Connection getConnection(){
        return null;
    }
//    scan class, database; compare them
    private boolean scanModel() {
        return true;
    }
}
