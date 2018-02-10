package com.bumptech.glide.b.a;

import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.b.a;
import com.bumptech.glide.b.c.ac;
import com.bumptech.glide.b.e;
import com.bumptech.glide.g;
import com.bumptech.glide.util.d;
import com.bumptech.glide.util.f;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: ProGuard */
public final class n implements c<InputStream> {
    static final m a = new l();
    private final ac b;
    private final int c;
    private final m d;
    private HttpURLConnection e;
    private InputStream f;
    private volatile boolean g;

    public n(ac acVar, int i) {
        this(acVar, i, a);
    }

    private n(ac acVar, int i, m mVar) {
        this.b = acVar;
        this.c = i;
        this.d = mVar;
    }

    public final void a(g gVar, b<? super InputStream> bVar) {
        long a = f.a();
        try {
            ac acVar = this.b;
            if (acVar.b == null) {
                acVar.b = new URL(acVar.a());
            }
            Object a2 = a(acVar.b, 0, null, this.b.b());
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                new StringBuilder("Finished http url fetcher fetch in ").append(f.a(a)).append(" ms and loaded ").append(a2);
            }
            bVar.a(a2);
        } catch (Exception e) {
            Log.isLoggable("HttpUrlFetcher", 3);
            bVar.a(e);
        }
    }

    private InputStream a(URL url, int i, URL url2, Map<String, String> map) throws IOException {
        URL url3 = url;
        while (i < 5) {
            if (url2 != null) {
                try {
                    if (url3.toURI().equals(url2.toURI())) {
                        throw new e("In re-direct loop");
                    }
                } catch (URISyntaxException e) {
                }
            }
            this.e = this.d.a(url3);
            for (Entry entry : map.entrySet()) {
                this.e.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
            this.e.setConnectTimeout(this.c);
            this.e.setReadTimeout(this.c);
            this.e.setUseCaches(false);
            this.e.setDoInput(true);
            this.e.setInstanceFollowRedirects(false);
            this.e.connect();
            if (this.g) {
                return null;
            }
            int responseCode = this.e.getResponseCode();
            if (responseCode / 100 == 2) {
                HttpURLConnection httpURLConnection = this.e;
                if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
                    this.f = d.a(httpURLConnection.getInputStream(), (long) httpURLConnection.getContentLength());
                } else {
                    if (Log.isLoggable("HttpUrlFetcher", 3)) {
                        new StringBuilder("Got non empty content encoding: ").append(httpURLConnection.getContentEncoding());
                    }
                    this.f = httpURLConnection.getInputStream();
                }
                return this.f;
            } else if (responseCode / 100 == 3) {
                Object headerField = this.e.getHeaderField("Location");
                if (TextUtils.isEmpty(headerField)) {
                    throw new e("Received empty or null redirect url");
                }
                i++;
                url2 = url3;
                url3 = new URL(url3, headerField);
            } else if (responseCode == -1) {
                throw new e(responseCode);
            } else {
                throw new e(this.e.getResponseMessage(), responseCode);
            }
        }
        throw new e("Too many (> 5) redirects!");
    }

    public final void a() {
        if (this.f != null) {
            try {
                this.f.close();
            } catch (IOException e) {
            }
        }
        if (this.e != null) {
            this.e.disconnect();
        }
    }

    public final void b() {
        this.g = true;
    }

    public final Class<InputStream> d() {
        return InputStream.class;
    }

    public final a c() {
        return a.REMOTE;
    }
}
