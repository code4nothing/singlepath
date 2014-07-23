package it.tug.Main;

public enum Response {
    FAIL {
        @Override
        public String getResponseValue(String theInput) {
            return "error";
        }
    }, OK
    {
        @Override
        public String getResponseValue(String theInput) {
            return String.format("%s%s", theInput, theInput);
        }
    };

    public String getResponseValue(String theInput) {
        return null;
    }
}
