package it.tug.Main;

public class FailAskResult extends AskResult {
  @Override
  public AskResult onFail(PermissionAction action){
    action.execute();
    return this;
  }
}
