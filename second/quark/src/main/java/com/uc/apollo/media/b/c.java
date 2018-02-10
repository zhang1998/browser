package com.uc.apollo.media.b;

import android.util.Log;
import com.uc.apollo.media.b.i.a;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: ProGuard */
public final class c {
    private static h a = new k();

    public static b a(String str, Map<String, String> map) throws IOException, d {
        Throwable th;
        InputStream inputStream = null;
        String str2 = null;
        b bVar = null;
        do {
            try {
                InputStream b = b(str, map);
                if (bVar == null) {
                    bVar = new b();
                    if (e.a(a.M3U8).a(new BufferedInputStream(b), new com.uc.apollo.media.b.e.c(str, bVar, a))) {
                        try {
                            if (bVar.d == null) {
                                str2 = "m3u8 parse " + str + " succes, but it is empty.";
                            } else if (bVar.d.a) {
                                new StringBuilder().append(str).append(" was parsed.");
                                if (b != null) {
                                    b.close();
                                }
                            } else {
                                new StringBuilder().append(str).append(" was parsed, it is a variant, load sub m3u8 list");
                                str = bVar.d.e;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            inputStream = b;
                        }
                    } else {
                        str2 = "m3u8 parse " + str + " failure, user cancelled or content is empty!";
                        bVar = null;
                    }
                    if (b != null) {
                        b.close();
                        continue;
                    }
                } else {
                    e.a(a.M3U8).a(new BufferedInputStream(b), new com.uc.apollo.media.b.e.c(str, bVar, a));
                    if (b != null) {
                        b.close();
                    }
                }
                return bVar;
            } catch (Throwable th3) {
                th = th3;
            }
        } while (str2 == null);
        return bVar;
        if (inputStream != null) {
            inputStream.close();
        }
        throw th;
    }

    private static InputStream b(String str, Map<String, String> map) throws IOException {
        String toLowerCase = str.toLowerCase(Locale.getDefault());
        if (toLowerCase.startsWith("http://") || toLowerCase.startsWith("https://")) {
            new StringBuilder("try to parse media, uri: ").append(str).append(", headers: ").append(map);
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setReadTimeout(6000);
            httpURLConnection.setConnectTimeout(8000);
            if (map != null && map.size() > 0) {
                for (Entry entry : map.entrySet()) {
                    httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
            }
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                InputStream inputStream = httpURLConnection.getInputStream();
                if (inputStream != null) {
                    return inputStream;
                }
                throw new IOException("content is null");
            }
            throw new IOException("connect error, http response code: " + responseCode);
        }
        if (toLowerCase.startsWith("file:///")) {
            str = str.substring(7);
        }
        try {
            str = URLDecoder.decode(str, "UTF-8");
        } catch (Exception e) {
            Log.w("ucmedia.m3u8.M3u8ContextLoader", "java.net.URLDecoder.decode failure: " + e);
        }
        return new FileInputStream(str);
    }
}
