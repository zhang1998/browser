package okhttp3.internal.http;

import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.BufferedSource;

/* compiled from: ProGuard */
public final class RealResponseBody extends ResponseBody {
    private final Headers headers;
    private final BufferedSource source;

    public RealResponseBody(Headers headers, BufferedSource bufferedSource) {
        this.headers = headers;
        this.source = bufferedSource;
    }

    public final MediaType contentType() {
        String str = this.headers.get("Content-Type");
        return str != null ? MediaType.parse(str) : null;
    }

    public final long contentLength() {
        return HttpHeaders.contentLength(this.headers);
    }

    public final BufferedSource source() {
        return this.source;
    }
}
