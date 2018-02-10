package com.bumptech.glide.b.a;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: ProGuard */
final class l implements m {
    l() {
    }

    public final HttpURLConnection a(URL url) throws IOException {
        return (HttpURLConnection) url.openConnection();
    }
}
