package okhttp3.internal.framed;

import java.io.IOException;
import java.util.List;
import okio.BufferedSource;

/* compiled from: ProGuard */
public interface PushObserver {
    public static final PushObserver CANCEL = new PushObserver() {
        public final boolean onRequest(int i, List<Header> list) {
            return true;
        }

        public final boolean onHeaders(int i, List<Header> list, boolean z) {
            return true;
        }

        public final boolean onData(int i, BufferedSource bufferedSource, int i2, boolean z) throws IOException {
            bufferedSource.skip((long) i2);
            return true;
        }

        public final void onReset(int i, ErrorCode errorCode) {
        }
    };

    boolean onData(int i, BufferedSource bufferedSource, int i2, boolean z) throws IOException;

    boolean onHeaders(int i, List<Header> list, boolean z);

    boolean onRequest(int i, List<Header> list);

    void onReset(int i, ErrorCode errorCode);
}
