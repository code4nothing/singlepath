package it.tug.Main;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Formatter {

    private static final MethodReflector<Formatter> methodReflector = new MethodReflector<>(Formatter.class);

    private final Service service;

    public Formatter(Service service) {
        this.service = service;
    }

    public String doTheJob(String theInput) {
        String response = service.askForPermission();

        try {
            String methodName = response.toLowerCase();
            Method method = methodReflector.getMethod(methodName);

            return (String) method.invoke(this, theInput);
        } catch (IllegalAccessException 
                | IllegalArgumentException 
                | InvocationTargetException 
                | NoSuchMethodException ex) {
            return null;
        }
    }

    private String fail(String theInput) {
        return "error";
    }

    private String ok(String theInput) {
        return String.format("%s%s", theInput, theInput);
    }
}
