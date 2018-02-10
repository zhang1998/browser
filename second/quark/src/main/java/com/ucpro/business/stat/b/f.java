package com.ucpro.business.stat.b;

import android.os.Build;
import android.os.Build.VERSION;
import android.util.Log;
import com.uc.base.wa.a.c;
import com.uc.base.wa.component.WaStatService;
import com.uc.base.wa.k;
import com.uc.base.wa.w;
import com.uc.base.wa.x;
import com.ucpro.business.stat.RemoteStatService;
import com.ucpro.c.b;
import com.ucpro.services.f.g;
import com.ucweb.common.util.d;
import com.ucweb.common.util.d.e;
import com.ucweb.common.util.k.a;
import hugo.weaving.DebugLog;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.Response;

/* compiled from: ProGuard */
public final class f extends c {
    private static String b = "27c8291cc1b2";
    private static final boolean c = (b.b());
    private static final boolean d = b.b();
    private static final String[] e = new String[]{"https://applog.uc.cn/collect?uc_param_str="};
    private static final String[] f = new String[]{"http://applogmaster.test.uae.uc.cn/collect?uc_param_str="};
    private DateFormat g;
    private w h = new b(this);

    public final void c() {
        x.a(b);
        x.a(new String[]{"ver", "sver"}, new String[]{"tm"}, k.b);
        x.a(this.h);
        if (d && new File(com.ucpro.c.c.d().getAbsolutePath() + File.separator + "wa.ini").exists()) {
            x.a(new d(this, com.ucpro.c.c.b("wa")));
            x.a(new a(this));
        }
    }

    public final String[] m() {
        String[] strArr = e;
        if (!c) {
            return strArr;
        }
        new StringBuilder("use wa test server:").append(f);
        return f;
    }

    public final String k() {
        return d.a().getApplicationInfo().dataDir;
    }

    public final byte[] a(byte[] bArr) {
        return bArr;
    }

    public final byte[] b(byte[] bArr) {
        return bArr;
    }

    public final boolean a(byte[] bArr, File file) {
        com.ucweb.common.util.c.a((Object) bArr);
        com.ucweb.common.util.c.a((Object) file);
        if (bArr == null || file == null) {
            return false;
        }
        try {
            a.a(file, bArr);
            return true;
        } catch (Throwable e) {
            Log.e("WA", "write file fail", e);
            return false;
        }
    }

    public final byte[] a(File file) {
        byte[] bArr = null;
        com.ucweb.common.util.c.a((Object) file);
        if (file != null) {
            try {
                bArr = a.f(file);
            } catch (IOException e) {
            }
        }
        return bArr;
    }

    @DebugLog
    public final byte[] c(byte[] bArr) {
        return bArr;
    }

    public final String h() {
        return null;
    }

    public final void b(String str) {
        Log.w("WA", "assertFail: " + str);
    }

    public final boolean i() {
        return com.ucweb.common.util.i.c.b();
    }

    public final boolean j() {
        return com.ucweb.common.util.i.c.a(d.a());
    }

    public final String l() {
        return com.ucpro.business.stat.f.b();
    }

    public final Class<? extends WaStatService> o() {
        return RemoteStatService.class;
    }

    @DebugLog
    public final com.uc.base.wa.a.b a(String str, byte[] bArr) {
        Throwable e;
        Throwable th;
        Throwable th2;
        com.ucweb.common.util.c.a((CharSequence) str);
        com.ucweb.common.util.c.a((Object) bArr);
        com.ucweb.common.util.c.b(bArr.length > 0);
        com.uc.base.wa.a.b bVar = new com.uc.base.wa.a.b();
        Response execute;
        try {
            execute = g.a().newCall(new Builder().url(str).post(RequestBody.create(null, bArr)).build()).execute();
            if (execute == null) {
                try {
                    Log.e("WA", "response == null");
                    if (execute != null) {
                        execute.close();
                    }
                    return null;
                } catch (Exception e2) {
                    e = e2;
                    try {
                        bVar.a = e;
                        Log.e("WA", "upload exception", e);
                        c.a.b(e.toString());
                        if (execute != null) {
                            return bVar;
                        }
                        execute.close();
                        return bVar;
                    } catch (Throwable th3) {
                        th = th3;
                        if (execute != null) {
                            execute.close();
                        }
                        throw th;
                    }
                } catch (UnsatisfiedLinkError e3) {
                    e = e3;
                    Log.e("WA", "upload error", e);
                    c.a.b(e.toString());
                    if (execute != null) {
                        return bVar;
                    }
                    execute.close();
                    return bVar;
                }
            }
            int code = execute.code();
            bVar.d = bArr.length;
            bVar.b = code;
            if (code == 200 && execute.body() != null) {
                byte[] bytes = execute.body().bytes();
                bVar.c = Arrays.copyOf(bytes, bytes.length);
            }
            if (execute == null) {
                return bVar;
            }
            execute.close();
            return bVar;
        } catch (Throwable e4) {
            th2 = e4;
            execute = null;
            e = th2;
            bVar.a = e;
            Log.e("WA", "upload exception", e);
            c.a.b(e.toString());
            if (execute != null) {
                return bVar;
            }
            execute.close();
            return bVar;
        } catch (Throwable e42) {
            th2 = e42;
            execute = null;
            e = th2;
            Log.e("WA", "upload error", e);
            c.a.b(e.toString());
            if (execute != null) {
                return bVar;
            }
            execute.close();
            return bVar;
        } catch (Throwable th4) {
            th = th4;
            execute = null;
            if (execute != null) {
                execute.close();
            }
            throw th;
        }
    }

    public final HashMap<String, String> n() {
        HashMap<String, String> hashMap = new HashMap();
        hashMap.put("ml", Build.MODEL);
        hashMap.put("bd", Build.BRAND);
        hashMap.put("rom", VERSION.RELEASE);
        hashMap.put("asdk", String.valueOf(VERSION.SDK_INT));
        hashMap.put("utdid", com.ucpro.business.stat.f.b());
        hashMap.put("bid", com.ucpro.c.a.a());
        hashMap.put("bseq", "180123054500");
        hashMap.put("ch", com.ucpro.c.a.b());
        hashMap.put("sid", com.ucpro.model.a.a.a.a("setting_sid", ""));
        hashMap.put("btype", com.ucpro.c.a.d());
        hashMap.put("bmode", com.ucpro.c.a.e());
        hashMap.put("tmem", String.valueOf(e.l()));
        hashMap.put("lang", Locale.getDefault().getLanguage());
        hashMap.put("vcode", "50");
        hashMap.put("o_vname", com.ucpro.b.d.a.b.a().e);
        hashMap.put("o_subver", com.ucpro.b.d.a.b.a().f);
        hashMap.put("l_vname", com.ucpro.b.d.a.b.a().h);
        hashMap.put("l_subver", com.ucpro.b.d.a.b.a().i);
        return hashMap;
    }

    static /* synthetic */ DateFormat a(f fVar) {
        if (fVar.g == null) {
            fVar.g = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINESE);
        }
        return fVar.g;
    }
}
