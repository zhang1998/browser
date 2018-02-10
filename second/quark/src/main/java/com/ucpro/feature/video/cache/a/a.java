package com.ucpro.feature.video.cache.a;

import android.support.annotation.NonNull;
import android.util.Log;
import com.alibaba.wireless.security.SecExceptionCode;
import com.quark.browser.R;
import com.ucpro.feature.video.cache.db.bean.b;
import com.ucpro.feature.video.cache.e.b.h;
import com.ucpro.feature.video.cache.e.b.i;
import com.ucpro.services.f.g;
import com.ucpro.ui.b.e;
import com.ucweb.common.util.c;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import okhttp3.Request.Builder;
import okhttp3.Response;
import org.android.spdy.SpdyRequest;

/* compiled from: ProGuard */
public final class a {
    public static InputStream a(String str) {
        try {
            Response c = c(str);
            int code = c.code();
            if (code >= SecExceptionCode.SEC_ERROR_STA_ENC && code <= 307) {
                c = c(a(str, c.header("location")));
            } else if (code != 200) {
                e.a().a(com.ucpro.ui.c.a.d((int) R.string.video_download_error_connect_site) + code, 0);
                return null;
            }
            return c.body().byteStream();
        } catch (Exception e) {
            e.a().a(com.ucpro.ui.c.a.d((int) R.string.video_download_error_connect_site) + e.getMessage(), 0);
            return null;
        }
    }

    private static Response c(String str) throws IOException {
        return g.a().newCall(new Builder().url(str).method(SpdyRequest.GET_METHOD, null).build()).execute();
    }

    public static byte[] a(InputStream inputStream) {
        Throwable e;
        Throwable th;
        byte[] bArr = null;
        Closeable byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byte[] g = com.ucweb.common.util.o.a.g(inputStream);
                if (g == null) {
                    com.ucweb.common.util.o.a.a(byteArrayOutputStream);
                    com.ucweb.common.util.o.a.a((Closeable) inputStream);
                } else if (g[0] == (byte) 35 && g[1] == (byte) 69 && g[2] == (byte) 88 && g[3] == (byte) 84 && g[4] == (byte) 77 && g[5] == (byte) 51 && g[6] == (byte) 85) {
                    byteArrayOutputStream.write(g, 0, g.length);
                    g = com.ucweb.common.util.o.a.f(inputStream);
                    if (g != null) {
                        byteArrayOutputStream.write(g, 0, g.length);
                    }
                    bArr = byteArrayOutputStream.toByteArray();
                    com.ucweb.common.util.o.a.a(byteArrayOutputStream);
                    com.ucweb.common.util.o.a.a((Closeable) inputStream);
                } else {
                    com.ucweb.common.util.o.a.a(byteArrayOutputStream);
                    com.ucweb.common.util.o.a.a((Closeable) inputStream);
                }
            } catch (IOException e2) {
                e = e2;
                try {
                    c.a("checkIsM3u8File filed", e);
                    com.ucweb.common.util.o.a.a(byteArrayOutputStream);
                    com.ucweb.common.util.o.a.a((Closeable) inputStream);
                    return bArr;
                } catch (Throwable th2) {
                    th = th2;
                    com.ucweb.common.util.o.a.a(byteArrayOutputStream);
                    com.ucweb.common.util.o.a.a((Closeable) inputStream);
                    throw th;
                }
            }
        } catch (IOException e3) {
            e = e3;
            byteArrayOutputStream = null;
            c.a("checkIsM3u8File filed", e);
            com.ucweb.common.util.o.a.a(byteArrayOutputStream);
            com.ucweb.common.util.o.a.a((Closeable) inputStream);
            return bArr;
        } catch (Throwable e4) {
            byteArrayOutputStream = null;
            th = e4;
            com.ucweb.common.util.o.a.a(byteArrayOutputStream);
            com.ucweb.common.util.o.a.a((Closeable) inputStream);
            throw th;
        }
        return bArr;
    }

    public static String a(List<i> list) {
        String str = "";
        int i = 0;
        for (i iVar : list) {
            String uri;
            int i2;
            h c = iVar.c();
            if (c != null) {
                int a = c.a();
                if (a > i) {
                    int i3 = a;
                    uri = iVar.b().toString();
                    i2 = i3;
                    i = i2;
                    str = uri;
                }
            }
            i2 = i;
            uri = str;
            i = i2;
            str = uri;
        }
        return str;
    }

    public static int a(com.ucpro.feature.video.cache.e.b.e eVar, com.ucpro.feature.video.cache.e.b.e eVar2) {
        if (eVar == null || eVar2 == null) {
            return b.h;
        }
        if (eVar.c != eVar2.c) {
            return b.c;
        }
        if (eVar.b != eVar2.b) {
            return b.d;
        }
        List list = eVar.a;
        List list2 = eVar2.a;
        if (list == null || list2 == null || list.size() <= 0 || list2.size() <= 0 || list.size() != list2.size()) {
            return b.e;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            i iVar = (i) list.get(i);
            i iVar2 = (i) list2.get(i);
            if (iVar == null || iVar2 == null) {
                return b.e;
            }
            if (iVar.a() != iVar2.a()) {
                return b.f;
            }
        }
        return b.a;
    }

    public static void b(String str) {
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            file.mkdir();
        }
    }

    @NonNull
    private static HashMap<String, String> a(b bVar) {
        HashMap<String, String> hashMap = new HashMap();
        byte[] d = com.ucweb.common.util.k.a.d(bVar.i);
        if (d != null) {
            com.ucpro.feature.video.cache.e.b.e a = a(d);
            if (a != null) {
                List list = a.a;
                if (list == null || list.size() <= 0) {
                    Log.e("hjw-m3u8", "parseVideoUrlListFromM3u8::elements empty..!!");
                } else {
                    for (int i = 0; i < list.size(); i++) {
                        String uri = ((i) list.get(i)).b().toString();
                        String str = bVar.h + "/" + String.valueOf(i);
                        if (com.ucpro.c.b.b()) {
                            new StringBuilder("parseVideoUrlListFromM3u8::[").append(i).append("] key----->").append(str);
                            new StringBuilder("parseVideoUrlListFromM3u8::[").append(i).append("] value---->").append(uri);
                        }
                        hashMap.put(str, uri);
                    }
                }
            } else {
                Log.e("hjw-m3u8", "parseVideoUrlListFromM3u8::playList == null!!");
            }
        } else {
            Log.e("hjw-m3u8", "parseVideoUrlListFromM3u8::m3u8Data == null!!");
        }
        return hashMap;
    }

    public static com.ucpro.feature.video.cache.e.b.e a(byte[] bArr) {
        try {
            InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            if (com.ucpro.c.b.b()) {
                Log.e("hjw-m3u8", "prasePlatlistFromM3u8Data:m3u8文件字符串:\n" + new String(bArr));
            }
            return com.ucpro.feature.video.cache.e.b.e.a(byteArrayInputStream);
        } catch (Throwable e) {
            Log.e("hjw-m3u8", "prasePlatlistFromM3u8Data exception:", e);
            return null;
        }
    }

    public static String a(String str, String str2) {
        if (com.ucweb.common.util.n.a.b(str2)) {
            try {
                str2 = new URL(new URL(str), str2).toString();
            } catch (MalformedURLException e) {
            }
        }
        return str2;
    }

    public static String b(String str, String str2) {
        b a = com.ucpro.feature.video.cache.db.b.b().a(str2);
        if (a == null) {
            return null;
        }
        try {
            File file = new File(a.i);
            if (!file.exists()) {
                return null;
            }
            String g = com.ucweb.common.util.k.a.g(file);
            HashMap a2 = a(a);
            c.b(a2.size() > 0);
            String str3 = g;
            for (Entry entry : a2.entrySet()) {
                CharSequence a3 = a(str, "m3u8", (String) entry.getKey());
                Log.e("hjw-m3u8", "replace mUrl to file path: from:" + ((String) entry.getValue()) + " --to--> " + a3);
                str3 = str3.replace((CharSequence) entry.getValue(), a3);
            }
            Log.e("hjw-m3u8", "new m3u8 file downloaded:" + str3);
            file = new File(a.h + "/local.m3u8");
            if (!file.exists()) {
                file.createNewFile();
            }
            com.ucweb.common.util.k.a.a(file, str3);
            return file.getAbsolutePath();
        } catch (Throwable e) {
            Log.e("hjw-m3u8", "读取m3u8", e);
            return null;
        }
    }

    public static String a(String str, String str2, String str3) {
        String str4 = "";
        try {
            str4 = URLEncoder.encode(str3, "utf-8");
        } catch (Exception e) {
        }
        return String.format("%splay.do?&type=%s&filepath=%s", new Object[]{str, str2, str4});
    }
}
