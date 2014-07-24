package it.tug.Main;

import java.lang.reflect.*;

public class Formatter {

    private Service service;

    public Formatter(Service service) {
        this.service = service;
    }

    public String doTheJob(String theInput) {
        String response = service.askForPermission();
        String result;

        try {
          Method method = getClass().getDeclaredMethod(response.toLowerCase(), String.class);
          result = (String)method.invoke(this, theInput);
        }
        catch(Exception e){
          result = null;
        }
        return result;
    }

    String fail(String theInput) {
      return "error";
    }

    String ok(String theInput) {
      return String.format("%s%s", theInput, theInput);
    }
}
