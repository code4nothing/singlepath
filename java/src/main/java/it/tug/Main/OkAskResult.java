package it.tug.Main;

public class OkAskResult extends AskResult {
  @Override
  public AskResult onOk(PermissionAction action) {
    action.execute();
    return this;
  }
}
