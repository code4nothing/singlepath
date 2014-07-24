package it.tug.Main;

public class OkAskResult extends AskResult {
  @Override
  public AskResult onOk(Runnable action) {
    action.run();
    return this;
  }
}
