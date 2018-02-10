package com.ucpro;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Process;
import android.support.multidex.b;
import android.taobao.windvane.jsbridge.WVPluginManager;
import com.alibaba.analytics.a.af;
import com.alibaba.analytics.core.d.g;
import com.h.a.a;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.config.j;
import com.raizlabs.android.dbflow.config.k;
import com.raizlabs.android.dbflow.runtime.m;
import com.uc.quark.x;
import com.ucpro.a.ac;
import com.ucpro.base.system.UCLibLoader;
import com.ucpro.c.f;
import com.ucpro.d.e;
import com.ucpro.services.download.i;
import com.ucweb.common.util.c;
import com.ucweb.common.util.d;
import com.ucweb.common.util.h;
import hugo.weaving.DebugLog;
import java.util.List;

/* compiled from: ProGuard */
public class BrowserApplication {
    private Application a;
    private a b = null;

    public BrowserApplication(Application application) {
        this.a = application;
    }

    protected void onBaseContextAttached(Context context) {
        b.a(context);
        if ((context.getPackageName() + ":quarkpatch").equalsIgnoreCase(com.ucweb.common.util.c.a.a())) {
            com.uc.aerie.updater.a.a(context);
        }
    }

    private Context b() {
        return this.a.getApplicationContext();
    }

    private Application c() {
        return this.a;
    }

    @DebugLog
    public void onCreate() {
        String str;
        e.a();
        Context b = b();
        c.a((Object) b);
        d.a(b);
        h.a = b.getResources().getDisplayMetrics();
        c.a(com.ucpro.c.b.a());
        if (h()) {
            f.a = true;
        }
        e.a("iu");
        Application c = c();
        if (com.ucpro.c.b.b()) {
            try {
                Class.forName("com.facebook.stetho.Stetho").getMethod("initializeWithDefaults", new Class[]{Context.class}).invoke(null, new Object[]{c});
            } catch (Throwable e) {
                c.a("stetho init fail", e);
            }
        }
        com.raizlabs.android.dbflow.config.d dVar = new com.raizlabs.android.dbflow.config.d(c());
        j jVar = new j(com.ucpro.feature.bookmarkhis.bookmark.a.e.class);
        if (m.a == null) {
            m.a = new m();
        }
        jVar.f = m.a;
        k kVar = new k(jVar);
        dVar.c.put(kVar.b, kVar);
        FlowManager.a(new com.raizlabs.android.dbflow.config.e(dVar));
        f();
        e.a("ls");
        com.ucpro.business.b.a.a(b());
        e.a("ic3");
        com.ucpro.c.b.b();
        e.a("ibc");
        e();
        e.a("iq");
        f.b = c().getApplicationInfo().dataDir;
        Application c2 = c();
        com.e.b.b.a();
        com.e.b.k eVar = new com.ucpro.business.stat.b.e();
        try {
            if (!com.e.b.b.b) {
                if (c2 != null) {
                    if (c2.getBaseContext() != null) {
                        com.alibaba.analytics.core.c.a().a = c2.getBaseContext();
                        com.alibaba.analytics.c.a(c2);
                        af.b("", "[i_initialize] start...");
                        com.alibaba.analytics.c.b(eVar.a());
                        String b2 = eVar.b();
                        com.alibaba.analytics.c.a(b2);
                        Context context = com.alibaba.analytics.core.c.a().a;
                        String str2 = "channel";
                        if (context != null) {
                            SharedPreferences sharedPreferences = context.getSharedPreferences("ut_setting", 4);
                            if (sharedPreferences != null) {
                                Editor edit = sharedPreferences.edit();
                                if (edit != null) {
                                    edit.putString(str2, b2);
                                    edit.apply();
                                }
                            }
                        }
                        if (eVar.e()) {
                            com.alibaba.analytics.core.c.a().d = true;
                        }
                        com.e.b.a.c a = com.e.b.a.c.a();
                        if (a.a != null) {
                            Thread.setDefaultUncaughtExceptionHandler(a.a);
                            a.a = null;
                        }
                        a.b = true;
                        if (eVar.d()) {
                            com.alibaba.analytics.c.a();
                        }
                        boolean z = com.e.b.b.a;
                        com.e.b.d.a.c c3 = eVar.c();
                        Object[] objArr = new Object[2];
                        StringBuilder stringBuilder = new StringBuilder("[_setRequestAuthentication] start...");
                        com.alibaba.analytics.b.a.a();
                        objArr[0] = stringBuilder.append(com.alibaba.analytics.b.a.b()).toString();
                        objArr[1] = Boolean.valueOf(com.alibaba.analytics.c.d);
                        af.b("UTAnalytics", objArr);
                        com.e.b.d.a.b bVar = (com.e.b.d.a.b) c3;
                        b2 = bVar.a;
                        str = bVar.b;
                        com.alibaba.analytics.core.c.a().c = b2;
                        com.alibaba.analytics.c.a(true, false, b2, str);
                        if (!com.e.b.b.a) {
                            com.e.b.b.c.d hVar = new com.e.b.h();
                            com.e.b.e.b().a(hVar);
                            if (VERSION.SDK_INT >= 8) {
                                hVar.b = new com.e.b.b.b.c();
                                hVar.b.a(c2.getApplicationInfo().uid);
                                g.a().a(hVar.b);
                            }
                            if (VERSION.SDK_INT >= 14) {
                                if (c2 != null) {
                                    c2.registerActivityLifecycleCallbacks(com.e.b.b.c.b.a());
                                }
                                com.e.b.b.c.e.a(com.e.b.b.c.c.a());
                                com.e.b.b.c.e.a(hVar);
                                com.e.b.b.c.e.a(new com.e.b.c.c());
                            }
                            g.a().a(c2.getApplicationContext());
                        }
                        if (com.e.b.b.c) {
                            af.c("UTAnalytics", "user disable WVTBUserTrack ");
                        } else if (com.e.b.b.a) {
                            af.c("UTAnalytics", "Has registered WVTBUserTrack plugin,not need to register again! ");
                        } else {
                            try {
                                WVPluginManager.registerPlugin("WVTBUserTrack", com.e.b.d.d.class, true);
                            } catch (Throwable e2) {
                                af.d("", "Exception", e2.toString());
                            }
                        }
                        com.e.b.b.a = true;
                        com.e.b.b.b = true;
                    }
                }
                throw new IllegalArgumentException("application and callback must not be null");
            }
        } catch (Throwable th) {
        }
        com.uc.base.wa.a.c.a(c2.getApplicationContext(), new com.ucpro.business.stat.b.f());
        e.a("iw");
        str = com.ucpro.c.a.a();
        e.a("ibd");
        com.ucweb.common.util.h.m.a(0, new com.ucpro.business.stat.g(str));
        e.a("ium");
        e.a("is");
        if (com.ucpro.c.b.b()) {
            c();
            this.b = a.a;
        }
        e.a("il");
        com.ucpro.base.system.b.a.a(b());
        e.a("isi");
        ac.a();
        e.a("iwc");
        d();
        e.a("iuu");
        com.ucweb.common.util.h.m.a(0, new i(x.a(b(), new com.ucpro.services.download.e(), new com.ucpro.services.download.h())));
        e.a("id");
        e.d();
    }

    private void d() {
        com.ucweb.common.util.h.m.a(0, new f(this));
    }

    public a a() {
        return this.b;
    }

    private void e() {
        com.uc.base.b.b.a.a = new com.uc.a.c.a(c().getApplicationInfo().dataDir, com.ucpro.business.e.b.a.b.a, new e(this));
    }

    private void f() {
        UCLibLoader.loadLibrary(g() ? "browserpro71" : "browserpro");
        com.uc.util.b.b();
        if (VERSION.SDK_INT >= 23) {
            com.uc.util.b.a();
        }
        com.uc.encrypt.f.a();
    }

    private static final boolean g() {
        return VERSION.SDK_INT >= 24 || "N".compareToIgnoreCase(VERSION.RELEASE) == 0;
    }

    private boolean h() {
        return a(b());
    }

    private boolean a(Context context) {
        String str;
        int myPid = Process.myPid();
        List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == myPid) {
                    str = runningAppProcessInfo.processName;
                    break;
                }
            }
        }
        str = null;
        if (str == null || !str.equals(context.getPackageName())) {
            return false;
        }
        return true;
    }
}
