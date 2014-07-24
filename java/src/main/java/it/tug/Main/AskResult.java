package it.tug.Main;

public abstract class AskResult {
  public AskResult onOk(PermissionAction action) {
    return this;
  }

  public AskResult onFail(PermissionAction action) {
    return this;
  }
}
