package it.tug.Main;

import java.util.concurrent.atomic.AtomicReference;

public class Formatter {
    private final Service service;    

    public Formatter(Service service) {
        this.service = service;
    }

    public String doTheJob(String theInput) {
        AtomicReference<String> doTheJobResult = new AtomicReference<>();
        
        service
          .askForPermission()
          .onFail(() -> doTheJobResult.set("error"))
          .onOk(() -> doTheJobResult.set(String.format("%s%s", theInput, theInput)));
        
        return doTheJobResult.get();
    }
}
