package ProjectServer.ServerSession;

import ProjectServer.ServerSession.ServerSession;

abstract class AddServerSession implements ServerSession {
    protected ServerSettings serverSettings;

    protected AddServerSession(ServerSettings serverSettings) {
        this.serverSettings = serverSettings;
    }
}
