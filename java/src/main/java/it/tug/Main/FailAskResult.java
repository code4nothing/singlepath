package it.tug.Main;

public class FailAskResult extends AskResult {
  @Override
  public AskResult onFail(Runnable action){
    action.run();
    return this;
  }
}
