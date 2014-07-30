package it.tug.Main;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Gianluca Costa
 */
public class MethodReflector<T> { //TODO: is this class really needed? We should definitely profile the reflection call
    private final Class<T> targetClass;
    private final Map<String, Method> methodCache = new HashMap<>();

    public MethodReflector(Class<T> targetClass) {
        this.targetClass = targetClass;
    }

    //TODO: this method is not thread-safe, but that should NOT be an issue, generally speaking - and introducing a lock would probably be worse
    public Method getMethod(String methodName) throws NoSuchMethodException {
        Method method = methodCache.get(methodName);

        if (method == null) {
            method = targetClass.getDeclaredMethod(methodName, String.class);
            methodCache.put(methodName, method);
        }

        return method;
    }
}
