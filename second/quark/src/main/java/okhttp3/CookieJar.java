package okhttp3;

import java.util.Collections;
import java.util.List;

/* compiled from: ProGuard */
public interface CookieJar {
    public static final CookieJar NO_COOKIES = new CookieJar() {
        public final void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
        }

        public final List<Cookie> loadForRequest(HttpUrl httpUrl) {
            return Collections.emptyList();
        }
    };

    List<Cookie> loadForRequest(HttpUrl httpUrl);

    void saveFromResponse(HttpUrl httpUrl, List<Cookie> list);
}
