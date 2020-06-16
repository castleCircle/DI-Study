package org.example;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Service {

    public static <T> T getObject(Class<T> clz) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        T instance = createInstance(clz);

        Arrays.stream(clz.getDeclaredFields()).forEach(f->{
            if(f.getAnnotation(Inject.class) != null){
                try {
                    Object object =createInstance(f.getType());
                    f.setAccessible(true);
                    f.set(instance,object);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            }
        });

        return instance;
    }

    public static <T> T createInstance(Class<T> clas) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return clas.getConstructor(null).newInstance();
    }
}
