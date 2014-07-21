package it.tug.Main;

public class Formatter {

    private Service service;

    public Formatter(Service service) {
        this.service = service;
    }

    public String doTheJob(String theInput) {
        String response = service.askForPermission();
        if (response == "FAIL") {
            return "error";
        } else if (response == "OK") {
            return String.format("%s%s", theInput, theInput);
        } else {
            return null;
        }
    }

}
