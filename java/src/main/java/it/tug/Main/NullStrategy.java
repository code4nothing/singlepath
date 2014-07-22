package it.tug.Main;

public class NullStrategy implements Strategy {

    @Override
    public String workOn(String theInput) {
        return null;
    }
}
