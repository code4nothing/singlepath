package it.tug.Main;

import org.apache.commons.collections4.map.DefaultedMap;


public class Formatter {

    private Service service;
    private DefaultedMap<String, Strategy> strategies;

    public Formatter(Service service) {
        this.service = service;
        
        strategies = new DefaultedMap<String, Strategy>(new NullStrategy());
        strategies.put("FAIL", new ErrorStrategy());
        strategies.put("OK", new DoubleStringStrategy());
    }

    public String doTheJob(String theInput) {
        String response = service.askForPermission();
        Strategy strategy = strategies.get(response);
        return strategy.workOn(theInput);
    }

}
