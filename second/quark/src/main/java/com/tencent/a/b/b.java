package com.tencent.a.b;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import com.uc.apollo.impl.SettingsConst;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public final class b {
    private static Map<String, b> b = Collections.synchronizedMap(new HashMap());
    private static String c = null;
    public JSONObject a = null;
    private Context d = null;
    private String e = null;
    private long f = 0;
    private int g = 0;
    private boolean h = true;

    public static b a(Context context, String str) {
        b bVar;
        synchronized (b) {
            if (str != null) {
                c = str;
            }
            if (str == null) {
                if (c != null) {
                    str = c;
                } else {
                    str = SettingsConst.FALSE;
                }
            }
            bVar = (b) b.get(str);
            if (bVar == null) {
                bVar = new b(context, str);
                b.put(str, bVar);
            }
        }
        return bVar;
    }

    private b(Context context, String str) {
        this.d = context.getApplicationContext();
        this.e = str;
        try {
            this.a = new JSONObject(c("com.tencent.open.config.json"));
        } catch (JSONException e) {
            this.a = new JSONObject();
        }
        b();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String c(java.lang.String r7) {
        /*
        r6 = this;
        r2 = "";
        r0 = r6.e;	 Catch:{ FileNotFoundException -> 0x0052 }
        if (r0 == 0) goto L_0x0050;
    L_0x0006:
        r0 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0052 }
        r1 = java.lang.String.valueOf(r7);	 Catch:{ FileNotFoundException -> 0x0052 }
        r0.<init>(r1);	 Catch:{ FileNotFoundException -> 0x0052 }
        r1 = ".";
        r0 = r0.append(r1);	 Catch:{ FileNotFoundException -> 0x0052 }
        r1 = r6.e;	 Catch:{ FileNotFoundException -> 0x0052 }
        r0 = r0.append(r1);	 Catch:{ FileNotFoundException -> 0x0052 }
        r0 = r0.toString();	 Catch:{ FileNotFoundException -> 0x0052 }
    L_0x001f:
        r1 = r6.d;	 Catch:{ FileNotFoundException -> 0x0052 }
        r1 = r1.openFileInput(r0);	 Catch:{ FileNotFoundException -> 0x0052 }
    L_0x0025:
        r3 = new java.io.BufferedReader;
        r4 = new java.io.InputStreamReader;
        r0 = r1;
        r0 = (java.io.InputStream) r0;
        r5 = "UTF-8";
        r5 = java.nio.charset.Charset.forName(r5);
        r4.<init>(r0, r5);
        r3.<init>(r4);
        r0 = new java.lang.StringBuffer;
        r0.<init>();
    L_0x003d:
        r4 = r3.readLine();	 Catch:{ IOException -> 0x0065, all -> 0x0073 }
        if (r4 != 0) goto L_0x0061;
    L_0x0043:
        r0 = r0.toString();	 Catch:{ IOException -> 0x0065, all -> 0x0073 }
        r1 = (java.io.InputStream) r1;	 Catch:{ IOException -> 0x007d }
        r1.close();	 Catch:{ IOException -> 0x007d }
        r3.close();	 Catch:{ IOException -> 0x007d }
    L_0x004f:
        return r0;
    L_0x0050:
        r0 = r7;
        goto L_0x001f;
    L_0x0052:
        r0 = move-exception;
        r0 = r6.d;	 Catch:{ IOException -> 0x005e }
        r0 = r0.getAssets();	 Catch:{ IOException -> 0x005e }
        r1 = r0.open(r7);	 Catch:{ IOException -> 0x005e }
        goto L_0x0025;
    L_0x005e:
        r0 = move-exception;
        r0 = r2;
        goto L_0x004f;
    L_0x0061:
        r0.append(r4);	 Catch:{ IOException -> 0x0065, all -> 0x0073 }
        goto L_0x003d;
    L_0x0065:
        r0 = move-exception;
        r1 = (java.io.InputStream) r1;	 Catch:{ IOException -> 0x0070 }
        r1.close();	 Catch:{ IOException -> 0x0070 }
        r3.close();	 Catch:{ IOException -> 0x0070 }
        r0 = r2;
        goto L_0x004f;
    L_0x0070:
        r0 = move-exception;
        r0 = r2;
        goto L_0x004f;
    L_0x0073:
        r0 = move-exception;
        r1 = (java.io.InputStream) r1;	 Catch:{ IOException -> 0x007f }
        r1.close();	 Catch:{ IOException -> 0x007f }
        r3.close();	 Catch:{ IOException -> 0x007f }
    L_0x007c:
        throw r0;
    L_0x007d:
        r1 = move-exception;
        goto L_0x004f;
    L_0x007f:
        r1 = move-exception;
        goto L_0x007c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.a.b.b.c(java.lang.String):java.lang.String");
    }

    private void b() {
        if (this.g != 0) {
            b("update thread is running, return");
            return;
        }
        this.g = 1;
        Bundle bundle = new Bundle();
        bundle.putString("appid", this.e);
        bundle.putString("appid_for_getting_config", this.e);
        bundle.putString("status_os", VERSION.RELEASE);
        bundle.putString("status_machine", Build.MODEL);
        bundle.putString("status_version", VERSION.SDK);
        bundle.putString("sdkv", "2.9.4.lite");
        bundle.putString("sdkp", "a");
        new a(this, bundle).start();
    }

    public final void a() {
        int optInt = this.a.optInt("Common_frequency");
        if (optInt == 0) {
            optInt = 1;
        }
        if (SystemClock.elapsedRealtime() - this.f >= ((long) (optInt * 3600000))) {
            b();
        }
    }

    public final int a(String str) {
        b("get " + str);
        a();
        return this.a.optInt(str);
    }

    public final void b(String str) {
        if (this.h) {
            new StringBuilder(String.valueOf(str)).append("; appid: ").append(this.e);
        }
    }

    static /* synthetic */ void a(b bVar, JSONObject jSONObject) {
        bVar.b("cgi back, do update");
        bVar.a = jSONObject;
        String str = "com.tencent.open.config.json";
        String jSONObject2 = jSONObject.toString();
        try {
            if (bVar.e != null) {
                str = new StringBuilder(String.valueOf(str)).append(".").append(bVar.e).toString();
            }
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(bVar.d.openFileOutput(str, 0), Charset.forName("UTF-8"));
            outputStreamWriter.write(jSONObject2);
            outputStreamWriter.flush();
            outputStreamWriter.close();
        } catch (IOException e) {
        }
        bVar.f = SystemClock.elapsedRealtime();
    }
}
