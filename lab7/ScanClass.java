package Lab7;

import Classes.Worker;
import Lab6.PathScan;
import Lab6.annotation.Column;
import Lab6.annotation.Entity;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ScanClass {
    public static String PATH_FOR_SCAN = "Lab7.classes";
    public static HashMap getCl() {
        List<Class<?>> classList = PathScan.find(PATH_FOR_SCAN);
        HashMap<String, HashSet<String>> tables = new HashMap<>();

        for (Class<?> cl : classList) {
            Field[] fields = cl.getDeclaredFields();
            HashSet<String> hashSetFields = new HashSet<>();
            for (Field field : fields) {
                hashSetFields.add(field.getName());
            }

            tables.put(cl.getSimpleName().toLowerCase(), hashSetFields);
        }
        return tables;
    }
}
