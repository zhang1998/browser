package okhttp3;

import java.io.IOException;

/* compiled from: ProGuard */
public interface Authenticator {
    public static final Authenticator NONE = new Authenticator() {
        public final Request authenticate(Route route, Response response) {
            return null;
        }
    };

    Request authenticate(Route route, Response response) throws IOException;
}
