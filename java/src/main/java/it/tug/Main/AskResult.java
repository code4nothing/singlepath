package it.tug.Main;

public abstract class AskResult {
  public AskResult onOk(Runnable action) {
    return this;
  }

  public AskResult onFail(Runnable action) {
    return this;
  }
}
