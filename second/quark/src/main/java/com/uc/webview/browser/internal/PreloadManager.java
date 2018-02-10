package com.uc.webview.browser.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alibaba.wireless.security.open.nocaptcha.INoCaptchaComponent;
import com.uc.apollo.impl.SettingsConst;
import com.uc.crashsdk.export.LogType;
import com.uc.webview.browser.BrowserCore;
import com.uc.webview.browser.interfaces.BrowserPreloader;
import com.uc.webview.browser.internal.interfaces.IPreloadManager;
import com.uc.webview.export.MimeTypeMap;
import com.uc.webview.export.WebResourceResponse;
import com.uc.webview.export.annotations.Reflection;
import com.uc.webview.export.cyclone.Constant;
import com.uc.webview.export.cyclone.UCCyclone;
import com.uc.webview.export.cyclone.UCHashMap;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.android.spdy.SpdyRequest;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class PreloadManager implements IPreloadManager {
    private static final String a = System.getProperty("line.separator");
    private static PreloadManager b;
    private static final UCHashMap<String, Boolean> c = new UCHashMap().set("access-control-allow-origin", Boolean.valueOf(true)).set("accept-patch", Boolean.valueOf(false)).set("accept-ranges", Boolean.valueOf(false)).set("age", Boolean.valueOf(false)).set("allow", Boolean.valueOf(false)).set("cache-control", Boolean.valueOf(true)).set("connection", Boolean.valueOf(false)).set("content-disposition", Boolean.valueOf(false)).set("content-encoding", Boolean.valueOf(false)).set("content-language", Boolean.valueOf(true)).set("content-length", Boolean.valueOf(false)).set("content-location", Boolean.valueOf(false)).set("content-md5", Boolean.valueOf(true)).set("content-range", Boolean.valueOf(false)).set("content-type", Boolean.valueOf(true)).set("date", Boolean.valueOf(false)).set("etag", Boolean.valueOf(true)).set("expires", Boolean.valueOf(true)).set("last-modified", Boolean.valueOf(true)).set("link", Boolean.valueOf(true)).set("location", Boolean.valueOf(true)).set("p3p", Boolean.valueOf(false)).set("pragma", Boolean.valueOf(false)).set("proxy-authenticate", Boolean.valueOf(false)).set("public-key-pins", Boolean.valueOf(false)).set("refresh", Boolean.valueOf(true)).set("retry-after", Boolean.valueOf(false)).set("server", Boolean.valueOf(true)).set("set-cookie", Boolean.valueOf(true)).set(INoCaptchaComponent.status, Boolean.valueOf(false)).set("strict-transport-security", Boolean.valueOf(false)).set("trailer", Boolean.valueOf(false)).set("transfer-encoding", Boolean.valueOf(false)).set("upgrade", Boolean.valueOf(false)).set("vary", Boolean.valueOf(true)).set("via", Boolean.valueOf(true)).set("warning", Boolean.valueOf(true)).set("www-authenticate", Boolean.valueOf(false)).set("x-frame-options", Boolean.valueOf(true)).set("x-xss-protection", Boolean.valueOf(true)).set("content-security-policy", Boolean.valueOf(true)).set("x-content-security-policy", Boolean.valueOf(true)).set("x-webkit-csp", Boolean.valueOf(true)).set("x-content-type-options", Boolean.valueOf(true)).set("x-powered-by", Boolean.valueOf(true)).set("x-ua-compatible", Boolean.valueOf(true)).set("x-content-duration", Boolean.valueOf(true)).set("eagleid", Boolean.valueOf(true)).set("timing-allow-origin", Boolean.valueOf(true)).set("x-cache", Boolean.valueOf(true)).set("x-swift-cachetime", Boolean.valueOf(true)).set("x-swift-savetime", Boolean.valueOf(true)).set("x-download-options", Boolean.valueOf(true)).set("x-readtime", Boolean.valueOf(true)).set("x-server-id", Boolean.valueOf(true));
    private Context d;
    private ThreadPoolExecutor e = new ThreadPoolExecutor(5, 5, 10, TimeUnit.SECONDS, new LinkedBlockingDeque());
    private i f = new i();
    private JSONObject g = new JSONObject();
    private HashMap<String, String> h = new HashMap();
    private final ConcurrentHashMap<String, ConcurrentHashMap<String, Pair<Boolean, WebResourceResponse>>> i = new ConcurrentHashMap(2);
    private final ConcurrentHashMap<String, Thread> j = new ConcurrentHashMap(2);
    private final ConcurrentHashMap<String, HashSet<String>> k = new ConcurrentHashMap(2);
    private final ConcurrentLinkedQueue<Pair<Integer, Object>> l = new ConcurrentLinkedQueue();
    private ConcurrentHashMap<String, JSONObject> m = new ConcurrentHashMap(5);
    private Runnable n = null;
    private final String o = "sir_video_preload_1";
    private final String p = "sir_video_preload_0";
    private final String q = "updateCDSwitch";
    private final String[] r = new String[]{"sir_prefetch_video", "sir_prefetch_video_stat"};
    private final long s = 10000;
    private final boolean[] t = new boolean[]{false, false, false};
    private long u = 0;

    /* compiled from: ProGuard */
    final class a {
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
        private static final /* synthetic */ int[] d = new int[]{a, b, c};
    }

    /* compiled from: ProGuard */
    final class b extends BufferedInputStream {
        final /* synthetic */ PreloadManager a;
        private File b;
        private File c;
        private String d;
        private BufferedOutputStream e;
        private FileOutputStream f;
        private long g = 0;

        private void a() {
            UCCyclone.close(this.e);
            this.e = null;
            UCCyclone.close(this.f);
        }

        public b(PreloadManager preloadManager, InputStream inputStream, String str, String str2, String str3) {
            this.a = preloadManager;
            super(inputStream);
            this.d = str2;
            preloadManager.a(this.d, "sir_res_fet_ass");
            try {
                String a = preloadManager.d(str);
                String a2 = preloadManager.d(str3);
                this.b = preloadManager.d(a, a2);
                this.c = new File(preloadManager.e(), String.valueOf(Process.myTid()) + "_" + a + "_" + a2 + ".tmp");
                this.c.getParentFile().mkdirs();
                this.f = new FileOutputStream(this.c);
                this.e = new BufferedOutputStream(this.f);
            } catch (Throwable th) {
                new StringBuilder("caching buffered input stream file error: ").append(th.toString());
                a();
                if (this.c.exists()) {
                    this.c.delete();
                }
            }
        }

        public final void close() throws IOException {
            a();
            super.close();
            if (this.c.exists()) {
                this.c.delete();
            }
        }

        public final synchronized int read() throws IOException {
            int read;
            read = super.read();
            if (this.e != null) {
                if (read == -1) {
                    this.b.getParentFile().mkdirs();
                    a();
                    if (this.g > 0 && this.g < 67108864) {
                        this.c.renameTo(this.b);
                        this.a.a(this.d, "sir_res_fet_ass_succ");
                    } else if (this.c.exists()) {
                        this.c.delete();
                    }
                } else {
                    try {
                        this.e.write(read);
                        this.g++;
                        if (this.g >= 67108864) {
                            this.a.a(this.d, "sir_res_fet_ass_lmt");
                            throw new IOException("exceed max asset size limit.");
                        }
                    } catch (IOException e) {
                        a();
                        if (this.c.exists()) {
                            this.c.delete();
                        }
                    }
                }
            }
            return read;
        }

        public final synchronized int read(byte[] bArr, int i, int i2) throws IOException {
            int read;
            read = super.read(bArr, i, i2);
            if (this.e != null) {
                if (read == -1) {
                    this.b.getParentFile().mkdirs();
                    a();
                    if (this.g > 0 && this.g < 67108864) {
                        this.c.renameTo(this.b);
                        this.a.a(this.d, "sir_res_fet_ass_succ");
                    } else if (this.c.exists()) {
                        this.c.delete();
                    }
                } else {
                    try {
                        this.e.write(bArr);
                        this.g += (long) read;
                        if (this.g >= 67108864) {
                            this.a.a(this.d, "sir_res_fet_ass_lmt");
                            throw new IOException("exceed max asset size limit.");
                        }
                    } catch (IOException e) {
                        a();
                        if (this.c.exists()) {
                            this.c.delete();
                        }
                    }
                }
            }
            return read;
        }
    }

    /* compiled from: ProGuard */
    final class c extends InputStream {
        int a;
        private InputStream b;

        public c(InputStream inputStream) {
            this.b = inputStream;
        }

        public final int available() throws IOException {
            return this.b.available();
        }

        public final void close() throws IOException {
            this.b.close();
        }

        public final void mark(int i) {
            this.b.mark(i);
        }

        public final boolean markSupported() {
            return this.b.markSupported();
        }

        public final int read() throws IOException {
            int read = this.b.read();
            if (read != -1) {
                this.a++;
            }
            return read;
        }

        public final int read(byte[] bArr) throws IOException {
            int read = this.b.read(bArr);
            if (read != -1) {
                this.a += read;
            }
            return read;
        }

        public final int read(byte[] bArr, int i, int i2) throws IOException {
            int read = this.b.read(bArr, i, i2);
            if (read != -1) {
                this.a += read;
            }
            return read;
        }

        public final synchronized void reset() throws IOException {
            this.b.reset();
        }

        public final long skip(long j) throws IOException {
            long skip = this.b.skip(j);
            if (skip != 0) {
                this.a = (int) (((long) this.a) + skip);
            }
            return skip;
        }
    }

    /* compiled from: ProGuard */
    final class d implements Runnable {
        final /* synthetic */ PreloadManager a;
        private String b;
        private String c;
        private String d;
        private int e = a.a;
        private ValueCallback<Pair<Integer, String>> f;

        d(PreloadManager preloadManager, String str, String str2, String str3, int i, a<ValueCallback<Pair, Integer>> aVar) {
            this.a = preloadManager;
            this.b = str;
            this.c = str3;
            this.e = i;
            this.f = aVar;
            this.d = str2;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            r26 = this;
            r0 = r26;
            r2 = r0.a;
            r0 = r26;
            r3 = r0.d;
            r4 = "sir_fet_ass_req";
            r2.a(r3, r4);
            r11 = 0;
            r8 = 0;
            r4 = 0;
            r10 = 0;
            r7 = 0;
            r6 = 0;
            r3 = 0;
            r16 = android.os.SystemClock.uptimeMillis();	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r18 = new java.net.URL;	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r0 = r26;
            r2 = r0.c;	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r0 = r18;
            r0.<init>(r2);	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r0 = r26;
            r2 = r0.a;	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r0 = r26;
            r5 = r0.b;	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r19 = r2.d(r5);	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r0 = r26;
            r2 = r0.a;	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r0 = r26;
            r5 = r0.c;	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r5 = r2.d(r5);	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r20 = com.uc.webview.browser.internal.PreloadManager.a(r18);	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r2 = 0;
            if (r20 == 0) goto L_0x0490;
        L_0x0042:
            r9 = r20.length();	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            if (r9 <= 0) goto L_0x0490;
        L_0x0048:
            r2 = "MD5";
            r2 = java.security.MessageDigest.getInstance(r2);	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r15 = r2;
        L_0x004f:
            r0 = r26;
            r2 = r0.a;	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r0 = r19;
            r21 = r2.d(r0, r5);	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r22 = new java.io.File;	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r2.<init>();	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r9 = r21.getAbsolutePath();	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r2 = r2.append(r9);	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r9 = ".zlst";
            r2 = r2.append(r9);	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r2 = r2.toString();	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r0 = r22;
            r0.<init>(r2);	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r23 = new java.io.File;	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r2.<init>();	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r9 = r21.getAbsolutePath();	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r2 = r2.append(r9);	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r9 = ".hj";
            r2 = r2.append(r9);	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r2 = r2.toString();	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r0 = r23;
            r0.<init>(r2);	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r0 = r26;
            r2 = r0.e;	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r9 = com.uc.webview.browser.internal.PreloadManager.a.b;	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            if (r2 == r9) goto L_0x013a;
        L_0x009d:
            r2 = r21.exists();	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            if (r2 == 0) goto L_0x00d8;
        L_0x00a3:
            r2 = r23.exists();	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            if (r2 == 0) goto L_0x00d8;
        L_0x00a9:
            r0 = r26;
            r2 = r0.f;	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r5 = new android.util.Pair;	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r9 = 0;
            r9 = java.lang.Integer.valueOf(r9);	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r12 = 0;
            r5.<init>(r9, r12);	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r2.onReceiveValue(r5);	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r2 = 0;
            com.uc.webview.export.cyclone.UCCyclone.close(r2);
            r2 = 0;
            com.uc.webview.export.cyclone.UCCyclone.close(r2);
            r2 = 0;
            com.uc.webview.export.cyclone.UCCyclone.close(r2);
            r2 = 0;
            com.uc.webview.export.cyclone.UCCyclone.close(r2);
            r2 = 0;
            com.uc.webview.export.cyclone.UCCyclone.close(r2);
            r2 = 0;
            com.uc.webview.export.cyclone.UCCyclone.close(r2);
            r2 = 0;
            com.uc.webview.export.cyclone.UCCyclone.close(r2);
        L_0x00d7:
            return;
        L_0x00d8:
            r0 = r26;
            r2 = r0.e;	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r9 = com.uc.webview.browser.internal.PreloadManager.a.c;	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            if (r2 != r9) goto L_0x013a;
        L_0x00e0:
            r2 = r22.exists();	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            if (r2 == 0) goto L_0x013a;
        L_0x00e6:
            r2 = com.uc.webview.browser.internal.PreloadManager.c(r22);	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            if (r2 == 0) goto L_0x013a;
        L_0x00ec:
            r9 = 1;
            r12 = r2.iterator();	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
        L_0x00f1:
            r2 = r12.hasNext();	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            if (r2 == 0) goto L_0x048d;
        L_0x00f7:
            r2 = r12.next();	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r2 = (java.lang.String) r2;	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r13 = new java.io.File;	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r13.<init>(r2);	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r2 = r13.exists();	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            if (r2 != 0) goto L_0x00f1;
        L_0x0108:
            r2 = 0;
        L_0x0109:
            if (r2 == 0) goto L_0x013a;
        L_0x010b:
            r0 = r26;
            r2 = r0.f;	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r5 = new android.util.Pair;	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r9 = 0;
            r9 = java.lang.Integer.valueOf(r9);	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r12 = 0;
            r5.<init>(r9, r12);	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r2.onReceiveValue(r5);	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r2 = 0;
            com.uc.webview.export.cyclone.UCCyclone.close(r2);
            r2 = 0;
            com.uc.webview.export.cyclone.UCCyclone.close(r2);
            r2 = 0;
            com.uc.webview.export.cyclone.UCCyclone.close(r2);
            r2 = 0;
            com.uc.webview.export.cyclone.UCCyclone.close(r2);
            r2 = 0;
            com.uc.webview.export.cyclone.UCCyclone.close(r2);
            r2 = 0;
            com.uc.webview.export.cyclone.UCCyclone.close(r2);
            r2 = 0;
            com.uc.webview.export.cyclone.UCCyclone.close(r2);
            goto L_0x00d7;
        L_0x013a:
            r0 = r26;
            r2 = r0.a;	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r0 = r26;
            r9 = r0.d;	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r12 = "sir_fet_ass";
            r2.a(r9, r12);	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r0 = r26;
            r2 = r0.a;	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r0 = r19;
            r24 = new java.io.File(r2.e(), java.lang.String.valueOf(android.os.Process.myTid()) + "_" + r0 + "_" + r5 + ".tmp");	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r2 = r24.getParentFile();	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r2.mkdirs();	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r2 = new java.net.URL;	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r0 = r26;
            r9 = r0.c;	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r9 = com.uc.webview.browser.internal.PreloadManager.a(r9);	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r2.<init>(r9);	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r2 = r2.openConnection();	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r2 = (java.net.HttpURLConnection) r2;	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r9 = "Accept-Encoding";
            r12 = "gzip";
            r2.setRequestProperty(r9, r12);	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r9 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
            r2.setConnectTimeout(r9);	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r9 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
            r2.setReadTimeout(r9);	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r9 = 1;
            r2.setInstanceFollowRedirects(r9);	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r9 = "GET";
            r2.setRequestMethod(r9);	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r2.connect();	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r9 = r2.getResponseCode();	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r12 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
            if (r9 < r12) goto L_0x0194;
        L_0x0190:
            r12 = 303; // 0x12f float:4.25E-43 double:1.497E-321;
            if (r9 <= r12) goto L_0x01ef;
        L_0x0194:
            r2 = new java.lang.RuntimeException;	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r5 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r12 = "Http-Code:";
            r5.<init>(r12);	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r5 = r5.append(r9);	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r9 = " not correct.";
            r5 = r5.append(r9);	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r5 = r5.toString();	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r2.<init>(r5);	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            throw r2;	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
        L_0x01af:
            r2 = move-exception;
            r5 = r7;
            r9 = r11;
            r7 = r4;
            r4 = r6;
            r6 = r10;
        L_0x01b5:
            r0 = r26;
            r10 = r0.a;	 Catch:{ all -> 0x0454 }
            r0 = r26;
            r11 = r0.d;	 Catch:{ all -> 0x0454 }
            r12 = "sir_at_e";
            r10.a(r11, r12);	 Catch:{ all -> 0x0454 }
            r0 = r26;
            r10 = r0.f;	 Catch:{ all -> 0x0454 }
            r11 = new android.util.Pair;	 Catch:{ all -> 0x0454 }
            r12 = 17;
            r12 = java.lang.Integer.valueOf(r12);	 Catch:{ all -> 0x0454 }
            r2 = r2.toString();	 Catch:{ all -> 0x0454 }
            r11.<init>(r12, r2);	 Catch:{ all -> 0x0454 }
            r10.onReceiveValue(r11);	 Catch:{ all -> 0x0454 }
            com.uc.webview.export.cyclone.UCCyclone.close(r5);
            com.uc.webview.export.cyclone.UCCyclone.close(r6);
            com.uc.webview.export.cyclone.UCCyclone.close(r9);
            com.uc.webview.export.cyclone.UCCyclone.close(r7);
            com.uc.webview.export.cyclone.UCCyclone.close(r8);
            com.uc.webview.export.cyclone.UCCyclone.close(r4);
            com.uc.webview.export.cyclone.UCCyclone.close(r3);
            goto L_0x00d7;
        L_0x01ef:
            r25 = r2.getContentLength();	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r12 = r2.getInputStream();	 Catch:{ Throwable -> 0x01af, all -> 0x0429 }
            r8 = 0;
            r4 = "gzip";
            r9 = r2.getContentEncoding();	 Catch:{ Throwable -> 0x045e, all -> 0x0433 }
            r4 = r4.equals(r9);	 Catch:{ Throwable -> 0x045e, all -> 0x0433 }
            if (r4 == 0) goto L_0x0264;
        L_0x0204:
            r4 = new com.uc.webview.browser.internal.PreloadManager$c;	 Catch:{ Throwable -> 0x045e, all -> 0x0433 }
            r4.<init>(r12);	 Catch:{ Throwable -> 0x045e, all -> 0x0433 }
            r9 = new java.util.zip.GZIPInputStream;	 Catch:{ Throwable -> 0x0466, all -> 0x043c }
            r9.<init>(r4);	 Catch:{ Throwable -> 0x0466, all -> 0x043c }
            r8 = r4;
            r13 = r9;
        L_0x0210:
            r14 = new java.io.BufferedInputStream;	 Catch:{ Throwable -> 0x046f, all -> 0x0445 }
            r14.<init>(r13);	 Catch:{ Throwable -> 0x046f, all -> 0x0445 }
            r3 = 262144; // 0x40000 float:3.67342E-40 double:1.295163E-318;
            r4 = new byte[r3];	 Catch:{ Throwable -> 0x0479, all -> 0x044b }
            r3 = 0;
            r11 = new java.io.FileOutputStream;	 Catch:{ Throwable -> 0x0479, all -> 0x044b }
            r0 = r24;
            r11.<init>(r0);	 Catch:{ Throwable -> 0x0479, all -> 0x044b }
            r10 = new java.io.BufferedOutputStream;	 Catch:{ Throwable -> 0x0483, all -> 0x0450 }
            r10.<init>(r11);	 Catch:{ Throwable -> 0x0483, all -> 0x0450 }
        L_0x0226:
            r6 = r14.read(r4);	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            r7 = -1;
            if (r6 == r7) goto L_0x026a;
        L_0x022d:
            if (r25 <= 0) goto L_0x0233;
        L_0x022f:
            r0 = r25;
            if (r3 > r0) goto L_0x026a;
        L_0x0233:
            r7 = 0;
            r10.write(r4, r7, r6);	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            if (r15 == 0) goto L_0x023d;
        L_0x0239:
            r7 = 0;
            r15.update(r4, r7, r6);	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
        L_0x023d:
            if (r8 == 0) goto L_0x0268;
        L_0x023f:
            r3 = r8.a;	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
        L_0x0241:
            r6 = 67108864; // 0x4000000 float:1.5046328E-36 double:3.31561842E-316;
            if (r3 < r6) goto L_0x0226;
        L_0x0245:
            r0 = r26;
            r2 = r0.a;	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            r0 = r26;
            r3 = r0.d;	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            r4 = "sir_fet_ass_lmt";
            r2.a(r3, r4);	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            r2 = new java.io.IOException;	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            r3 = "exceed max asset size limit.";
            r2.<init>(r3);	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            throw r2;	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
        L_0x025a:
            r2 = move-exception;
            r3 = r8;
            r4 = r9;
            r5 = r10;
            r6 = r11;
            r7 = r12;
            r8 = r13;
            r9 = r14;
            goto L_0x01b5;
        L_0x0264:
            r8 = r3;
            r9 = r6;
            r13 = r12;
            goto L_0x0210;
        L_0x0268:
            r3 = r3 + r6;
            goto L_0x0241;
        L_0x026a:
            if (r25 <= 0) goto L_0x02ae;
        L_0x026c:
            r0 = r25;
            if (r3 == r0) goto L_0x02ae;
        L_0x0270:
            r2 = new java.lang.RuntimeException;	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            r5 = "Content-Length:";
            r4.<init>(r5);	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            r0 = r25;
            r4 = r4.append(r0);	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            r5 = " but ";
            r4 = r4.append(r5);	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            r3 = r4.append(r3);	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            r4 = " received.";
            r3 = r3.append(r4);	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            r3 = r3.toString();	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            r2.<init>(r3);	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            throw r2;	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
        L_0x0297:
            r2 = move-exception;
        L_0x0298:
            com.uc.webview.export.cyclone.UCCyclone.close(r10);
            com.uc.webview.export.cyclone.UCCyclone.close(r11);
            com.uc.webview.export.cyclone.UCCyclone.close(r14);
            com.uc.webview.export.cyclone.UCCyclone.close(r12);
            com.uc.webview.export.cyclone.UCCyclone.close(r13);
            com.uc.webview.export.cyclone.UCCyclone.close(r9);
            com.uc.webview.export.cyclone.UCCyclone.close(r8);
            throw r2;
        L_0x02ae:
            if (r15 == 0) goto L_0x02e7;
        L_0x02b0:
            r3 = r15.digest();	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            r3 = com.uc.webview.browser.internal.PreloadManager.a(r3);	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            r0 = r20;
            r4 = r3.equals(r0);	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            if (r4 != 0) goto L_0x02e7;
        L_0x02c0:
            r2 = new java.lang.RuntimeException;	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            r5 = "specified Md5:";
            r4.<init>(r5);	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            r0 = r20;
            r4 = r4.append(r0);	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            r5 = " but ";
            r4 = r4.append(r5);	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            r3 = r4.append(r3);	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            r4 = " received.";
            r3 = r3.append(r4);	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            r3 = r3.toString();	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            r2.<init>(r3);	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            throw r2;	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
        L_0x02e7:
            r10.flush();	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            com.uc.webview.export.cyclone.UCCyclone.close(r10);	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            com.uc.webview.export.cyclone.UCCyclone.close(r11);	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            r3 = r21.getParentFile();	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            r3.mkdirs();	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            r0 = r26;
            r3 = r0.e;	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            r4 = com.uc.webview.browser.internal.PreloadManager.a.c;	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            if (r3 == r4) goto L_0x03ae;
        L_0x02ff:
            r0 = r24;
            r1 = r21;
            r0.renameTo(r1);	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            r3 = r2.getHeaderFields();	 Catch:{ Throwable -> 0x034d, all -> 0x0297 }
            r6 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x034d, all -> 0x0297 }
            r6.<init>();	 Catch:{ Throwable -> 0x034d, all -> 0x0297 }
            if (r3 == 0) goto L_0x035b;
        L_0x0311:
            r4 = r3.isEmpty();	 Catch:{ Throwable -> 0x034d, all -> 0x0297 }
            if (r4 != 0) goto L_0x035b;
        L_0x0317:
            r3 = r3.keySet();	 Catch:{ Throwable -> 0x034d, all -> 0x0297 }
            r7 = r3.iterator();	 Catch:{ Throwable -> 0x034d, all -> 0x0297 }
        L_0x031f:
            r3 = r7.hasNext();	 Catch:{ Throwable -> 0x034d, all -> 0x0297 }
            if (r3 == 0) goto L_0x03a4;
        L_0x0325:
            r3 = r7.next();	 Catch:{ Throwable -> 0x034d, all -> 0x0297 }
            r3 = (java.lang.String) r3;	 Catch:{ Throwable -> 0x034d, all -> 0x0297 }
            if (r3 == 0) goto L_0x031f;
        L_0x032d:
            r4 = com.uc.webview.browser.internal.PreloadManager.c;	 Catch:{ Throwable -> 0x034d, all -> 0x0297 }
            r15 = r3.toLowerCase();	 Catch:{ Throwable -> 0x034d, all -> 0x0297 }
            r4 = r4.get(r15);	 Catch:{ Throwable -> 0x034d, all -> 0x0297 }
            r4 = (java.lang.Boolean) r4;	 Catch:{ Throwable -> 0x034d, all -> 0x0297 }
            if (r4 == 0) goto L_0x031f;
        L_0x033d:
            r4 = r4.booleanValue();	 Catch:{ Throwable -> 0x034d, all -> 0x0297 }
            if (r4 == 0) goto L_0x031f;
        L_0x0343:
            r4 = r2.getHeaderField(r3);	 Catch:{ Throwable -> 0x034d, all -> 0x0297 }
            if (r4 == 0) goto L_0x031f;
        L_0x0349:
            r6.put(r3, r4);	 Catch:{ Throwable -> 0x034d, all -> 0x0297 }
            goto L_0x031f;
        L_0x034d:
            r2 = move-exception;
            r0 = r26;
            r2 = r0.a;	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            r0 = r26;
            r3 = r0.d;	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            r4 = "sir_hea_sav_e";
            r2.a(r3, r4);	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
        L_0x035b:
            r0 = r26;
            r2 = r0.a;	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            r0 = r26;
            r3 = r0.d;	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            r4 = "sir_asset_cost";
            r6 = android.os.SystemClock.uptimeMillis();	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            r6 = r6 - r16;
            r2.a(r3, r4, r5, r6);	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            r0 = r26;
            r2 = r0.a;	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            r0 = r26;
            r3 = r0.d;	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            r4 = "sir_fet_ass_succ";
            r2.a(r3, r4);	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            r0 = r26;
            r2 = r0.f;	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            r3 = new android.util.Pair;	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            r4 = 0;
            r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            r5 = 0;
            r3.<init>(r4, r5);	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            r2.onReceiveValue(r3);	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            com.uc.webview.export.cyclone.UCCyclone.close(r10);
            com.uc.webview.export.cyclone.UCCyclone.close(r11);
            com.uc.webview.export.cyclone.UCCyclone.close(r14);
            com.uc.webview.export.cyclone.UCCyclone.close(r12);
            com.uc.webview.export.cyclone.UCCyclone.close(r13);
            com.uc.webview.export.cyclone.UCCyclone.close(r9);
            com.uc.webview.export.cyclone.UCCyclone.close(r8);
            goto L_0x00d7;
        L_0x03a4:
            r0 = r26;
            r2 = r0.a;	 Catch:{ Throwable -> 0x034d, all -> 0x0297 }
            r0 = r23;
            com.uc.webview.browser.internal.PreloadManager.a(r2, r0, r6);	 Catch:{ Throwable -> 0x034d, all -> 0x0297 }
            goto L_0x035b;
        L_0x03ae:
            r3 = new java.io.File;	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            r2.<init>();	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            r4 = r24.getAbsolutePath();	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            r2 = r2.append(r4);	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            r4 = "_unzip";
            r2 = r2.append(r4);	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            r2 = r2.toString();	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            r3.<init>(r2);	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            r0 = r24;
            r2 = com.uc.webview.browser.internal.PreloadManager.b(r0, r3);	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            if (r2 == 0) goto L_0x041f;
        L_0x03d2:
            r4 = r2.isEmpty();	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            if (r4 != 0) goto L_0x041f;
        L_0x03d8:
            r4 = new java.util.ArrayList;	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            r4.<init>();	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            r6 = r2.iterator();	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
        L_0x03e1:
            r2 = r6.hasNext();	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            if (r2 == 0) goto L_0x041a;
        L_0x03e7:
            r2 = r6.next();	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            r2 = (java.lang.String) r2;	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            r7 = new java.net.URL;	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            r0 = r18;
            r7.<init>(r0, r2);	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            r0 = r26;
            r15 = r0.a;	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            r7 = r7.toString();	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            r7 = r15.d(r7);	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            r15 = new java.io.File;	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            r15.<init>(r3, r2);	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            r0 = r26;
            r2 = r0.a;	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            r0 = r19;
            r2 = r2.d(r0, r7);	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            r15.renameTo(r2);	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            r2 = r2.getAbsolutePath();	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            r4.add(r2);	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            goto L_0x03e1;
        L_0x041a:
            r0 = r22;
            com.uc.webview.browser.internal.PreloadManager.a(r0, r4);	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
        L_0x041f:
            r24.delete();	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            r2 = 0;
            r4 = 0;
            com.uc.webview.export.cyclone.UCCyclone.recursiveDelete(r3, r2, r4);	 Catch:{ Throwable -> 0x025a, all -> 0x0297 }
            goto L_0x035b;
        L_0x0429:
            r2 = move-exception;
            r9 = r6;
            r12 = r4;
            r13 = r8;
            r14 = r11;
            r8 = r3;
            r11 = r10;
            r10 = r7;
            goto L_0x0298;
        L_0x0433:
            r2 = move-exception;
            r9 = r6;
            r13 = r8;
            r14 = r11;
            r11 = r10;
            r8 = r3;
            r10 = r7;
            goto L_0x0298;
        L_0x043c:
            r2 = move-exception;
            r9 = r6;
            r13 = r8;
            r14 = r11;
            r11 = r10;
            r8 = r4;
            r10 = r7;
            goto L_0x0298;
        L_0x0445:
            r2 = move-exception;
            r14 = r11;
            r11 = r10;
            r10 = r7;
            goto L_0x0298;
        L_0x044b:
            r2 = move-exception;
            r11 = r10;
            r10 = r7;
            goto L_0x0298;
        L_0x0450:
            r2 = move-exception;
            r10 = r7;
            goto L_0x0298;
        L_0x0454:
            r2 = move-exception;
            r10 = r5;
            r11 = r6;
            r12 = r7;
            r13 = r8;
            r14 = r9;
            r9 = r4;
            r8 = r3;
            goto L_0x0298;
        L_0x045e:
            r2 = move-exception;
            r4 = r6;
            r5 = r7;
            r9 = r11;
            r7 = r12;
            r6 = r10;
            goto L_0x01b5;
        L_0x0466:
            r2 = move-exception;
            r3 = r4;
            r5 = r7;
            r9 = r11;
            r7 = r12;
            r4 = r6;
            r6 = r10;
            goto L_0x01b5;
        L_0x046f:
            r2 = move-exception;
            r3 = r8;
            r4 = r9;
            r5 = r7;
            r6 = r10;
            r7 = r12;
            r8 = r13;
            r9 = r11;
            goto L_0x01b5;
        L_0x0479:
            r2 = move-exception;
            r3 = r8;
            r4 = r9;
            r5 = r7;
            r6 = r10;
            r7 = r12;
            r8 = r13;
            r9 = r14;
            goto L_0x01b5;
        L_0x0483:
            r2 = move-exception;
            r3 = r8;
            r4 = r9;
            r5 = r7;
            r6 = r11;
            r7 = r12;
            r8 = r13;
            r9 = r14;
            goto L_0x01b5;
        L_0x048d:
            r2 = r9;
            goto L_0x0109;
        L_0x0490:
            r15 = r2;
            goto L_0x004f;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uc.webview.browser.internal.PreloadManager.d.run():void");
        }
    }

    /* compiled from: ProGuard */
    final class e {
        public static final int a = 1;
        public static final int b = 2;
        private static final /* synthetic */ int[] c = new int[]{a, b};
    }

    /* compiled from: ProGuard */
    final class f implements ValueCallback<Pair<Integer, String>>, Runnable {
        final /* synthetic */ PreloadManager a;
        private String b;
        private String c;
        private String d;
        private String e;
        private JSONObject f;
        private ValueCallback<Pair<Boolean, String>> g;
        private int h = 0;
        private int i = 0;
        private boolean j = false;
        private long k = SystemClock.uptimeMillis();
        private boolean l;
        private boolean m = false;
        private boolean n = false;

        public final /* synthetic */ void onReceiveValue(Object obj) {
            a((Pair) obj);
        }

        f(PreloadManager preloadManager, String str, String str2, String str3, String str4, JSONObject jSONObject, ValueCallback<Pair<Boolean, String>> valueCallback) {
            this.a = preloadManager;
            this.b = str;
            this.c = str4;
            this.d = str3;
            this.f = jSONObject;
            this.g = valueCallback;
            this.l = ((Boolean) preloadManager.getPrefetchResult(str, this.e).first).booleanValue();
            this.e = str2;
        }

        private String a(String str) throws Throwable {
            Closeable inputStream;
            Closeable inputStreamReader;
            Throwable th;
            Closeable closeable = null;
            Closeable bufferedReader;
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setReadTimeout(10000);
                httpURLConnection.setInstanceFollowRedirects(true);
                httpURLConnection.setRequestMethod(SpdyRequest.GET_METHOD);
                httpURLConnection.connect();
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode < 200 || responseCode > SecExceptionCode.SEC_ERROR_STA_NO_DATA_FILE) {
                    throw new RuntimeException("Http-Code:" + responseCode + " not correct.");
                }
                inputStream = httpURLConnection.getInputStream();
                try {
                    inputStreamReader = new InputStreamReader(inputStream);
                    try {
                        bufferedReader = new BufferedReader(inputStreamReader);
                    } catch (Throwable th2) {
                        th = th2;
                        UCCyclone.close(closeable);
                        UCCyclone.close(inputStreamReader);
                        UCCyclone.close(inputStream);
                        throw th;
                    }
                    try {
                        StringBuilder stringBuilder = new StringBuilder();
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine != null) {
                                stringBuilder.append(readLine);
                            } else {
                                String stringBuilder2 = stringBuilder.toString();
                                UCCyclone.close(bufferedReader);
                                UCCyclone.close(inputStreamReader);
                                UCCyclone.close(inputStream);
                                return stringBuilder2;
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        closeable = bufferedReader;
                        UCCyclone.close(closeable);
                        UCCyclone.close(inputStreamReader);
                        UCCyclone.close(inputStream);
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    inputStreamReader = null;
                    UCCyclone.close(closeable);
                    UCCyclone.close(inputStreamReader);
                    UCCyclone.close(inputStream);
                    throw th;
                }
            } catch (Throwable th5) {
                th = th5;
                inputStreamReader = null;
                inputStream = null;
                UCCyclone.close(closeable);
                UCCyclone.close(inputStreamReader);
                UCCyclone.close(inputStream);
                throw th;
            }
        }

        public final void run() {
            try {
                String a;
                File file = new File(new File(this.a.d.getFilesDir(), "precache"), this.a.d(this.b));
                this.m = file.exists();
                file.mkdirs();
                this.a.a(this.e, "sir_fet_ass_lst");
                long uptimeMillis = SystemClock.uptimeMillis();
                if (this.d == null || this.d.length() <= 0) {
                    a = a(this.c);
                } else {
                    a = this.d;
                }
                JSONObject jSONObject = new JSONObject(a);
                this.n = true;
                JSONObject jSONObject2 = new JSONObject();
                this.h++;
                String[] a2 = PreloadManager.b(jSONObject, a, "assets");
                if (a2 != null) {
                    this.h += a2.length;
                    for (String str : a2) {
                        this.a.e.execute(new d(this.a, this.b, this.e, str, a.a, this));
                        jSONObject2.put(this.a.d(str), true);
                    }
                }
                a2 = PreloadManager.b(jSONObject, a, "freshAssets");
                if (a2 != null) {
                    this.h += a2.length;
                    for (String str2 : a2) {
                        this.a.e.execute(new d(this.a, this.b, this.e, str2, a.b, this));
                        jSONObject2.put(this.a.d(str2), true);
                    }
                }
                PreloadManager.a(this.a, new File(file, "assets_json"), jSONObject2);
                String[] a3 = PreloadManager.b(jSONObject, a, "zipAssets");
                if (a3 != null) {
                    this.h += a3.length;
                    for (String str22 : a3) {
                        this.a.e.execute(new d(this.a, this.b, this.e, str22, a.c, this));
                    }
                }
                Object obj = (!this.a.f(this.a.r[e.b + -1]) || this.a.c().equals("sir_video_preload_1")) ? 1 : null;
                if (obj != null && this.a.f(this.a.r[e.a - 1])) {
                    String[] a4 = PreloadManager.b(jSONObject, a, "mediaAssets");
                    if (a4 != null) {
                        try {
                            UCHashMap uCHashMap = new UCHashMap().set("Referer", jSONObject.optString("document"));
                            Class cls = Class.forName("com.uc.apollo.preload.PreLoader");
                            Class cls2 = Class.forName("com.uc.apollo.preload.PreloadListener");
                            Method declaredMethod = cls.getDeclaredMethod("add", new Class[]{String.class, String.class, Map.class, cls2});
                            for (Object obj2 : a4) {
                                try {
                                    declaredMethod.invoke(cls, new Object[]{r4, obj2, uCHashMap, null});
                                } catch (Throwable th) {
                                }
                            }
                        } catch (Throwable th2) {
                        }
                    }
                }
                Thread thread = new Thread(this.a.f);
                this.a.f.b = this;
                this.h++;
                thread.start();
                this.a.a(this.e, "sir_asset_lst_cost", "sir_fet_ass_lst_succ", SystemClock.uptimeMillis() - uptimeMillis);
                this.a.a(this.e, "sir_fet_ass_lst_succ");
                a(new Pair(Integer.valueOf(0), null));
            } catch (Throwable th3) {
                Throwable th4 = th3;
                new StringBuilder("get scope json other error: ").append(th4.toString());
                this.a.callback(this.e, this.g, Boolean.valueOf(false), th4.toString(), 13, this.b, BrowserPreloader.CDKEY_SIR_PREFETCH, true, this.l, this.m, this.n, this.h, this.i);
                this.a.a(this.e, "sir_fet_e");
            }
        }

        private void a(Pair<Integer, String> pair) {
            boolean z = this.j;
            synchronized (this) {
                if (((Integer) pair.first).intValue() == 0) {
                    this.i++;
                } else if (!this.j) {
                    this.j = true;
                }
            }
            if (!z) {
                if (this.i == this.h) {
                    try {
                        int i;
                        File c = this.a.d(this.a.d(this.b), "all_done");
                        boolean z2 = c.exists() || c.createNewFile();
                        PreloadManager preloadManager = this.a;
                        String str = this.e;
                        ValueCallback valueCallback = this.g;
                        Boolean valueOf = Boolean.valueOf(z2);
                        String str2 = z2 ? null : "all_done:file not created.";
                        if (z2) {
                            i = 0;
                        } else {
                            i = 14;
                        }
                        preloadManager.callback(str, valueCallback, valueOf, str2, i, this.b, BrowserPreloader.CDKEY_SIR_PREFETCH, true, this.l, this.m, this.n, this.h, this.i);
                        if (z2) {
                            this.a.a(this.e, "sir_fetch_scope_cost", "sir_fet_cmd_succ", SystemClock.uptimeMillis() - this.k);
                            if (this.l) {
                                this.a.a(this.e, "sir_fetch_scope_cost_q", "sir_fet_cmd_succ", SystemClock.uptimeMillis() - this.k);
                                this.a.a(this.e, "sir_fet_cmd_succ_q");
                            } else {
                                this.a.a(this.e, "sir_fetch_scope_cost_s", "sir_fet_cmd_succ", SystemClock.uptimeMillis() - this.k);
                                this.a.a(this.e, "sir_fet_cmd_succ_s");
                            }
                            this.a.a(this.e, "sir_fet_cmd_succ");
                        }
                    } catch (Throwable th) {
                        this.a.callback(this.e, this.g, Boolean.valueOf(false), th.getMessage(), 15, this.b, BrowserPreloader.CDKEY_SIR_PREFETCH, true, this.l, this.m, this.n, this.h, this.i);
                    }
                } else if (this.j) {
                    this.a.callback(this.e, this.g, Boolean.valueOf(false), (String) pair.second, ((Integer) pair.first).intValue(), this.b, BrowserPreloader.CDKEY_SIR_PREFETCH, true, this.l, this.m, this.n, this.h, this.i);
                }
            }
        }
    }

    /* compiled from: ProGuard */
    final class g implements Runnable {
        File a = null;
        String b;
        String c;
        String d;
        final /* synthetic */ PreloadManager e;

        g(PreloadManager preloadManager, String str, String str2) {
            this.e = preloadManager;
            this.b = str;
            this.d = str2;
            this.c = preloadManager.d(str);
            if (this.c != null && !this.c.isEmpty()) {
                try {
                    this.a = new File(new File(preloadManager.d.getFilesDir(), "precache"), this.c);
                } catch (Throwable th) {
                    preloadManager.a(this.d, "sir_io_e");
                }
            }
        }

        public final void run() {
            try {
                if (this.a != null) {
                    this.e.a(this.d, "sir_preload_cmd");
                    long uptimeMillis = SystemClock.uptimeMillis();
                    ConcurrentHashMap b = this.e.c(this.b, this.d);
                    LinkedList linkedList = new LinkedList();
                    File[] listFiles = this.a.listFiles();
                    if (listFiles != null) {
                        HashSet hashSet = new HashSet(20);
                        for (File file : listFiles) {
                            if (file.isFile()) {
                                String str;
                                hashSet.add(file.getName());
                                if (file == null || !file.exists() || file.isDirectory()) {
                                    str = null;
                                } else {
                                    str = file.getName();
                                    if (str.equals("") || str.endsWith(".")) {
                                        str = null;
                                    } else {
                                        int lastIndexOf = str.lastIndexOf(".");
                                        str = lastIndexOf != -1 ? str.substring(lastIndexOf).toLowerCase(Locale.US) : null;
                                    }
                                }
                                if (str == null || !(str.equals(".js") || str.equals(".css"))) {
                                    linkedList.addLast(file);
                                } else {
                                    linkedList.addFirst(file);
                                }
                            }
                        }
                        this.e.k.put(this.c, hashSet);
                    }
                    Iterator it = linkedList.iterator();
                    while (it.hasNext()) {
                        String name = ((File) it.next()).getName();
                        synchronized (b) {
                            if (((Pair) b.get(name)) != null) {
                            } else {
                                WebResourceResponse a = this.e.a(null, this.d, name, this.c, name);
                                synchronized (b) {
                                    if (((Pair) b.get(name)) == null) {
                                        b.put(name, new Pair(Boolean.valueOf(true), a));
                                    }
                                }
                            }
                        }
                    }
                    this.e.a(this.d, "sir_preload_cost", this.a.getName(), SystemClock.uptimeMillis() - uptimeMillis);
                    this.e.a(this.d, "sir_preload_cmd_succ");
                    Thread.sleep(10000);
                    this.e.j.remove(this.c);
                    this.e.i.remove(this.c);
                    this.e.k.remove(this.c);
                }
            } catch (Throwable th) {
                this.e.a(this.d, "sir_preload_e");
            }
        }
    }

    /* compiled from: ProGuard */
    final class h implements Runnable {
        final /* synthetic */ PreloadManager a;

        private h(PreloadManager preloadManager) {
            this.a = preloadManager;
        }

        private static Date a(Date date, int i) {
            Calendar instance = Calendar.getInstance();
            instance.setTime(date);
            instance.add(5, i);
            return instance.getTime();
        }

        private boolean a(String str, JSONObject jSONObject) {
            try {
                File file = new File(new File(this.a.d.getFilesDir(), "precache"), this.a.d(str));
                if (!jSONObject.has("startDate")) {
                    return true;
                }
                String optString = jSONObject.optString("startDate");
                if (optString.length() <= 0) {
                    return true;
                }
                Date parse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(optString);
                if (new Date().after(a(parse, 90))) {
                    return true;
                }
                if (!new Date().after(a(parse, 7)) || UCCyclone.getFolderSize(file, 67108864) <= 67108864) {
                    return false;
                }
                return true;
            } catch (Throwable th) {
                return true;
            }
        }

        public final void run() {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                new Thread(this, "PreloadManager.Prune").start();
            } else if (this.a.d != null) {
                try {
                    UCCyclone.recursiveDelete(this.a.d(), true, this.a.e());
                } catch (Throwable th) {
                }
                File file = new File(this.a.d.getFilesDir(), "precache");
                File file2 = new File(file, "manifest.json");
                synchronized (this.a.g) {
                    String str;
                    Object obj;
                    Object obj2 = null;
                    try {
                        Iterator keys = this.a.g.keys();
                        while (keys.hasNext()) {
                            str = (String) keys.next();
                            JSONObject optJSONObject = this.a.g.optJSONObject(str);
                            if (optJSONObject != null) {
                                if (this.a.a(optJSONObject)) {
                                    PreloadManager.b(this.a, str);
                                    keys.remove();
                                    obj = 1;
                                } else {
                                    obj = obj2;
                                }
                                obj2 = obj;
                            }
                        }
                    } catch (Exception e) {
                        new StringBuilder("iterate manifest error: ").append(e.toString());
                    } catch (Throwable th2) {
                        new StringBuilder("delete expire scope error: ").append(th2.toString());
                    }
                    int length = this.a.g.length();
                    if (length > 10) {
                        long folderSize = UCCyclone.getFolderSize(file, 536870912);
                        if (folderSize > 536870912) {
                            this.a.a(com.uc.webview.export.internal.interfaces.IPreloadManager.SIR_COMMON_TYPE, "sir_prune_cmd");
                            try {
                                Iterator keys2 = this.a.g.keys();
                                while (keys2.hasNext()) {
                                    str = (String) keys2.next();
                                    JSONObject optJSONObject2 = this.a.g.optJSONObject(str);
                                    if (optJSONObject2 != null) {
                                        if (a(str, optJSONObject2)) {
                                            PreloadManager.b(this.a, str);
                                            keys2.remove();
                                            obj = 1;
                                        } else {
                                            obj = obj2;
                                        }
                                        obj2 = obj;
                                    }
                                }
                                this.a.a(com.uc.webview.export.internal.interfaces.IPreloadManager.SIR_COMMON_TYPE, "sir_prune_cmd_succ");
                                this.a.a(com.uc.webview.export.internal.interfaces.IPreloadManager.SIR_COMMON_TYPE, "sir_prune_size", new UCHashMap().set("prune_bs", String.valueOf(folderSize)).set("prune_as", String.valueOf(UCCyclone.getFolderSize(file, 536870912))).set("prune_bc", String.valueOf(length)).set("prune_ac", this.a.g.length()));
                            } catch (Exception e2) {
                                new StringBuilder("iterate prune scope error: ").append(e2.toString());
                            } catch (Throwable th22) {
                                new StringBuilder("delete prune scope error: ").append(th22.toString());
                                this.a.a(com.uc.webview.export.internal.interfaces.IPreloadManager.SIR_COMMON_TYPE, "sir_prune_e");
                            }
                        }
                    }
                    if (obj2 != null) {
                        PreloadManager.a(this.a, file2, this.a.g);
                    }
                }
            }
        }
    }

    /* compiled from: ProGuard */
    final class i implements Runnable {
        HashSet<String> a;
        ValueCallback<Pair<Integer, String>> b;
        boolean c;
        final /* synthetic */ PreloadManager d;

        private i(PreloadManager preloadManager) {
            this.d = preloadManager;
            this.a = new HashSet();
            this.c = false;
        }

        public final void run() {
            if (this.d.d != null) {
                try {
                    a();
                    if (this.b != null) {
                        this.b.onReceiveValue(new Pair(Integer.valueOf(0), null));
                    }
                } catch (Throwable th) {
                    if (this.b != null) {
                        this.b.onReceiveValue(new Pair(Integer.valueOf(16), th.toString()));
                    }
                }
            }
        }

        private synchronized void a() {
            File file = new File(new File(this.d.d.getFilesDir(), "precache"), "manifest.json");
            synchronized (this.d.g) {
                boolean z = this.c;
                this.c = false;
                Iterator it = this.a.iterator();
                while (it.hasNext()) {
                    boolean z2;
                    String str = (String) it.next();
                    try {
                        PreloadManager.b(this.d, str);
                    } catch (MalformedURLException e) {
                        this.d.a(com.uc.webview.export.internal.interfaces.IPreloadManager.SIR_COMMON_TYPE, "sir_url_e");
                    }
                    it.remove();
                    if (this.d.g.has(str)) {
                        this.d.g.remove(str);
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    z = z2;
                }
                if (z) {
                    this.d.a(com.uc.webview.export.internal.interfaces.IPreloadManager.SIR_COMMON_TYPE, "sir_mf_ud");
                    PreloadManager.a(this.d, file, this.d.g);
                }
            }
        }
    }

    static /* synthetic */ String a(String str) {
        return str;
    }

    static /* synthetic */ String a(URL url) {
        String query = url.getQuery();
        if (query != null) {
            for (String str : query.split("&")) {
                if (str != null && str.startsWith("__md5=")) {
                    return str.substring(6);
                }
            }
        }
        return null;
    }

    static /* synthetic */ String a(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            if ((bArr[i] & 255) < 16) {
                stringBuffer.append(SettingsConst.FALSE);
            }
            stringBuffer.append(Long.toString((long) (bArr[i] & 255), 16));
        }
        return stringBuffer.toString();
    }

    static /* synthetic */ void a(PreloadManager preloadManager, File file, JSONObject jSONObject) {
        file.getParentFile().mkdirs();
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file));
            outputStreamWriter.write(jSONObject.toString());
            outputStreamWriter.close();
        } catch (FileNotFoundException e) {
            preloadManager.a(com.uc.webview.export.internal.interfaces.IPreloadManager.SIR_COMMON_TYPE, "sir_not_found_e");
        } catch (IOException e2) {
            preloadManager.a(com.uc.webview.export.internal.interfaces.IPreloadManager.SIR_COMMON_TYPE, "sir_io_e");
        }
    }

    static /* synthetic */ void a(File file, ArrayList arrayList) {
        if (!arrayList.isEmpty()) {
            file.getParentFile().mkdirs();
            try {
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    outputStreamWriter.write(((String) it.next()) + a);
                }
                outputStreamWriter.close();
            } catch (FileNotFoundException e) {
                new StringBuilder("zlst file error: ").append(e.toString());
            } catch (IOException e2) {
                new StringBuilder("zlst file io error: ").append(e2.toString());
            }
        }
    }

    static /* synthetic */ void b(PreloadManager preloadManager, String str) throws MalformedURLException {
        if (str != null && str.length() != 0) {
            UCCyclone.recursiveDelete(new File(new File(preloadManager.d.getFilesDir(), "precache"), preloadManager.d(str)), false, null);
        }
    }

    @Reflection
    public static PreloadManager getInstance() {
        if (b == null) {
            synchronized (PreloadManager.class) {
                if (b == null) {
                    PreloadManager preloadManager = new PreloadManager();
                    b = preloadManager;
                    new Handler(Looper.getMainLooper()).postDelayed(new h(), 180000);
                }
            }
        }
        return b;
    }

    public void setContext(Context context) {
        if (this.d == null && context != null) {
            synchronized (PreloadManager.class) {
                if (this.d == null) {
                    this.d = context;
                    this.g = b(new File(new File(this.d.getFilesDir(), "precache"), "manifest.json"));
                    this.g = this.g == null ? new JSONObject() : this.g;
                    a(true);
                }
            }
        }
    }

    public void setStatCallback(Runnable runnable) {
        this.n = runnable;
        b();
    }

    private void b() {
        if (this.n != null && !this.l.isEmpty()) {
            this.n.run();
        }
    }

    public AbstractQueue<Pair<Integer, Object>> getStats() {
        return this.l;
    }

    private void a(String str, String str2) {
        this.l.add(new Pair(Integer.valueOf(1), new Pair(str, str2)));
        b();
    }

    private void a(String str, String str2, HashMap<String, String> hashMap) {
        hashMap.put("bus", str);
        this.l.add(new Pair(Integer.valueOf(2), new Pair(str2, hashMap)));
        b();
    }

    private void a(String str, String str2, String str3, long j) {
        this.l.add(new Pair(Integer.valueOf(2), new Pair(str2, new UCHashMap().set("bus", str).set("name", str3).set("costs", String.valueOf(j)))));
        b();
    }

    public Pair<Boolean, String> getPrefetchResult(String str, String str2) {
        if (str == null || str.length() == 0) {
            return new Pair(Boolean.valueOf(false), "scope is null/empty.");
        }
        try {
            boolean exists = d(d(str), "all_done").exists();
            return new Pair(Boolean.valueOf(exists), exists ? null : "all_done:file not created.");
        } catch (Throwable th) {
            return new Pair(Boolean.valueOf(false), th.getMessage());
        }
    }

    private Boolean b(String str, String str2) {
        try {
            if (this.g != null && this.g.has(str)) {
                JSONObject optJSONObject = this.g.optJSONObject(str);
                if (optJSONObject != null && optJSONObject.has("content")) {
                    String optString = optJSONObject.optString("content");
                    String[] strArr = new String[]{"assets", "freshAssets", "zipAssets"};
                    for (int i = 0; i < 3; i++) {
                        String[] b = b(null, optString, strArr[i]);
                        if (b != null) {
                            for (String url : b) {
                                URL url2 = new URL(url);
                                URL url3 = new URL(str2);
                                if (url2.getHost().equals(url3.getHost()) && url2.getPath().equals(url3.getPath()) && url2.getPort() == url3.getPort()) {
                                    return Boolean.valueOf(true);
                                }
                            }
                            continue;
                        }
                    }
                }
            }
        } catch (Throwable th) {
        }
        return Boolean.valueOf(false);
    }

    public Pair<Boolean, String> getPrefetchUrlResult(String str, String str2, String str3) {
        if (str3 == null || str3.length() == 0) {
            return getPrefetchResult(str, str2);
        }
        try {
            URL url = new URL(str3);
            File d = d(d(str), d(str3));
            if (!d.getParentFile().exists()) {
                return new Pair(null, "no task");
            }
            boolean exists = d.exists();
            if (!exists && url.getPath().endsWith("zip")) {
                File file = new File(d.getAbsolutePath() + ".zlst");
                if (file.exists()) {
                    ArrayList c = c(file);
                    if (c != null) {
                        Iterator it = c.iterator();
                        while (it.hasNext()) {
                            exists = new File((String) it.next()).exists();
                            if (!exists) {
                                break;
                            }
                        }
                    }
                }
            }
            if (exists) {
                return new Pair(Boolean.valueOf(true), null);
            }
            if (b(str, str3).booleanValue()) {
                return new Pair(Boolean.valueOf(false), "url:file not created.");
            }
            return new Pair(null, "no task");
        } catch (Throwable th) {
            return new Pair(null, th.getMessage());
        }
    }

    private ConcurrentHashMap<String, Pair<Boolean, WebResourceResponse>> c(String str, String str2) {
        ConcurrentHashMap<String, Pair<Boolean, WebResourceResponse>> concurrentHashMap;
        String d = d(str);
        synchronized (this.j) {
            if (((Thread) this.j.get(d)) == null) {
                Thread thread = new Thread(new g(this, str, str2));
                thread.start();
                this.j.put(d, thread);
            }
        }
        synchronized (this.i) {
            concurrentHashMap = (ConcurrentHashMap) this.i.get(d);
            if (concurrentHashMap == null) {
                concurrentHashMap = new ConcurrentHashMap();
                this.i.put(d, concurrentHashMap);
            }
        }
        return concurrentHashMap;
    }

    public WebResourceResponse getPreloadResourceWithNetwork(String str, String str2, String str3, String str4) {
        WebResourceResponse webResourceResponse;
        Throwable th;
        if (str == null || str.length() == 0 || str3 == null || str3.length() == 0) {
            return null;
        }
        a(str2, "sir_res_fet_cmd");
        WebResourceResponse preloadResource = getPreloadResource(str, str2, str3);
        if (preloadResource != null) {
            a(str2, "sir_res_fet_cmd_succ_h");
            return preloadResource;
        }
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str3).openConnection();
            httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.setRequestMethod(SpdyRequest.GET_METHOD);
            httpURLConnection.connect();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode < 200 || responseCode > SecExceptionCode.SEC_ERROR_STA_NO_DATA_FILE) {
                throw new RuntimeException("Http-Code:" + responseCode + " not correct.");
            }
            httpURLConnection.getContentLength();
            InputStream inputStream = httpURLConnection.getInputStream();
            if ("gzip".equals(httpURLConnection.getContentEncoding().toLowerCase())) {
                inputStream = new GZIPInputStream(new c(inputStream));
            }
            WebResourceResponse webResourceResponse2 = new WebResourceResponse(b(str3), "UTF-8", new b(this, inputStream, str, str2, str3));
            try {
                a(str2, "sir_res_fet_cmd_succ");
                return webResourceResponse2;
            } catch (Throwable th2) {
                Throwable th3 = th2;
                webResourceResponse = webResourceResponse2;
                th = th3;
                a(str2, "sir_res_fet_e");
                new StringBuilder("download asset resource error: ").append(th.toString());
                return webResourceResponse;
            }
        } catch (Throwable th22) {
            th = th22;
            webResourceResponse = preloadResource;
            a(str2, "sir_res_fet_e");
            new StringBuilder("download asset resource error: ").append(th.toString());
            return webResourceResponse;
        }
    }

    public WebResourceResponse getPreloadResource(String str, String str2, String str3) {
        int i;
        boolean z;
        String str4;
        boolean z2;
        boolean z3;
        int i2;
        boolean z4;
        boolean z5;
        String str5;
        WebResourceResponse webResourceResponse;
        long uptimeMillis;
        ConcurrentHashMap c;
        boolean z6;
        Pair pair;
        Pair pair2;
        boolean z7;
        Class cls;
        Method declaredMethod;
        if (str == null || str.length() == 0 || str3 == null || str3.length() == 0) {
            return null;
        }
        String str6 = null;
        boolean z8 = false;
        boolean z9 = false;
        try {
            File file = new File(new File(this.d.getFilesDir(), "precache"), d(str));
            File file2 = new File(file, "assets_json");
            z8 = file.exists();
            try {
                z9 = file2.exists();
            } catch (Throwable th) {
                i = 0;
                z = z9;
                z9 = z8;
                str4 = str6;
                z2 = true;
                z3 = false;
                i2 = i;
                z4 = z;
                z5 = z9;
                str5 = str4;
                webResourceResponse = null;
                uptimeMillis = SystemClock.uptimeMillis();
                if (z5) {
                    c = c(str, str2);
                    if (str5 == null) {
                        webResourceResponse = a(str, str2, str3, null, null);
                        z6 = false;
                    } else {
                        synchronized (c) {
                            pair = (Pair) c.get(str5);
                            if (pair == null) {
                                pair = new Pair(Boolean.valueOf(false), null);
                                c.put(str5, pair);
                                pair2 = pair;
                            } else {
                                pair2 = pair;
                            }
                        }
                        if (((Boolean) pair2.first).booleanValue()) {
                            c.remove(str5);
                            webResourceResponse = (WebResourceResponse) pair2.second;
                            a(str2, "sir_res_quick_cost", str5, SystemClock.uptimeMillis() - uptimeMillis);
                            z6 = true;
                        } else {
                            webResourceResponse = a(str, str2, str3, null, null);
                            z6 = false;
                        }
                    }
                } else {
                    z6 = false;
                }
                if (webResourceResponse != null) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (z7) {
                    a(str2, "sir_res_cost", str5, SystemClock.uptimeMillis() - uptimeMillis);
                    if (f(this.r[e.b - 1])) {
                        try {
                            if (SystemClock.uptimeMillis() > this.u) {
                                cls = Class.forName("com.uc.apollo.Settings");
                                declaredMethod = cls.getDeclaredMethod("setOption", new Class[]{Integer.TYPE, String.class});
                                declaredMethod.invoke(cls, new Object[]{Integer.valueOf(1001), c()});
                                this.u = SystemClock.uptimeMillis() + 10000;
                                new Handler(Looper.getMainLooper()).postDelayed(new a(this, declaredMethod, cls), 10000);
                            }
                        } catch (Throwable th2) {
                        }
                    }
                }
                a(str2, "sir_hit", new UCHashMap().set("scope", str).set("file", str5).set("scopeDir", String.valueOf(z5)).set("jsonFile", String.valueOf(z4)).set("jsonSize", String.valueOf(i2)).set("inJson", String.valueOf(z3)).set("isHit", String.valueOf(z7)).set("isQuick", String.valueOf(z6)).set("isWrong", String.valueOf(z2)));
                return webResourceResponse;
            }
            try {
                str6 = d(str3);
            } catch (Throwable th3) {
                i = 0;
                z = z9;
                z9 = z8;
                str4 = str6;
                z2 = true;
                z3 = false;
                i2 = i;
                z4 = z;
                z5 = z9;
                str5 = str4;
                webResourceResponse = null;
                uptimeMillis = SystemClock.uptimeMillis();
                if (z5) {
                    c = c(str, str2);
                    if (str5 == null) {
                        webResourceResponse = a(str, str2, str3, null, null);
                        z6 = false;
                    } else {
                        synchronized (c) {
                            pair = (Pair) c.get(str5);
                            if (pair == null) {
                                pair = new Pair(Boolean.valueOf(false), null);
                                c.put(str5, pair);
                                pair2 = pair;
                            } else {
                                pair2 = pair;
                            }
                        }
                        if (((Boolean) pair2.first).booleanValue()) {
                            c.remove(str5);
                            webResourceResponse = (WebResourceResponse) pair2.second;
                            a(str2, "sir_res_quick_cost", str5, SystemClock.uptimeMillis() - uptimeMillis);
                            z6 = true;
                        } else {
                            webResourceResponse = a(str, str2, str3, null, null);
                            z6 = false;
                        }
                    }
                } else {
                    z6 = false;
                }
                if (webResourceResponse != null) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (z7) {
                    a(str2, "sir_res_cost", str5, SystemClock.uptimeMillis() - uptimeMillis);
                    if (f(this.r[e.b - 1])) {
                        if (SystemClock.uptimeMillis() > this.u) {
                            cls = Class.forName("com.uc.apollo.Settings");
                            declaredMethod = cls.getDeclaredMethod("setOption", new Class[]{Integer.TYPE, String.class});
                            declaredMethod.invoke(cls, new Object[]{Integer.valueOf(1001), c()});
                            this.u = SystemClock.uptimeMillis() + 10000;
                            new Handler(Looper.getMainLooper()).postDelayed(new a(this, declaredMethod, cls), 10000);
                        }
                    }
                }
                a(str2, "sir_hit", new UCHashMap().set("scope", str).set("file", str5).set("scopeDir", String.valueOf(z5)).set("jsonFile", String.valueOf(z4)).set("jsonSize", String.valueOf(i2)).set("inJson", String.valueOf(z3)).set("isHit", String.valueOf(z7)).set("isQuick", String.valueOf(z6)).set("isWrong", String.valueOf(z2)));
                return webResourceResponse;
            }
            try {
                JSONObject jSONObject = (JSONObject) this.m.get(str);
                if (z9 && jSONObject == null) {
                    jSONObject = b(file2);
                    if (jSONObject == null) {
                        jSONObject = new JSONObject();
                    }
                    this.m.put(str, jSONObject);
                }
                int length = jSONObject != null ? jSONObject.length() : 0;
                boolean z10 = length > 0 && jSONObject.optBoolean(str6, false);
                z2 = false;
                z3 = z10;
                i2 = length;
                z4 = z9;
                z5 = z8;
                str5 = str6;
            } catch (Throwable th4) {
                i = 0;
                z = z9;
                z9 = z8;
                str4 = str6;
                z2 = true;
                z3 = false;
                i2 = i;
                z4 = z;
                z5 = z9;
                str5 = str4;
                webResourceResponse = null;
                uptimeMillis = SystemClock.uptimeMillis();
                if (z5) {
                    z6 = false;
                } else {
                    c = c(str, str2);
                    if (str5 == null) {
                        synchronized (c) {
                            pair = (Pair) c.get(str5);
                            if (pair == null) {
                                pair2 = pair;
                            } else {
                                pair = new Pair(Boolean.valueOf(false), null);
                                c.put(str5, pair);
                                pair2 = pair;
                            }
                        }
                        if (((Boolean) pair2.first).booleanValue()) {
                            webResourceResponse = a(str, str2, str3, null, null);
                            z6 = false;
                        } else {
                            c.remove(str5);
                            webResourceResponse = (WebResourceResponse) pair2.second;
                            a(str2, "sir_res_quick_cost", str5, SystemClock.uptimeMillis() - uptimeMillis);
                            z6 = true;
                        }
                    } else {
                        webResourceResponse = a(str, str2, str3, null, null);
                        z6 = false;
                    }
                }
                if (webResourceResponse != null) {
                    z7 = false;
                } else {
                    z7 = true;
                }
                if (z7) {
                    a(str2, "sir_res_cost", str5, SystemClock.uptimeMillis() - uptimeMillis);
                    if (f(this.r[e.b - 1])) {
                        if (SystemClock.uptimeMillis() > this.u) {
                            cls = Class.forName("com.uc.apollo.Settings");
                            declaredMethod = cls.getDeclaredMethod("setOption", new Class[]{Integer.TYPE, String.class});
                            declaredMethod.invoke(cls, new Object[]{Integer.valueOf(1001), c()});
                            this.u = SystemClock.uptimeMillis() + 10000;
                            new Handler(Looper.getMainLooper()).postDelayed(new a(this, declaredMethod, cls), 10000);
                        }
                    }
                }
                a(str2, "sir_hit", new UCHashMap().set("scope", str).set("file", str5).set("scopeDir", String.valueOf(z5)).set("jsonFile", String.valueOf(z4)).set("jsonSize", String.valueOf(i2)).set("inJson", String.valueOf(z3)).set("isHit", String.valueOf(z7)).set("isQuick", String.valueOf(z6)).set("isWrong", String.valueOf(z2)));
                return webResourceResponse;
            }
        } catch (Throwable th5) {
            i = 0;
            z = z9;
            z9 = z8;
            str4 = str6;
            z2 = true;
            z3 = false;
            i2 = i;
            z4 = z;
            z5 = z9;
            str5 = str4;
            webResourceResponse = null;
            uptimeMillis = SystemClock.uptimeMillis();
            if (z5) {
                z6 = false;
            } else {
                c = c(str, str2);
                if (str5 == null) {
                    synchronized (c) {
                        pair = (Pair) c.get(str5);
                        if (pair == null) {
                            pair2 = pair;
                        } else {
                            pair = new Pair(Boolean.valueOf(false), null);
                            c.put(str5, pair);
                            pair2 = pair;
                        }
                    }
                    if (((Boolean) pair2.first).booleanValue()) {
                        webResourceResponse = a(str, str2, str3, null, null);
                        z6 = false;
                    } else {
                        c.remove(str5);
                        webResourceResponse = (WebResourceResponse) pair2.second;
                        a(str2, "sir_res_quick_cost", str5, SystemClock.uptimeMillis() - uptimeMillis);
                        z6 = true;
                    }
                } else {
                    webResourceResponse = a(str, str2, str3, null, null);
                    z6 = false;
                }
            }
            if (webResourceResponse != null) {
                z7 = false;
            } else {
                z7 = true;
            }
            if (z7) {
                a(str2, "sir_res_cost", str5, SystemClock.uptimeMillis() - uptimeMillis);
                if (f(this.r[e.b - 1])) {
                    if (SystemClock.uptimeMillis() > this.u) {
                        cls = Class.forName("com.uc.apollo.Settings");
                        declaredMethod = cls.getDeclaredMethod("setOption", new Class[]{Integer.TYPE, String.class});
                        declaredMethod.invoke(cls, new Object[]{Integer.valueOf(1001), c()});
                        this.u = SystemClock.uptimeMillis() + 10000;
                        new Handler(Looper.getMainLooper()).postDelayed(new a(this, declaredMethod, cls), 10000);
                    }
                }
            }
            a(str2, "sir_hit", new UCHashMap().set("scope", str).set("file", str5).set("scopeDir", String.valueOf(z5)).set("jsonFile", String.valueOf(z4)).set("jsonSize", String.valueOf(i2)).set("inJson", String.valueOf(z3)).set("isHit", String.valueOf(z7)).set("isQuick", String.valueOf(z6)).set("isWrong", String.valueOf(z2)));
            return webResourceResponse;
        }
        webResourceResponse = null;
        uptimeMillis = SystemClock.uptimeMillis();
        if (z5) {
            c = c(str, str2);
            if (str5 == null) {
                webResourceResponse = a(str, str2, str3, null, null);
                z6 = false;
            } else {
                synchronized (c) {
                    pair = (Pair) c.get(str5);
                    if (pair == null) {
                        pair = new Pair(Boolean.valueOf(false), null);
                        c.put(str5, pair);
                        pair2 = pair;
                    } else {
                        pair2 = pair;
                    }
                }
                if (((Boolean) pair2.first).booleanValue()) {
                    c.remove(str5);
                    webResourceResponse = (WebResourceResponse) pair2.second;
                    a(str2, "sir_res_quick_cost", str5, SystemClock.uptimeMillis() - uptimeMillis);
                    z6 = true;
                } else {
                    webResourceResponse = a(str, str2, str3, null, null);
                    z6 = false;
                }
            }
        } else {
            z6 = false;
        }
        if (webResourceResponse != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            a(str2, "sir_res_cost", str5, SystemClock.uptimeMillis() - uptimeMillis);
            if (f(this.r[e.b - 1])) {
                if (SystemClock.uptimeMillis() > this.u) {
                    cls = Class.forName("com.uc.apollo.Settings");
                    declaredMethod = cls.getDeclaredMethod("setOption", new Class[]{Integer.TYPE, String.class});
                    declaredMethod.invoke(cls, new Object[]{Integer.valueOf(1001), c()});
                    this.u = SystemClock.uptimeMillis() + 10000;
                    new Handler(Looper.getMainLooper()).postDelayed(new a(this, declaredMethod, cls), 10000);
                }
            }
        }
        if (!z5 || !z4 || i2 <= 0 || z3 || z7) {
            a(str2, "sir_hit", new UCHashMap().set("scope", str).set("file", str5).set("scopeDir", String.valueOf(z5)).set("jsonFile", String.valueOf(z4)).set("jsonSize", String.valueOf(i2)).set("inJson", String.valueOf(z3)).set("isHit", String.valueOf(z7)).set("isQuick", String.valueOf(z6)).set("isWrong", String.valueOf(z2)));
        }
        return webResourceResponse;
    }

    public String getPreloadResourcePath(String str, String str2, String str3) {
        String str4 = null;
        if (!(str == null || str.length() == 0 || str3 == null || str3.length() == 0)) {
            try {
                File d = d(d(str), d(str3));
                if (d.exists()) {
                    str4 = d.getAbsolutePath();
                }
            } catch (Throwable th) {
            }
        }
        return str4;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final com.uc.webview.export.WebResourceResponse a(java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24) {
        /*
        r19 = this;
        r9 = 0;
        r0 = r19;
        r4 = r0.d;
        if (r4 != 0) goto L_0x0009;
    L_0x0007:
        r4 = 0;
    L_0x0008:
        return r4;
    L_0x0009:
        r12 = android.os.SystemClock.uptimeMillis();
        if (r23 == 0) goto L_0x0019;
    L_0x000f:
        if (r23 == 0) goto L_0x0017;
    L_0x0011:
        r4 = r23.isEmpty();	 Catch:{ IOException -> 0x0233, Exception -> 0x0243 }
        if (r4 == 0) goto L_0x001e;
    L_0x0017:
        r4 = 0;
        goto L_0x0008;
    L_0x0019:
        r23 = r19.d(r20);	 Catch:{ IOException -> 0x0233, Exception -> 0x0243 }
        goto L_0x000f;
    L_0x001e:
        if (r24 == 0) goto L_0x0038;
    L_0x0020:
        r0 = r19;
        r4 = r0.k;	 Catch:{ IOException -> 0x0233, Exception -> 0x0243 }
        r0 = r23;
        r4 = r4.get(r0);	 Catch:{ IOException -> 0x0233, Exception -> 0x0243 }
        r4 = (java.util.HashSet) r4;	 Catch:{ IOException -> 0x0233, Exception -> 0x0243 }
        if (r4 == 0) goto L_0x0041;
    L_0x002e:
        r0 = r24;
        r4 = r4.contains(r0);	 Catch:{ IOException -> 0x0233, Exception -> 0x0243 }
        if (r4 != 0) goto L_0x0041;
    L_0x0036:
        r4 = 0;
        goto L_0x0008;
    L_0x0038:
        r0 = r19;
        r1 = r22;
        r24 = r0.d(r1);	 Catch:{ IOException -> 0x0233, Exception -> 0x0243 }
        goto L_0x0020;
    L_0x0041:
        r0 = r19;
        r1 = r23;
        r2 = r24;
        r10 = r0.d(r1, r2);	 Catch:{ IOException -> 0x0233, Exception -> 0x0243 }
        r6 = new java.io.File;	 Catch:{ IOException -> 0x0233, Exception -> 0x0243 }
        r4 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0233, Exception -> 0x0243 }
        r4.<init>();	 Catch:{ IOException -> 0x0233, Exception -> 0x0243 }
        r5 = r10.getAbsolutePath();	 Catch:{ IOException -> 0x0233, Exception -> 0x0243 }
        r4 = r4.append(r5);	 Catch:{ IOException -> 0x0233, Exception -> 0x0243 }
        r5 = ".hj";
        r4 = r4.append(r5);	 Catch:{ IOException -> 0x0233, Exception -> 0x0243 }
        r4 = r4.toString();	 Catch:{ IOException -> 0x0233, Exception -> 0x0243 }
        r6.<init>(r4);	 Catch:{ IOException -> 0x0233, Exception -> 0x0243 }
        r4 = r10.exists();	 Catch:{ IOException -> 0x0233, Exception -> 0x0243 }
        if (r4 == 0) goto L_0x0219;
    L_0x006d:
        r4 = r6.exists();	 Catch:{ IOException -> 0x0233, Exception -> 0x0243 }
        if (r4 == 0) goto L_0x0219;
    L_0x0073:
        r4 = new java.io.FileInputStream;	 Catch:{ IOException -> 0x0233, Exception -> 0x0243 }
        r4.<init>(r10);	 Catch:{ IOException -> 0x0233, Exception -> 0x0243 }
        r11 = new java.io.BufferedInputStream;	 Catch:{ IOException -> 0x0233, Exception -> 0x0243 }
        r11.<init>(r4);	 Catch:{ IOException -> 0x0233, Exception -> 0x0243 }
        r8 = 0;
        r4 = 0;
        r5 = 0;
        r7 = r6.exists();	 Catch:{ Throwable -> 0x01ab }
        if (r7 == 0) goto L_0x026c;
    L_0x0086:
        r0 = r19;
        r14 = r0.b(r6);	 Catch:{ Throwable -> 0x01ab }
        if (r14 == 0) goto L_0x026c;
    L_0x008e:
        r6 = r14.keys();	 Catch:{ Throwable -> 0x01ab }
        r6 = r6.hasNext();	 Catch:{ Throwable -> 0x01ab }
        if (r6 == 0) goto L_0x026c;
    L_0x0098:
        r7 = new com.uc.webview.export.cyclone.UCHashMap;	 Catch:{ Throwable -> 0x01ab }
        r7.<init>();	 Catch:{ Throwable -> 0x01ab }
        r15 = r14.keys();	 Catch:{ Throwable -> 0x01ab }
        r6 = r4;
    L_0x00a2:
        r4 = r15.hasNext();	 Catch:{ Throwable -> 0x0257 }
        if (r4 == 0) goto L_0x00f3;
    L_0x00a8:
        r4 = r15.next();	 Catch:{ Throwable -> 0x0257 }
        r16 = java.lang.String.valueOf(r4);	 Catch:{ Throwable -> 0x0257 }
        if (r16 == 0) goto L_0x0269;
    L_0x00b2:
        r4 = c;	 Catch:{ Throwable -> 0x0257 }
        r17 = r16.toLowerCase();	 Catch:{ Throwable -> 0x0257 }
        r0 = r17;
        r4 = r4.get(r0);	 Catch:{ Throwable -> 0x0257 }
        r4 = (java.lang.Boolean) r4;	 Catch:{ Throwable -> 0x0257 }
        if (r4 == 0) goto L_0x0269;
    L_0x00c2:
        r4 = r4.booleanValue();	 Catch:{ Throwable -> 0x0257 }
        if (r4 == 0) goto L_0x0269;
    L_0x00c8:
        r0 = r16;
        r4 = r14.get(r0);	 Catch:{ Throwable -> 0x0257 }
        r4 = (java.lang.String) r4;	 Catch:{ Throwable -> 0x0257 }
        if (r4 == 0) goto L_0x0269;
    L_0x00d2:
        r0 = r16;
        r7.put(r0, r4);	 Catch:{ Throwable -> 0x0257 }
        r16 = "content-type";
        r0 = r17;
        r1 = r16;
        r16 = r0.equals(r1);	 Catch:{ Throwable -> 0x0257 }
        if (r16 == 0) goto L_0x00e5;
    L_0x00e3:
        r6 = r4;
        goto L_0x00a2;
    L_0x00e5:
        r16 = "via";
        r0 = r17;
        r1 = r16;
        r16 = r0.equals(r1);	 Catch:{ Throwable -> 0x0257 }
        if (r16 == 0) goto L_0x0269;
    L_0x00f1:
        r5 = r4;
        goto L_0x00a2;
    L_0x00f3:
        r4 = r7.isEmpty();	 Catch:{ Throwable -> 0x0257 }
        if (r4 != 0) goto L_0x0265;
    L_0x00f9:
        r4 = r6;
        r6 = r7;
    L_0x00fb:
        r7 = r5;
        r18 = r4;
        r4 = r6;
        r6 = r18;
    L_0x0101:
        if (r4 != 0) goto L_0x0262;
    L_0x0103:
        r4 = new com.uc.webview.export.cyclone.UCHashMap;	 Catch:{ IOException -> 0x0233, Exception -> 0x0243 }
        r4.<init>();	 Catch:{ IOException -> 0x0233, Exception -> 0x0243 }
        r8 = r4;
    L_0x0109:
        r4 = "";
        r5 = "";
        r14 = java.util.Locale.CHINA;	 Catch:{ Throwable -> 0x01ba }
        r14 = java.util.Calendar.getInstance(r14);	 Catch:{ Throwable -> 0x01ba }
        r16 = r10.lastModified();	 Catch:{ Throwable -> 0x01ba }
        r0 = r16;
        r14.setTimeInMillis(r0);	 Catch:{ Throwable -> 0x01ba }
        r15 = r14.getTime();	 Catch:{ Throwable -> 0x01ba }
        r4 = r15.toString();	 Catch:{ Throwable -> 0x01ba }
        r16 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x01ba }
        r0 = r16;
        r14.setTimeInMillis(r0);	 Catch:{ Throwable -> 0x01ba }
        r14 = r14.getTime();	 Catch:{ Throwable -> 0x01ba }
        r5 = r14.toString();	 Catch:{ Throwable -> 0x01ba }
        r18 = r5;
        r5 = r4;
        r4 = r18;
    L_0x013a:
        r14 = "Content-Length";
        r16 = r10.length();	 Catch:{ IOException -> 0x0233, Exception -> 0x0243 }
        r10 = java.lang.String.valueOf(r16);	 Catch:{ IOException -> 0x0233, Exception -> 0x0243 }
        r10 = r8.set(r14, r10);	 Catch:{ IOException -> 0x0233, Exception -> 0x0243 }
        r14 = "Last-Modified";
        r5 = r10.set(r14, r5);	 Catch:{ IOException -> 0x0233, Exception -> 0x0243 }
        r10 = "Date";
        r5 = r5.set(r10, r4);	 Catch:{ IOException -> 0x0233, Exception -> 0x0243 }
        r10 = "Via";
        r14 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0233, Exception -> 0x0243 }
        r4 = "1.0 uc-sir-prefetch";
        r14.<init>(r4);	 Catch:{ IOException -> 0x0233, Exception -> 0x0243 }
        if (r7 != 0) goto L_0x01c2;
    L_0x015f:
        r4 = "";
    L_0x0161:
        r4 = r14.append(r4);	 Catch:{ IOException -> 0x0233, Exception -> 0x0243 }
        r4 = r4.toString();	 Catch:{ IOException -> 0x0233, Exception -> 0x0243 }
        r5.set(r10, r4);	 Catch:{ IOException -> 0x0233, Exception -> 0x0243 }
        r4 = 0;
        r5 = 0;
        if (r6 == 0) goto L_0x025f;
    L_0x0170:
        r7 = 59;
        r7 = r6.indexOf(r7);	 Catch:{ IOException -> 0x0233, Exception -> 0x0243 }
        r10 = -1;
        if (r7 != r10) goto L_0x01d2;
    L_0x0179:
        r7 = 47;
        r7 = r6.indexOf(r7);	 Catch:{ IOException -> 0x0233, Exception -> 0x0243 }
        r10 = -1;
        if (r7 == r10) goto L_0x01d2;
    L_0x0182:
        r4 = new com.uc.webview.export.WebResourceResponse;	 Catch:{ IOException -> 0x0233, Exception -> 0x0243 }
        if (r6 != 0) goto L_0x018a;
    L_0x0186:
        r6 = b(r22);	 Catch:{ IOException -> 0x0233, Exception -> 0x0243 }
    L_0x018a:
        if (r5 != 0) goto L_0x018e;
    L_0x018c:
        r5 = "utf-8";
    L_0x018e:
        r4.<init>(r6, r5, r11);	 Catch:{ IOException -> 0x0233, Exception -> 0x0243 }
        r4.setResponseHeaders(r8);	 Catch:{ IOException -> 0x0255, Exception -> 0x0252 }
        r10 = r4;
        r7 = r24;
    L_0x0197:
        if (r10 == 0) goto L_0x01a8;
    L_0x0199:
        r6 = "sir_res_slow_cost";
        r4 = android.os.SystemClock.uptimeMillis();
        r8 = r4 - r12;
        r4 = r19;
        r5 = r21;
        r4.a(r5, r6, r7, r8);
    L_0x01a8:
        r4 = r10;
        goto L_0x0008;
    L_0x01ab:
        r6 = move-exception;
        r6 = r4;
    L_0x01ad:
        r4 = "sir_hea_rea_e";
        r0 = r19;
        r1 = r21;
        r0.a(r1, r4);	 Catch:{ IOException -> 0x0233, Exception -> 0x0243 }
        r7 = r5;
        r4 = r8;
        goto L_0x0101;
    L_0x01ba:
        r14 = move-exception;
        r18 = r5;
        r5 = r4;
        r4 = r18;
        goto L_0x013a;
    L_0x01c2:
        r4 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0233, Exception -> 0x0243 }
        r15 = ", ";
        r4.<init>(r15);	 Catch:{ IOException -> 0x0233, Exception -> 0x0243 }
        r4 = r4.append(r7);	 Catch:{ IOException -> 0x0233, Exception -> 0x0243 }
        r4 = r4.toString();	 Catch:{ IOException -> 0x0233, Exception -> 0x0243 }
        goto L_0x0161;
    L_0x01d2:
        r7 = ";";
        r10 = r6.split(r7);	 Catch:{ IOException -> 0x0233, Exception -> 0x0243 }
        if (r10 == 0) goto L_0x025f;
    L_0x01da:
        r6 = r10.length;	 Catch:{ IOException -> 0x0233, Exception -> 0x0243 }
        if (r6 <= 0) goto L_0x025f;
    L_0x01dd:
        r14 = r10.length;	 Catch:{ IOException -> 0x0233, Exception -> 0x0243 }
        r6 = 0;
        r7 = r6;
        r6 = r4;
        r4 = r5;
    L_0x01e2:
        if (r7 >= r14) goto L_0x025c;
    L_0x01e4:
        r5 = r10[r7];	 Catch:{ IOException -> 0x0233, Exception -> 0x0243 }
        r15 = 47;
        r15 = r5.indexOf(r15);	 Catch:{ IOException -> 0x0233, Exception -> 0x0243 }
        r16 = -1;
        r0 = r16;
        if (r15 == r0) goto L_0x01f7;
    L_0x01f2:
        r6 = r7 + 1;
        r7 = r6;
        r6 = r5;
        goto L_0x01e2;
    L_0x01f7:
        r5 = r5.trim();	 Catch:{ IOException -> 0x0233, Exception -> 0x0243 }
        r5 = r5.toLowerCase();	 Catch:{ IOException -> 0x0233, Exception -> 0x0243 }
        r15 = "charset=";
        r15 = r5.startsWith(r15);	 Catch:{ IOException -> 0x0233, Exception -> 0x0243 }
        if (r15 == 0) goto L_0x025a;
    L_0x0207:
        r15 = r5.length();	 Catch:{ IOException -> 0x0233, Exception -> 0x0243 }
        r16 = 8;
        r0 = r16;
        if (r15 <= r0) goto L_0x025a;
    L_0x0211:
        r4 = 8;
        r4 = r5.substring(r4);	 Catch:{ IOException -> 0x0233, Exception -> 0x0243 }
        r5 = r6;
        goto L_0x01f2;
    L_0x0219:
        r4 = r10.exists();	 Catch:{ IOException -> 0x0233, Exception -> 0x0243 }
        if (r4 == 0) goto L_0x022e;
    L_0x021f:
        r4 = r6.exists();	 Catch:{ IOException -> 0x0233, Exception -> 0x0243 }
        if (r4 != 0) goto L_0x022e;
    L_0x0225:
        r4 = "sir_ass_no_hj_e";
        r0 = r19;
        r1 = r21;
        r0.a(r1, r4);	 Catch:{ IOException -> 0x0233, Exception -> 0x0243 }
    L_0x022e:
        r10 = r9;
        r7 = r24;
        goto L_0x0197;
    L_0x0233:
        r4 = move-exception;
        r4 = r9;
    L_0x0235:
        r5 = "sir_res_io_e";
        r0 = r19;
        r1 = r21;
        r0.a(r1, r5);
        r10 = r4;
        r7 = r24;
        goto L_0x0197;
    L_0x0243:
        r4 = move-exception;
    L_0x0244:
        r4 = "sir_res_e";
        r0 = r19;
        r1 = r21;
        r0.a(r1, r4);
        r10 = r9;
        r7 = r24;
        goto L_0x0197;
    L_0x0252:
        r5 = move-exception;
        r9 = r4;
        goto L_0x0244;
    L_0x0255:
        r5 = move-exception;
        goto L_0x0235;
    L_0x0257:
        r4 = move-exception;
        goto L_0x01ad;
    L_0x025a:
        r5 = r6;
        goto L_0x01f2;
    L_0x025c:
        r5 = r4;
        goto L_0x0182;
    L_0x025f:
        r6 = r4;
        goto L_0x0182;
    L_0x0262:
        r8 = r4;
        goto L_0x0109;
    L_0x0265:
        r4 = r6;
        r6 = r8;
        goto L_0x00fb;
    L_0x0269:
        r4 = r5;
        goto L_0x00f1;
    L_0x026c:
        r6 = r8;
        goto L_0x00fb;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.webview.browser.internal.PreloadManager.a(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):com.uc.webview.export.WebResourceResponse");
    }

    public void callback(String str, ValueCallback<Pair<Boolean, String>> valueCallback, Boolean bool, String str2, int i, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4, int i2, int i3) {
        if (valueCallback != null) {
            try {
                valueCallback.onReceiveValue(new Pair(bool, String.valueOf(i) + ":" + str2));
            } catch (Throwable th) {
            }
        }
        try {
            UCHashMap uCHashMap = new UCHashMap().set("scope", str3).set("key", str4).set("hasChecked", String.valueOf(z)).set("isPrefetched", String.valueOf(z2)).set("hasScopeDir", String.valueOf(z3)).set("hasAssets", String.valueOf(z4)).set("downloadCnt", String.valueOf(i2)).set("finishedCnt", String.valueOf(i3)).set("ok", bool.booleanValue() ? SettingsConst.TRUE : SettingsConst.FALSE).set("errCode", String.valueOf(i));
            String str5 = "reason";
            if (str2 == null) {
                str2 = "";
            } else if (str2.length() >= 40) {
                str2 = str2.substring(0, 40);
            }
            a(str, "sir_callback", uCHashMap.set(str5, str2));
        } catch (Throwable th2) {
        }
    }

    public void prefetchScope(String str, String str2, ValueCallback<Pair<Boolean, String>> valueCallback) {
        String str3 = "unknown";
        if (str2 == null || str2.trim().length() == 0) {
            callback(str, valueCallback, Boolean.valueOf(false), str2 + ":valueAsJson not valid.", 2, str3, BrowserPreloader.CDKEY_SIR_PREFETCH, false, false, false, false, 0, 0);
            return;
        }
        String optString;
        try {
            JSONObject jSONObject = new JSONObject(str2);
            if (jSONObject.has("business") || jSONObject.optString("business").length() > 0) {
                optString = jSONObject.optString("business");
            } else {
                optString = str;
            }
            try {
                a(optString, "sir_fet_cmd");
                if (!jSONObject.has("scope") || jSONObject.optString("scope").length() <= 0) {
                    callback(optString, valueCallback, Boolean.valueOf(false), "scope not specified.", 3, str3, BrowserPreloader.CDKEY_SIR_PREFETCH, false, false, false, false, 0, 0);
                    return;
                }
                str3 = jSONObject.optString("scope");
                if (!jSONObject.has("netType") || jSONObject.optString("netType").length() <= 0) {
                    callback(optString, valueCallback, Boolean.valueOf(false), "netType not specified.", 4, str3, BrowserPreloader.CDKEY_SIR_PREFETCH, false, false, false, false, 0, 0);
                } else if (!jSONObject.has("startDate") || jSONObject.optString("startDate").length() <= 0) {
                    callback(optString, valueCallback, Boolean.valueOf(false), "startDate not specified.", 5, str3, BrowserPreloader.CDKEY_SIR_PREFETCH, false, false, false, false, 0, 0);
                } else if (!jSONObject.has("endDate") || jSONObject.optString("endDate").length() <= 0) {
                    callback(optString, valueCallback, Boolean.valueOf(false), "endDate not specified.", 6, str3, BrowserPreloader.CDKEY_SIR_PREFETCH, false, false, false, false, 0, 0);
                } else if (!jSONObject.has("expireDate") || jSONObject.optString("expireDate").length() <= 0) {
                    callback(optString, valueCallback, Boolean.valueOf(false), "expireDate not specified.", 7, str3, BrowserPreloader.CDKEY_SIR_PREFETCH, false, false, false, false, 0, 0);
                } else if ((!jSONObject.has("content") || jSONObject.optString("content").length() <= 0) && (!jSONObject.has("jsonContent") || jSONObject.optString("jsonContent").length() <= 0)) {
                    callback(optString, valueCallback, Boolean.valueOf(false), "content or jsonContent not specified.", 8, str3, BrowserPreloader.CDKEY_SIR_PREFETCH, false, false, false, false, 0, 0);
                } else {
                    if (jSONObject.has("expandExpire") && jSONObject.optString("expandExpire").equals("true") && this.g != null) {
                        String optString2 = jSONObject.optString("expireDate");
                        JSONObject optJSONObject = this.g.optJSONObject(str3);
                        if (optJSONObject != null && optJSONObject.has("expireDate")) {
                            String optString3 = optJSONObject.optString("expireDate");
                            if (optString3.length() > 0) {
                                try {
                                    if (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(optString3).after(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(optString2))) {
                                        jSONObject.put("expireDate", optString3);
                                    }
                                } catch (Exception e) {
                                    a(com.uc.webview.export.internal.interfaces.IPreloadManager.SIR_COMMON_TYPE, "sir_date_e");
                                }
                            }
                        }
                    }
                    if (a(jSONObject)) {
                        a(str3, optString, null);
                        callback(optString, valueCallback, Boolean.valueOf(false), jSONObject.optString("expireDate") + ":expireDate is reached.", 9, str3, BrowserPreloader.CDKEY_SIR_PREFETCH, false, false, false, false, 0, 0);
                    } else if (jSONObject.has("active") && jSONObject.optString("active").equals("false")) {
                        a(str3, optString, null);
                        callback(optString, valueCallback, Boolean.valueOf(false), "not active.", 12, str3, BrowserPreloader.CDKEY_SIR_PREFETCH, false, false, false, false, 0, 0);
                    } else {
                        jSONObject.remove("scope");
                        synchronized (this.g) {
                            this.g.putOpt(str3, jSONObject);
                            this.f.c = true;
                        }
                        String optString4 = jSONObject.optString("jsonContent");
                        String optString5 = jSONObject.optString("content");
                        if (this.d != null) {
                            new Thread(new f(this, str3, optString, optString4, optString5, jSONObject, valueCallback)).start();
                        }
                    }
                }
            } catch (JSONException e2) {
            }
        } catch (JSONException e3) {
            optString = str;
            callback(optString, valueCallback, Boolean.valueOf(false), str2 + ":format not a json.", 10, str3, BrowserPreloader.CDKEY_SIR_PREFETCH, false, false, false, false, 0, 0);
            a(optString, "sir_fet_j_e");
        }
    }

    public void deleteScope(String str, String str2, ValueCallback<Pair<Boolean, String>> valueCallback) {
        a(str, "sir_del_cmd");
        String str3 = "unknown";
        if (str2 == null || str2.trim().length() == 0) {
            callback(str, valueCallback, Boolean.valueOf(false), str2 + ":valueAsJson not valid.", 2, str3, BrowserPreloader.CDKEY_SIR_DELETE, false, false, false, false, 0, 0);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            if (!jSONObject.has("scope") || jSONObject.optString("scope").length() <= 0) {
                callback(str, valueCallback, Boolean.valueOf(false), "scope not specified.", 3, str3, BrowserPreloader.CDKEY_SIR_DELETE, false, false, false, false, 0, 0);
                return;
            }
            a(jSONObject.optString("scope"), str, (ValueCallback) valueCallback);
        } catch (JSONException e) {
            callback(str, valueCallback, Boolean.valueOf(false), str2 + ":format not a json.", 10, str3, BrowserPreloader.CDKEY_SIR_DELETE, false, false, false, false, 0, 0);
            a(str, "sir_del_j_e");
        }
    }

    public void deletePreloadResource(String str, String str2, String str3) {
        if (str != null) {
            if (str3 == null || str3.isEmpty()) {
                a(str, str2, null);
                return;
            }
            try {
                a(str2, "sir_del_ass_cmd");
                File file = new File(this.d.getFilesDir(), "precache");
                String d = d(str);
                File file2 = new File(file, d);
                file = new File(file2, d(str3));
                File file3 = new File(file.getAbsolutePath() + ".zlst");
                File d2 = d(d, "all_done");
                if (file.exists()) {
                    file.delete();
                    d2.delete();
                } else if (file3.exists()) {
                    ArrayList c = c(file3);
                    if (c != null) {
                        Iterator it = c.iterator();
                        while (it.hasNext()) {
                            new File((String) it.next()).delete();
                        }
                    }
                    file3.delete();
                    d2.delete();
                }
                a(str2, "sir_del_ass_cmd_succ");
                Object obj = 1;
                if (file2.list() != null) {
                    for (String endsWith : file2.list()) {
                        if (!endsWith.endsWith(".zlst")) {
                            obj = null;
                            break;
                        }
                    }
                }
                if (obj != null) {
                    a(str, str2, null);
                }
            } catch (Throwable th) {
                new StringBuilder("remove specified scope url error: ").append(th.toString());
            }
        }
    }

    private void a(String str, String str2, ValueCallback<Pair<Boolean, String>> valueCallback) {
        a(str2, "sir_del_cmd");
        if (this.d != null) {
            this.f.a.add(str);
            Thread thread = new Thread(this.f);
            this.f.b = new b(this, str2, valueCallback, str);
            thread.start();
        }
    }

    private boolean a(JSONObject jSONObject) {
        if (!jSONObject.has("expireDate")) {
            return false;
        }
        String optString = jSONObject.optString("expireDate");
        if (optString.length() <= 0) {
            return false;
        }
        try {
            if (new Date().after(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(optString))) {
                return true;
            }
            return false;
        } catch (Exception e) {
            a(com.uc.webview.export.internal.interfaces.IPreloadManager.SIR_COMMON_TYPE, "sir_date_e");
            return false;
        }
    }

    private static String b(String str) {
        String fileExtensionFromUrl;
        if (BrowserCore.isCoreInited()) {
            fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        } else {
            fileExtensionFromUrl = android.webkit.MimeTypeMap.getFileExtensionFromUrl(str);
        }
        if (fileExtensionFromUrl == null) {
            return null;
        }
        if (fileExtensionFromUrl.equals("js")) {
            return "text/javascript";
        }
        if (fileExtensionFromUrl.equals("html") || fileExtensionFromUrl.equals("htm")) {
            return "text/html";
        }
        if (fileExtensionFromUrl.equals("css")) {
            return "text/css";
        }
        if (fileExtensionFromUrl.equals("svg")) {
            return "image/svg+xml";
        }
        if (fileExtensionFromUrl.equals("png")) {
            return "image/png";
        }
        if (fileExtensionFromUrl.equals("gif")) {
            return "image/gif";
        }
        if (fileExtensionFromUrl.equals("jpeg") || fileExtensionFromUrl.equals("jpg")) {
            return "image/jpeg";
        }
        if (BrowserCore.isCoreInited()) {
            return MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
        }
        return android.webkit.MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
    }

    private static String[] b(JSONObject jSONObject, String str, String str2) throws JSONException {
        if (jSONObject == null) {
            jSONObject = new JSONObject(str);
        }
        if (!jSONObject.has(str2)) {
            return null;
        }
        JSONArray jSONArray = jSONObject.getJSONArray(str2);
        if (jSONArray.length() <= 0) {
            return null;
        }
        String[] strArr = new String[jSONArray.length()];
        for (int i = 0; i < jSONArray.length(); i++) {
            strArr[i] = jSONArray.optString(i);
        }
        return strArr;
    }

    @Constant
    public void deleteAllScope() {
        try {
            UCCyclone.recursiveDelete(new File(this.d.getFilesDir(), "precache"), true, null);
        } catch (Throwable th) {
            a(com.uc.webview.export.internal.interfaces.IPreloadManager.SIR_COMMON_TYPE, "sir_io_e");
        }
    }

    private JSONObject b(File file) {
        JSONObject jSONObject;
        if (!file.exists()) {
            return null;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            StringBuilder stringBuilder = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    stringBuilder.append(readLine);
                    stringBuilder.append('\n');
                } else {
                    jSONObject = new JSONObject(stringBuilder.toString());
                    try {
                        bufferedReader.close();
                        return jSONObject;
                    } catch (JSONException e) {
                        a(com.uc.webview.export.internal.interfaces.IPreloadManager.SIR_COMMON_TYPE, "sir_json_e");
                        return jSONObject;
                    } catch (FileNotFoundException e2) {
                        a(com.uc.webview.export.internal.interfaces.IPreloadManager.SIR_COMMON_TYPE, "sir_not_found_e");
                        return jSONObject;
                    } catch (IOException e3) {
                        a(com.uc.webview.export.internal.interfaces.IPreloadManager.SIR_COMMON_TYPE, "sir_io_e");
                        return jSONObject;
                    }
                }
            }
        } catch (JSONException e4) {
            jSONObject = null;
            a(com.uc.webview.export.internal.interfaces.IPreloadManager.SIR_COMMON_TYPE, "sir_json_e");
            return jSONObject;
        } catch (FileNotFoundException e5) {
            jSONObject = null;
            a(com.uc.webview.export.internal.interfaces.IPreloadManager.SIR_COMMON_TYPE, "sir_not_found_e");
            return jSONObject;
        } catch (IOException e6) {
            jSONObject = null;
            a(com.uc.webview.export.internal.interfaces.IPreloadManager.SIR_COMMON_TYPE, "sir_io_e");
            return jSONObject;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.ArrayList<java.lang.String> c(java.io.File r4) {
        /*
        r2 = 0;
        r3 = new java.io.FileInputStream;	 Catch:{ Throwable -> 0x003d, all -> 0x002f }
        r3.<init>(r4);	 Catch:{ Throwable -> 0x003d, all -> 0x002f }
        r1 = new java.io.BufferedReader;	 Catch:{ Throwable -> 0x0041, all -> 0x0038 }
        r0 = new java.io.InputStreamReader;	 Catch:{ Throwable -> 0x0041, all -> 0x0038 }
        r0.<init>(r3);	 Catch:{ Throwable -> 0x0041, all -> 0x0038 }
        r1.<init>(r0);	 Catch:{ Throwable -> 0x0041, all -> 0x0038 }
        r0 = new java.util.ArrayList;	 Catch:{ Throwable -> 0x0046, all -> 0x003a }
        r0.<init>();	 Catch:{ Throwable -> 0x0046, all -> 0x003a }
    L_0x0015:
        r2 = r1.readLine();	 Catch:{ Throwable -> 0x001f, all -> 0x003a }
        if (r2 == 0) goto L_0x0028;
    L_0x001b:
        r0.add(r2);	 Catch:{ Throwable -> 0x001f, all -> 0x003a }
        goto L_0x0015;
    L_0x001f:
        r2 = move-exception;
        r2 = r3;
    L_0x0021:
        com.uc.webview.export.cyclone.UCCyclone.close(r1);
        com.uc.webview.export.cyclone.UCCyclone.close(r2);
    L_0x0027:
        return r0;
    L_0x0028:
        com.uc.webview.export.cyclone.UCCyclone.close(r1);
        com.uc.webview.export.cyclone.UCCyclone.close(r3);
        goto L_0x0027;
    L_0x002f:
        r0 = move-exception;
        r3 = r2;
    L_0x0031:
        com.uc.webview.export.cyclone.UCCyclone.close(r2);
        com.uc.webview.export.cyclone.UCCyclone.close(r3);
        throw r0;
    L_0x0038:
        r0 = move-exception;
        goto L_0x0031;
    L_0x003a:
        r0 = move-exception;
        r2 = r1;
        goto L_0x0031;
    L_0x003d:
        r0 = move-exception;
        r1 = r2;
        r0 = r2;
        goto L_0x0021;
    L_0x0041:
        r0 = move-exception;
        r1 = r2;
        r0 = r2;
        r2 = r3;
        goto L_0x0021;
    L_0x0046:
        r0 = move-exception;
        r0 = r2;
        r2 = r3;
        goto L_0x0021;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.webview.browser.internal.PreloadManager.c(java.io.File):java.util.ArrayList<java.lang.String>");
    }

    private static String c(String str) {
        String str2 = ".unknown";
        if (str == null || str.length() == 0) {
            return str2;
        }
        int indexOf = str.indexOf(63);
        if (indexOf >= 0) {
            str = str.substring(0, indexOf);
        }
        indexOf = str.lastIndexOf(47);
        if (indexOf >= 0) {
            str = str.substring(indexOf + 1);
        }
        indexOf = str.lastIndexOf(46);
        if (indexOf >= 0) {
            return str.substring(indexOf);
        }
        return str2;
    }

    private String d(String str) {
        int i = 0;
        if (str != null) {
            try {
                if (str.trim().length() != 0) {
                    try {
                        return b(new URL(str));
                    } catch (Throwable th) {
                        String str2;
                        a(com.uc.webview.export.internal.interfaces.IPreloadManager.SIR_COMMON_TYPE, "sir_url_e");
                        int indexOf = str.indexOf(63);
                        String str3 = "";
                        if (indexOf != -1) {
                            String substring = str.substring(0, indexOf);
                            if (indexOf + 1 < str.length()) {
                                String[] split = str.substring(indexOf + 1).split("&");
                                int length = split.length;
                                for (indexOf = i; indexOf < length; indexOf++) {
                                    str2 = split[indexOf];
                                    if (str2 != null && str2.startsWith("__hash=")) {
                                        str = substring;
                                        break;
                                    }
                                }
                                str2 = str3;
                                str = substring;
                            } else {
                                str2 = str3;
                                str = substring;
                            }
                        } else {
                            str2 = str3;
                        }
                        return "f" + str.hashCode() + "_" + str2.hashCode() + c(str);
                    }
                }
            } catch (RuntimeException e) {
                a(com.uc.webview.export.internal.interfaces.IPreloadManager.SIR_COMMON_TYPE, "sir_hash_e");
                throw e;
            }
        }
        return "null_0";
    }

    private String b(URL url) {
        int length;
        String str = "-0";
        String query = url.getQuery();
        if (query != null) {
            for (String query2 : query2.split("&")) {
                if (query2 != null && query2.startsWith("__hash=")) {
                    break;
                }
            }
        }
        query2 = str;
        query2 = url.getAuthority() + url.getPath() + query2;
        if (query2.endsWith("/")) {
            query2 = query2.substring(0, query2.length() - 1);
        }
        str = "f";
        if (this.h.containsKey(query2)) {
            return (String) this.h.get(query2);
        }
        length = query2.length() / 2;
        str = ((str + String.valueOf(query2.substring(0, length).hashCode())) + String.valueOf(query2.substring(length).hashCode())) + c(url.toString());
        if (this.h.size() > LogType.UNEXP) {
            this.h.clear();
        }
        this.h.put(query2, str);
        return str;
    }

    private File d(String str, String str2) {
        return new File(new File(new File(this.d.getFilesDir(), "precache"), str), str2);
    }

    private String c() {
        try {
            File file = new File(this.d.getFilesDir(), "precache");
            File file2 = new File(file, "sir_video_preload_1");
            if (file2.exists()) {
                return "sir_video_preload_1";
            }
            File file3 = new File(file, "sir_video_preload_0");
            if (file3.exists()) {
                return "sir_video_preload_0";
            }
            file.mkdirs();
            if (Math.random() > 0.5d) {
                file2.createNewFile();
                return "sir_video_preload_1";
            }
            file3.createNewFile();
            return "sir_video_preload_0";
        } catch (Throwable th) {
            return "sir_video_preload_2";
        }
    }

    private File d() {
        return new File(new File(this.d.getFilesDir(), "precache"), "tmp");
    }

    private File e() {
        return new File(d(), String.valueOf(Process.myPid()));
    }

    private static ArrayList<String> b(File file, File file2) throws Throwable {
        Closeable closeable;
        Throwable th;
        Closeable closeable2 = null;
        ArrayList<String> arrayList = new ArrayList();
        if (!file2.exists()) {
            file2.mkdirs();
        }
        Closeable bufferedInputStream;
        try {
            Closeable zipFile = new ZipFile(file);
            try {
                Enumeration entries = zipFile.entries();
                closeable = null;
                while (entries.hasMoreElements()) {
                    ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                    if (zipEntry.getName().contains("..")) {
                        throw new IOException("zip list has dis law directory ..");
                    }
                    try {
                        bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(zipEntry));
                        try {
                            byte[] bArr = new byte[262144];
                            File file3 = new File(file2, zipEntry.getName());
                            if (zipEntry.isDirectory()) {
                                file3.mkdirs();
                                closeable2 = bufferedInputStream;
                            } else {
                                if (!file3.exists()) {
                                    file3.getParentFile().mkdirs();
                                    file3.createNewFile();
                                }
                                closeable2 = new BufferedOutputStream(new FileOutputStream(file3), 262144);
                                while (true) {
                                    try {
                                        int read = bufferedInputStream.read(bArr, 0, 262144);
                                        if (read == -1) {
                                            break;
                                        }
                                        closeable2.write(bArr, 0, read);
                                    } catch (Throwable th2) {
                                        th = th2;
                                        closeable = zipFile;
                                        Closeable closeable3 = closeable2;
                                        closeable2 = bufferedInputStream;
                                        bufferedInputStream = closeable3;
                                    }
                                }
                                arrayList.add(zipEntry.getName());
                                closeable2.flush();
                                UCCyclone.close(closeable2);
                                UCCyclone.close(bufferedInputStream);
                                closeable = closeable2;
                                closeable2 = bufferedInputStream;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            closeable2 = bufferedInputStream;
                            bufferedInputStream = closeable;
                            closeable = zipFile;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        bufferedInputStream = closeable;
                        closeable = zipFile;
                    }
                }
                UCCyclone.close(closeable);
                UCCyclone.close(closeable2);
                UCCyclone.close(zipFile);
                return arrayList;
            } catch (Throwable th5) {
                th = th5;
                bufferedInputStream = null;
                closeable = zipFile;
                UCCyclone.close(bufferedInputStream);
                UCCyclone.close(closeable2);
                UCCyclone.close(closeable);
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            bufferedInputStream = null;
            closeable = null;
            UCCyclone.close(bufferedInputStream);
            UCCyclone.close(closeable2);
            UCCyclone.close(closeable);
            throw th;
        }
    }

    public Object invoke(String str, Object obj) {
        if ("updateCDSwitch".equals(str) && (obj instanceof String[]) && ((String[]) obj).length == 2) {
            a(((String[]) obj)[0], SettingsConst.TRUE.equals(((String[]) obj)[1]));
        }
        return null;
    }

    private void a(boolean z) {
        File file = new File(this.d.getFilesDir(), "precache");
        for (String str : this.r) {
            File file2 = new File(file, str + "_0");
            if (!z) {
                boolean f = f(str);
                File file3 = new File(file, str + "_1");
                if (f) {
                    try {
                        if (file2.exists()) {
                            file2.delete();
                        }
                        if (!file3.exists()) {
                            file3.createNewFile();
                        }
                    } catch (IOException e) {
                    }
                } else {
                    if (file3.exists()) {
                        file3.delete();
                    }
                    if (!file2.exists()) {
                        file2.createNewFile();
                    }
                }
            } else if (file2.exists()) {
                a(str, false);
            } else if (new File(file, str + "_1").exists()) {
                a(str, true);
            }
        }
    }

    private int e(String str) {
        for (int length = this.r.length - 1; length >= 0; length--) {
            if (this.r[length].equals(str)) {
                return length;
            }
        }
        return this.r.length;
    }

    private void a(String str, boolean z) {
        int e = e(str);
        if (this.t[e] != z) {
            this.t[e] = z;
            a(false);
        }
    }

    private boolean f(String str) {
        return this.t[e(str)];
    }
}
