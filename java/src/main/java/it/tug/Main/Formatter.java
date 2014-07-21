package it.tug.Main;

public class Formatter {

    private Service service;

    public Formatter(Service service) {
        this.service = service;
    }

    public String doTheJob(String theInput) {
        String response = service.askForPermission();
        switch (response) {
            case "FAIL":
                return "error";
            case "OK":
                return String.format("%s%s", theInput, theInput);
            default:
                return null;
        }
    }
}
