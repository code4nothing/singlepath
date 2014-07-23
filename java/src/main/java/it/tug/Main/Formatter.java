package it.tug.Main;

public class Formatter {

    private Service service;

    public Formatter(Service service) {
        this.service = service;
    }

    public String doTheJob(String theInput) {
        String response = service.askForPermission();

        try {
            return Response.valueOf(response).getResponseValue(theInput);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
