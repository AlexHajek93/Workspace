public abstract class WHState {
  protected static WHContext context;
  protected WHState() {
    //context = WHContext.instance();
  }
  public abstract void run();
}
