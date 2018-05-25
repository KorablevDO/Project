package ProjectServer.ServerSession;

public interface ServerSession {
    public void setServerSettings(ServerSettings serverSettings);
    public void readMessages();
    public void dispatchMessages();
    public void openSession();
    public void close();
}
