package ProjectServer.ServerSession;

public interface ServerSession {
    public void readMessages();
    public void dispatchMessages();
    public void openSession(int port);
    public void close();
}
