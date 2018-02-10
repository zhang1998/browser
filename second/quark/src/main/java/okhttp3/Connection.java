package okhttp3;

import java.net.Socket;

/* compiled from: ProGuard */
public interface Connection {
    Handshake handshake();

    Protocol protocol();

    Route route();

    Socket socket();
}
