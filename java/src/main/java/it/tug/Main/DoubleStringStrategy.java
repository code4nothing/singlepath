package it.tug.Main;

public class DoubleStringStrategy implements Strategy {

    @Override
    public String workOn(String theInput) {
        return String.format("%s%s", theInput, theInput);
    }

}
