package com.uc.webview.export.utility.download;

import android.content.Context;
import android.webkit.ValueCallback;
import com.UCMobile.Apollo.ApolloMetaData;
import com.uc.webview.export.annotations.Api;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.interfaces.IWaStat.WaStat;
import java.util.concurrent.ConcurrentHashMap;

@Api
/* compiled from: ProGuard */
public class DownloadTask implements Runnable {
    private static final ConcurrentHashMap<Integer, Integer> a = new ConcurrentHashMap();
    private final Object[] b = new Object[3];
    private final ValueCallback<DownloadTask>[] c = new ValueCallback[9];
    private final String[] d = new String[3];
    private final long[] e = new long[3];
    private ValueCallback<Object[]> f;

    public DownloadTask(Context context, String str, ValueCallback<Object[]> valueCallback) {
        int hashCode = str.hashCode();
        this.b[2] = context;
        synchronized (a) {
            if (a.containsKey(Integer.valueOf(hashCode))) {
                throw new RuntimeException("Duplicate task.");
            }
            a.put(Integer.valueOf(hashCode), Integer.valueOf(hashCode));
        }
        String valueOf = hashCode >= 0 ? String.valueOf(hashCode) : String.valueOf(hashCode).replace('-', '_');
        this.f = valueCallback;
        WaStat.stat(IWaStat.DOWNLOAD);
        this.d[0] = str;
        this.d[1] = context.getApplicationContext().getCacheDir().getAbsolutePath() + "/ucdown" + valueOf;
    }

    protected void finalize() throws Throwable {
        try {
            int hashCode = this.d[0].hashCode();
            synchronized (a) {
                a.remove(Integer.valueOf(hashCode));
            }
        } catch (Throwable th) {
        }
    }

    public DownloadTask onEvent(String str, ValueCallback<DownloadTask> valueCallback) {
        if (str.equals("success")) {
            this.c[0] = valueCallback;
        } else if (str.equals("failed")) {
            this.c[1] = valueCallback;
        } else if (str.equals("recovered")) {
            this.c[2] = valueCallback;
        } else if (str.equals("progress")) {
            this.c[3] = valueCallback;
        } else if (str.equals("exception")) {
            this.c[4] = valueCallback;
        } else if (str.equals("check")) {
            this.c[5] = valueCallback;
        } else if (str.equals(ApolloMetaData.KEY_HEADER)) {
            this.c[6] = valueCallback;
        } else if (str.equals("exists")) {
            this.c[7] = valueCallback;
        } else if (str.equals("beginDownload")) {
            this.c[8] = valueCallback;
        } else {
            throw new RuntimeException("The given event:" + str + " is unknown.");
        }
        return this;
    }

    public Throwable getException() {
        return (Throwable) this.b[1];
    }

    public String getFilePath() {
        return this.d[2];
    }

    public long getTotalSize() {
        return this.e[0];
    }

    public long getCurrentSize() {
        return this.e[1];
    }

    public long getLastModified() {
        return this.e[2];
    }

    public DownloadTask start() {
        this.b[0] = new Thread(this);
        ((Thread) this.b[0]).start();
        return this;
    }

    public DownloadTask stop() {
        this.b[0] = null;
        return this;
    }

    public DownloadTask stopWith(Runnable runnable) {
        this.b[0] = new Thread(new a(this, runnable));
        ((Thread) this.b[0]).start();
        return this;
    }

    public DownloadTask planWith(Runnable runnable) {
        new Thread(new b(this, runnable)).start();
        return this;
    }

    public DownloadTask delete() {
        this.b[0] = new Thread(new c(this));
        ((Thread) this.b[0]).start();
        return this;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void run() {
        /*
        r22 = this;
        monitor-enter(r22);
        r2 = android.os.Looper.myLooper();	 Catch:{ all -> 0x0013 }
        r3 = android.os.Looper.getMainLooper();	 Catch:{ all -> 0x0013 }
        if (r2 != r3) goto L_0x0016;
    L_0x000b:
        r2 = new java.lang.RuntimeException;	 Catch:{ all -> 0x0013 }
        r3 = "Download should not run in UI thread.";
        r2.<init>(r3);	 Catch:{ all -> 0x0013 }
        throw r2;	 Catch:{ all -> 0x0013 }
    L_0x0013:
        r2 = move-exception;
        monitor-exit(r22);
        throw r2;
    L_0x0016:
        r0 = r22;
        r2 = r0.c;	 Catch:{ all -> 0x0013 }
        r3 = 0;
        r4 = r2[r3];	 Catch:{ all -> 0x0013 }
        r0 = r22;
        r2 = r0.c;	 Catch:{ all -> 0x0013 }
        r3 = 1;
        r5 = r2[r3];	 Catch:{ all -> 0x0013 }
        r0 = r22;
        r2 = r0.c;	 Catch:{ all -> 0x0013 }
        r3 = 2;
        r6 = r2[r3];	 Catch:{ all -> 0x0013 }
        r0 = r22;
        r2 = r0.c;	 Catch:{ all -> 0x0013 }
        r3 = 3;
        r7 = r2[r3];	 Catch:{ all -> 0x0013 }
        r0 = r22;
        r2 = r0.c;	 Catch:{ all -> 0x0013 }
        r3 = 4;
        r8 = r2[r3];	 Catch:{ all -> 0x0013 }
        r0 = r22;
        r2 = r0.c;	 Catch:{ all -> 0x0013 }
        r3 = 5;
        r2 = r2[r3];	 Catch:{ all -> 0x0013 }
        r0 = r22;
        r3 = r0.c;	 Catch:{ all -> 0x0013 }
        r9 = 6;
        r9 = r3[r9];	 Catch:{ all -> 0x0013 }
        r0 = r22;
        r3 = r0.c;	 Catch:{ all -> 0x0013 }
        r10 = 7;
        r10 = r3[r10];	 Catch:{ all -> 0x0013 }
        r0 = r22;
        r3 = r0.c;	 Catch:{ all -> 0x0013 }
        r11 = 8;
        r11 = r3[r11];	 Catch:{ all -> 0x0013 }
        if (r2 == 0) goto L_0x005d;
    L_0x0058:
        r0 = r22;
        r2.onReceiveValue(r0);	 Catch:{ Throwable -> 0x0142 }
    L_0x005d:
        r0 = r22;
        r2 = r0.b;	 Catch:{ Throwable -> 0x0142 }
        r3 = 1;
        r12 = 0;
        r2[r3] = r12;	 Catch:{ Throwable -> 0x0142 }
        r0 = r22;
        r2 = r0.d;	 Catch:{ Throwable -> 0x0142 }
        r3 = 0;
        r12 = r2[r3];	 Catch:{ Throwable -> 0x0142 }
        r0 = r22;
        r2 = r0.d;	 Catch:{ Throwable -> 0x0142 }
        r3 = 1;
        r13 = r2[r3];	 Catch:{ Throwable -> 0x0142 }
        r0 = r22;
        r2 = r0.f;	 Catch:{ Throwable -> 0x0358, Exception -> 0x0115 }
        if (r2 == 0) goto L_0x008b;
    L_0x0079:
        r0 = r22;
        r2 = r0.f;	 Catch:{ Throwable -> 0x0358, Exception -> 0x0115 }
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ Throwable -> 0x0358, Exception -> 0x0115 }
        r14 = 0;
        r15 = 1;
        r15 = java.lang.Integer.valueOf(r15);	 Catch:{ Throwable -> 0x0358, Exception -> 0x0115 }
        r3[r14] = r15;	 Catch:{ Throwable -> 0x0358, Exception -> 0x0115 }
        r2.onReceiveValue(r3);	 Catch:{ Throwable -> 0x0358, Exception -> 0x0115 }
    L_0x008b:
        r2 = 0;
        r3 = com.uc.webview.export.internal.utility.d.a(r12, r2);	 Catch:{ Exception -> 0x0115 }
        r0 = r22;
        r14 = r0.e;	 Catch:{ Throwable -> 0x0142 }
        r15 = 0;
        r2 = r3.first;	 Catch:{ Throwable -> 0x0142 }
        r2 = (java.lang.Long) r2;	 Catch:{ Throwable -> 0x0142 }
        r16 = r2.longValue();	 Catch:{ Throwable -> 0x0142 }
        r14[r15] = r16;	 Catch:{ Throwable -> 0x0142 }
        r0 = r22;
        r14 = r0.e;	 Catch:{ Throwable -> 0x0142 }
        r15 = 2;
        r2 = r3.second;	 Catch:{ Throwable -> 0x0142 }
        r2 = (java.lang.Long) r2;	 Catch:{ Throwable -> 0x0142 }
        r2 = r2.longValue();	 Catch:{ Throwable -> 0x0142 }
        r14[r15] = r2;	 Catch:{ Throwable -> 0x0142 }
        r14 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0142 }
        r14.<init>();	 Catch:{ Throwable -> 0x0142 }
        r0 = r16;
        r14 = r14.append(r0);	 Catch:{ Throwable -> 0x0142 }
        r15 = "_";
        r14 = r14.append(r15);	 Catch:{ Throwable -> 0x0142 }
        r2 = r14.append(r2);	 Catch:{ Throwable -> 0x0142 }
        r14 = r2.toString();	 Catch:{ Throwable -> 0x0142 }
        r0 = r22;
        r2 = r0.d;	 Catch:{ Throwable -> 0x0142 }
        r3 = 2;
        r15 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0142 }
        r15.<init>();	 Catch:{ Throwable -> 0x0142 }
        r15 = r15.append(r13);	 Catch:{ Throwable -> 0x0142 }
        r18 = "/";
        r0 = r18;
        r15 = r15.append(r0);	 Catch:{ Throwable -> 0x0142 }
        r15 = r15.append(r14);	 Catch:{ Throwable -> 0x0142 }
        r15 = r15.toString();	 Catch:{ Throwable -> 0x0142 }
        r2[r3] = r15;	 Catch:{ Throwable -> 0x0142 }
        r18 = new java.io.File;	 Catch:{ Throwable -> 0x0142 }
        r0 = r18;
        r0.<init>(r15);	 Catch:{ Throwable -> 0x0142 }
        r0 = r22;
        r2 = r0.e;	 Catch:{ Throwable -> 0x0142 }
        r3 = 1;
        r20 = r18.length();	 Catch:{ Throwable -> 0x0142 }
        r2[r3] = r20;	 Catch:{ Throwable -> 0x0142 }
        r2 = (r20 > r16 ? 1 : (r20 == r16 ? 0 : -1));
        if (r2 == 0) goto L_0x0159;
    L_0x00fd:
        r2 = 1;
        r3 = r2;
    L_0x00ff:
        if (r9 == 0) goto L_0x0106;
    L_0x0101:
        r0 = r22;
        r9.onReceiveValue(r0);	 Catch:{ Throwable -> 0x0335 }
    L_0x0106:
        r0 = r22;
        r2 = r0.b;	 Catch:{ Throwable -> 0x0142 }
        r9 = 0;
        r2 = r2[r9];	 Catch:{ Throwable -> 0x0142 }
        r9 = java.lang.Thread.currentThread();	 Catch:{ Throwable -> 0x0142 }
        if (r2 == r9) goto L_0x015c;
    L_0x0113:
        monitor-exit(r22);
        return;
    L_0x0115:
        r2 = move-exception;
        r0 = r22;
        r3 = r0.f;	 Catch:{ Throwable -> 0x0355 }
        if (r3 == 0) goto L_0x0141;
    L_0x011c:
        r0 = r22;
        r3 = r0.f;	 Catch:{ Throwable -> 0x0355 }
        r4 = 2;
        r4 = new java.lang.Object[r4];	 Catch:{ Throwable -> 0x0355 }
        r5 = 0;
        r6 = 6;
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ Throwable -> 0x0355 }
        r4[r5] = r6;	 Catch:{ Throwable -> 0x0355 }
        r5 = 1;
        r6 = r2.getClass();	 Catch:{ Throwable -> 0x0355 }
        r6 = r6.getName();	 Catch:{ Throwable -> 0x0355 }
        r6 = r6.hashCode();	 Catch:{ Throwable -> 0x0355 }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ Throwable -> 0x0355 }
        r4[r5] = r6;	 Catch:{ Throwable -> 0x0355 }
        r3.onReceiveValue(r4);	 Catch:{ Throwable -> 0x0355 }
    L_0x0141:
        throw r2;	 Catch:{ Throwable -> 0x0142 }
    L_0x0142:
        r2 = move-exception;
        r3 = "sdk_dl_e";
        com.uc.webview.export.internal.interfaces.IWaStat.WaStat.stat(r3);	 Catch:{ all -> 0x0013 }
        r0 = r22;
        r3 = r0.b;	 Catch:{ all -> 0x0013 }
        r4 = 1;
        r3[r4] = r2;	 Catch:{ all -> 0x0013 }
        if (r8 == 0) goto L_0x0113;
    L_0x0151:
        r0 = r22;
        r8.onReceiveValue(r0);	 Catch:{ Throwable -> 0x0157 }
        goto L_0x0113;
    L_0x0157:
        r2 = move-exception;
        goto L_0x0113;
    L_0x0159:
        r2 = 0;
        r3 = r2;
        goto L_0x00ff;
    L_0x015c:
        r0 = r22;
        r2 = r0.f;	 Catch:{ Throwable -> 0x0352 }
        if (r2 == 0) goto L_0x0175;
    L_0x0162:
        r0 = r22;
        r2 = r0.f;	 Catch:{ Throwable -> 0x0352 }
        r9 = 1;
        r9 = new java.lang.Object[r9];	 Catch:{ Throwable -> 0x0352 }
        r15 = 0;
        r19 = 2;
        r19 = java.lang.Integer.valueOf(r19);	 Catch:{ Throwable -> 0x0352 }
        r9[r15] = r19;	 Catch:{ Throwable -> 0x0352 }
        r2.onReceiveValue(r9);	 Catch:{ Throwable -> 0x0352 }
    L_0x0175:
        if (r3 == 0) goto L_0x0324;
    L_0x0177:
        r2 = new java.io.File;	 Catch:{ Throwable -> 0x0142 }
        r2.<init>(r13);	 Catch:{ Throwable -> 0x0142 }
        com.uc.webview.export.cyclone.UCCyclone.expectCreateDirFile(r2);	 Catch:{ Throwable -> 0x0142 }
        r9 = r2.listFiles();	 Catch:{ Throwable -> 0x0142 }
        r10 = r9.length;	 Catch:{ Throwable -> 0x0142 }
        r2 = 0;
    L_0x0185:
        if (r2 >= r10) goto L_0x019e;
    L_0x0187:
        r13 = r9[r2];	 Catch:{ Throwable -> 0x0142 }
        r15 = r13.getName();	 Catch:{ Throwable -> 0x0142 }
        r15 = r15.equals(r14);	 Catch:{ Throwable -> 0x0142 }
        if (r15 != 0) goto L_0x019b;
    L_0x0193:
        r15 = 0;
        r19 = 0;
        r0 = r19;
        com.uc.webview.export.cyclone.UCCyclone.recursiveDelete(r13, r15, r0);	 Catch:{ Throwable -> 0x0142 }
    L_0x019b:
        r2 = r2 + 1;
        goto L_0x0185;
    L_0x019e:
        r2 = r18.exists();	 Catch:{ Throwable -> 0x0142 }
        if (r2 != 0) goto L_0x01a7;
    L_0x01a4:
        r18.createNewFile();	 Catch:{ Throwable -> 0x0142 }
    L_0x01a7:
        r2 = (r20 > r16 ? 1 : (r20 == r16 ? 0 : -1));
        if (r2 >= 0) goto L_0x02f9;
    L_0x01ab:
        if (r11 == 0) goto L_0x01b2;
    L_0x01ad:
        r0 = r22;
        r11.onReceiveValue(r0);	 Catch:{ Exception -> 0x0338 }
    L_0x01b2:
        r2 = com.uc.webview.export.internal.SDKFactory.f;	 Catch:{ Throwable -> 0x034f }
        if (r2 != 0) goto L_0x01ce;
    L_0x01b6:
        r2 = "traffic_stat";
        r2 = com.uc.webview.export.extension.UCCore.getParam(r2);	 Catch:{ Throwable -> 0x034f }
        r2 = java.lang.Boolean.parseBoolean(r2);	 Catch:{ Throwable -> 0x034f }
        if (r2 == 0) goto L_0x01ce;
    L_0x01c2:
        r2 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Throwable -> 0x034f }
        r9 = 14;
        if (r2 < r9) goto L_0x01ce;
    L_0x01c8:
        r2 = 40962; // 0xa002 float:5.74E-41 double:2.0238E-319;
        android.net.TrafficStats.setThreadStatsTag(r2);	 Catch:{ Throwable -> 0x034f }
    L_0x01ce:
        r2 = new java.net.URL;	 Catch:{ Throwable -> 0x0142 }
        r2.<init>(r12);	 Catch:{ Throwable -> 0x0142 }
        r2 = r2.openConnection();	 Catch:{ Throwable -> 0x0142 }
        r2 = (java.net.HttpURLConnection) r2;	 Catch:{ Throwable -> 0x0142 }
        r9 = com.uc.webview.export.internal.utility.d.a;	 Catch:{ Throwable -> 0x0142 }
        r2.setConnectTimeout(r9);	 Catch:{ Throwable -> 0x0142 }
        r9 = com.uc.webview.export.internal.utility.d.b;	 Catch:{ Throwable -> 0x0142 }
        r2.setReadTimeout(r9);	 Catch:{ Throwable -> 0x0142 }
        r9 = 1;
        r2.setInstanceFollowRedirects(r9);	 Catch:{ Throwable -> 0x0142 }
        r9 = "GET";
        r2.setRequestMethod(r9);	 Catch:{ Throwable -> 0x0142 }
        r10 = 0;
        r9 = (r20 > r10 ? 1 : (r20 == r10 ? 0 : -1));
        if (r9 <= 0) goto L_0x0220;
    L_0x01f2:
        r9 = "Range";
        r10 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0142 }
        r11 = "bytes=";
        r10.<init>(r11);	 Catch:{ Throwable -> 0x0142 }
        r0 = r20;
        r10 = r10.append(r0);	 Catch:{ Throwable -> 0x0142 }
        r11 = "-";
        r10 = r10.append(r11);	 Catch:{ Throwable -> 0x0142 }
        r0 = r16;
        r10 = r10.append(r0);	 Catch:{ Throwable -> 0x0142 }
        r10 = r10.toString();	 Catch:{ Throwable -> 0x0142 }
        r2.setRequestProperty(r9, r10);	 Catch:{ Throwable -> 0x0142 }
        r9 = "sdk_dl_r";
        com.uc.webview.export.internal.interfaces.IWaStat.WaStat.stat(r9);	 Catch:{ Throwable -> 0x0142 }
        if (r6 == 0) goto L_0x0220;
    L_0x021b:
        r0 = r22;
        r6.onReceiveValue(r0);	 Catch:{ Throwable -> 0x033b }
    L_0x0220:
        r2.connect();	 Catch:{ Throwable -> 0x0142 }
        r6 = r2.getResponseCode();	 Catch:{ Throwable -> 0x0142 }
        r9 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r6 < r9) goto L_0x022f;
    L_0x022b:
        r9 = 303; // 0x12f float:4.25E-43 double:1.497E-321;
        if (r6 <= r9) goto L_0x024c;
    L_0x022f:
        r2 = new com.uc.webview.export.cyclone.UCKnownException;	 Catch:{ Throwable -> 0x0142 }
        r3 = 4020; // 0xfb4 float:5.633E-42 double:1.986E-320;
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0142 }
        r5 = "httpcode:";
        r4.<init>(r5);	 Catch:{ Throwable -> 0x0142 }
        r4 = r4.append(r6);	 Catch:{ Throwable -> 0x0142 }
        r5 = " not correct.";
        r4 = r4.append(r5);	 Catch:{ Throwable -> 0x0142 }
        r4 = r4.toString();	 Catch:{ Throwable -> 0x0142 }
        r2.<init>(r3, r4);	 Catch:{ Throwable -> 0x0142 }
        throw r2;	 Catch:{ Throwable -> 0x0142 }
    L_0x024c:
        r6 = r2.getInputStream();	 Catch:{ Throwable -> 0x0142 }
        r9 = new java.io.FileOutputStream;	 Catch:{ all -> 0x02ee }
        r10 = 1;
        r0 = r18;
        r9.<init>(r0, r10);	 Catch:{ all -> 0x02ee }
        r10 = 51200; // 0xc800 float:7.1746E-41 double:2.5296E-319;
        r10 = new byte[r10];	 Catch:{ all -> 0x02e9 }
    L_0x025d:
        r11 = r6.read(r10);	 Catch:{ all -> 0x02e9 }
        if (r11 <= 0) goto L_0x027c;
    L_0x0263:
        r12 = 0;
        r9.write(r10, r12, r11);	 Catch:{ all -> 0x02e9 }
        r0 = r22;
        r12 = r0.e;	 Catch:{ all -> 0x02e9 }
        r13 = 1;
        r14 = r12[r13];	 Catch:{ all -> 0x02e9 }
        r0 = (long) r11;	 Catch:{ all -> 0x02e9 }
        r20 = r0;
        r14 = r14 + r20;
        r12[r13] = r14;	 Catch:{ all -> 0x02e9 }
        if (r7 == 0) goto L_0x027c;
    L_0x0277:
        r0 = r22;
        r7.onReceiveValue(r0);	 Catch:{ Throwable -> 0x033e }
    L_0x027c:
        if (r11 <= 0) goto L_0x0289;
    L_0x027e:
        r0 = r22;
        r11 = r0.e;	 Catch:{ all -> 0x02e9 }
        r12 = 1;
        r12 = r11[r12];	 Catch:{ all -> 0x02e9 }
        r11 = (r12 > r16 ? 1 : (r12 == r16 ? 0 : -1));
        if (r11 <= 0) goto L_0x028a;
    L_0x0289:
        r3 = 0;
    L_0x028a:
        if (r3 == 0) goto L_0x0299;
    L_0x028c:
        r0 = r22;
        r11 = r0.b;	 Catch:{ all -> 0x02e9 }
        r12 = 0;
        r11 = r11[r12];	 Catch:{ all -> 0x02e9 }
        r12 = java.lang.Thread.currentThread();	 Catch:{ all -> 0x02e9 }
        if (r11 == r12) goto L_0x025d;
    L_0x0299:
        r9.close();	 Catch:{ Throwable -> 0x0341 }
    L_0x029c:
        r6.close();	 Catch:{ Throwable -> 0x0346 }
    L_0x029f:
        r2.disconnect();	 Catch:{ Throwable -> 0x02f6 }
        r2 = r3;
    L_0x02a3:
        if (r2 != 0) goto L_0x0113;
    L_0x02a5:
        r2 = r18.length();	 Catch:{ Throwable -> 0x0142 }
        r2 = (r16 > r2 ? 1 : (r16 == r2 ? 0 : -1));
        if (r2 == 0) goto L_0x02fb;
    L_0x02ad:
        r2 = "sdk_dl_f";
        com.uc.webview.export.internal.interfaces.IWaStat.WaStat.stat(r2);	 Catch:{ Throwable -> 0x0142 }
        r0 = r22;
        r2 = r0.b;	 Catch:{ Throwable -> 0x0142 }
        r3 = 1;
        r4 = new java.lang.RuntimeException;	 Catch:{ Throwable -> 0x0142 }
        r6 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0142 }
        r7 = "Size mismatch:";
        r6.<init>(r7);	 Catch:{ Throwable -> 0x0142 }
        r10 = r18.length();	 Catch:{ Throwable -> 0x0142 }
        r6 = r6.append(r10);	 Catch:{ Throwable -> 0x0142 }
        r7 = "/";
        r6 = r6.append(r7);	 Catch:{ Throwable -> 0x0142 }
        r0 = r16;
        r6 = r6.append(r0);	 Catch:{ Throwable -> 0x0142 }
        r6 = r6.toString();	 Catch:{ Throwable -> 0x0142 }
        r4.<init>(r6);	 Catch:{ Throwable -> 0x0142 }
        r2[r3] = r4;	 Catch:{ Throwable -> 0x0142 }
        if (r5 == 0) goto L_0x0113;
    L_0x02df:
        r0 = r22;
        r5.onReceiveValue(r0);	 Catch:{ Throwable -> 0x02e6 }
        goto L_0x0113;
    L_0x02e6:
        r2 = move-exception;
        goto L_0x0113;
    L_0x02e9:
        r3 = move-exception;
        r9.close();	 Catch:{ Throwable -> 0x0344 }
    L_0x02ed:
        throw r3;	 Catch:{ all -> 0x02ee }
    L_0x02ee:
        r3 = move-exception;
        r6.close();	 Catch:{ Throwable -> 0x0349 }
    L_0x02f2:
        r2.disconnect();	 Catch:{ Throwable -> 0x034b }
    L_0x02f5:
        throw r3;	 Catch:{ Throwable -> 0x0142 }
    L_0x02f6:
        r2 = move-exception;
        r2 = r3;
        goto L_0x02a3;
    L_0x02f9:
        r2 = 0;
        goto L_0x02a3;
    L_0x02fb:
        r2 = "sdk_dl_s";
        com.uc.webview.export.internal.interfaces.IWaStat.WaStat.stat(r2);	 Catch:{ Throwable -> 0x0142 }
        if (r4 == 0) goto L_0x0307;
    L_0x0302:
        r0 = r22;
        r4.onReceiveValue(r0);	 Catch:{ Throwable -> 0x034d }
    L_0x0307:
        r0 = r22;
        r2 = r0.f;	 Catch:{ Throwable -> 0x0321 }
        if (r2 == 0) goto L_0x0113;
    L_0x030d:
        r0 = r22;
        r2 = r0.f;	 Catch:{ Throwable -> 0x0321 }
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ Throwable -> 0x0321 }
        r4 = 0;
        r5 = 5;
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ Throwable -> 0x0321 }
        r3[r4] = r5;	 Catch:{ Throwable -> 0x0321 }
        r2.onReceiveValue(r3);	 Catch:{ Throwable -> 0x0321 }
        goto L_0x0113;
    L_0x0321:
        r2 = move-exception;
        goto L_0x0113;
    L_0x0324:
        r2 = "sdk_dl_x";
        com.uc.webview.export.internal.interfaces.IWaStat.WaStat.stat(r2);	 Catch:{ Throwable -> 0x0142 }
        if (r10 == 0) goto L_0x0113;
    L_0x032b:
        r0 = r22;
        r10.onReceiveValue(r0);	 Catch:{ Throwable -> 0x0332 }
        goto L_0x0113;
    L_0x0332:
        r2 = move-exception;
        goto L_0x0113;
    L_0x0335:
        r2 = move-exception;
        goto L_0x0106;
    L_0x0338:
        r2 = move-exception;
        goto L_0x01b2;
    L_0x033b:
        r6 = move-exception;
        goto L_0x0220;
    L_0x033e:
        r12 = move-exception;
        goto L_0x027c;
    L_0x0341:
        r7 = move-exception;
        goto L_0x029c;
    L_0x0344:
        r4 = move-exception;
        goto L_0x02ed;
    L_0x0346:
        r6 = move-exception;
        goto L_0x029f;
    L_0x0349:
        r4 = move-exception;
        goto L_0x02f2;
    L_0x034b:
        r2 = move-exception;
        goto L_0x02f5;
    L_0x034d:
        r2 = move-exception;
        goto L_0x0307;
    L_0x034f:
        r2 = move-exception;
        goto L_0x01ce;
    L_0x0352:
        r2 = move-exception;
        goto L_0x0175;
    L_0x0355:
        r3 = move-exception;
        goto L_0x0141;
    L_0x0358:
        r2 = move-exception;
        goto L_0x008b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.webview.export.utility.download.DownloadTask.run():void");
    }
}
