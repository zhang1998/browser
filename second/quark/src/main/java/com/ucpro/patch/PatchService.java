package com.ucpro.patch;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Base64;
import android.util.Log;
import com.d.a.b.e;
import com.uc.aerie.loader.AerieLoaderContext;
import com.uc.apollo.impl.SettingsConst;
import com.uc.base.wa.x;
import com.uc.encrypt.f;
import com.ucpro.feature.r.b.b;
import com.ucweb.a.a.c;
import com.ucweb.a.r;
import com.ucweb.a.s;
import com.ucweb.common.util.d;
import com.ucweb.common.util.h.m;
import com.ucweb.common.util.k.a;
import java.io.File;
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request;
import okhttp3.Response;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;

/* compiled from: ProGuard */
public class PatchService extends IntentService {
    private static Handler z = null;
    private final String a = "U3RhcnQgdmVyaWZpY2F0aW9uLg==";
    private final String b = "RG93bmxvYWQgY29tcGxldGVkLg==";
    private final String c = "RG93bmxvYWQgZmFpbGVkLg==";
    private final String d = "QXBwbHlpbmcgcGF0Y2gu";
    private final String e = "UGxlYXNlIHJlc3RhcnQgYXBwLg==";
    private final String f = "UGF0Y2ggZmFpbGVkLg==";
    private final int g = 0;
    private final int h = 1;
    private String i = null;
    private final String j = "patch";
    private final String k = "PatchService";
    private final String l = "dl";
    private final String m = "ph";
    private final String n = "req";
    private final String o = "rb";
    private final String p = "comret";
    private final String q = "stat";
    private final String r = SettingsConst.FALSE;
    private final String s = SettingsConst.TRUE;
    private final int t = 0;
    private final int u = 1;
    private final int v = 2;
    private final int w = 3;
    private final int x = 4;
    private long y = 20000;

    static /* synthetic */ void a(PatchService patchService, String str, String str2, String str3, int i, Context context) {
        int i2;
        new StringBuilder("update found:").append(str).append("\n").append(str2).append("\nsize:").append(i).append("\nmd5:").append(str3);
        File file = new File(patchService.i);
        if (file.exists() && file.length() == ((long) i)) {
            String str4 = "";
            try {
                str4 = a.b(file, patchService.y);
            } catch (IOException e) {
            }
            if (str4.equals(str3)) {
                i2 = 0;
                if (i2 != 0) {
                    m.a(0, new d(patchService, i, context, str, str3, str2));
                }
            }
        }
        i2 = 1;
        if (i2 != 0) {
            m.a(0, new d(patchService, i, context, str, str3, str2));
        }
    }

    public PatchService() {
        super("PatchSerivce");
        if (z == null) {
            z = new c(this, Looper.getMainLooper());
        }
    }

    protected void onHandleIntent(Intent intent) {
        this.i = getFilesDir().getAbsolutePath() + File.separator + "patch";
        File file;
        if (intent == null || !"v".equals(intent.getAction())) {
            com.ucpro.business.stat.m.a("patch", "req", new String[0]);
            x.a(4);
            Context applicationContext = getApplicationContext();
            file = new File(this.i);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            file = new File(this.i);
            if (file.exists()) {
                b(file);
                return;
            }
            try {
                if (!com.ucpro.b.a.a.a()) {
                    f.a();
                    f.a(applicationContext, true, (byte) 1);
                    c.a(d.a(), new b(), new com.ucpro.feature.r.b.a(), com.ucweb.a.a.b.c, com.ucpro.c.b.b());
                    s sVar = new s();
                    String baseDv = AerieLoaderContext.getBaseDv();
                    String loadDv = AerieLoaderContext.getLoadDv();
                    if (loadDv == null) {
                        loadDv = baseDv;
                    }
                    sVar.o = loadDv;
                    loadDv = "-1";
                    e eVar = new e();
                    eVar.a = com.uc.base.b.c.c.a("deployment");
                    eVar.c = com.uc.base.b.c.c.a(loadDv);
                    eVar.b = 99;
                    eVar.d = 2;
                    sVar.n.add(eVar);
                    sVar.a = "ucpro";
                    sVar.b = 3;
                    sVar.e = loadDv;
                    r.a().a = new b(this, applicationContext);
                    r.a().a(sVar);
                    return;
                }
                return;
            } catch (Throwable e) {
                Log.getStackTraceString(e);
                return;
            }
        }
        a("U3RhcnQgdmVyaWZpY2F0aW9uLg==");
        file = new File(this.i);
        a(intent.getStringExtra("k_1"), this.i);
        if (file.exists()) {
            a("RG93bmxvYWQgY29tcGxldGVkLg==");
            a("QXBwbHlpbmcgcGF0Y2gu");
            if (b(file)) {
                a("UGxlYXNlIHJlc3RhcnQgYXBwLg==");
                return;
            } else {
                a("UGF0Y2ggZmFpbGVkLg==");
                return;
            }
        }
        a("RG93bmxvYWQgZmFpbGVkLg==");
    }

    private static void a(String str) {
        String str2 = new String(Base64.decode(str.getBytes(), 3));
        Message obtain = Message.obtain();
        obtain.what = 10000;
        obtain.obj = str2;
        z.sendMessage(obtain);
    }

    private static boolean b(File file) {
        boolean z;
        try {
            com.uc.aerie.updater.a.a().a(file);
            if (file != null && file.exists()) {
                file.delete();
            }
            b();
            z = true;
        } catch (Throwable e) {
            Log.getStackTraceString(e);
            if (file != null && file.exists()) {
                file.delete();
            }
            b();
            z = false;
        } catch (Throwable th) {
            if (file != null && file.exists()) {
                file.delete();
            }
            b();
        }
        if (z) {
            com.ucpro.business.stat.m.a("patch", "ph", "stat", SettingsConst.FALSE);
            x.a(4);
        } else {
            com.ucpro.business.stat.m.a("patch", "ph", "stat", SettingsConst.TRUE);
            x.a(4);
        }
        return z;
    }

    private static File a(String str, String str2) {
        OkHttpClient build = new Builder().build();
        File file = new File(str2);
        Response response = null;
        try {
            response = build.newCall(new Request.Builder().url(str).get().build()).execute();
            BufferedSink buffer = Okio.buffer(Okio.sink(file));
            Buffer buffer2 = buffer.buffer();
            BufferedSource source = response.body().source();
            for (long read = source.read(buffer2, 512000); read != -1; read = source.read(buffer2, 512000)) {
                buffer.emit();
            }
            buffer.emit();
            buffer.flush();
            buffer.emit();
            buffer.close();
            if (response != null) {
                try {
                    response.body().close();
                } catch (Throwable e) {
                    Log.getStackTraceString(e);
                }
            }
        } catch (Throwable e2) {
            Log.getStackTraceString(e2);
            if (response != null) {
                try {
                    response.body().close();
                } catch (Throwable e22) {
                    Log.getStackTraceString(e22);
                }
            }
        } catch (Throwable th) {
            if (response != null) {
                try {
                    response.body().close();
                } catch (Throwable e3) {
                    Log.getStackTraceString(e3);
                }
            }
        }
        return file;
    }

    public void onDestroy() {
        super.onDestroy();
    }

    private static void b() {
        x.a(5);
        z.removeMessages(10001);
        Message obtain = Message.obtain();
        obtain.what = 10001;
        z.sendMessageDelayed(obtain, 600000);
    }

    static /* synthetic */ File a(Context context, String str, String str2, int i) {
        if (i == 0 && com.f.a.b.a.a.a(context)) {
            return a(str, str2);
        }
        if (1 == i) {
            return a(str, str2);
        }
        return null;
    }
}
