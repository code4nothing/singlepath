package it.tug.Main;

public class Formatter {

    private Service service;
    private String doTheJobResult;

    public Formatter(Service service) {
        this.service = service;
    }

    public String doTheJob(String theInput) {
        final String localInput = theInput;
        service
          .askForPermission()
          .onFail(new PermissionAction() {
            public void execute(){
              doTheJobResult = "error";
            }
          })
          .onOk(new PermissionAction() {
            public void execute(){
              doTheJobResult = String.format("%s%s", localInput, localInput);
            }
          });
        return doTheJobResult;
    }
}
