package it.tug.Main;

public class ErrorStrategy implements Strategy {

    @Override
    public String workOn(String theInput) {
        return "error";
    }

}
