package it.tug.Main;

public class Formatter {

    private Service service;
    private String doTheJobResult;

    public Formatter(Service service) {
        this.service = service;
    }

    public String doTheJob(String theInput) {
        doTheJobResult = null;
        service
          .askForPermission()
          .onFail(() -> doTheJobResult = "error")
          .onOk(() -> doTheJobResult = String.format("%s%s", theInput, theInput));
        return doTheJobResult;
    }
}
